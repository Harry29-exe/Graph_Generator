package code.Function.Eqation;

import code.Function.Eqation.Equation;

import java.util.Iterator;
import java.util.LinkedList;

public class EquationList implements Iterable<Equation> {
    LinkedList<Equation>  equations = new LinkedList<>();

    public void addEquation(Equation equation) {
        int priority = equation.getPriority();
        if(equations.getLast().getPriority() > priority) {
            equations.addLast(equation);
        } else {
            int i = 0;
            while (priority <= equations.get(i).getPriority()) {
                i++;
            }
            equations.add(i, equation);
        }
    }

    @Override
    public Iterator<Equation> iterator() {
        return new Iterator<Equation>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < equations.size();
            }

            @Override
            public Equation next() {
                return equations.get(i++);
            }
        };
    }
}
