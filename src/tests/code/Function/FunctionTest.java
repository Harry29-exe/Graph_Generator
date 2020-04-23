package code.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
    public void createSimplifiedFunction_exampleStringFunction_Test() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1,1, -3, 0, -4, 2, -2));
        ArrayList<Integer> output = function.createSimplifiedFunction(exampleStringFunction.toCharArray());
        if(expected.size() == output.size()) {
            for (int i = 0; i < expected.size(); i++) {
                assertEquals(expected.get(i), output.get(i));
            }
        } else {
            throw new AssertionError("Excepted output length:" + expected.size() +
                    "when output length is:" + output.size() + "\n" + output
            );
        }
    }


}