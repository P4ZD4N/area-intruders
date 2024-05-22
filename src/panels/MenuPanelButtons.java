package panels;

import frames.InstructionsFrame;
import frames.SettingsFrame;
import game.Ship;

import javax.swing.*;
import java.awt.*;

public class MenuPanelButtons extends JPanel {

    private MenuPanelCenterRight menuPanelCenterRight;
    private Dimension buttonSize;
    private JButton buttonPlay;
    private JButton buttonInstructions;
    private JButton buttonSettings;
    private SettingsPanel settings;
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

        buttonExit = new JButton("Exit");
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.addActionListener(e -> exitGame());
        buttonExit.setBackground(Color.RED);
        buttonExit.setFont(new Font("Arial", Font.BOLD, 18));
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setPreferredSize(buttonSize);
        buttonExit.setMinimumSize(buttonSize);
        buttonExit.setMaximumSize(buttonSize);

        add(Box.createVerticalStrut(50));
        add(buttonPlay);
        add(Box.createVerticalStrut(20));
        add(buttonInstructions);
        add(Box.createVerticalStrut(20));
        add(buttonSettings);
        add(Box.createVerticalStrut(20));
        add(buttonExit);
    }

    public void startGame() {

        String nickname = menuPanelCenterRight.getMenuPanelCenterRightTop().getNicknameField().getText();
        boolean isShip1Selected = menuPanelCenterRight.getMenuPanelCenterRightBottom().getSubmitShipIcon1().isSelected();
        boolean isShip2Selected = menuPanelCenterRight.getMenuPanelCenterRightBottom().getSubmitShipIcon2().isSelected();

        if (settings == null) {

            settings = new SettingsPanel();
        }

        if (nickname.isBlank()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Firstly enter your username!",
                            "Enter username!",
                            JOptionPane.WARNING_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Hello " +
                            nickname +
                            "! Get ready!" +
                            " You will get " +
                            settings.getPointsForEnemyHit() +
                            " points for hitting each enemy!",
                    "Get ready!",
                    JOptionPane.INFORMATION_MESSAGE);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.getContentPane().removeAll();

            if (isShip1Selected) {
                frame.getContentPane().add(new GamePanel(
                        new Ship(new ImageIcon("src/img/1.png")),
                        nickname,
                        settings
                ));
            } else if (isShip2Selected) {
                frame.getContentPane().add(new GamePanel(
                        new Ship(new ImageIcon("src/img/2.png")),
                        nickname,
                        settings
                ));
            }

            frame.revalidate();
            frame.repaint();
        }
    }

    public void displayInstructions() {

        new InstructionsFrame();
    }

    public void displayOptions() {

        SettingsFrame settings = new SettingsFrame();
        this.settings = settings.getSettingsPanel();
    }

    public void exitGame() {

        System.exit(0);
    }

    public JButton getButtonPlay() {
        return buttonPlay;
    }

    public void setButtonPlay(JButton buttonPlay) {
        this.buttonPlay = buttonPlay;
    }

    public JButton getButtonInstructions() {
        return buttonInstructions;
    }

    public void setButtonInstructions(JButton buttonInstructions) {
        this.buttonInstructions = buttonInstructions;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }

    public void setButtonExit(JButton buttonExit) {
        this.buttonExit = buttonExit;
    }
}
