package Function;

import code.Function.Function;
import code.Function.FunctionInterpreter;
import code.Function.FunctionsExceptions.InvalidFunctionException;
import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {
    private FunctionInterpreter functionInterpreter = new FunctionInterpreter();
    Function testFun;

    @Test
    public void testFun1() {
        setTestFun("x^4+3*x^3-x^2");
        for(double x = -100; x < 100; x += 0.4) {
            double funVal = testFun.getValueFor(x);
            Assert.assertEquals(Math.pow(x, 4) + 3 * Math.pow(x,3) - x*x,
                    funVal, funVal*0.001);
        }
    }

    @Test
    public void testFun2() {
        setTestFun("(1/(6*(2*3.14)^(1/2))) * 2.72 ^ ((-1/2) * ((x-3)/6)^2)");
        for(double x = -100; x < 100; x += 0.4) {
            System.out.println(x);
            double funVal = testFun.getValueFor(x);
            Assert.assertEquals(0.066507 * Math.pow(2.72, (-1.0/2)*Math.pow(((x-3)/6),2)),
                    funVal, funVal*0.01);
        }
    }



    private void setTestFun(String stringFunction) {
        try {
            testFun = functionInterpreter.createFunction(stringFunction);
        } catch (InvalidFunctionException e) {
            Assert.fail();
        }
    }
}
