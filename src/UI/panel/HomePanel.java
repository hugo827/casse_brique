package UI.panel;

import UI.listener.StartListener;
import UI.listener.ChangePanelListener;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel(JPanel panel) {
        setLayout(null);

        JPanel borderLayoutPanel = new JPanel();
        borderLayoutPanel.setBounds(300,100,400,500);
        borderLayoutPanel.setLayout(new BorderLayout());

        JPanel panelButtons = new JPanel();
        panelButtons.setMinimumSize(new Dimension(300, 150));
        panelButtons.setLayout(new GridLayout(1,3));
        JButton start = new JButton("Start game");
        JButton rules = new JButton("View Rules ");
        JButton scores = new JButton("View Score Board");

        panelButtons.add(start);
        panelButtons.add(rules);
        panelButtons.add(scores);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(panel);

        start.addActionListener(new StartListener());
        rules.addActionListener(new ChangePanelListener(new GamePlayPanel()));
        scores.addActionListener(new ChangePanelListener(new ScoreBoardPanel()));

        borderLayoutPanel.add(centerPanel, BorderLayout.CENTER);
        borderLayoutPanel.add(panelButtons, BorderLayout.NORTH);

        this.add(borderLayoutPanel);
    }
}
