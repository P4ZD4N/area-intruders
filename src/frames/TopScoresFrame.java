package frames;

import panels.TopScoresPanel;

import javax.swing.*;

public class TopScoresFrame extends JFrame {

    private TopScoresPanel topScoresPanel;

    public TopScoresFrame() {

        super("Top 10 Scores");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        topScoresPanel = new TopScoresPanel();
        add(topScoresPanel);
    }
}
