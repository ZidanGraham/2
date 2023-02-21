import java.awt.*;

public class Villan {
    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public Rectangle rec;


    public Villan(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 100;
        height = 100;
        isAlive = true;
    }

    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        //bounce off keft and right sides
        if (xpos > 1000) {
            xpos = 0;
        }

        if (xpos < 0) {
            xpos = 1000;
        }
        //wrap around screen in y direction
        if (ypos > 700) {
            ypos = 0;
        }
        rec=new Rectangle(xpos,ypos,width,height);
    }


}




