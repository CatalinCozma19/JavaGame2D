import java.awt.*;

public abstract class State {

    protected int id;

    private static State currentState=null;

    public static void setState(State state){
        currentState=state;
    }

    static State getState(){
        return currentState;
    }


    //CLASS

    protected Handler handler;

    public State(Handler handler){
        this.handler=handler;
        id=0;
    }

    public int getId(){
        return id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
