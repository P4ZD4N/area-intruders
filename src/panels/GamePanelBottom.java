package panels;

import game.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanelBottom extends JPanel {

    private String nickname;

    private JPanel labelPanel;
    private JPanel buttonsPanel;

    private JLabel playerNickname;
    private JLabel playerScore;

    private JButton moveLeftButton;
    private JButton shootButton;
    private JButton moveRightButton;

    private int score = 0;

    public GamePanelBottom(String nickname, GamePanel gamePanel, Ship ship) {

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        this.nickname = nickname;

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
                gamePanel.requestFocusInWindow();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ship.getStopAction().actionPerformed(null);
                gamePanel.requestFocusInWindow();
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
                gamePanel.requestFocusInWindow();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ship.getStopAction().actionPerformed(null);
                gamePanel.requestFocusInWindow();
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
                gamePanel.requestFocusInWindow();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ship.getStopAction().actionPerformed(null);
                gamePanel.requestFocusInWindow();
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

    public String getNickname() {
        return nickname;
    }

    public JPanel getLabelPanel() {
        return labelPanel;
    }

    public int getScore() {
        return score;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }
}
