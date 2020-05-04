package code.Function;

import code.Function.Eqation.Equation;

import java.util.LinkedList;

public class Function {
    SingleVariableValuesList varsConsts;
    LinkedList<Equation> equations;

    public Function(SingleVariableValuesList varsConsts, LinkedList<Equation> equations) {
        this.varsConsts = varsConsts;
        this.equations = equations;
    }

    public double getValueFor(double x) {
        double[] values = varsConsts.getNumbersArray(x);
        for(Equation equation : equations) {
            int valIndex1 = equation.neededVariablesIndexes()[0];
            int valIndex2 = equation.neededVariablesIndexes()[1];
            values[valIndex2] = equation.result(values[valIndex1],values[valIndex2]);
        }
        return values[values.length - 1];
    }
}
