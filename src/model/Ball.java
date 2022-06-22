package model;

import UI.panel.LevelPanel;

import java.awt.*;

import static java.lang.Math.abs;

public class Ball {
    private Rectangle rectangle;
    private Color color;
    private LevelPanel levelPanel;
    private int startX = 440, startY = 570, deltaStartX = 2, deltaStartY = -1;
    private int deltaX = 2, deltaY = -1;
    public Ball(LevelPanel levelPanel, int x, int y, int width, int height, Color color) {
        this.rectangle = new Rectangle(x,y,width,height);
        this.color = color;
        this.levelPanel = levelPanel;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void move() {
        if(rectangle.x >= 970 ) deltaX = -(deltaX);
        else if(rectangle.x <= 0) deltaX = abs(deltaX);
        if(rectangle.y > 800 ) {
            rectangle.x = startX; // change with postion bouncing
            rectangle.y = startY; // change with postion bouncing
            deltaY = deltaStartY; // change with condition
            deltaX = deltaStartX; // change with condition
            levelPanel.removeLife();
        } else {
            if(  rectangle.y <= 0) deltaY = abs(deltaY);
        }

        for(Brick brick : levelPanel.getBricks()) {
            if(brick.collision(this)) {
                deltaY = deltaY < 0 ? abs(deltaY) : (-(deltaY));
                brick.setNbHitPoints();
                levelPanel.setPoints();
            }
        }


        int i = levelPanel.getBouncingPlatform().pointCollision(this);
        if(i != 0) {
           if( i == 3 ) deltaY = deltaY < 0 ? abs(deltaY) : (-(deltaY));
           else if(i == 4 || i == 5 ) {
               deltaX = -(deltaX);
           } else if(i == 1 || i == 2) {
               deltaY = -(deltaY);
               deltaX = -(deltaX);
           }
        }

        rectangle.x += deltaX;
        rectangle.y += deltaY;
    }
}
