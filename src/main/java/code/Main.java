package code;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        BufferedImage buffGraph = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graph = buffGraph.createGraphics();
        graph.setColor(Color.BLUE);
        graph.drawRect(0,0,400,400);
        MainWindow mainWindow = new MainWindow(buffGraph);
    }

    /*    public static void main(String[] args) {
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }*/
}
