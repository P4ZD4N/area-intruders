package panels;

import javax.swing.*;
import java.awt.*;

public class MenuPanelCenterRightTop extends JPanel {

    private JLabel labelNickname;
    private JTextField nicknameField;

    public MenuPanelCenterRightTop() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        labelNickname = new JLabel("Enter nickname");
        labelNickname.setFont(new Font("Arial", Font.BOLD, 18));
        labelNickname.setForeground(Color.WHITE);
        labelNickname.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNickname.setAlignmentY(Component.TOP_ALIGNMENT);

        nicknameField = new JTextField(100);
        nicknameField.setBackground(Color.BLACK);
        nicknameField.setForeground(Color.WHITE);
        nicknameField.setHorizontalAlignment(JTextField.CENTER);
        nicknameField.setMaximumSize(new Dimension(nicknameField.getPreferredSize().width, 50));
        nicknameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nicknameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nicknameField.setAlignmentY(Component.TOP_ALIGNMENT);

        add(labelNickname);
        add(nicknameField);
    }

    public JLabel getLabelNickname() {
        return labelNickname;
    }

    public void setLabelNickname(JLabel labelNickname) {
        this.labelNickname = labelNickname;
    }

    public JTextField getNicknameField() {
        return nicknameField;
    }

    public void setNicknameField(JTextField nicknameField) {
        this.nicknameField = nicknameField;
    }
}
