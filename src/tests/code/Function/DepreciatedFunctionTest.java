package code.Function;

import code.Function.FunctionsExceptions.InvalidFunctionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepreciatedFunctionTest {
    private DepreciatedFunction depreciatedFunction;
    private String exampleStringFunction;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void goToEndOfNumber_Test() throws InvalidFunctionException {
        exampleStringFunction = "(6 + x - 31)";
        depreciatedFunction = new DepreciatedFunction(exampleStringFunction);
        int i = depreciatedFunction.goToEndOfNumber(exampleStringFunction.toCharArray(),1);
        int j = depreciatedFunction.goToEndOfNumber(exampleStringFunction.toCharArray(),9);
        assertEquals(')', exampleStringFunction.charAt(j));
        assertEquals(' ', exampleStringFunction.charAt(i));
    }

    @Test
    public void getValueFor_Test() throws InvalidFunctionException {
        exampleStringFunction = "(6 + x - 31)";
        depreciatedFunction = new DepreciatedFunction(exampleStringFunction);
        int x = 5;
        assertEquals(-20, depreciatedFunction.getValueFor(x), 0.0001);
    }

    @Test
    public void getValueFor_Test1() {
        exampleStringFunction = "(2 * x ^ 3 + x - 31)";
        try {
            depreciatedFunction = new DepreciatedFunction(exampleStringFunction);
        } catch (InvalidFunctionException e) {
            e.printStackTrace();
        }
        int x = 3;
        assertEquals(26, depreciatedFunction.getValueFor(x), 0.001);
    }

    @Test
    public void getValueFor_Test2() {
        exampleStringFunction = "(3.9 * 2 * (x * x) ^ 3 + x - (31 -23) * 2)";
        try {
            depreciatedFunction = new DepreciatedFunction(exampleStringFunction);

        } catch (InvalidFunctionException e) {
            e.printStackTrace();
        }
        int x1 = 7;
        int x2 = 5;
        int x3 = 4;
        assertEquals(917_653.2, depreciatedFunction.getValueFor(x1), 0.01);
        assertEquals(121_864, depreciatedFunction.getValueFor(x2), 0.01);
        assertEquals(31_936.8, depreciatedFunction.getValueFor(x3), 0.01);
    }

    @Test(expected = InvalidFunctionException.class)
    public void getValueFor_Test3() throws InvalidFunctionException {
        String exampleStringFunction = "(2GGG * x ^ 3 + x - 31)";
        depreciatedFunction = new DepreciatedFunction(exampleStringFunction);

        assert false;
    }

    @Test
    public void getValueFor_Test4() {
        exampleStringFunction = "2 * x ^ (3 + x) - 31";
        try {
            depreciatedFunction = new DepreciatedFunction(exampleStringFunction);
        } catch (InvalidFunctionException e) {
            e.printStackTrace();
        }
        double x1 = 3;
        double x2 = 6.5;
        int x3 = -7;
        assertEquals(1427, depreciatedFunction.getValueFor(x1), 0.001);
        assertEquals(105_610_416.72423, depreciatedFunction.getValueFor(x2), 0.001);
        assertEquals(-31.0008329, depreciatedFunction.getValueFor(x3), 0.1);
    }

}