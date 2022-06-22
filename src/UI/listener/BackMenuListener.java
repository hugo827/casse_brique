package UI.listener;

import UI.panel.HomePanel;
import UI.panel.ScoreBoardPanel;
import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackMenuListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getContainer().removeAll();
        MainWindow.getInstance().getContainer().add(new HomePanel(new ScoreBoardPanel()));
        MainWindow.getInstance().printAll(MainWindow.getInstance().getGraphics());
    }
}
