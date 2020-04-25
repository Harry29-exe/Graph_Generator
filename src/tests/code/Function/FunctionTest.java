package code.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FunctionTest {
    private Function function;
    private String exampleStringFunction;

    @Before
    public void setUp() throws Exception {
        exampleStringFunction = "(6 + x - 31)";
        function = new Function(exampleStringFunction);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void goToEndOfNumber_Test() {
        int i = function.goToEndOfNumber(exampleStringFunction.toCharArray(),1);
        int j = function.goToEndOfNumber(exampleStringFunction.toCharArray(),9);
        assertEquals(')', exampleStringFunction.charAt(j));
        assertEquals(' ', exampleStringFunction.charAt(i));
    }

    @Test
    public void getValueFor_Test() {
        int x = 5;
        System.out.println(function.simpleFunction);
        System.out.println(function.getValueFor(x));
        assertEquals(-20, function.getValueFor(x), 0.0001);
    }

    @Test
    public void getValueFor_Test1() {
        exampleStringFunction = "(2 * x ^ 3 + x - 31)";
        try {
            function = new Function(exampleStringFunction);
        } catch (InvalidFunctionException e) {
            e.printStackTrace();
        }
        int x = 3;
        assertEquals(26, function.getValueFor(x), 0.001);
    }

    @Test
    public void getValueFor_Test2() {
        exampleStringFunction = "(3.9 * 2 * (x * x) ^ 3 + x - (31 -23) * 2)";
        try {
            function = new Function(exampleStringFunction);
            System.out.println("ok1");
        } catch (InvalidFunctionException e) {
            e.printStackTrace();
        }
        int x = 7;
        assertEquals(917_646.2, function.getValueFor(x), 0.01);
    }

}