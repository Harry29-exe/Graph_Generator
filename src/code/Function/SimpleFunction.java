package code.Function;

import code.Function.FunctionNode.FunctionNode;
import code.Function.FunctionsExceptions.InvalidFunctionException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleFunction implements Iterable<FunctionNode>{
    List<FunctionNode> simpleFunction = new ArrayList<>();

    public SimpleFunction(String textFunction) {
        ArrayList<Integer> simpleFunction = new ArrayList<>();
        int variableCount = 0;

        for(int i = 0; i < textFunction.length; i++) {
            char c = textFunction[i];
            if( (c >= '0' && c <= '9') ) {
                simpleFunction.add(variableCount++);
                i = goToEndOfNumber(textFunction, i) - 1;
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
                        if(textFunction[i+1] == 'N' && textFunction[i+2] == 'D') {
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


    @Override
    public Iterator<FunctionNode> iterator() {
        return null;
    }
}
