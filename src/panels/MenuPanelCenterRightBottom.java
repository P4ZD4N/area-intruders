package panels;

import javax.swing.*;
import java.awt.*;

public class MenuPanelCenterRightBottom extends JPanel {

    private MenuShipPanel shipPanelLeft;
    private MenuShipPanel shipPanelRight;
    private JLabel shipIcon1;
    private JLabel shipIcon2;
    private JRadioButton submitShipIcon1;
    private JRadioButton submitShipIcon2;
    private ButtonGroup buttonGroup;
    private GridBagConstraints gbc;

    public MenuPanelCenterRightBottom() {

        setBackground(Color.BLACK);

        shipPanelLeft = new MenuShipPanel();
        shipIcon1 = new JLabel(new ImageIcon("src/img/3.png"));
        submitShipIcon1 = new JRadioButton();
        submitShipIcon1.setSelected(true);
        submitShipIcon1.setBackground(Color.BLACK);

        shipPanelLeft.add(shipIcon1);
        shipPanelLeft.add(submitShipIcon1);

        shipPanelRight = new MenuShipPanel();

        shipIcon2 = new JLabel(new ImageIcon("src/img/4.png"));
        submitShipIcon2 = new JRadioButton();
        submitShipIcon2.setBackground(Color.BLACK);

        shipPanelRight.add(shipIcon2);
        shipPanelRight.add(submitShipIcon2);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(submitShipIcon1);
        buttonGroup.add(submitShipIcon2);

        setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(shipPanelLeft, gbc);

        gbc.gridx = 1;
        add(shipPanelRight, gbc);
    }

    public MenuShipPanel getShipPanelLeft() {
        return shipPanelLeft;
    }

    public void setShipPanelLeft(MenuShipPanel shipPanelLeft) {
        this.shipPanelLeft = shipPanelLeft;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public JRadioButton getSubmitShipIcon2() {
        return submitShipIcon2;
    }

    public void setSubmitShipIcon2(JRadioButton submitShipIcon2) {
        this.submitShipIcon2 = submitShipIcon2;
    }

    public JRadioButton getSubmitShipIcon1() {
        return submitShipIcon1;
    }

    public void setSubmitShipIcon1(JRadioButton submitShipIcon1) {
        this.submitShipIcon1 = submitShipIcon1;
    }

    public JLabel getShipIcon2() {
        return shipIcon2;
    }

    public void setShipIcon2(JLabel shipIcon2) {
        this.shipIcon2 = shipIcon2;
    }

    public JLabel getShipIcon1() {
        return shipIcon1;
    }

    public void setShipIcon1(JLabel shipIcon1) {
        this.shipIcon1 = shipIcon1;
    }

    public MenuShipPanel getShipPanelRight() {
        return shipPanelRight;
    }

    public void setShipPanelRight(MenuShipPanel shipPanelRight) {
        this.shipPanelRight = shipPanelRight;
    }
}
