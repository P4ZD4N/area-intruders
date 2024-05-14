package panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPanelCenterRight extends JPanel {

    private MenuPanelCenterRightTop menuPanelCenterRightTop;
    private MenuPanelCenterRightBottom menuPanelCenterRightBottom;

    public MenuPanelCenterRight() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(0, 0, 0, 180));

        menuPanelCenterRightTop = new MenuPanelCenterRightTop();
        menuPanelCenterRightBottom = new MenuPanelCenterRightBottom();

        add(Box.createVerticalStrut(50));
        add(menuPanelCenterRightTop);
        add(menuPanelCenterRightBottom);
    }

    public MenuPanelCenterRightBottom getMenuPanelCenterRightBottom() {
        return menuPanelCenterRightBottom;
    }

    public void setMenuPanelCenterRightBottom(MenuPanelCenterRightBottom menuPanelCenterRightBottom) {
        this.menuPanelCenterRightBottom = menuPanelCenterRightBottom;
    }

    public MenuPanelCenterRightTop getMenuPanelCenterRightTop() {
        return menuPanelCenterRightTop;
    }

    public void setMenuPanelCenterRightTop(MenuPanelCenterRightTop menuPanelCenterRightTop) {
        this.menuPanelCenterRightTop = menuPanelCenterRightTop;
    }
}
