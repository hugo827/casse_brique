package UI.listener;

import UI.panel.HomePanel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePanelListener implements ActionListener {

    private JPanel panel;

    public ChangePanelListener(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getContainer().removeAll();
        MainWindow.getInstance().getContainer().add(new HomePanel(panel));
        MainWindow.getInstance().printAll(MainWindow.getInstance().getGraphics());
    }
}
