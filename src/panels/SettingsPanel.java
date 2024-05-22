package panels;

import buttons.DifficultyButton;
import buttons.GameModeButton;
import enums.GameMode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SettingsPanel extends JPanel {

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
    private GameMode selectedGameMode = GameMode.NORMAL;

    private JPanel enemyRowsPanel;
    private JLabel enemyRowsLabel;
    private JSpinner enemyRowsSpinner;

    private JPanel enemyColumnsPanel;
    private JLabel enemyColumnsLabel;
    private JSpinner enemyColumnsSpinner;

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
        normalGameModeButton.addActionListener(e -> setNormalGameMode());
        normalGameModeButton.setBackground(Color.WHITE);
        normalGameModeButton.setSelected(true);
        normalGameModeButton.setAsDefault();

        discoGameModeButton = new GameModeButton("Disco");
        discoGameModeButton.addActionListener(e -> setDiscoGameMode());
        discoGameModeButton.setBackground(Color.WHITE);

        mirrorGameModeButton = new GameModeButton("Mirror");
        mirrorGameModeButton.addActionListener(e -> setMirrorGameMode());
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

        enemyColumnsPanel = new JPanel(new FlowLayout());
        enemyColumnsPanel.setBackground(Color.BLACK);
        enemyColumnsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        enemyColumnsLabel = new JLabel("Enemy columns:");
        enemyColumnsLabel.setForeground(Color.WHITE);

        enemyColumnsSpinner = new JSpinner();
        enemyColumnsSpinner.setPreferredSize(new Dimension(50, enemyColumnsSpinner.getPreferredSize().height));
        enemyColumnsSpinner.setValue(15);
        ((SpinnerNumberModel) enemyColumnsSpinner.getModel()).setMinimum(1);
        ((SpinnerNumberModel) enemyColumnsSpinner.getModel()).setMaximum(30);

        enemyColumnsPanel.add(enemyColumnsLabel);
        enemyColumnsPanel.add(enemyColumnsSpinner);

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
        add(enemyColumnsPanel);
        add(enemyFallingTimePanel);
        add(saveButton);
    }

    private void setEasyDifficulty() {

        enemyRowsSpinner.setValue(5);
        enemyColumnsSpinner.setValue(10);
        enemyFallingTimeSpinner.setValue(3);
    }

    private void setNormalDifficulty() {

        enemyRowsSpinner.setValue(7);
        enemyColumnsSpinner.setValue(15);
        enemyFallingTimeSpinner.setValue(2);
    }

    private void setHardDifficulty() {

        enemyRowsSpinner.setValue(10);
        enemyColumnsSpinner.setValue(25);
        enemyFallingTimeSpinner.setValue(1);
    }

    private void setNormalGameMode() {

        selectedGameMode = GameMode.NORMAL;
    }

    private void setDiscoGameMode() {

        selectedGameMode = GameMode.DISCO;
    }

    private void setMirrorGameMode() {

        selectedGameMode = GameMode.MIRROR;
    }

    public void exitSettings() {

        Window window = SwingUtilities.getWindowAncestor(this);
        window.dispose();
    }

    public int getPointsForEnemyHit() {

        int enemyRows = (int) getEnemyRowsSpinner().getValue();
        int enemyColumns = (int) getEnemyColumnsSpinner().getValue();
        int enemyFallingTime = (int) getEnemyFallingTimeSpinner().getValue();

        int rowPoints = (enemyRows <= 5) ? 1 : (enemyRows <= 8) ? 2 : 3;
        int columnPoints = (enemyColumns <= 10) ? 1 : (enemyColumns <= 20) ? 2 : 3;
        int timePoints = (enemyFallingTime == 1) ? 3 : (enemyFallingTime == 2) ? 2 : 1;
        int gameModePints = switch (selectedGameMode) {

            case NORMAL -> 0;
            case DISCO -> 1;
            case MIRROR -> 2;
        };

        return rowPoints + columnPoints + timePoints + gameModePints;
    }

    public JSpinner getEnemyRowsSpinner() {
        return enemyRowsSpinner;
    }

    public JSpinner getEnemyColumnsSpinner() {
        return enemyColumnsSpinner;
    }

    public JSpinner getEnemyFallingTimeSpinner() {
        return enemyFallingTimeSpinner;
    }

    public GameMode getSelectedGameMode() {
        return selectedGameMode;
    }
}
