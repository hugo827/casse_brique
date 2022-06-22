package thread;

import UI.panel.LevelPanel;

import javax.swing.*;

public class BallMovement extends Thread {
    private LevelPanel levelPanel;
    private Boolean exit;

    public BallMovement(LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
        exit = false;
    }

    public void run() {

        while (!exit) {
            try {
                Thread.sleep(5);
                levelPanel.getBall().move();
                levelPanel.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void stopThread() {
        exit = true;
    }
}
