import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private static Game instance=null;
    private Display display;
    private int width,height;
    public String title;

    private boolean running=false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;


    private Game(String title,int width,int height){             //constructor pentru clasa Game
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager=new KeyManager();
        mouseManager=new MouseManager();
    }

    public static Game GetInstance(String title,int width,int height){
        if(instance==null)
            instance=new Game(title,width,height);
        return instance;
    }

    private void init(){                        //initializeaza graficele pentru joc
        display=new Display(title,width,height);     //initializeaza un nou display pentru clasa Game
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler=new Handler(this);
        gameCamera=new GameCamera(handler,0,0);


        gameState=new GameState(handler);
        menuState=new MenuState(handler);
        State.setState(menuState);
        
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() !=null)
            State.getState().tick();
    }

    private void render(){
        bs=display.getCanvas().getBufferStrategy();      //bs primeste valoarea de la BufferStrategy a jocului;
                                                         //BufferStrategy reprezinta modul prin care calculatorul deseneaza pe ecran folosind buffere
                                                         //Buffer= 'hidden' computer screen within the computer
        if(bs==null){
            display.getCanvas().createBufferStrategy(3); //creeaza un buffer in cazul in care nu exista deja unul
            return;
        }
        g=bs.getDrawGraphics();                       //permite desenul asupra canvas-ului ca un paintbrush


        //clear screen
        g.clearRect(0,0,width,height);          //stergem ecranul dupa fiecare render

        //Draw

        if(State.getState() !=null)
            State.getState().render(g);





        //end Draw

        bs.show();
        g.dispose();

    }

    public void run(){
        init();

        int fps=60;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;

        while (running){
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime=now;

            if(delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer>=1000000000){
                System.out.println("Ticks and Frames:"+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start(){                //synchronized se foloseste cand se lucreaza direct cu thread-ul
        if(running)                                  //in cazul in care jocul deja ruleaza, nu mai initializam thread-ul
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;                                   //in cazul in care jocul s-a oprit, sarim peste (nu il mai inchidem inca o data)deoarece va genera erori, la fel ca la deschidere
        running=false;
        try {
            thread.join();
        }  catch(InterruptedException e){
                e.printStackTrace();
        }
    }

}
