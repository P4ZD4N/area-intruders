package panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JLabel labelTitle;
    private MenuPanelCenter centerPanel;
    private JLabel labelAuthor;

    public MenuPanel() {

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(50, 0, 50, 0));
        setLayout(new BorderLayout());

        labelTitle = new JLabel("Area Intruders");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 48));
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        centerPanel = new MenuPanelCenter();

        labelAuthor = new JLabel("® 2024 Wiktor Chudy. All Rights Reserved.");
        labelAuthor.setFont(new Font("Arial", Font.BOLD, 24));
        labelAuthor.setForeground(Color.WHITE);
        labelAuthor.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        add(labelTitle, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(labelAuthor, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    public JLabel getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
    }

    public MenuPanelCenter getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(MenuPanelCenter centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JLabel getLabelAuthor() {
        return labelAuthor;
    }

    public void setLabelAuthor(JLabel labelAuthor) {
        this.labelAuthor = labelAuthor;
    }
}
