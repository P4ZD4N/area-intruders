package panels;

import javax.swing.*;
import java.awt.*;

public class MenuPanelCenter extends JPanel {

    private MenuPanelCenterLeft menuPanelCenterLeft;
    private MenuPanelCenterRight menuPanelCenterRight;

    public MenuPanelCenter() {

        setLayout(new GridLayout(1, 2));

        setBackground(Color.BLACK);

        menuPanelCenterRight = new MenuPanelCenterRight();
        menuPanelCenterLeft = new MenuPanelCenterLeft(menuPanelCenterRight);

        add(menuPanelCenterLeft);
        add(menuPanelCenterRight);
    }

    public MenuPanelCenterLeft getMenuPanelCenterLeft() {
        return menuPanelCenterLeft;
    }

    public MenuPanelCenterRight getMenuPanelCenterRight() {
        return menuPanelCenterRight;
    }
}
