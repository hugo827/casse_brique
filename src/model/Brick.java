package model;

import java.awt.*;

public class Brick implements IPrototypeBrick {

    private Rectangle brick;
    private Color color;


    private int x,y,width,height, nbHitPoints ;

    public Brick(int x, int y, int width, int height, Color color, int nbHitPoints) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.nbHitPoints = nbHitPoints;
        brick =  new Rectangle(x, y, width, height);
    }
    public Brick(int x, int y, int width, int height, Color color) {
        this(x, y, width, height, color, 1);
    }


    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y, width, height);
    }

    public Boolean collision(Ball ball) {
        if(nbHitPoints <= 0 ) return false;
        return this.brick.intersects(ball.getRectangle());
    }



    @Override
    public Brick clone() {
        return new Brick(x,y,width,height,color);
    }

    public int getNbHitPoints() { return nbHitPoints; }
    public void setNbHitPoints() { nbHitPoints -= 1; }

    public void setColor(Color color) {
        this.color = color;
    }
}
