package game;

import javax.swing.*;
import java.awt.*;

public class Bullet extends JLabel {

    private static final int SPEED = 1;

    public Bullet(int x, int y) {

        setBounds(x, y, 10, 10);
        setBackground(Color.GREEN);
        setOpaque(true);
    }

    public void move() {

        setLocation(getX(), getY() - SPEED);
    }

    public boolean hit(Enemy enemy) {

        Rectangle bulletBounds = getBounds();
        Rectangle enemyBounds = enemy.getBounds();

        return bulletBounds.intersects(enemyBounds);
    }
}
