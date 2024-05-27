package panels;

import frames.InstructionsFrame;
import frames.SettingsFrame;
import frames.TopScoresFrame;
import game.Ship;

import javax.swing.*;
import java.awt.*;

public class MenuPanelButtons extends JPanel {

    private SettingsPanel settings;

    private MenuPanelCenterRight menuPanelCenterRight;

    private Dimension buttonSize;

    private JButton buttonPlay;
    private JButton buttonInstructions;
    private JButton buttonSettings;
    private JButton buttonTopScores;
    private JButton buttonExit;

    public MenuPanelButtons(MenuPanelCenterRight menuPanelCenterRight) {

        this.menuPanelCenterRight = menuPanelCenterRight;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        buttonSize = new Dimension(300, 75);

        buttonPlay = new JButton("Play");
        buttonPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPlay.addActionListener(e -> startGame());
        buttonPlay.setBackground(Color.CYAN);
        buttonPlay.setFont(new Font("Arial", Font.BOLD, 18));
        buttonPlay.setForeground(Color.BLACK);
        buttonPlay.setPreferredSize(buttonSize);
        buttonPlay.setMinimumSize(buttonSize);
        buttonPlay.setMaximumSize(buttonSize);

        buttonInstructions = new JButton("Instructions");
        buttonInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonInstructions.addActionListener(e -> displayInstructions());
        buttonInstructions.setBackground(Color.GREEN);
        buttonInstructions.setFont(new Font("Arial", Font.BOLD, 18));
        buttonInstructions.setForeground(Color.BLACK);
        buttonInstructions.setPreferredSize(buttonSize);
        buttonInstructions.setMinimumSize(buttonSize);
        buttonInstructions.setMaximumSize(buttonSize);

        buttonSettings = new JButton("Settings");
        buttonSettings.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonSettings.addActionListener(e -> displayOptions());
        buttonSettings.setBackground(Color.ORANGE);
        buttonSettings.setFont(new Font("Verdana", Font.BOLD, 18));
        buttonSettings.setForeground(Color.BLACK);
        buttonSettings.setPreferredSize(buttonSize);
        buttonSettings.setMinimumSize(buttonSize);
        buttonSettings.setMaximumSize(buttonSize);

        buttonTopScores = new JButton("Top 10 Scores");
        buttonTopScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonTopScores.addActionListener(e -> displayTopScores());
        buttonTopScores.setBackground(Color.MAGENTA);
        buttonTopScores.setFont(new Font("Verdana", Font.BOLD, 18));
        buttonTopScores.setForeground(Color.BLACK);
        buttonTopScores.setPreferredSize(buttonSize);
        buttonTopScores.setMinimumSize(buttonSize);
        buttonTopScores.setMaximumSize(buttonSize);

        buttonExit = new JButton("Exit");
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.addActionListener(e -> exitGame());
        buttonExit.setBackground(Color.RED);
        buttonExit.setFont(new Font("Arial", Font.BOLD, 18));
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setPreferredSize(buttonSize);
        buttonExit.setMinimumSize(buttonSize);
        buttonExit.setMaximumSize(buttonSize);

        add(buttonPlay);
        add(Box.createVerticalStrut(20));
        add(buttonInstructions);
        add(Box.createVerticalStrut(20));
        add(buttonSettings);
        add(Box.createVerticalStrut(20));
        add(buttonTopScores);
        add(Box.createVerticalStrut(20));
        add(buttonExit);
    }

    public void startGame() {

        String nickname = menuPanelCenterRight.getMenuPanelCenterRightTop().getNicknameField().getText();
        boolean isShip1Selected = menuPanelCenterRight.getMenuPanelCenterRightBottom().getSubmitShipIcon1().isSelected();

        if (nickname.isBlank()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Firstly enter your username!",
                    "Enter username!",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (settings == null) {

            settings = new SettingsPanel();
        }

        int pointsForEnemyHit = settings.getPointsForEnemyHit();
        String message = "Hello " + nickname + "! Get ready!" + " You will get " + pointsForEnemyHit + " points for hitting each enemy!";
        String shipImagePath = isShip1Selected ? "src/img/1.png" : "src/img/2.png";
        ImageIcon shipIcon = new ImageIcon(shipImagePath);

        JOptionPane.showMessageDialog(null, message, "Get ready!", JOptionPane.INFORMATION_MESSAGE);

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new GamePanel(new Ship(shipIcon), nickname, settings));
        frame.revalidate();
        frame.repaint();
    }

    public void displayInstructions() {

        new InstructionsFrame();
    }

    public void displayOptions() {

        SettingsFrame settings = new SettingsFrame();
        this.settings = settings.getSettingsPanel();
    }

    public void displayTopScores() {

        new TopScoresFrame();
    }

    public void exitGame() {

        System.exit(0);
    }

    public JButton getButtonPlay() {

        return buttonPlay;
    }
}
