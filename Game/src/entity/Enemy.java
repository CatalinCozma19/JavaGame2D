import java.awt.*;

public class Enemy extends StaticEntity{

    public Enemy(Handler handler,float x,float y){

        super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT);

        bounds.x=10;
        bounds.y=(int) (height/1.5f);
        bounds.width=width-20;
        bounds.height=(int) (height-height/1.1f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die(){

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.knight,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}
