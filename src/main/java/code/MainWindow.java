package code;

import code.Function.FunctionsExceptions.InvalidFunctionException;
import code.GraphDrawer.Domain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static code.GraphDrawer.Graph.createGraph;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JButton generateButton;
    private JPanel topPanel;
    private JLabel graphLabel;
    private JTextField functionField;
    private BufferedImage buffGraph;

    public MainWindow(BufferedImage buffGraph) {
        this.buffGraph = buffGraph;


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("listener dziala");
                try {
                    graphLabel.setIcon(new ImageIcon(createGraph(400, 400, functionField.getText(), new Domain(Domain.X_DOMAIN,10,10))) );
                } catch (InvalidFunctionException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void setGraph(BufferedImage graph) {
        graphLabel.setIcon(new ImageIcon(graph));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    private void createUIComponents() {
        generateButton = new JButton();
        generateButton.setText("Generate");


        graphLabel = new JLabel(new ImageIcon(this.buffGraph));
        functionField = new JTextField();
    }
}
