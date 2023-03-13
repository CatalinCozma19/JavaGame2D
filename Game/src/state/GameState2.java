import java.awt.*;

public class GameState2 extends State{

    private World world;


    public GameState2(Handler handler){
        super(handler);
        world=new World(handler,"E:\\Facultate\\PAOO\\Game\\res\\worlds\\world2.txt");
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
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,200,50));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,150,720));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,880,140));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,445,500));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,920,667));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,543,654));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,340,874));
        handler.getWorld().getEntityManager().addEntity(new Enemy(handler,572,445));

        id=2;


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
