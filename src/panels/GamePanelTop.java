package panels;

import enums.GameMode;
import game.Bullet;
import game.Enemy;
import game.Ship;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class GamePanelTop extends JPanel {

    private SettingsPanel settings;
    private GamePanelBottom bottom;
    private Ship ship;
    private List<List<Enemy>> enemyRows;
    private Timer timer;

    public GamePanelTop(Ship ship, GamePanelBottom bottom, SettingsPanel settings) {

        this.settings = settings;
        this.bottom = bottom;
        this.ship = ship;
        ship.addKeyListener(ship);

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(0, 0, 50, 0));
        setLayout(null);

        add(ship);
        ship.setBounds(575, 600, 50, 50);

        enemyRows = new ArrayList<>();
        createEnemyRows();

        int delayFromSettings = (int) settings.getEnemyFallingTimeSpinner().getValue();
        timer = new Timer(1000 * delayFromSettings, e -> moveEnemies());
        timer.start();
    }

    private void createEnemyRows() {

        int enemyWidth = Enemy.getEnemyWidth();
        int enemyHeight = Enemy.getEnemyHeight();
        int rows = (int) settings.getEnemyRowsSpinner().getValue();
        int columns = (int) settings.getEnemyColumnsSpinner().getValue();
        int gap = 10;

        for (int i = 0; i < rows; i++) {

            List<Enemy> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {

                Enemy enemy = new Enemy();
                int x = j * (enemyWidth + gap);
                int y = i * (enemyHeight + gap);
                enemy.setBounds(x, y, enemyWidth, enemyHeight);
                row.add(enemy);
                add(enemy);
            }
            enemyRows.add(row);
        }
    }

    private void moveEnemies() {

        for (List<Enemy> row : enemyRows) {

            for (Enemy enemy : row) {

                enemy.move();

                int enemyY = enemy.getY();
                int enemyBottomY = enemyY + enemy.getHeight();
                int shipY = ship.getY();
                int shipBottomY = shipY + ship.getHeight();

                if (enemyBottomY >= shipY && enemyY <= shipBottomY) {

                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Enemies reached the ship! The end of game!");
                    exitGame();
                    return;
                }
            }
        }

        repaint();
    }

    private void exitGame() {

        saveScoreToFile(bottom.getNickname(), bottom.getScore());

        int choice = showExitDialog(bottom.getScore());
        handleExitChoice(choice);
    }

    private void saveScoreToFile(String nickname, int score) {

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        try {

            FileWriter writer = new FileWriter("scores.txt", true);
            writer.write(nickname + " " + score + " " + formattedDate + "\n");
            writer.close();
        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "An error occurred while saving the score to the file: " + e.getMessage()
            );
        }
    }

    private int showExitDialog(int score) {

        Object[] options = {"Yes", "No"};

        return JOptionPane.showOptionDialog(
                this,
                "You scored: " + score + "! Do you want to play again?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
    }

    private void handleExitChoice(int choice) {

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();

        if (choice == JOptionPane.YES_OPTION) {
            frame.getContentPane().add(new GamePanel(ship, bottom.getNickname(), settings));
        } else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
            frame.getContentPane().add(new MenuPanel());
        }

        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        checkCollisions();

        Arrays.stream(getComponents())
                .filter(component -> component instanceof Bullet)
                .map(component -> (Bullet) component)
                .forEach(Bullet::move);
    }

    private void checkCollisions() {

        enemyRows.forEach(row -> {

            row.removeIf(enemy -> {

               for (Bullet bullet : getBullets()) {

                   if (bullet.hit(enemy)) {

                       handleCollision(bullet, enemy);
                       return true;
                   }
               }
               return false;
            });
        });

        if (enemyRows.isEmpty()) {

            createEnemyRows();
        }
    }

    private List<Bullet> getBullets() {

        return Arrays.stream(getComponents())
                .filter(component -> component instanceof Bullet)
                .map(component -> (Bullet) component)
                .collect(Collectors.toList());
    }

    private void handleCollision(Bullet bullet, Enemy enemy) {

        if (settings.getSelectedGameMode().equals(GameMode.DISCO)) {

            setBackground(getRandomColor());
            bottom.getLabelPanel().setBackground(getBackground());
            bottom.getButtonsPanel().setBackground(getBackground());
        }

        remove(bullet);
        remove(enemy);
        repaint();
        bottom.updateScore(settings.getPointsForEnemyHit());
    }

    private Color getRandomColor() {

        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public void displayPauseOptions() {

        int choice = showPauseDialog();
        handlePauseChoice(choice);
    }

    private int showPauseDialog() {

        Object[] options = {"Resume", "Exit"};
        return JOptionPane.showOptionDialog(
                this,
                "Game paused. Press ESC or click Resume to resume.",
                "Pause",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
    }

    private void handlePauseChoice(int choice) {

        if (choice == JOptionPane.YES_OPTION || choice == JOptionPane.CLOSED_OPTION) {
            resumeGame();
        } else if (choice == JOptionPane.NO_OPTION) {
            exitGame();
        }
    }

    public void pauseGame() {

        timer.stop();
        ship.removeKeyListener(ship);
    }

    public void resumeGame() {

        timer.start();
        ship.addKeyListener(ship);
    }
}