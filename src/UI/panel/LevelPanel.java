package UI.panel;

import UI.listener.BouncingPlatformMovement;
import UI.window.MainWindow;
import model.*;
import thread.BallMovement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelPanel extends JPanel {

    private Ball ball;
    private Thread ballMovement;
    private ArrayList<Wall> walls = new ArrayList<>();
    private BouncingPlatform bouncingPlatform;
    private ArrayList<Brick> bricks = new ArrayList<>();

    private Score score;
    private  final static int MAX_BRICK_COLUMN = 13;
    private final static int MAX_LINE = 10;
    private static int nbLines = 1;
    private Color[] colors = {Color.RED, Color.BLUE, Color.CYAN, Color.ORANGE, Color.GREEN};
    public LevelPanel(int nbLigne, int brickPointsLive ) {

       // this.gamePanel = gamePanel;
        //MainWindow.getInstance().getContainer().requestFocusInWindow();
        // OR
        MainWindow.getInstance().getContainer().setFocusable(true);
        MainWindow.getInstance().getContainer().requestFocus();
        MainWindow.getInstance().getContainer().addKeyListener(new BouncingPlatformMovement(this));
        setBackground(Color.DARK_GRAY);
        nbLigne = Math.min(nbLigne, MAX_LINE);
        for(int j = 0; j < nbLigne; j++ ) {
            int pointLive = brickPointsLive - j  > 0 ?  brickPointsLive - j : 1;
            int y = (50 + j * 30);
            for (int i = 0; i < MAX_BRICK_COLUMN; i++) {
                int x = (70 + i * 65);
                bricks.add(new Brick(x, y, 60, 20, colors[pointLive-1] , pointLive));
            }
        }
        ball = new Ball(this,440,570,20,20, Color.BLACK);
        bouncingPlatform = new BouncingPlatform( 400,600, 125,10, Color.BLACK);
        score = new Score();

        ballMovement = new BallMovement(this);
        ballMovement.start();
    }

    public void paint (Graphics g) {
        super.paint(g);

        score.draw(g);
        ball.draw(g);
        bouncingPlatform.draw(g);
        int i = 0;
        for(Brick brick : bricks) {
            if(brick.getNbHitPoints() > 0) {
                brick.setColor(colors[brick.getNbHitPoints()-1]);
                brick.draw(g);

            } else i++;
        }

        if(i == bricks.size()) this.newLevel();
    }

    public Ball getBall() {
        return ball;
    }

    public BouncingPlatform getBouncingPlatform() {
        return bouncingPlatform;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public void setPoints() {
         Score.addPoint();
    }

    public void removeLife() {
        Score.removeLife();
        if(Score.getHeart() < 0) {
            MainWindow.getInstance().getContainer().removeAll();
            MainWindow.getInstance().getContainer().add(new EndGamePanel(Score.getPoints(),Score.getHeart() , Score.getHeart()));
            MainWindow.getInstance().printAll(MainWindow.getInstance().getGraphics());
        }
    }

    public void newLevel() {
        nbLines++;
        ballMovement.stop();
        MainWindow.getInstance().getContainer().removeAll();
        MainWindow.getInstance().getContainer().add(new LevelPanel(nbLines, nbLines));
        MainWindow.getInstance().printAll(MainWindow.getInstance().getGraphics());
    }

}
