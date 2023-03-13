import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private Player player   ;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter= new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY()+a.getHeight() < b.getY()+b.getHeight())
                return -1;
            return 1;
        }
    };


    public EntityManager(Handler handler,Player player){
        this.handler=handler;
        this.player=player;
        entities=new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick(){
        for(int i=0;i<entities.size();i++){
            Entity e=entities.get(i);
            e.tick();
            if(!e.isActive()) {
                entities.remove(e);
                handler.getWorld().getEntityManager().getPlayer().counter++;
                handler.getWorld().getScoreBoard().addPoints(10);
                if(handler.getWorld().getEntityManager().getPlayer().counter == 5 && State.getState().getId()==1)
                    State.setState(new GameState2(handler));
                else if(handler.getWorld().getEntityManager().getPlayer().counter == 8 && State.getState().getId()==2)
                    System.exit(0);
            }
        }

        entities.sort(renderSorter);
    }

    public void render(Graphics g) {
        for(Entity e:entities){
            e.render(g);
        }

    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTERS SETTERS

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
