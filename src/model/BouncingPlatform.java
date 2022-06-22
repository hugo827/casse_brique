package model;

import java.awt.*;

public class BouncingPlatform extends Wall {

    public BouncingPlatform( int x, int y, int width, int height , Color color) {
        super(x, y, width, height, color);
    }

    public void setX(int x) {
        rectangle.x = x;
    }

    public Boolean collision(Ball ball) {
        return this.rectangle.intersects(ball.getRectangle());
    }

    public int pointCollision(Ball ball) {
            if(ball.getRectangle().getX() + ball.getRectangle().getWidth() == this.rectangle.getX() && ball.getRectangle().getY() + ball.getRectangle().getHeight() == this.rectangle.getY() ) return 1;
            if(ball.getRectangle().getX() + ball.getRectangle().getWidth() == this.rectangle.getX() + this.rectangle.getWidth()
                    && ball.getRectangle().getY() + ball.getRectangle().getHeight() == this.rectangle.getY()  ) return 2;
            if(ball.getRectangle().getX() + ball.getRectangle().getWidth() > this.rectangle.getX()
                    && ball.getRectangle().getX() + ball.getRectangle().getWidth() < this.rectangle.getX() + this.rectangle.getWidth()
                    && ball.getRectangle().getY() + ball.getRectangle().getHeight() == this.rectangle.getY()  ) return 3;
            if(ball.getRectangle().getX() + ball.getRectangle().getWidth() == this.rectangle.getX()
                    && ball.getRectangle().getY() + ball.getRectangle().getHeight() >= this.rectangle.getY()
                    && ball.getRectangle().getY() + ball.getRectangle().getHeight() <= this.rectangle.getY() + this.rectangle.getHeight()
            ) return 4;
            if(ball.getRectangle().getX() == this.rectangle.getX() + this.rectangle.getWidth()
                    && ball.getRectangle().getY() + ball.getRectangle().getHeight() >= this.rectangle.getY()
                    && ball.getRectangle().getY() + ball.getRectangle().getHeight() <= this.rectangle.getY() + this.rectangle.getHeight()
            ) return 5;
        return 0;
    }

}
