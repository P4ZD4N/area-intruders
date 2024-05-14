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
        add(menuPanel);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }
}
