package UI.panel;

import UI.listener.BackMenuListener;

import javax.swing.*;
import java.awt.*;

public class EndGamePanel extends JPanel {


    public EndGamePanel(int score, int delay, int heart) {
        this.setLayout(new GridBagLayout());
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(6,1));
        JLabel finishLabel = new JLabel("You finished the game : ");
        JLabel scoreLabel = new JLabel("Score : " + score);
        JLabel delayLabel = new JLabel("Durée : " + delay);
        JLabel lifeLabel = new JLabel("Vie restante : " + ( heart == -1 ? 0 : heart ));
        JTextField namePlayer = new JTextField();
        JButton menu = new JButton("Retour menu");
        menu.addActionListener(new BackMenuListener());
        middlePanel.add(finishLabel);
        middlePanel.add(scoreLabel);
        middlePanel.add(delayLabel);
        middlePanel.add(lifeLabel);
        middlePanel.add(namePlayer);
        middlePanel.add(menu);
        this.add(middlePanel);
    }
}
