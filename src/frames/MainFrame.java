import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        super("Area Intruders");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel);
    }
}
