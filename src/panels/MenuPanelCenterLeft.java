package panels;

import javax.swing.*;
import java.awt.*;

public class MenuPanelCenterLeft extends JPanel {

    private MenuPanelButtons menuPanelButtons;

    public MenuPanelCenterLeft(MenuPanelCenterRight menuPanelCenterRight) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        add(Box.createVerticalStrut(50));

        menuPanelButtons = new MenuPanelButtons(menuPanelCenterRight);
        add(menuPanelButtons);
    }

    public MenuPanelButtons getMenuPanelButtons() {
        return menuPanelButtons;
    }
}
