package panels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TopScoresPanel extends JPanel {

    List<List<String>> games = new ArrayList<>();
    private JTable topScoresTable;

    public TopScoresPanel() {

        setLayout(new BorderLayout());

        readGamesFromFile();
        sortGamesByScore();

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Position");
        tableModel.addColumn("Nickname");
        tableModel.addColumn("Score");
        tableModel.addColumn("Game Date");
        tableModel.addColumn("Game hour");

        AtomicInteger i = new AtomicInteger(1);
        games.stream().limit(10).forEach(game -> tableModel.addRow(
                new String[] { Integer.toString(i.getAndAdd(1)), game.getFirst(), game.get(1), game.get(2), game.get(3) }
        ));

        topScoresTable = new JTable(tableModel);
        topScoresTable.getTableHeader().setBackground(Color.BLACK);
        topScoresTable.getTableHeader().setForeground(Color.WHITE);
        topScoresTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        topScoresTable.setBackground(Color.BLACK);
        topScoresTable.setForeground(Color.WHITE);
        topScoresTable.setFont(new Font("Arial", Font.BOLD, 16));
        topScoresTable.setRowHeight(55);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return cellComponent;
            }
        };
        topScoresTable.setDefaultRenderer(Object.class, cellRenderer);


        JScrollPane scrollPane = new JScrollPane(topScoresTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void readGamesFromFile() {

        String filePath = "scores.txt";

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                games.add(List.of(line.split(" ")));
            }

            bufferedReader.close();
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "No games played!");
        }
    }

    private void sortGamesByScore() {

        Comparator<List<String>> comparator = (o1, o2) -> {

            int score1 = Integer.parseInt(o1.get(1));
            int score2 = Integer.parseInt(o2.get(1));
            return Integer.compare(score2, score1);
        };

        games.sort(comparator);
    }
}
