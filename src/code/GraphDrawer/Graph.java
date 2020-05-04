package code.GraphDrawer;

import code.Function.DepreciatedFunction;
import code.Function.Function;
import code.Function.FunctionInterpreter;
import code.Function.FunctionsExceptions.InvalidFunctionException;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Graph {
    private final static int defaultPrecision = 1;

    public static BufferedImage createGraph(int height, int width, String textFunction, Domain domain) throws InvalidFunctionException {
        BufferedImage buffGraph = createAxis(height, width);
        Pivot pivot = new Pivot(height, width, height/2, width/2, 50);
        Graphics2D graph = buffGraph.createGraphics();
        graph.setColor(Color.BLACK);
        FunctionInterpreter functionInterpreter = new FunctionInterpreter();
        Function function = functionInterpreter.createFunction(textFunction);

        double temp1 = function.getValueFor(pivot.pixelsToX(0));
        System.out.println(function.getValueFor(0));
        System.out.println(function.getValueFor(1));
        double temp2;
        for(int i = 0; i < (width/defaultPrecision); i++) {
            temp2 = function.getValueFor(pivot.pixelsToX(i*defaultPrecision+defaultPrecision));
            graph.drawLine(i*defaultPrecision, pivot.yToPixels(temp1), i*defaultPrecision+defaultPrecision, pivot.yToPixels(temp2));
            /*System.out.println("x1: " + i*defaultPrecision + " y1: " + pivot.yToPixels(temp1) +
                    " x2: " + i*defaultPrecision+defaultPrecision + " y2: " + pivot.yToPixels(temp2));*/
            /*System.out.println("x1: " + pivot.pixelsToX(i*defaultPrecision) + " y1: " + temp1 +
                    " x2: " +pivot.pixelsToX(i*defaultPrecision+defaultPrecision) + " y2: " + temp2);*/
            temp1 = temp2;
        }


        return buffGraph;
    }

    private static BufferedImage createAxis(int height, int width) {
        BufferedImage buffGraph = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graph = buffGraph.createGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(0,0, width,height);
        graph.setColor(Color.BLACK);
        //lines
        graph.drawLine(0,height/2,width,height/2);
        graph.drawLine(width/2, 0, width/2, height);
        //Arrows
        graph.drawLine(width - 1, height/2, (width-1)- width/40, height/2 - width/40 );
        graph.drawLine(width - 1, height/2, (width-1)- width/40, height/2 + width/40 );
        graph.drawLine(width/2, 0, (width/2)- width/40, width/40 );
        graph.drawLine(width/2, 0, (width/2)+ width/40, width/40 );

        return buffGraph;
    }

    /*private static void drawArrow(Graphics2D graph, ) {

    }*/
}
