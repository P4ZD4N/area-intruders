package frames;

import panels.MenuPanel;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MenuPanel menuPanel;

    public MainFrame() {

        super("Area Intruders");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        menuPanel = new MenuPanel();
        getRootPane().setDefaultButton(menuPanel.getCenterPanel().getMenuPanelCenterLeft().getMenuPanelButtons().getButtonPlay());
        add(menuPanel);
    }
}
