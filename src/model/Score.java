package model;

import java.awt.*;

public class Score {

    private static int heart = 3;
    private static int points = 0;

    public static void addPoint() {
        points++;
    }

    public static void removeLife() {
        heart--;
        points -= 10;
    }

    public static int getHeart() {
        return heart;
    }

    public Score() {
    }

    public static int getPoints() {
        return points;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Score  : "+ points, 450,20 );
        g.drawString("Life : " + heart, 940,20);
    }
}
