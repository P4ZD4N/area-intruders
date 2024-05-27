package frames;

import panels.InstructionsPanel;
import javax.swing.*;

public class InstructionsFrame extends JFrame {

    private InstructionsPanel instructionsPanel;

    public InstructionsFrame() {

        super("Instructions");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        instructionsPanel = new InstructionsPanel();
        add(instructionsPanel);
    }
}
