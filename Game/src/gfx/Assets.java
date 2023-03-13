import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=32,height=32;

    public static BufferedImage dirt,grass,stone,water,tree;
    public static BufferedImage[] player_down,player_up,player_left,player_right;
    public static BufferedImage knight;
    public static BufferedImage[] btn_start;

    public static void init(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("E:\\Facultate\\PAOO\\Game\\res\\texture\\all3.png" ));
        SpriteSheet sheet2=new SpriteSheet(ImageLoader.loadImage("E:\\Facultate\\PAOO\\Game\\res\\texture\\Minotaur-Sprite Sheet.png"));
        SpriteSheet sheet3=new SpriteSheet(ImageLoader.loadImage("E:\\Facultate\\PAOO\\Game\\res\\texture\\BarrelKnight_run.png"));


        btn_start=new BufferedImage[2];
        btn_start[0]=sheet.crop(width*5+20,0,width*2-10,height);
        btn_start[1]=sheet.crop(width*5+20,height,width*2-10,height);

        player_down=new BufferedImage[4];
        player_up=new BufferedImage[4];
        player_right=new BufferedImage[4];
        player_left=new BufferedImage[4];

        player_down[0]=sheet2.crop(width -5,height*3,width+20,height*2);
        player_down[1]=sheet2.crop(width*4 -5,height*3,width+20,height*2);
        player_down[2]=sheet2.crop(width*7 -5,height*3,width+20,height*2);
        player_down[3]=sheet2.crop(width*10 -5,height*3,width+20,height*2);
        player_up[0]=sheet2.crop(width -5,height*3,width+20,height*2);
        player_up[1]=sheet2.crop(width*4 -5,height*3,width+20,height*2);
        player_up[2]=sheet2.crop(width*7 -5,height*3,width+20,height*2);
        player_up[3]=sheet2.crop(width*10 -5,height*3,width+20,height*2);
        player_right[0]=sheet2.crop(width -5,height*3,width+20,height*2);
        player_right[1]=sheet2.crop(width*4 -5,height*3,width+20,height*2);
        player_right[2]=sheet2.crop(width*7 -5,height*3,width+20,height*2);
        player_right[3]=sheet2.crop(width*10 -5,height*3,width+20,height*2);
        player_left[0]=sheet2.crop(width -15,height*33,width+20,height*2);
        player_left[1]=sheet2.crop(width*4 -15,height*33,width+20,height*2);
        player_left[2]=sheet2.crop(width*7 -15,height*33,width+20,height*2);
        player_left[3]=sheet2.crop(width*10 -15,height*33,width+20,height*2);

        knight=sheet3.crop(width*3-5,0,width,height*2);


        dirt=sheet.crop(width *2+5,1,width-5,height-5);
        grass= sheet.crop(1,1,width,height-5);
        stone= sheet.crop(width *3+5,1,width-5,height-5);
        water= sheet.crop(width+5,1,width-5,height-5);
        tree=sheet.crop(width*4+10,0,width,height*2);

    }
}
