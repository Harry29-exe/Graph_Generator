package code.Function.Eqation;

public class PowerEquation implements Equation {
    int varIndex1;
    int varIndex2;

    public PowerEquation(int varIndex1, int varIndex2) {
        this.varIndex1 = varIndex1;
        this.varIndex2 = varIndex2;
    }

    @Override
    public int[] neededVariablesIndexes() {
        return new int[] {varIndex1, varIndex2};
    }

    @Override
    public double result(double var1, double var2) {
        return Math.pow(var1, var2);
    }
}
