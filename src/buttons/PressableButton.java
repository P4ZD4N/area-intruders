package buttons;

import javax.swing.*;

public abstract class PressableButton extends JButton {

    public PressableButton(String text) {

        super(text);
    }

    abstract void restoreBackground();

    abstract void setAsDefault();
}

