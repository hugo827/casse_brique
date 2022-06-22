package UI.window;

import UI.panel.GamePlayPanel;
import UI.panel.HomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    private static MainWindow mainWindow = null;
    private Container container;

    private MainWindow() {
        super("Casse brique");
        setLayout(new BorderLayout());
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        setBounds(100,100,1000,800);

        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                                System.exit(0);
                            }
                        }
                );


        container.add(new HomePanel(new GamePlayPanel()), BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
    }

    public static MainWindow getInstance() {
        if(mainWindow == null) mainWindow = new MainWindow();
        return mainWindow;
    }

    public  Container getContainer() {
        return container;
    }
}
