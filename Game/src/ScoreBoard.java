
import java.awt.*;
/*
ScoreBoard clasa destinata inregistrarii si afisarii pe ecran a scorului
*/
public class ScoreBoard {

    private int score;
    public ScoreBoard(){

        score=0;
    }
    public void addPoints(int points){
        score+=points;
    }
    public void resetPoints(){
        score=0;
    }
    public int getScore(){return score;}
    public void setScore(int score){ this.score=score;}
    public void Draw(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman",Font.PLAIN,18));
        g.drawString("Score: "+score,10,20);
    }

}