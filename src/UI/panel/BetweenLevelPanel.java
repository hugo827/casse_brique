package UI.panel;

import UI.listener.ContinueListener;

import javax.swing.*;

public class BetweenLevelPanel extends JPanel {

    public BetweenLevelPanel(int nbLines) {
        JButton button = new JButton("Continue");
        button.addActionListener(new ContinueListener( nbLines));
        this.add(button);
    }
}
