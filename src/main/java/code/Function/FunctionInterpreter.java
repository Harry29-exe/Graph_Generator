package code.Function;

import code.Function.Eqation.*;
import code.Function.FunctionNode.*;
import code.Function.FunctionsExceptions.InvalidFunctionException;
import code.Function.FunctionsExceptions.InvalidSignException;

import java.util.LinkedList;

import static code.Function.FunctionNode.NodeType.*;

public  class FunctionInterpreter {
    private Function function;
    private FunctionNodeList functionNodeList;

    public Function createFunction(String textFunction) throws InvalidFunctionException {
        try {
            functionNodeList = new FunctionNodeList(textFunction);
            System.out.println(functionNodeList);
        } catch (InvalidSignException e) {
            e.printStackTrace();
        }

        LinkedList<Equation> equations = generateEquationList();
        for(Equation equation : equations) {
            System.out.println("[" + equation.neededVariablesIndexes()[0] + equation.neededVariablesIndexes()[1] + "]");
        }
        return new Function(functionNodeList.getVarsConsts(), equations);
    }

    private LinkedList<Equation> generateEquationList() throws InvalidFunctionException {
        LinkedList<EquationPrototype> equationPrototypes = new LinkedList<>();

        int openedBraces = 0;
        for(FunctionNode fNode : functionNodeList) {
            NodeType nodeType = fNode.getType();
            if(nodeType == OPENING_BRACKET) {
                openedBraces++;
            } else if(nodeType == CLOSING_BRACKET) {
                if(openedBraces > 0) {
                    openedBraces--;
                } else {
                    throw new InvalidFunctionException("The number of parentheses is not balanced");
                }
            } else if (nodeType == OPERATOR) {
                OperatorNode operatorNode = (OperatorNode) fNode;
                equationPrototypes.add(new EquationPrototype(
                        ( (OperatorNode) fNode ).getOperatorType(), openedBraces, fNode.getIndexInFNList()) );
            }
        }
        equationPrototypes.sort(EquationPrototype::compareTo);

        LinkedList<Equation> equations = new LinkedList<>();
        for(EquationPrototype equationPrototype : equationPrototypes) {
            equations.add(createEquation(equationPrototype));
        }

        return equations;
    }



    private Equation createEquation(EquationPrototype equationPrototype) throws InvalidFunctionException {
        int index = equationPrototype.getOperatorIndex();

        int varIndex1;
        int varIndex2;
        int var1NodeIndex;
        if( functionNodeList.getPreviousVarConst(index) == null ||
            functionNodeList.getNextVarConst(index) == null) {
            throw new InvalidFunctionException("Please check if function is correct");
        } else {
            var1NodeIndex = functionNodeList.getPreviousVarConst(index).getIndexInFNList();
            varIndex1 = ((ValueNode) functionNodeList.getPreviousVarConst(index)).getIndexInVCList();
            varIndex2 = ((ValueNode) functionNodeList.getNextVarConst(index)).getIndexInVCList();
        }

        switch(equationPrototype.getEquationType()) {
            case '+':
                functionNodeList.setNodeToBlank(var1NodeIndex);
                return new AdditionEquation(varIndex1, varIndex2);
            case '-':
                functionNodeList.setNodeToBlank(var1NodeIndex);
                return new SubtractionEquation(varIndex1, varIndex2);
            case '*':
                functionNodeList.setNodeToBlank(var1NodeIndex);
                return new MultiplicationEquation(varIndex1, varIndex2);
            case '/':
                functionNodeList.setNodeToBlank(var1NodeIndex);
                return new DivisionEquation(varIndex1, varIndex2);
            case '^':
                functionNodeList.setNodeToBlank(var1NodeIndex);
                return new PowerEquation(varIndex1, varIndex2);
            default:
                throw new IllegalArgumentException();
        }

    }

    private class EquationPrototype implements Comparable<EquationPrototype>{
        private final int priority;
        private final int operatorIndex;
        private final char equationType;
        @Override
        public String toString() {
            return new String("Priority:" + priority + " operator index: " + operatorIndex);
        }

        public EquationPrototype(char equationType, int openedBrackets, int indexInSimpleFunction) {
            this.priority = calculatePriority(equationType, openedBrackets);
            this.equationType = equationType;
            this.operatorIndex = indexInSimpleFunction;
        }

        private int calculatePriority(char equationType, int openedBraces) {
            int result = openedBraces * 3;
            if(equationType == '+' || equationType == '-') {
                return result + 1;
            } else if (equationType  == '*' || equationType == '/') {
                return result + 2;
            } else if (equationType == '^') {
                return result + 3;
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override
        public int compareTo(EquationPrototype eNode) {
            return eNode.getPriority() - this.priority;
        }

        public int getPriority() {
            return priority;
        }

        public int getOperatorIndex() {
            return operatorIndex;
        }

        public char getEquationType() {
            return equationType;
        }
    }



}
