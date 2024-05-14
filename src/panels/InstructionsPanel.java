package panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InstructionsPanel extends JPanel {

    private JLabel labelTitle;
    private JLabel labelInstructions;
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

        labelInstructions = new JLabel(
            "<html>" +
                "<p>1. You can enter your nickname in main menu.</p>" +
                "<p>2. You can set ship appearance in main menu.</p>" +
                "<p>3. You can set difficulty level in main menu.</p>" +
                "</html>"
        );
        labelInstructions.setFont(new Font("Arial", Font.PLAIN, 18));
        labelInstructions.setForeground(Color.WHITE);

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
        centerPanel.add(Box.createVerticalStrut(50));
        centerPanel.add(labelInstructions);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(buttonPanel);

        add(labelTitle, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void exitInstructions() {

        Window window = SwingUtilities.getWindowAncestor(this);
        window.dispose();
    }

    public JLabel getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
    }


    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }

    public void setButtonExit(JButton buttonExit) {
        this.buttonExit = buttonExit;
    }

    public JLabel getLabelInstructions() {
        return labelInstructions;
    }

    public void setLabelInstructions(JLabel labelInstructions) {
        this.labelInstructions = labelInstructions;
    }
}
