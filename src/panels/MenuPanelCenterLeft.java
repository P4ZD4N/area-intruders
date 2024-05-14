package panels;

import javax.swing.*;
import java.awt.*;

public class MenuPanelCenterLeft extends JPanel {

    public MenuPanelCenterLeft(MenuPanelCenterRight menuPanelCenterRight) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        add(Box.createVerticalStrut(50));
        add(new MenuPanelButtons(menuPanelCenterRight));
    }
}
