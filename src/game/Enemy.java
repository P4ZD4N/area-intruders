package game;

import javax.swing.*;

public class Enemy extends JLabel {

    private static int width = 30;
    private static int height = 30;

    public Enemy() {

        setHorizontalAlignment(SwingConstants.CENTER);
        setIcon(new ImageIcon("src/img/enemy.png"));
        setBounds(0, 0, width, height);
    }

    public void move() {
        setLocation(getX(), getY() + getHeight());
    }

    public static int getEnemyWidth() {
        return width;
    }

    public static int getEnemyHeight() {
        return height;
    }
}