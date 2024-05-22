package panels;

import game.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanelBottom extends JPanel {

    private JPanel labelPanel;
    private JPanel buttonsPanel;
    private JLabel playerNickname;
    private JLabel playerScore;
    private JButton moveLeftButton;
    private JButton shootButton;
    private JButton moveRightButton;
    private int score = 0;

    public GamePanelBottom(String nickname, Ship ship) {

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.setBackground(Color.BLACK);
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        playerNickname = new JLabel("Player: " + nickname);
        playerNickname.setForeground(Color.WHITE);
        playerNickname.setFont(new Font("Arial", Font.BOLD, 18));
        labelPanel.add(playerNickname);

        playerScore = new JLabel("Score: " + this.score);
        playerScore.setForeground(Color.WHITE);
        playerScore.setFont(new Font("Arial", Font.BOLD, 18));
        labelPanel.add(playerScore);

        add(labelPanel, BorderLayout.PAGE_END);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(Color.BLACK);

        moveLeftButton = new JButton("<");
        moveLeftButton.setBackground(Color.WHITE);
        moveLeftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ship.getMoveLeftAction().actionPerformed(null);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ship.getStopAction().actionPerformed(null);
            }
        });
        moveLeftButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        buttonsPanel.add(moveLeftButton);


        shootButton = new JButton("Shoot");
        shootButton.setBackground(Color.WHITE);
        shootButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ship.getShootAction().actionPerformed(null);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ship.getStopAction().actionPerformed(null);
            }
        });
        shootButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        buttonsPanel.add(shootButton);

        moveRightButton = new JButton(">");
        moveRightButton.setBackground(Color.WHITE);
        moveRightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ship.getMoveRightAction().actionPerformed(null);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ship.getStopAction().actionPerformed(null);
            }
        });
        moveRightButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");

        buttonsPanel.add(moveRightButton);

        add(buttonsPanel, BorderLayout.CENTER);
    }

    public void updateScore(int points) {

        this.score += points;
        playerScore.setText("Score: " + score);
    }

    public JPanel getLabelPanel() {
        return labelPanel;
    }

    public void setLabelPanel(JPanel labelPanel) {
        this.labelPanel = labelPanel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public JButton getMoveRightButton() {
        return moveRightButton;
    }

    public void setMoveRightButton(JButton moveRightButton) {
        this.moveRightButton = moveRightButton;
    }

    public JButton getShootButton() {
        return shootButton;
    }

    public void setShootButton(JButton shootButton) {
        this.shootButton = shootButton;
    }

    public JLabel getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(JLabel playerScore) {
        this.playerScore = playerScore;
    }

    public JButton getMoveLeftButton() {
        return moveLeftButton;
    }

    public void setMoveLeftButton(JButton moveLeftButton) {
        this.moveLeftButton = moveLeftButton;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void setButtonsPanel(JPanel buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public JLabel getPlayerNickname() {
        return playerNickname;
    }

    public void setPlayerNickname(JLabel playerNickname) {
        this.playerNickname = playerNickname;
    }
}
