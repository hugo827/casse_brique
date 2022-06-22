package UI.panel;

import javax.swing.*;
import java.awt.*;

public class GamePlayPanel extends JPanel {

    public GamePlayPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.cyan);
        this.add(new JLabel("Gameplay panel"));
    }
}
