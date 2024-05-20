package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends JLabel implements KeyListener {

    private Action moveLeftAction;
    private Action moveRightAction;
    private Action stopAction;
    private Action shootAction;

    private int dx = 0;
    private static final int SPEED = 5;

    public Ship(ImageIcon icon) {

        setHorizontalAlignment(SwingConstants.CENTER);
        setIcon(icon);

        moveLeftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx = -SPEED;
            }
        };

        moveRightAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx = SPEED;
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

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        getActionMap().put("moveLeft", moveLeftAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        getActionMap().put("moveRight", moveRightAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "stopLeft");
        getActionMap().put("stopLeft", stopAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "stopRight");
        getActionMap().put("stopRight", stopAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "shoot");
        getActionMap().put("shoot", shootAction);

        Timer timer = new Timer(10, e -> move());
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> moveLeftAction.actionPerformed(null);
            case KeyEvent.VK_RIGHT -> moveRightAction.actionPerformed(null);
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

    public Action getMoveLeftAction() {
        return moveLeftAction;
    }

    public void setMoveLeftAction(Action moveLeftAction) {
        this.moveLeftAction = moveLeftAction;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public Action getShootAction() {
        return shootAction;
    }

    public void setShootAction(Action shootAction) {
        this.shootAction = shootAction;
    }

    public Action getStopAction() {
        return stopAction;
    }

    public void setStopAction(Action stopAction) {
        this.stopAction = stopAction;
    }

    public Action getMoveRightAction() {
        return moveRightAction;
    }

    public void setMoveRightAction(Action moveRightAction) {
        this.moveRightAction = moveRightAction;
    }
}
