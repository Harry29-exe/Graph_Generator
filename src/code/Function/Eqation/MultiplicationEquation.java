package code.Function.Eqation;

public class MultiplicationEquation implements Equation {
    int varIndex1;
    int varIndex2;

    public MultiplicationEquation(int varIndex1, int varIndex2) {
        this.varIndex1 = varIndex1;
        this.varIndex2 = varIndex2;
    }

    @Override
    public int[] neededVariablesIndexes() {
        return new int[] {varIndex1, varIndex2};
    }

    @Override
    public double result(double var1, double var2) {
        return var1 * var2;
    }
}
