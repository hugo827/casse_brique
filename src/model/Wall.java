package model;

import java.awt.*;

public class Wall {
    protected Rectangle rectangle;
    protected Color color;

    public Wall(int x, int y, int width, int height, Color color) {
        this.rectangle = new Rectangle(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(rectangle.x,rectangle.y, rectangle.width, rectangle.height);
    }

    public int getX() {
        return  rectangle.x;
    }
}


