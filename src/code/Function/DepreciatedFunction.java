package code.Function;

import code.Function.Eqation.*;
import code.Function.FunctionsExceptions.InvalidFunctionException;

import java.util.ArrayList;
import java.util.LinkedList;

@Deprecated
public class DepreciatedFunction {
    private ArrayList<Double> constantList;
    public ArrayList<Integer> simpleFunction;

    private ArrayList<Equation> function = new ArrayList<>();

    private final int OPENING_BRACE = -1;
    private final int CLOSING_BRACE = -2;
    private final int PLUS = -3;
    private final int MINUS = -4;
    private final int MULTIPLICATION = -5;
    private final int DIVISION = -6;
    private final int POWER = -7;
    private final int BLANK = -8;



    public DepreciatedFunction(String stringFunction) throws InvalidFunctionException {
        stringFunction = "(" + stringFunction + ")" + "END";
        constantList = getConstantList(stringFunction);
        simpleFunction = createSimpleFunction(stringFunction.toCharArray());
        System.out.println(simpleFunction);
        LinkedList<EquationNode> equationNodes = simpleFunctionToEquationNodes(simpleFunction);
        for(EquationNode node: equationNodes) {
            function.add(createEquation(node.getOperatorIndex(), simpleFunction));
        }
    }

    public double getValueFor(double x) {
        Double[] vL = new Double[this.constantList.size()];
        for(int i = 0; i< this.constantList.size(); i++) {
            if(this.constantList.get(i) != null) {
                vL[i] = this.constantList.get(i);
            } else {
                vL[i] = x;
            }
        }
        for(Equation equation: function) {
            int varIndex1 = equation.neededVariablesIndexes()[0];
            int varIndex2 = equation.neededVariablesIndexes()[1];
            vL[varIndex2] = equation.result(vL[varIndex1], vL[varIndex2]);
        }
        return vL[vL.length - 1];
    }

    public Equation createEquation(int operatorIndex, ArrayList<Integer> simpleFunction) {
        System.out.println(simpleFunction);
        int varIndex1;
        int varIndex2;
        try {
            int i = operatorIndex - 1;
            while (simpleFunction.get(i) == OPENING_BRACE || simpleFunction.get(i) == CLOSING_BRACE || simpleFunction.get(i) == BLANK) {
                i--;
            }
            varIndex1 = simpleFunction.get(i);
        } catch (ArrayIndexOutOfBoundsException ex) {
            varIndex1 = -1;
        }
        try {
            int i = operatorIndex + 1;
            while (simpleFunction.get(i) == OPENING_BRACE || simpleFunction.get(i) == CLOSING_BRACE || simpleFunction.get(i) == BLANK) {
                i++;
            }
            varIndex2 = simpleFunction.get(i);
        } catch (ArrayIndexOutOfBoundsException ex) {
            varIndex2 = -1;
        }
        Equation equation;
        switch (simpleFunction.get(operatorIndex)) {
            case PLUS:
                equation = new AdditionEquation(simpleFunction.get(varIndex1), simpleFunction.get(varIndex2));
                break;
            case MINUS:
                if(varIndex1 < 0) {
                    equation = new OppositeEquation(varIndex2, varIndex2);
                    simpleFunction.set(operatorIndex, BLANK);
                    return equation;
                }
                equation = new SubtractionEquation(simpleFunction.get(varIndex1), simpleFunction.get(varIndex2));
                break;
            case DIVISION:
                equation = new DivisionEquation(simpleFunction.get(varIndex1), simpleFunction.get(varIndex2));
                break;
            case MULTIPLICATION:
                equation = new MultiplicationEquation(simpleFunction.get(varIndex1), simpleFunction.get(varIndex2));
                break;
            case POWER:
                equation = new PowerEquation(simpleFunction.get(varIndex1), simpleFunction.get(varIndex2));
                break;
            default:
                throw new IllegalArgumentException("Sorry I don't know what: " + simpleFunction.get(operatorIndex) + " at index: " + operatorIndex +" means");
        }

        simpleFunction.set(varIndex1, BLANK);
        simpleFunction.set(operatorIndex, BLANK);
        return equation;
    }

    public LinkedList<EquationNode> simpleFunctionToEquationNodes(ArrayList<Integer> simpleFunction) throws InvalidFunctionException {
        LinkedList<EquationNode> equationNodes = new LinkedList<>();
        int openedBraces = 0;
        int var1 = -1;
        int var2 = -1;
        for(int i = 0; i < simpleFunction.size(); i++) {
            int c = simpleFunction.get(i);
            if(c == OPENING_BRACE) {
                openedBraces++;
            } else if(c == CLOSING_BRACE) {
                if(openedBraces > 0) {
                    openedBraces--;
                } else {
                    throw new InvalidFunctionException("The number of parentheses is not balanced");
                }
            } else if (c < CLOSING_BRACE && c > BLANK ){
                equationNodes.add(new EquationNode( calculatePriority(c, openedBraces), i));
            }
        }
        equationNodes.sort(EquationNode::compareTo);
        return equationNodes;
    }

