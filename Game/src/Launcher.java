public class Launcher {
    public static void main(String[] args){
        Game game=Game.GetInstance("Yagao, the knight slayer",900,500);           //depoziteaza obiectul Game intr-o variabila numita ,,game''
        game.start();
    }
}
