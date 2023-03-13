import java.awt.*;

public class GameState extends State{

    private World world;


    public GameState(Handler handler){
        super(handler);
        world=new World(handler,"E:\\Facultate\\PAOO\\Game\\res\\worlds\\world1.txt");
        handler.setWorld(world);
        //trees
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,100,452));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,400,126));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,1100,216));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,870,452));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,1000,1000));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,432,763));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,654,642));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,213,623));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,541,742));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,143,531));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,100,1000));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,400,1050));
        handler.getWorld().getEntityManager().addEntity(new Tree(handler,434,1020));
        //enemies
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,800,50));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,670,920));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,220,440));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,450,1100));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,1000,500));

        id=1;

    }

    @Override
    public void tick() {
        world.tick();


    }

    @Override
    public void render(Graphics g) {
        world.render(g);


    }
}
