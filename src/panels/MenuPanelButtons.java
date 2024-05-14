package panels;

import frames.InstructionsFrame;
import game.Ship;

import javax.swing.*;
import java.awt.*;

public class MenuPanelButtons extends JPanel {

    private MenuPanelCenterRight menuPanelCenterRight;
    private JButton buttonPlay;
    private JButton buttonInstructions;
    private JButton buttonExit;

    public MenuPanelButtons(MenuPanelCenterRight menuPanelCenterRight) {

        this.menuPanelCenterRight = menuPanelCenterRight;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        buttonPlay = new JButton("Play");
        buttonPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPlay.addActionListener(e -> startGame());
        buttonPlay.setBackground(Color.CYAN);
        buttonPlay.setFont(new Font("Arial", Font.BOLD, 18));
        buttonPlay.setForeground(Color.BLACK);
        buttonPlay.setMargin(new Insets(20, 95, 20, 95));

        buttonInstructions = new JButton("Instructions");
        buttonInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonInstructions.addActionListener(e -> displayInstructions());
        buttonInstructions.setBackground(Color.GREEN);
        buttonInstructions.setFont(new Font("Arial", Font.BOLD, 18));
        buttonInstructions.setForeground(Color.BLACK);
        buttonInstructions.setMargin(new Insets(20, 50, 20, 50));

        buttonExit = new JButton("Exit");
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.addActionListener(e -> exitGame());
        buttonExit.setBackground(Color.RED);
        buttonExit.setFont(new Font("Arial", Font.BOLD, 18));
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setMargin(new Insets(20, 95, 20, 95));

        add(Box.createVerticalStrut(50));
        add(buttonPlay);
        add(Box.createVerticalStrut(20));
        add(buttonInstructions);
        add(Box.createVerticalStrut(20));
        add(buttonExit);
    }

    public void startGame() {

        String nickname = menuPanelCenterRight.getMenuPanelCenterRightTop().getNicknameField().getText();
        boolean isShip1Selected = menuPanelCenterRight.getMenuPanelCenterRightBottom().getSubmitShipIcon1().isSelected();
        boolean isShip2Selected = menuPanelCenterRight.getMenuPanelCenterRightBottom().getSubmitShipIcon2().isSelected();

        if (nickname.isBlank()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Firstly enter your username!",
                            "Enter username!",
                            JOptionPane.WARNING_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Hello " + nickname + "! Get ready!",
                    "Get ready!",
                    JOptionPane.INFORMATION_MESSAGE);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.getContentPane().removeAll();

            if (isShip1Selected) {
                frame.getContentPane().add(new GamePanel(new Ship(new ImageIcon("src/img/1.png"))));
            } else if (isShip2Selected) {
                frame.getContentPane().add(new GamePanel(new Ship(new ImageIcon("src/img/2.png"))));
            }

            frame.revalidate();
            frame.repaint();
        }
    }

    public void displayInstructions() {

        new InstructionsFrame();
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
