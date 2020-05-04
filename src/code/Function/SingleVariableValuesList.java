package code.Function;

import java.util.LinkedList;
import java.util.List;

public class SingleVariableValuesList {
    LinkedList<VarConst> constants = new LinkedList<>();

    public void addConst(Double constant) {
        constants.addLast(new VarConst(false, constant));
    }

    public void addX() {
        constants.addLast(new VarConst(false, null));
    }

    public double[] getNumbersArray(double x) {
        double[] numbers = new double[constants.size()];
        int i = 0;
        for(VarConst vS : constants) {
            if(vS.value == null) {
                if(vS.isNegative) {
                    numbers[i++] = -x;
                } else {
                    numbers[i++] = x;
                }
            } else {
                if(vS.isNegative) {
                    numbers[i++] = -vS.value;
                } else {
                    numbers[i++] = vS.value;
                }
            }
        }
        return numbers;
    }

    class VarConst {
        boolean isNegative;
        Double value;

        public VarConst(boolean isNegative, Double value) {
            this.isNegative = isNegative;
            this.value = value;
        }
    }
}
