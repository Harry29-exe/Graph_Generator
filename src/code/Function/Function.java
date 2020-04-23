package code.Function;

import code.Function.Eqation.*;

import java.util.ArrayList;

public class Function {
    int openedBraces = 0;
    ArrayList<Double> variableList;

    private final int OPENING_BRACE = -1;
    private final int CLOSING_BRACE = -2;
    private final int PLUS = -3;
    private final int MINUS = -4;
    private final int MULTIPLICATION = -5;
    private final int DIVISION = -6;
    private final int POWER = -7;



    public Function(String function) {
        variableList = getVariableList(function);

    }

    public EquationList simpleFunctionToEquationList(ArrayList<Integer> simpleFunction) throws InvalidFunctionException {
        EquationList equations = new EquationList();
        int openedBraces = 0;
        int var1 = -1;
        int var2 = -1;
        for(int i = 0; i < simpleFunction.size(); i++) {
            int c = simpleFunction.get(i);
            if(c >= 0) {
                if(var1 != -1) {
                    var1 = c;
                } else if(var2 != -1) {
                    var2 = c;
                } else {
                    throw new InvalidFunctionException();
                }
            } else if(c == OPENING_BRACE) {
                openedBraces++;
            } else if(c == CLOSING_BRACE) {
                if(openedBraces > 0) {
                    openedBraces--;
                } else {
                    throw new InvalidFunctionException("The number of parentheses is not balanced");
                }
            } else {
                switch (c) {
                    case PLUS:
                        equations.addEquation(new AdditionEquation());
                        break;
                    case MINUS:
                        equations.addEquation(new SubstractionEqation());
                        break;
                    case MULTIPLICATION:
                        equations.addEquation(new MultiplicationEqation());
                        break;
                    case DIVISION:
                        equations.addEquation(new DivisionEqation());
                        break;
                    case POWER:
                        equations.addEquation(new PowerEqation());
                        break;
                }
            }
        }
    }

    private ArrayList<Double> getVariableList(String function) {
        ArrayList<Double> arrayList = new ArrayList<>();

        for(int i = 0; i < function.length(); i++) {
            char c = function.charAt(i);
            if(c == 'x' || c == 'X') {
                arrayList.add(null);
            } else if (c >= '0' && c <= '9' ) {
                int temp = goToEndOfNumber(function, i);
                arrayList.add( Double.parseDouble(function.substring(i, temp)) );
                i = temp;
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> createSimplifiedFunction(char[] function) {
        ArrayList<Integer> simpleFunction = new ArrayList<>();
        int variableCount = 0;

        for(int i = 0; i < function.length; i++) {
            char c = function[i];
            if( (c >= '0' && c <= '9') || c =='.') {
                simpleFunction.add(++variableCount);
                i = goToEndOfNumber(function, i) - 1;
            } else if(c == 'x' || c == 'X') {
                simpleFunction.add(0);
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
                }
            }
        }
        return simpleFunction;
    }

    private int goToEndOfNumber(String string, int fromN) throws IllegalArgumentException{
        boolean comaOccurred = false;
        while(true) {
            char c = string.charAt(fromN++);
            if( (c > '9' || c < '0') && c != ',') {
                return fromN - 1;
            } else if (c == ',') {
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
            if( (c > '9' || c < '0') && c != ',') {
                return (fromN - 1);
            } else if (c == ',') {
                c = string[fromN++];
                if(c < '0' || c > '9') {
                    throw new IllegalArgumentException("After the decimal point a digit must appear");
                }
            }
        }
    }

    private int getPriority(char sign) {
        int result = openedBraces * 3;
        if(sign == '+' || sign == '-') {
            return result + 1;
        } else if (sign == '*' || sign == '/') {
            return result + 2;
        } else if (sign == '^') {
            return result + 3;
        } else {
            throw new IllegalArgumentException();
        }

    }
}


