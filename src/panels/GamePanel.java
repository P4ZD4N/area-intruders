package panels;

import game.Ship;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GamePanel extends JPanel {

    private Ship controlledLabel;

    public GamePanel(Ship ship) {

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(50, 0, 50, 0));
        setLayout(new BorderLayout());

        controlledLabel = ship;
        controlledLabel.addKeyListener(controlledLabel);

        add(controlledLabel, BorderLayout.SOUTH);
    }

    public Ship getControlledLabel() {
        return controlledLabel;
    }

    public void setControlledLabel(Ship controlledLabel) {
        this.controlledLabel = controlledLabel;
    }
}
