public class ArrayMain {
    /**
     * Step One Arrays : Declare
     **/

    public String[] VillanChoices;
    public String[] Villan;

    public int[] Grades;

    //default static main method and I ALWAYS have to have in a program
    public static void main(String[] args) {
        ArrayMain MyApp = new ArrayMain();

    }

    //the constructor method is not static and we have to call it inside PSVM
    public ArrayMain() {
        System.out.println("Hello World");
//Bookshelf example step 2
        VillanChoices = new String[7];
        //Bookshelf Example Step 3

        VillanChoices[0] = "Ursula";
        VillanChoices[1] = "Cruella";
        VillanChoices[2] = "Maleficent";
        VillanChoices[3] = "Witch";
        VillanChoices[4] = "Ernesto";
        VillanChoices[5]= "Gaston";
        VillanChoices[6]= "Scar";


        System.out.println(VillanChoices[3]);

        //Grades example step 2 construct the array and give it a size
        Villan = new String[11];

        //Grades example step 3 Fill the ray

        for (int i = 0; i < 11; i = i + 1) {
            Villan[i] = VillanChoices[(int) (Math.random()*7)];
            System.out.println(Villan[i]);
        }
//        System.out.println("jessie's grade is " + Grades[3]);
//        System.out.println("Zidan grade is " +Grades[1]);


    }
}

