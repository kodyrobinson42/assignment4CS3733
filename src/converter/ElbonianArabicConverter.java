package converter;

import com.sun.deploy.security.SelectableSecurityManager;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert


    private final String number;
    ArrayList<Character> ElbonianChar = new ArrayList<Character>();

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Elbonian number system.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system or any other error in Arabic number input.
	 * Leading and trailing spaces should not throw an error.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        // TODO check to see if the number is valid, then set it equal to the string
        ArrayList<Integer> ArabicInts = new ArrayList<Integer>();
        ArabicInts.add(0);
        ArabicInts.add(1);
        ArabicInts.add(3);
        ArabicInts.add(10);
        ArabicInts.add(30);
        ArabicInts.add(100);
        ArabicInts.add(300);
        ArabicInts.add(1000);
        ArabicInts.add(3000);
        //upper-case
        ElbonianChar.add('Z');
        ElbonianChar.add('I');
        ElbonianChar.add('V');
        ElbonianChar.add('X');
        ElbonianChar.add('L');
        ElbonianChar.add('C');
        ElbonianChar.add('D');
        ElbonianChar.add('M');
        ElbonianChar.add('N');
        //lower-case
        ElbonianChar.add('z');
        ElbonianChar.add('i');
        ElbonianChar.add('v');
        ElbonianChar.add('x');
        ElbonianChar.add('l');
        ElbonianChar.add('c');
        ElbonianChar.add('d');
        ElbonianChar.add('m');
        ElbonianChar.add('n');

        number = removeWhiteSpace(number);

        boolean isInElbonianAlphabet = checkIfElbonian(number);
        if(!isInElbonianAlphabet){
            throw new MalformedNumberException("The string contains letters not in the Elbonian Alphabet!");

        }

        boolean resultofTestOne = ruleOneTest(number);
        if(!resultofTestOne){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 1!");
        }
/*
        boolean resultofTestTwo = ruleTwoTest(number);
        if(!resultofTestTwo){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 2!")
        }

        boolean resultofTestThree = ruleThreeTest(number);
        if(!resultofTestThree){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 3!")
        }

        boolean resultofTestFour = ruleFourTest(number);
        if(!resultofTestFour){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 4!")
        }

        boolean resultofTestFive = ruleFiveTest(number);
        if(!resultofTestFive){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 5!")
        }

        boolean resultofTestSix = ruleOneTest(number);
        if(!resultofTestSix){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 6!")
        }

        boolean resultofTestSeven = ruleOneTest(number);
        if(!resultofTestSeven){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 7!")
        }

 */







        this.number = number;
    }

    //remove whitespace
    public String removeWhiteSpace(String num){
        num = num.replaceAll("\\s", "");
        return num;
    }

    //check if letters are even in Elbonian alphabet
    private boolean checkIfElbonian(String num){
        for (char elb: num.toCharArray()){
            if(!ElbonianChar.contains(elb)){
                return false;
            }
        }
        return true;
    }

    //TODO: create individual methods to check each rule one by one
    //STEP 1: helper function for rule 1
    private boolean ruleOneTest(String num){

        int maxStraight = 2;
        char last = ' ';
        int count = 1;

        ArrayList<Character> twiceChars = new ArrayList<Character>();
        twiceChars.add('M');
        twiceChars.add('C');
        twiceChars.add('X');
        twiceChars.add('I');
        for(char ruleOne: num.toCharArray()){
            if(ruleOne == last) {
                count += 1;

                if (count > maxStraight) {
                    return false;
                }

            }
            else
            {
                last = ruleOne;
                count = 1;
            }

        }
        {
        }
        return true;

    }



    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        int count = 0;
        int n = number.length();
        for (int i = 0; i < n; i++)
        {
            char c = number.charAt(i);
        }
        return count;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

}
