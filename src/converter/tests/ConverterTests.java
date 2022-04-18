package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Z");
        assertEquals(converter.toArabic(), 0);
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
    // check single number conversions, both ways

    //ARABIC TO ELBONIAN:
    @Test
    public void ArabicToElbonianSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Z");
        assertEquals(converter.toArabic(), 0);
    }
    @Test
    public void ArabicToElbonianSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }
    @Test
    public void ArabicToElbonianSampleTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 3);
    }
    @Test
    public void ArabicToElbonianSampleTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);
    }
    @Test
    public void ArabicToElbonianSampleTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("L");
        assertEquals(converter.toArabic(), 30);
    }
    @Test
    public void ArabicToElbonianSampleTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("C");
        assertEquals(converter.toArabic(), 100);
    }
    @Test
    public void ArabicToElbonianSampleTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("D");
        assertEquals(converter.toArabic(), 300);
    }
    @Test
    public void ArabicToElbonianSampleTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }
    @Test
    public void ArabicToElbonianSampleTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("N");
        assertEquals(converter.toArabic(), 3000);
    }

    //ELBONIAN TO ARABIC:
    @Test
    public void ElbonianToArabicSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
        assertEquals(converter.toElbonian(), "Z");
    }
    @Test
    public void ElbonianToArabicSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }
    @Test
    public void ElbonianToArabicSampleTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3");
        assertEquals(converter.toElbonian(), "V");
    }
    @Test
    public void ElbonianToArabicSampleTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10");
        assertEquals(converter.toElbonian(), "X");
    }
    @Test
    public void ElbonianToArabicSampleTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("30");
        assertEquals(converter.toElbonian(), "L");
    }
    @Test
    public void ElbonianToArabicSampleTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("100");
        assertEquals(converter.toElbonian(), "C");
    }
    @Test
    public void ElbonianToArabicSampleTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("300");
        assertEquals(converter.toElbonian(), "D");
    }
    @Test
    public void ElbonianToArabicSampleTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1000");
        assertEquals(converter.toElbonian(), "M");
    }
    @Test
    public void ElbonianToArabicSampleTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3000");
        assertEquals(converter.toElbonian(), "N");
    }

    @Test
    public void rule1Test1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCXII");
        assertEquals(converter.toArabic(), 212);
    }

    @Test
    public void rule1Test2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DXV");
        assertEquals(converter.toArabic(), 313);
    }


    @Test
    public void rule1Test3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2120");
        assertEquals(converter.toElbonian(), "MMMCXXX");
    }

    @Test
    public void rule1Test4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMCXXX");
        assertEquals(converter, "MalformedNumberException");
    }

    @Test

    public void rule2Test1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VVV");
        assertEquals(converter.toArabic(), 9);
    }


    @Test
    public void rule2Test3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VVVV");
        assertEquals(converter.toArabic(), "MalformedNumberException");
    }

    // TEST 7:
    // change after making tests private
    @Test
    public void rule7Test1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("-L");
        String c = "-L";
        assertEquals(convert.ruleSevenTest1(c), true);
    }

    @Test
    public void rule7Test2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("L-");
        String c = "L-";
        assertEquals(convert.ruleSevenTest1(c), false);
    }

    @Test
    public void rule7Test3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("LXV-I");
        String c = "LXV-I";
        assertEquals(convert.ruleSevenTest1(c), false);
    }

    @Test
    public void rule7Test6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("L-");
        String c = "L";
        assertEquals(convert.ruleSevenTest1(c), true);
    }


    @Test
    public void rule7Test4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("-L");
        String c = "-L";
        assertEquals(convert.ruleSevenTest2(c), false);
    }
    @Test
    public void rule7Test5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("L");
        String c = "L";
        assertEquals(convert.ruleSevenTest2(c), false);
    }

    @Test
    public void RuletoElbonian1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("7300");
        assertEquals(convert.toElbonian(), "NNMD");
    }

    @Test
    public void RuletoElbonian2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("8744");
        assertEquals(convert.toElbonian(), "NNMMDDCLXVI");
    }

    @Test
    public void RuletoElbonian3()  throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter convert = new ElbonianArabicConverter("0");
        assertEquals(convert.toElbonian(), "Z");
    }



//    @Test
//    public void rule9Test1() throws MalformedNumberException, ValueOutOfBoundsException {
//        ElbonianArabicConverter converter = new ElbonianArabicConverter("VL");
//        assertEquals(converter.ruleNineTest(), false);
//    }
//
//    @Test
//    public void rule9Test2() throws MalformedNumberException, ValueOutOfBoundsException {
//        ElbonianArabicConverter converter = new ElbonianArabicConverter("MDCN");
//        assertEquals(converter.ruleNineTest(), false);
//    }
//
//    @Test
//    public void rule9Test3() throws MalformedNumberException, ValueOutOfBoundsException {
//        ElbonianArabicConverter converter = new ElbonianArabicConverter("MV");
//        assertEquals(converter.ruleNineTest(), true);
//    }



}
