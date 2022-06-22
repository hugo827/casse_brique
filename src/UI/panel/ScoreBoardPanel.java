package UI.panel;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardPanel extends JPanel {

        public ScoreBoardPanel() {
            setLayout(new BorderLayout());
            setBackground(Color.yellow);
            this.add(new JLabel("Score board panel"));
        }
}