    private ArrayList<Double> getConstantList(String function) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for(int i = 0; i < function.length(); i++) {
            char c = function.charAt(i);
            if(c == 'x' | c == 'X') {
                arrayList.add(null);
            } else if (c >= '0' && c <= '9' ) {
                int temp = goToEndOfNumber(function, i);
                arrayList.add( Double.parseDouble(function.substring(i, temp)) );
                i = temp;
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> createSimpleFunction(char[] function) throws InvalidFunctionException{
        ArrayList<Integer> simpleFunction = new ArrayList<>();
        int variableCount = 0;

        for(int i = 0; i < function.length; i++) {
            char c = function[i];
            if( (c >= '0' && c <= '9') ) {
                simpleFunction.add(variableCount++);
                i = goToEndOfNumber(function, i) - 1;
            } else if(c == 'x' || c == 'X') {
                simpleFunction.add(variableCount++);
            } else {
                switch(c) {
                    case '(':
                        simpleFunction.add(OPENING_BRACE);
                        break;
                    case ')':
                        simpleFunction.add(CLOSING_BRACE);
                        break;
                    case '+':
                        simpleFunction.add(PLUS);
                        break;
                    case '-':
                        simpleFunction.add(MINUS);
                        break;
                    case '*':
                        simpleFunction.add(MULTIPLICATION);
                        break;
                    case '/':
                        simpleFunction.add(DIVISION);
                        break;
                    case '^':
                        simpleFunction.add(POWER);
                        break;
                    case 'E':
                        if(function[i+1] == 'N' && function[i+2] == 'D') {
                            return simpleFunction;
                        } else {
                            throw new InvalidFunctionException("Please check if function is correct.");
                        }
                    case '.':
                    case ' ':
                        break;
                    default:
                        throw new InvalidFunctionException("Sorry I don't know what sign \"" + c + "\" means.");
                }
            }
        }
        return simpleFunction;
    }

    /*public int getClosestVarBehindOf(int index) {
        int i = index;
        while(simpleFunction.get(i) < 0 && simpleFunction.get(i) != null) {
            i--;
        }
        return i;
    }

    public int getClosestVarAheadOf(int index) {
        int i = index;
        while(simpleFunction.get(i) < 0 && simpleFunction.get(i) != null) {
            i++;
        }
        return i;
    }*/

    private int calculatePriority(int equationType, int openedBraces) {
        int result = openedBraces * 3;
        if(equationType == PLUS || equationType == MINUS) {
            return result + 1;
        } else if (equationType  == MULTIPLICATION || equationType == DIVISION) {
            return result + 2;
        } else if (equationType == POWER) {
            return result + 3;
        } else {
            throw new IllegalArgumentException();
        }

    }

    private int goToEndOfNumber(String string, int fromN) throws IllegalArgumentException{
        boolean comaOccurred = false;
        while(true) {
            char c = string.charAt(fromN++);
            if( (c > '9' || c < '0') && c != '.') {
                return fromN - 1;
            } else if (c == '.') {
                c = string.charAt(fromN++);
                if(c < '0' || c > '9') {
                    throw new IllegalArgumentException("After the decimal point a digit must appear");
                }
            }
        }
    }

    public int goToEndOfNumber(char[] string, int fromN) throws IllegalArgumentException{
        boolean comaOccurred = false;
        while(true) {
            char c = string[fromN++];
            if( (c > '9' || c < '0') && c != '.') {
                return (fromN - 1);
            } else if (c == '.') {
                c = string[fromN++];
                if(c < '0' || c > '9') {
                    throw new IllegalArgumentException("After the decimal point a digit must appear");
                }
            }
        }
    }

    private class EquationNode implements Comparable<EquationNode>{
        private final int priority;
        private final int operatorIndex;

        @Override
        public String toString() {
            return new String("Priority:" + priority + " operator index: " + operatorIndex);
        }
        public EquationNode(int priority, int indexInSimpleFunction) {
            this.priority = priority;
            this.operatorIndex = indexInSimpleFunction;
        }

        @Override
        public int compareTo(EquationNode eNode) {
            return eNode.getPriority() - this.priority;
        }

        public int getPriority() {
            return priority;
        }

        public int getOperatorIndex() {
            return operatorIndex;
        }
    }
}


