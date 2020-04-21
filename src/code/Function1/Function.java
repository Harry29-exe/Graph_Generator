package code.Function1;

import java.util.LinkedList;

import static code.Function1.CharTypes.*;

public class Function {
    int openBraces = 0;
    int[] variables;
    LinkedList<Functionable> equations;

    public Function(String function) {
        equations = new LinkedList<>();
        int i = 0;
        Double tempVar1 = null;
        Double tempVar2 = null;

        while(i < function.length()) {
            switch(getCharType(function.charAt(i))) {
                case DIGIT:
                    if(tempVar1 == null) {
                        tempVar1 = Double.parseDouble(function.substring(i));
                    } else {
                        tempVar2 = Double.parseDouble(function.substring(i));
                    }
                    i = goToEndOfNumber(function, i);
                    break;
                case OPENING_BRACKET:


            }
            i++;
        }
    }

    private CharTypes getCharType(char c) {
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
    }

    private int goToEndOfNumber(String string, int fromN) throws IllegalArgumentException{
        boolean comaOccurred = false;
        CharTypes lastType;
        while(true) {
            CharTypes type = getCharType(string.charAt(fromN++));
            if(type != DIGIT && type != COMA) {
                return fromN - 1;
            } else if (type == COMA) {
                type = getCharType(string.charAt(fromN++));
                if(type != DIGIT) {
                    throw new IllegalArgumentException("After the decimal point a digit must appear");
                }
            }
        }
    }





}