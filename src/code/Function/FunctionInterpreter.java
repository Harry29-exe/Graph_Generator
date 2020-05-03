package code.Function;

import code.Function.FunctionNode.FunctionNodeList;
import code.Function.FunctionsExceptions.InvalidFunctionException;

import java.util.LinkedList;

public  class FunctionInterpreter {
    private Function function;
    private LinkedList<Double> variables;

    private FunctionNodeList functionNodeList;

    public Function createFunction(String textFunction) throws InvalidFunctionException {
        functionNodeList = new FunctionNodeList(textFunction);

        for(int i = 0; i< functionNodeList.)
    }
}
