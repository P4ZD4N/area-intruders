package panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InstructionsPanel extends JPanel {

    private JLabel labelTitle;

    private JList<String> listOfInstructions;

    private JButton buttonExit;

    private JPanel buttonPanel;
    private JPanel centerPanel;

    public InstructionsPanel() {

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(50, 0, 50, 0));
        setLayout(new BorderLayout());

        labelTitle = new JLabel("Instructions");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 48));
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        String[] instructions = {
                "1. You must enter your nickname in main menu.",
                "2. You can set ship appearance in main menu.",
                "3. You can set difficulty level in settings.",
                "4. You can customize difficulty level depends",
                "    on your preferences in settings.",
                "5. You can set one of three game modes.",
                "6. You can see top scores in TOP 10 Scores.",
                "7. You can play using arrows and space on your",
                "    keyboard or using buttons visible in game panel.",
                "8. Points you earn for hitting an opponent depends",
                "    on the difficulty settings and selected game mode.",
                "9. Game ends when enemies reach the ship's line ",
                "    or when you finish it by clicking ESC -> Exit."
        };

        listOfInstructions = new JList<>(instructions);
        listOfInstructions.setFixedCellWidth(500);
        listOfInstructions.setFont(new Font("Arial", Font.PLAIN, 18));
        listOfInstructions.setBackground(Color.BLACK);
        listOfInstructions.setForeground(Color.WHITE);

        buttonExit = new JButton("Exit");
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.addActionListener(e -> exitInstructions());
        buttonExit.setBackground(Color.WHITE);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(buttonExit);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(listOfInstructions);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(buttonPanel);

        add(labelTitle, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void exitInstructions() {

        Window window = SwingUtilities.getWindowAncestor(this);
        window.dispose();
    }
}
