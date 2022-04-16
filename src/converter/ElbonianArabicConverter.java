package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

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

        ArrayList<Integer> ElbonianInts = new ArrayList<Integer>();
        ElbonianInts.add(0);
        ElbonianInts.add(1);
        ElbonianInts.add(3);
        ElbonianInts.add(10);
        ElbonianInts.add(30);
        ElbonianInts.add(100);
        ElbonianInts.add(300);
        ElbonianInts.add(1000);
        ElbonianInts.add(3000);


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







        this.number = number;
    }

    //check if letters are even Elbonian
    private boolean checkIfElbonian(String letter){
        for (char elb: letter.toCharArray()){
            if(!ElbonianChar.contains(elb)){
                return false;
            }
        }
        return true;
    }

    //create individual methods to check each rule one by one


    private boolean magnitudeTest(String number) {
        String N = "M";
        Stack<String> stack = new Stack<String>();
        int n = number.length();

        for (int i = 0; i < n; i++) {
            String c = Character.toString(number.charAt(i));
            stack.push(c);
//            if (c.equals("-")) {
//                sign = -1;
//            } else {
//                count += conversionTable.get(c);
//            }
//            return false;
//        }
        }
        return false;
    }


        // takes in an integer and decides if it's out of bounds
    private boolean intOutOfBounds(String number)
    {
        int Number = Integer.parseInt(number);
        if (Number >= 9999 || Number <= -9999)
        {
            return false;
        }
        else {
            return true; // returns true if not out of bounds
        }
    }

    // Removes leading and trailing spaces
    // kinda useless to have as seperate function lol
    private String trimSpace(String number)
    {
        return number.trim();
    }


    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        HashMap<String, Integer> conversionTable = new HashMap<String, Integer>();

        conversionTable.put("N", 3000);
        conversionTable.put("M", 1000);
        conversionTable.put("D", 300);
        conversionTable.put("C", 100);
        conversionTable.put("L", 30);
        conversionTable.put("X", 10);
        conversionTable.put("V", 3);
        conversionTable.put("I", 1);
        conversionTable.put("Z", 0);

        String c2 = "-";
        int count = 0;
        int sign = 1;
        int n = number.length();
        for (int i = 0; i < n; i++)
        {
            String c = Character.toString(number.charAt(i));

            if (c.equals("-"))
            {
                sign = -1;
            }
            else {
                count += conversionTable.get(c);
            }
        }
        count = count*sign;
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
