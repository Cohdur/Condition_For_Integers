import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
// I could just have it accept string values as no real math computation is happening.
// However, this will convert the string for mathmatical computation if need be.

/**
 * Program will accept values as values for upper/lower bound of a fraction.
 * Follows the rule of dividing by 0
 */
public class Condition
{
    private  int upperBound;
    private  String upperBoundString;

    private  int lowerBound;
    private  String lowerBoundString;

    private final String Default = "100";
    
    /**
     * Default constructor 
     */
    public Condition()
    {
        upperBound = 0;
        lowerBound = 0;
    }
        

    public void User_Input_Upper_Lower()
    {
        Scanner read = new Scanner(System.in);
        upperBoundString = read.nextLine();
        
        //checks for the one non numerical input..
        if(!(upperBoundString.equals("Default")))
        {
        
        //outter loop to break from range based for loop
        checkForLetter : 
        {
        //Numerical condition 
        for(var check : upperBoundString.toCharArray())
        {

            while(check < 48 || check > 57)
            {
                Logger.getGlobal().info("The only accepted input is a integer value UPPER");
                upperBoundString = read.nextLine();

                //"Default condition"
                if(upperBoundString.equals("Default"))
                {
                    upperBound = Integer.parseInt(Default);
                    break checkForLetter;
                }
                else
                {
                    upperBound = Integer.parseInt(upperBoundString);
                    break checkForLetter;
                }

            }
                        
        } // close for outer most for loop 

        }// close checkForLetter outer loop 

        } // close for !(lowerBoundString.equals("Default")) if


        //condition for "Default value"
        if(upperBoundString.equals("Default"))
        {
            upperBound = Integer.parseInt(Default);
        }
        
        else
        {
            upperBound = Integer.parseInt(upperBoundString);
        }


        // Lower bound input 
        System.out.print("Lower: ");
        lowerBoundString = read.nextLine();

        //checks for the one non numerical input..
        if(!(lowerBoundString.equals("Default")))
        {
        //Copy of only numerical condition 
        checkForLetter2 :
        { 
        
        for(var check2 : lowerBoundString.toCharArray())
        {         
            while( check2 < 48 || check2 > 57 )
            {
                Logger.getGlobal().info("The only accepted input is a integer value LOWER");
                lowerBoundString = read.nextLine();

                // Default condition
                if(lowerBoundString.equals("Default"))
                {
                    lowerBound = Integer.parseInt(Default);
                    break checkForLetter2;
                }
                else
                {
                    lowerBound = Integer.parseInt(lowerBoundString);
                    
                    while( lowerBound == 0 )
                    {
                        Logger.getGlobal().info("Incorrect value for lower bound. Any integer > 0: ");
                        
                        lowerBoundString = read.nextLine();
                        // copy over "Default" condition within this exception
                        if(lowerBoundString.equals("Default"))
                        {
                            lowerBound = Integer.parseInt(Default);
                            break checkForLetter2;
                        }
                        else
                        {
                            lowerBound = Integer.parseInt(lowerBoundString);
                            break checkForLetter2;
                        }
                    } // close for while lowerBound == 0 condition
                     
                    break checkForLetter2;
                }

            } // close for while loop check2 < 48 || check2 > 57 

        } // close range based for loop check
        
    } // close for checkForLetter2 outer loop

    } // close for if(!(lowerBoundString.equals("Default")))

    //else{

        //condition for "Default value"
        if(lowerBoundString.equals("Default"))
        {
            lowerBound = Integer.parseInt(Default);
        }
        else
        {
            lowerBound = Integer.parseInt(lowerBoundString);
        }

        while( lowerBound == 0 )
        {
            System.out.print("Incorrect value for lower bound. Any integer > 0: ");
            
            lowerBoundString = read.nextLine();
            // copy over "Default" condition within this exception
            if(lowerBoundString.equals("Default"))
            {
                lowerBound = Integer.parseInt(Default);
            }
            else
            {
                lowerBound = Integer.parseInt(lowerBoundString);
            }
        }

        //}// close for !lowerboundString.equal("Default") else

        read.close();
    }//User_Input_Upper_Lower close bracket

    /**
     * Needed for output statements 
     * @return returns the upperbound of the user input
     */
    final public int Get_Upper_Bound(){ return upperBound; }

    /**
     * Needed for output statements 
     * @return  returns the lower bound
     */
    final public int Get_Lower_Bound(){ return lowerBound; }

    public static void main(String[] args)
    {
        // set the exception messages Default value is "ON"
        //Logger.getGlobal().setLevel(Level.OFF);

        String input;
        final String EXIT = "exit";
        final String  CONTINUE = "continue";

        Condition classObj = new Condition();
        
        Scanner menuChoice = new Scanner(System.in);
        System.out.println("Type exit to quit or continue to enter values.");
        input = menuChoice.nextLine();

        switch (input) {
            case EXIT:
                ; // terminates without output
                break;

            case CONTINUE:
                // upper bound class method/function
                System.out.print("Type \"Default\" to enter the value 100\n");
                System.out.print("Enter a integer value for the upperbound: ");
                classObj.User_Input_Upper_Lower();

                System.out.println("You entered\n" + classObj.Get_Upper_Bound() + " for upper bound " + 
                '\n' + classObj.Get_Lower_Bound() + " for lower bound\n"); 
                default:
                break;
        }

        menuChoice.close();
        
    }// main close bracket

} // class condition close bracket