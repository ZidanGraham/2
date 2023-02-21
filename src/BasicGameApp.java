//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Array;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener, MouseListener {

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;
   
	public BufferStrategy bufferStrategy;
	public Image astroPic;
	public Image neilPic;

	public Image CocoPic;

	public Image DantePic;

	public Image TamalesPic;

	public Image MamacocoPic;

	public Image UrulaPic;






   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	private Astronaut astro;
	public Astronaut neil;

	public Image coco;

	public  Spirit dante;

	public Food tamales;

	public Hero mamacoco;

	public Villan Ursula;

	public boolean TamalesIntersectAstro;

	public boolean DanteIntersectsAstro;






	// Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {


      setUpGraphics();
		canvas.addKeyListener(this);


		//variable and objects
      //create (construct) the objects needed for the game and load up 
		astroPic = Toolkit.getDefaultToolkit().getImage("astronaut.png"); //load the picture
		astro = new Astronaut(10,100,3,9);
// this is constructing the image for neil
		neilPic=Toolkit.getDefaultToolkit().getImage("Mike-removebg-preview.png");
		 neil= new Astronaut(50,50,1,-2);

		 CocoPic=Toolkit.getDefaultToolkit().getImage("Coco.jpg");

		 //dante
		DantePic=Toolkit.getDefaultToolkit().getImage("Dante-removebg-preview.png");
		dante=new Spirit(105,600,4,8);

		//tamales
		TamalesPic=Toolkit.getDefaultToolkit().getImage("Tamales-removebg-preview.png");
		tamales= new Food(30,75,8,12);

		//mamacoco
		MamacocoPic=Toolkit.getDefaultToolkit().getImage("Mamacoco.webp");
		mamacoco= new Hero(30,75,8,12);

		//urula
		UrulaPic=Toolkit.getDefaultToolkit().getImage("Ursula.jpg");
		Ursula= new Villan(30,75,8,12);





	}// BasicGameApp()

   
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {

      //for the moment we will loop things forever.
		while (true) {

         moveThings();  //move all the game objects
		//	collision();
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings()
	{
      //calls the move( ) code in the objects
		//astro.move();
		neil.move();
		neil.move();
		dante.move();
		tamales.move();
		mamacoco.move();
		Ursula.move();

	}

	public void collision() {
		//if the astro rectange intersects the froggos rectangle.&& they are not already intersecting
		if (astro.rec.intersects(tamales.rec) && TamalesIntersectAstro == false) {

			TamalesIntersectAstro = true;

			//grow
			astro.height = astro.height + 5;
			astro.width = astro.width + 5;
			astro.isAlive = false;
			System.out.println("astro is dead");

			//bounce
			//astro.dx=(-1*astro.dx);
			//astro.dy= (-1*astro.dy);
		}
		if (astro.rec.intersects(tamales.rec) == false) {

			TamalesIntersectAstro = false;
		}//this is the end of the astro tamales intersection

		//here is the dante and neil intersection
		if (neil.rec.intersects(dante.rec)) {
			neil.isAlive=false;
		}
		//here is dante and astro intersection
		if (dante.rec.intersects(astro.rec)&& DanteIntersectsAstro==false){
			dante.width = dante.width + 5;
			DanteIntersectsAstro=true;
		}
		if(dante.rec.intersects(astro.rec)==false){
			DanteIntersectsAstro=false;

		}
	}
	
   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
   
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
   
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
	  canvas.addMouseListener(this);
   
      panel.add(canvas);  // adds the canvas to the panel.
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

//put g.draw () here for the background pic
		g.drawImage(CocoPic, 0, 0, WIDTH, HEIGHT, null);

		//draw the image of the astronaut
		g.drawImage(astroPic, astro.xpos, astro.ypos, astro.width, astro.height, null);
		//draw image of neil
		if (neil.isAlive == true) {
			g.drawImage(neilPic, neil.xpos, neil.ypos, neil.width, neil.height, null);
		}

		//draw image of the dante spirit
		if (dante.isAlive == true) {
			g.drawImage(DantePic, dante.xpos, dante.ypos, dante.width, dante.height, null);
		}
		//draw image of the food Tamales
		g.drawImage(TamalesPic, tamales.xpos, tamales.ypos, tamales.width, tamales.height, null);

//draw image of mamacoco
		if (mamacoco.isAlive == true) {
			g.drawImage(MamacocoPic, mamacoco.xpos, mamacoco.ypos, mamacoco.width, mamacoco.height, null);
		}

		//draw image of Urusla
		if (Ursula.isAlive == true) {
			g.drawImage(UrulaPic, Ursula.xpos, Ursula.ypos, Ursula.width, Ursula.height, null);
		}
		g.dispose();
		bufferStrategy.show();
	}






	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==68){
			dante.dx=-5;
			System.out.println("should be dx=5");
			//make dante's x speed =5 when i pressed dd
		}
		if(e.getKeyCode()==65) {
			tamales.dx=3;
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX());
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


	}

