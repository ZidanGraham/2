import java.awt.*;

public class Hero {
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


    public Hero(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 150;
        height = 150;
        isAlive = true;
        rec=new Rectangle(xpos,ypos,width,height);

    }
    public void move(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        //bounce off keft and right sides
        if(xpos>1000){
            xpos=0;
        }

        if(xpos<0){
            xpos=1000;
        }
        //wrap around screen in y direction
        if(ypos>700){
            ypos=0;
        }

        if(ypos<0){
            ypos=700;
        }
        rec=new Rectangle(xpos,ypos,width,height);
    }
    public void printInfo(){
        System.out.println("the (x,y) position of my dante is:"+xpos+", "+ypos);
        System.out.print(" the speed is"+dx+"the y speed is" +dy);
        System.out.print("the width of my dante is:60");

    }
}




