package code.Function.Eqation;

import code.Function.Eqation.Equation;

public class AdditionEquation implements Equation {
    int varIndex1;
    int varIndex2;
    double var1;
    double var2;
    @Override
    public int[] neededVariablesIndexes() {

        return new int[0];
    }

    @Override
    public double result(double var1, double var2) {
        return 0;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
