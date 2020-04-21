package code.Function;

import java.util.ArrayList;
import java.util.LinkedList;
import static code.Function.CharTypes.*;

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
        ArrayList<Character> simplifiedFunction =
    }



    /*private CharTypes getCharType(char c) {
        if(c >= '0' && c <= '0') {
            return DIGIT;
        } else if (c == '(') {
            return OPENING_BRACKET;
        } else if (c == ')') {
            return CLOSING_BRACKET;
        } else if (c == '+' || c == '-' ||
                c == '*' || c == '/' || c == '^') {
            return OPERATOR;
        } else if (c == 'x' || c == 'X') {
            return VARIABLE;
        } else if(c == ',') {
            return COMA;
        } else if (c == ' ') {
            return SKIPPABLE;
        } else {
            throw new IllegalArgumentException(c +
                    "is not either operator bracket or digit");
        }
    }*/

    private ArrayList<Double> getVariableList(String function) {
        ArrayList<Double> arrayList = new ArrayList<>();

        for(int i = 0; i < function.length(); i++) {
            char c = function.charAt(i);
            if(c == 'x' || c == 'X') {
                arrayList.add(null);
            } else if (c >= '0' && c <= '9' ) {
                arrayList.add( Double.parseDouble(function.substring(i)) );
                i = goToEndOfNumber(function, i);
            }
        }
        return arrayList;
    }

    private ArrayList<Double> createSimplifiedFunction(char[] function) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < function.length; i++) {
            c
            int variableCount = 0;
            switch (type) {
                case DIGIT:
                    arrayList.add()
            }

        }
        return arrayList<Character>;
    }

    private int goToEndOfNumber(String string, int fromN) throws IllegalArgumentException{
        boolean comaOccurred = false;
        CharTypes lastType;
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

    private int goToEndOfNumber(char[] string, int fromN) throws IllegalArgumentException{
        boolean comaOccurred = false;
        CharTypes lastType;
        while(true) {
            char c = string[fromN++];
            if( (c > '9' || c < '0') && c != ',') {
                return fromN - 1;
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


