package UI.listener;

import UI.panel.LevelPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BouncingPlatformMovement implements KeyListener {

    private LevelPanel levelPanel;

    public BouncingPlatformMovement(LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'q' || e.getKeyChar() == 'd') {
            if(e.getKeyChar() == 'q' && levelPanel.getBouncingPlatform().getX() > 0) levelPanel.getBouncingPlatform().setX(levelPanel.getBouncingPlatform().getX() - 30);
            if(e.getKeyChar() == 'd' && levelPanel.getBouncingPlatform().getX() < 900) levelPanel.getBouncingPlatform().setX(levelPanel.getBouncingPlatform().getX() + 30);
            levelPanel.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
