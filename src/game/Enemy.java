package game;

import javax.swing.*;

public class Enemy extends JLabel {

    private static final int SPEED = 5;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public Enemy() {

        setHorizontalAlignment(SwingConstants.CENTER);
        setIcon(new ImageIcon("src/img/enemy.png"));
        setBounds(0, 0, WIDTH, HEIGHT);
    }

    public void move() {
        setLocation(getX(), getY() + SPEED);
    }
}