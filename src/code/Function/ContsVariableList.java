package code.Function;

import java.util.LinkedList;

public class ContsVariableList {
    LinkedList<Double> constants = new LinkedList<>();

    public void addConst(Double constant) {
        constants.addLast(constant);
    }

    public void addX() {
        constants.addLast(null);
    }

    public double[] getNumbersArray(double x) {
        double[] numbers = new double[constants.size()];
        int i = 0;
        for(Double constant : constants) {
            if(constant == null) {
                numbers[i++] = x;
            } else {
                numbers[i++] = constant;
            }
        }
        return numbers;
    }
}
