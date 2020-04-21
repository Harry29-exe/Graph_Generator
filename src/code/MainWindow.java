package code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static code.Graph.createGraph;

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
                graphLabel.setIcon(new ImageIcon(createGraph(400, 400, functionField.getText(), new Domain(Domain.X_DOMAIN,10,10))) );
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
        generateButton = new JButton("Generate");
        generateButton.setText("Generate");
        graphLabel = new JLabel(new ImageIcon(this.buffGraph));
        functionField = new JTextField();
    }
}
