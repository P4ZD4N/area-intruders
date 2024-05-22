package panels;

import buttons.DifficultyButton;
import buttons.GameModeButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SettingsPanel extends JPanel {

    private int columns = 15;
    private int pointsForEnemyHit = 2;

    private JPanel difficultyButtonsPanel;
    private JLabel difficultyLabel;
    private DifficultyButton easyDifficultyButton;
    private DifficultyButton normalDifficultyButton;
    private DifficultyButton hardDifficultyButton;

    private JPanel gameModePanel;
    private JLabel gameModeLabel;
    private GameModeButton normalGameModeButton;
    private GameModeButton discoGameModeButton;
    private GameModeButton mirrorGameModeButton;

    private JPanel enemyRowsPanel;
    private JLabel enemyRowsLabel;
    private JSpinner enemyRowsSpinner;

    private JPanel enemyFallingTimePanel;
    private JLabel enemyFallingTimeLabel;
    private JLabel enemyFallingTimeSecondsLabel;
    private JSpinner enemyFallingTimeSpinner;

    private JButton saveButton;

    public SettingsPanel() {

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(50, 0, 50, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        difficultyButtonsPanel = new JPanel();
        difficultyButtonsPanel.setLayout(new FlowLayout());
        difficultyButtonsPanel.setBackground(Color.BLACK);
        difficultyButtonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        difficultyLabel = new JLabel("Difficulty:");
        difficultyLabel.setForeground(Color.WHITE);

        easyDifficultyButton = new DifficultyButton("Easy");
        easyDifficultyButton.setBackground(Color.WHITE);
        easyDifficultyButton.addActionListener(e -> setEasyDifficulty());

        normalDifficultyButton = new DifficultyButton("Normal");
        normalDifficultyButton.setBackground(Color.WHITE);
        normalDifficultyButton.addActionListener(e -> setNormalDifficulty());
        normalDifficultyButton.setSelected(true);
        normalDifficultyButton.setAsDefault();

        hardDifficultyButton = new DifficultyButton("Hard");
        hardDifficultyButton.addActionListener(e -> setHardDifficulty());
        hardDifficultyButton.setBackground(Color.WHITE);

        ButtonGroup difficultyLevelButtonsGroup = new ButtonGroup();
        difficultyLevelButtonsGroup.add(easyDifficultyButton);
        difficultyLevelButtonsGroup.add(normalDifficultyButton);
        difficultyLevelButtonsGroup.add(hardDifficultyButton);

        difficultyButtonsPanel.add(difficultyLabel);
        difficultyButtonsPanel.add(easyDifficultyButton);
        difficultyButtonsPanel.add(normalDifficultyButton);
        difficultyButtonsPanel.add(hardDifficultyButton);

        gameModePanel = new JPanel();
        gameModePanel.setLayout(new FlowLayout());
        gameModePanel.setBackground(Color.BLACK);
        gameModePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        gameModeLabel = new JLabel("Game mode:");
        gameModeLabel.setForeground(Color.WHITE);

        normalGameModeButton = new GameModeButton("Normal");
        normalGameModeButton.setBackground(Color.WHITE);
        normalGameModeButton.setSelected(true);
        normalGameModeButton.setAsDefault();
        discoGameModeButton = new GameModeButton("Disco");
        discoGameModeButton.setBackground(Color.WHITE);
        mirrorGameModeButton = new GameModeButton("Mirror");
        mirrorGameModeButton.setBackground(Color.WHITE);

        ButtonGroup gameModeButtonsGroup = new ButtonGroup();
        gameModeButtonsGroup.add(normalGameModeButton);
        gameModeButtonsGroup.add(discoGameModeButton);
        gameModeButtonsGroup.add(mirrorGameModeButton);

        gameModePanel.add(gameModeLabel);
        gameModePanel.add(normalGameModeButton);
        gameModePanel.add(discoGameModeButton);
        gameModePanel.add(mirrorGameModeButton);

        enemyRowsPanel = new JPanel(new FlowLayout());
        enemyRowsPanel.setBackground(Color.BLACK);
        enemyRowsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        enemyRowsLabel = new JLabel("Enemy rows:");
        enemyRowsLabel.setForeground(Color.WHITE);

        enemyRowsSpinner = new JSpinner();
        enemyRowsSpinner.setPreferredSize(new Dimension(50, enemyRowsSpinner.getPreferredSize().height));
        enemyRowsSpinner.setValue(7);
        ((SpinnerNumberModel) enemyRowsSpinner.getModel()).setMinimum(1);
        ((SpinnerNumberModel) enemyRowsSpinner.getModel()).setMaximum(10);

        enemyRowsPanel.add(enemyRowsLabel);
        enemyRowsPanel.add(enemyRowsSpinner);

        enemyFallingTimePanel = new JPanel(new FlowLayout());
        enemyFallingTimePanel.setBackground(Color.BLACK);
        enemyFallingTimePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        enemyFallingTimeLabel = new JLabel("Enemy rows falling time:");
        enemyFallingTimeLabel.setForeground(Color.WHITE);

        enemyFallingTimeSpinner = new JSpinner();
        enemyFallingTimeSpinner.setValue(2);
        ((SpinnerNumberModel) enemyFallingTimeSpinner.getModel()).setMinimum(1);
        ((SpinnerNumberModel) enemyFallingTimeSpinner.getModel()).setMaximum(5);

        enemyFallingTimeSecondsLabel = new JLabel("seconds");
        enemyFallingTimeSecondsLabel.setForeground(Color.WHITE);

        enemyFallingTimePanel.add(enemyFallingTimeLabel);
        enemyFallingTimePanel.add(enemyFallingTimeSpinner);
        enemyFallingTimePanel.add(enemyFallingTimeSecondsLabel);

        saveButton = new JButton("Save");
        saveButton.setBackground(Color.WHITE);
        saveButton.addActionListener(e -> exitSettings());

        add(difficultyButtonsPanel);
        add(gameModePanel);
        add(enemyRowsPanel);
        add(enemyFallingTimePanel);
        add(saveButton);
    }

    private void setEasyDifficulty() {

        columns = 10;
        pointsForEnemyHit = 1;
        enemyRowsSpinner.setValue(5);
        enemyFallingTimeSpinner.setValue(3);
    }

    private void setNormalDifficulty() {

        enemyRowsSpinner.setValue(7);
        enemyFallingTimeSpinner.setValue(2);
    }

    private void setHardDifficulty() {

        columns = 25;
        pointsForEnemyHit = 3;
        enemyRowsSpinner.setValue(10);
        enemyFallingTimeSpinner.setValue(1);
    }

    public void exitSettings() {

        Window window = SwingUtilities.getWindowAncestor(this);
        window.dispose();
    }

    public int getColumns() {
        return columns;
    }

    public int getPointsForEnemyHit() {
        return pointsForEnemyHit;
    }

    public JSpinner getEnemyRowsSpinner() {
        return enemyRowsSpinner;
    }

    public JSpinner getEnemyFallingTimeSpinner() {
        return enemyFallingTimeSpinner;
    }
}
