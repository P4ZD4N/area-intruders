package panels;

import game.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    private GamePanelTop top;
    private GamePanelBottom bottom;
    private SettingsPanel settings;

    public GamePanel(Ship ship, String nickname, SettingsPanel settings) {

        setLayout(new BorderLayout());

        this.settings = settings;
        bottom = new GamePanelBottom(nickname, ship);
        top = new GamePanelTop(ship, bottom, settings);

        add(top, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {


                    top.pauseGame();
                    top.displayPauseOptions();
                }
            }
        });
    }
}
