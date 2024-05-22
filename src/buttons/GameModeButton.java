package buttons;

import java.awt.*;

public class GameModeButton extends PressableButton {

    private static GameModeButton lastClickedButton;

    public GameModeButton(String text) {

        super(text);
        addActionListener(e -> {

            setBackground(Color.ORANGE);

            if (lastClickedButton != null && lastClickedButton != GameModeButton.this) {

                lastClickedButton.restoreBackground();
            }

            lastClickedButton = GameModeButton.this;
        });
    }

    @Override
    public void restoreBackground() {

        setBackground(Color.WHITE);
    }

    @Override
    public void setAsDefault() {

        setBackground(Color.ORANGE);
        lastClickedButton = this;
    }
}
