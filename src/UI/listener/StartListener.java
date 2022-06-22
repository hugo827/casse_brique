package UI.listener;

import UI.panel.LevelPanel;
import UI.window.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getContainer().removeAll();
        MainWindow.getInstance().getContainer().add(new LevelPanel(1,1), BorderLayout.CENTER);
        MainWindow.getInstance().printAll(MainWindow.getInstance().getGraphics());
    }
}
