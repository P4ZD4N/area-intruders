import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel extends JPanel {

    private JLabel labelTitle;
    private JButton jButtonPlay;
    private JButton jButtonInstructions;
    private JButton jButtonExit;
    private JLabel labelAuthor;

    public Panel() {

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(50, 0, 50, 0));
        setLayout(new BorderLayout());

        this.labelTitle = new JLabel("Cosmic Defenders");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 48));
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        this.jButtonPlay = new JButton("Play");
        jButtonPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonPlay.setBackground(Color.WHITE);
        jButtonPlay.setSize(300, 100);

        this.jButtonInstructions = new JButton("Instructions");
        jButtonInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonInstructions.addActionListener(e -> displayInstructions());
        jButtonInstructions.setBackground(Color.WHITE);

        this.jButtonExit = new JButton("Exit");
        jButtonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonExit.addActionListener(e -> exitGame());
        jButtonExit.setBackground(Color.WHITE);

        this.labelAuthor = new JLabel("® 2024 Wiktor Chudy. All Rights Reserved.");
        labelAuthor.setFont(new Font("Arial", Font.BOLD, 24));
        labelAuthor.setForeground(Color.WHITE);
        labelAuthor.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(jButtonPlay);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(jButtonInstructions);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(jButtonExit);

        add(labelTitle, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(labelAuthor, BorderLayout.SOUTH);
    }

    public void displayInstructions() {

        JOptionPane.showMessageDialog(this, "s", "ins", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exitGame() {

        System.exit(0);
    }
}
