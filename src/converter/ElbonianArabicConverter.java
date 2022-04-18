package converter;

//import com.sun.deploy.security.SelectableSecurityManager;
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
    HashMap<String, Integer> conversionTable = new HashMap<String, Integer>();

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
          initHash();
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
        ElbonianChar.add('-');

        number = removeWhiteSpace(number);

        boolean isInElbonianAlphabet = checkIfElbonian(number);
        if(!isInElbonianAlphabet){
            throw new MalformedNumberException("The string contains letters not in the Elbonian Alphabet!");

        }

        boolean resultofTestOne = ruleOneTest(number);
        if(!resultofTestOne){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 1!");
        }

        boolean resultofTestTwo = ruleTwoTest(number);
        if(!resultofTestTwo){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 2!");
        }

        boolean resultofTestThree = ruleThreeTest(number);
        if(!resultofTestThree){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 3!");
        }

        boolean resultofTestFour = ruleFourTest(number);
        if(!resultofTestFour){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 4!");
        }

        boolean resultofTestFive = ruleFiveTest(number);
        if(!resultofTestFive){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 5!");
        }

        boolean resultofTestSix = ruleSixTest(number);
        if(!resultofTestSix){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 6!");
        }

        boolean resultofTestSeven1 = ruleSevenTest1(number);
        if(resultofTestSeven1 == false){
            throw new MalformedNumberException("Failed Elbonian Numeral Rule 7: Extra '-'");
        }

        boolean resultofTestSeven2 = ruleSevenTest2(number);
        if (resultofTestSeven2 == true)
        {
            System.out.println("number is negative");
        }
        else {
            System.out.println("number is postive");
        }



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
    private boolean ruleOneTest(String number){

        int maxStraight = 2;
        char last = ' ';
        int count = 1;

        ArrayList<Character> twiceChars = new ArrayList<Character>();
        twiceChars.add('M');
        twiceChars.add('C');
        twiceChars.add('X');
        twiceChars.add('I');
        for(char ruleOne: number.toCharArray()){
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

    //STEP 2: helper function for rule 2
    private boolean ruleTwoTest(String num){

        int maxStraight = 3;
        char last = ' ';
        int count = 1;

        ArrayList<Character> tripleChars = new ArrayList<Character>();
        tripleChars.add('N');
        tripleChars.add('D');
        tripleChars.add('L');
        tripleChars.add('V');
        for(char ruleTwo: num.toCharArray()){
            if(ruleTwo == last) {
                count += 1;

                if (count > maxStraight) {
                    return false;
                }

            }
            else
            {
                last = ruleTwo;
                count = 1;
            }

        }
        {
        }
        return true;

    }
    //STEP 3: helper function for rule 3
    private boolean ruleThreeTest(String num) {
        int countN = 0;
        int maxCountN = 3;
        char N = 'N';
        char M = 'M';
        for(char ruleThree: num.toCharArray()){
            if(ruleThree == N){
                countN += 1;
            }
            if(countN >= maxCountN){
                if(ruleThree == M){
                    return false;
                }
            }
        }
        return true;
    }

    //STEP 4: helper function for rule 4
    private boolean ruleFourTest(String num) {
        int countD = 0;
        int maxCountD = 3;
        char D = 'D';
        char C = 'C';
        for(char ruleFour: num.toCharArray()){
            if(ruleFour == D){
                countD += 1;
            }
            if(countD >= maxCountD){
                if(ruleFour == C){
                    return false;
                }
            }
        }
        return true;
    }

    //STEP 5: helper function for rule 5
    private boolean ruleFiveTest(String num) {
        int countL = 0;
        int maxCountL = 3;
        char L = 'L';
        char X = 'C';
        for(char ruleFive: num.toCharArray()){
            if(ruleFive == L){
                countL += 1;
            }
            if(countL >= maxCountL){
                if(ruleFive == X){
                    return false;
                }
            }
        }
        return true;
    }

    //STEP 6: helper function for rule 6
    private boolean ruleSixTest(String num) {
        int countV = 0;
        int maxCountV = 3;
        char V = 'V';
        char I = 'I';
        for(char ruleSix: num.toCharArray()){
            if(ruleSix == V){
                countV += 1;
            }
            if(countV >= maxCountV){
                if(ruleSix == I){
                    return false;
                }
            }
        }
        return true;
    }

    // STEP 7:
    // checks that negative sign is only at the beginning
    // returns false if fails
    public boolean ruleSevenTest1(String number) {
        int n = number.length();
        for (int i = 1; i < n; i++) {
            String c = Character.toString(number.charAt(i));
            if (c.equals("-"))
            {
                return false;
            }
        }
        return true;
    }

    // checks for negative sign at beginning, returns true if neg. false if not
    public boolean ruleSevenTest2(String number)
    {
            String c = Character.toString(number.charAt(0));
            if (Character.toString(number.charAt(0)) == "-")
            {
                return true;
            }
        return false;
    }





    // STEP 8:
    private boolean ruleEightTest(String number)
    {
        Stack<String> stack = new Stack<String>();
        int n = number.length();
        int zCount = 0;
        for (int i = 0; i < n; i++) {
            String c = Character.toString(number.charAt(i));
            if (c == "Z")
            {
                zCount++;
            }
            if (stack.isEmpty())
                {
                    stack.push(c);
                }
            else {
                String last = stack.peek();
                if (last == "-" && c == "Z")
                {
                    return false;
                }
            }
        }
        if (zCount >= 2)
        {
            return false;
        }
        return true;
    }

    // STEP 9:
    // ** Tests if it's in correct order
    // returns true if passes test
    // false if breaks test
    private boolean ruleNineTest(String number) {
        Stack<String> stack = new Stack<String>();
        int n = number.length();

        for (int i = 0; i < n; i++) {
            String c = Character.toString(number.charAt(i));

            if (stack.isEmpty())
            {
                stack.push(c);
            }
            else {
                String last = stack.peek();
                int compare = conversionTable.get(last);
                int current = conversionTable.get(c);
                if (current > compare) { // if current value is greater than last added value
                    return false;
                } else {
                    stack.push(c);
                }
            }
        }
        return true;
    }



        // takes in an integer and decides if it's out of bounds
    private boolean ruleTenTest(String number)
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

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */

    public int toArabic() {
        // TODO Fill in the method's body

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

    private void initHash()
    {   // builds hash
        conversionTable.put("N", 3000);
        conversionTable.put("M", 1000);
        conversionTable.put("D", 300);
        conversionTable.put("C", 100);
        conversionTable.put("L", 30);
        conversionTable.put("X", 10);
        conversionTable.put("V", 3);
        conversionTable.put("I", 1);
        conversionTable.put("Z", 0);
    }

}
