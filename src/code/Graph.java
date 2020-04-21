package code;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Graph {
    public static BufferedImage createGraph(int height, int width, String function, Domain domain) {
        BufferedImage buffGraph = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graph = buffGraph.createGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(0,0, width,height);
        graph.setColor(Color.BLACK);
        //lines
        graph.drawLine(0,height/2,width,height/2);
        graph.drawLine(width/2,0,width/2,height);
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
