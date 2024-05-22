package frames;

import panels.SettingsPanel;

import javax.swing.*;

public class SettingsFrame extends JFrame {

    private SettingsPanel settingsPanel;

    public SettingsFrame() {

        super("Settings");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        settingsPanel = new SettingsPanel();
        add(settingsPanel);
    }

    public SettingsPanel getSettingsPanel() {
        return settingsPanel;
    }
}
