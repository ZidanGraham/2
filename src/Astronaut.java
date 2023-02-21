import java.awt.*;

/**
 * Created by chales on 11/6/2017.
 */
public class Astronaut {

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


    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Astronaut(int pXpos, int pYpos,int pDx,int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx =pDx;
        dy =pDy;
        width = 80;
        height = 80;
        isAlive = true;


 
    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        //wrap around
        if(xpos>1000-width||xpos<0){
            dx=-dx;//set the new dx=negative old dx
        }
        //bounce off bottom and top
        if(ypos>700-height||ypos<0){
            dy=-dy;//set the new dx=negative old dx
        }
        //
        rec=new Rectangle(xpos,ypos,width,height);
    }//end of move method
    public void printInfo(){
        System.out.println("the (x,y) position of my astro is:"+xpos+", "+ypos);
        System.out.print(" the speed is"+dx+"the y speed is" +dy);
        System.out.print("the width of my astro is:60");

    }
}






