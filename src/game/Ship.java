package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends JLabel implements KeyListener {

    private static final int SPEED = 5;

    private int dx = 0;

    private boolean isMirrorModeEnabled = false;

    private Action moveLeftAction;
    private Action moveRightAction;
    private Action stopAction;
    private Action shootAction;

    public Ship(ImageIcon icon) {

        setHorizontalAlignment(SwingConstants.CENTER);
        setIcon(icon);

        moveLeftAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dx = isMirrorModeEnabled ? SPEED : -SPEED;
            }
        };

        moveRightAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dx = isMirrorModeEnabled ? -SPEED : SPEED;
            }
        };

        stopAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dx = 0;
            }
        };

        shootAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                shoot();
            }
        };

        setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "moveLeft", moveLeftAction);
        setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "moveRight", moveRightAction);
        setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "stopLeft", stopAction);
        setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "stopRight", stopAction);
        setKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "shoot", shootAction);

        Timer timer = new Timer(10, e -> move());
        timer.start();
    }

    private void setKeyBinding(KeyStroke keyStroke, String actionName, Action action) {

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, actionName);
        getActionMap().put(actionName, action);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (isMirrorModeEnabled) {

            switch (keyCode) {
                case KeyEvent.VK_LEFT -> moveRightAction.actionPerformed(null);
                case KeyEvent.VK_RIGHT -> moveLeftAction.actionPerformed(null);
            }
        } else {

            switch (keyCode) {
                case KeyEvent.VK_LEFT -> moveLeftAction.actionPerformed(null);
                case KeyEvent.VK_RIGHT -> moveRightAction.actionPerformed(null);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> stopAction.actionPerformed(null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    private void move() {

        if (getX() + dx <= 1150 && getX() + dx >= 0) {

            setLocation(getX() + dx, getY());
        }
    }

    private void shoot() {

        int bulletX = getX() + getWidth() / 2 - 2;
        int bulletY = getY();
        Bullet bullet = new Bullet(bulletX, bulletY);
        getParent().add(bullet);
        bullet.move();
    }
    public void setMirrorModeEnabled(boolean mirrorModeEnabled) {
        isMirrorModeEnabled = mirrorModeEnabled;
    }

    public Action getMoveLeftAction() {
        return moveLeftAction;
    }

    public Action getShootAction() {
        return shootAction;
    }

    public Action getStopAction() {
        return stopAction;
    }

    public Action getMoveRightAction() {
        return moveRightAction;
    }
}
