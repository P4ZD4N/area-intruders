package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends JLabel implements KeyListener {

    private int dx = 0;
    private static final int SPEED = 5;

    public Ship(ImageIcon icon) {

        setHorizontalAlignment(SwingConstants.CENTER);
        setIcon(icon);

        Action moveLeftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx = -SPEED;
            }
        };

        Action moveRightAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx = SPEED;
            }
        };

        Action stopAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx = 0;
            }
        };

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        getActionMap().put("moveLeft", moveLeftAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        getActionMap().put("moveRight", moveRightAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "stopLeft");
        getActionMap().put("stopLeft", stopAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "stopRight");
        getActionMap().put("stopRight", stopAction);

        Timer timer = new Timer(10, e -> move());
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> dx = -1;
            case KeyEvent.VK_RIGHT -> dx = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> dx = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void move() {

        setLocation(getX() + dx, getY());
    }
}
