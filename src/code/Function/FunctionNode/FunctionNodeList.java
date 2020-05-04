package code.Function.FunctionNode;

import code.Function.FunctionsExceptions.InvalidFunctionException;
import code.Function.FunctionsExceptions.InvalidSignException;
import code.Function.SingleVariableValuesList;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static code.Function.FunctionNode.NodeType.*;

public class FunctionNodeList implements Iterable<FunctionNode>{
    private List<FunctionNode> simpleFunction = new ArrayList<>();
    private SingleVariableValuesList varsConsts = new SingleVariableValuesList();

    public FunctionNodeList(String textFunction) throws InvalidFunctionException, InvalidSignException {
        int variableCount = 0;
        boolean changeNextValueToNegative;

        for (int i = 0; i < textFunction.length(); i++) {
            char c = textFunction.charAt(i);
            if ((c >= '0' && c <= '9')) {
                simpleFunction.add(new ConstantNode(variableCount++, simpleFunction.size()));
                int j = goToEndOfNumber(textFunction, i) - 1;
                varsConsts.addConst(Double.parseDouble
                        (textFunction.substring(i, j)));
                i = j;
            } else if (c == 'x' || c == 'X') {
                simpleFunction.add(new VariableNode("x", variableCount++, simpleFunction.size()));
                varsConsts.addX();
            } else {
                switch (c) {
                    case '(':
                        simpleFunction.add(new BracketNode(OPENING_BRACKET, simpleFunction.size()));
                        break;
                    case ')':
                        simpleFunction.add(new BracketNode(CLOSING_BRACKET, simpleFunction.size()));
                        break;
                    case '+':
                        simpleFunction.add(new OperatorNode('+', simpleFunction.size()));
                        break;
                    case '-':
                        if(isMinusSignAnOperator(i)) {
                            simpleFunction.add(new OperatorNode('-', simpleFunction.size()));
                            break;
                        } else {
                            simpleFunction.add(i-1, new ConstantNode(variableCount++, i-1));
                            varsConsts.addConst(0.0);
                            simpleFunction.add(new OperatorNode('-', simpleFunction.size()));
                        }

                    case '*':
                        simpleFunction.add(new OperatorNode('*', simpleFunction.size()));
                        break;
                    case '/':
                        simpleFunction.add(new OperatorNode('/', simpleFunction.size()));
                        break;
                    case '^':
                        simpleFunction.add(new OperatorNode('^', simpleFunction.size()));
                        break;
                    /*case 'E':
                        if (textFunction.charAt(i+1) == 'N' && textFunction.charAt(i+2) == 'D'
                                && i+3 == textFunction.length()) {
                            i = i + 3;
                        } else {
                            throw new InvalidFunctionException("Please check if function is correct.");
                        }*/
                    case '.':
                    case ' ':
                        break;
                    default:
                        throw new InvalidSignException(c + "");
                }
            }

        }
    }

    public int size() {
        return simpleFunction.size();
    }

    public FunctionNode getNodeAt(int i) {
        return simpleFunction.get(i);
    }

    public SingleVariableValuesList getVarsConsts() {
        return varsConsts;
    }

    @Override
    public Iterator<FunctionNode> iterator() {
        return simpleFunction.iterator();
    }

    public void setNodeToBlank(int index) {
        simpleFunction.set(index, new BlankNode(index));
    }

    public FunctionNode getPreviousVarConst(int index) {
        while(simpleFunction.get(index).getType() != CONST
            && simpleFunction.get(index).getType() != VARIABLE) {
            if(index > 0) {
                index--;
            } else {
                return null;
            }
        }
        return simpleFunction.get(index);
    }

    public FunctionNode getPreviousVarConst(FunctionNode functionNode) {
        int index = functionNode.getIndexInFNList();

        while(simpleFunction.get(index).getType() != CONST
                && simpleFunction.get(index).getType() != VARIABLE) {
            if(index > 0) {
                index--;
            } else {
                return null;
            }
        }
        return simpleFunction.get(index);
    }

    public FunctionNode getNextVarConst(int index) {
        while(simpleFunction.get(index).getType() != CONST
                && simpleFunction.get(index).getType() != VARIABLE) {
            if(index <= simpleFunction.size()) {
                index++;
            } else {
                return null;
            }
        }
        return simpleFunction.get(index);
    }

    public FunctionNode getNextVarConst(FunctionNode functionNode) {
        int index = functionNode.getIndexInFNList();

        while(simpleFunction.get(index).getType() != CONST
                && simpleFunction.get(index).getType() != VARIABLE) {
            if(index <= simpleFunction.size()) {
                index++;
            } else {
                return null;
            }
        }
        return simpleFunction.get(index);
    }

    private boolean isMinusSignAnOperator(int minusIndex) {
        int i = minusIndex - 1;
        while(simpleFunction.get(i).getType() == OPENING_BRACKET || simpleFunction.get(i).getType() == CLOSING_BRACKET) {
            if(i>0) {
                i--;
            } else {
                return false;
            }
        }
        if(simpleFunction.get(i).getType() == OPERATOR) {
            return false;
        } else {
            return true;
        }
    }

    private int goToEndOfNumber(String string, int fromN) throws IllegalArgumentException{
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

    private int goToEndOfNumber(char[] string, int fromN) throws IllegalArgumentException{
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

}
