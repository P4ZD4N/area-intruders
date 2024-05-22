package buttons;

import java.awt.*;

public class DifficultyButton extends PressableButton {

    private static DifficultyButton lastClickedButton;

    public DifficultyButton(String text) {

        super(text);
        addActionListener(e -> {

            setBackground(Color.RED);

            if (lastClickedButton != null && lastClickedButton != DifficultyButton.this) {

                lastClickedButton.restoreBackground();
            }

            lastClickedButton = DifficultyButton.this;
        });
    }

    @Override
    public void restoreBackground() {

        setBackground(Color.WHITE);
    }

    @Override
    public void setAsDefault() {

        setBackground(Color.RED);
        lastClickedButton = this;
    }
}
