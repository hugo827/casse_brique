package UI.listener;

import UI.panel.LevelPanel;
import UI.window.MainWindow;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueListener implements ActionListener {


    private int nbLines;

    public ContinueListener(int nbLines) {
        this.nbLines = nbLines;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getContainer().removeAll();
        MainWindow.getInstance().getContainer().add(new LevelPanel(nbLines, nbLines));
        MainWindow.getInstance().printAll(MainWindow.getInstance().getGraphics());
    }
}
