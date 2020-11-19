package com.exocorp.swingtech21.engine;

import com.exocorp.swingtech21.games.ID;

import java.awt.*;

public abstract class GameObject {
    protected int x, y;
    protected int velX, velY;
    protected int health;
    protected boolean showScore = false;

    protected Handler handler;
    protected ID id;

    public GameObject(int x, int y, Handler handler, ID id){
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.id = id;
    }

    public abstract void update();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void move(int velX, int velY){
        x += velX;
        y += velY;
    }



    // Getters and Setters ---------------------------------------------------------------------------------------------


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y += y;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }

    public void setHealth(int amount){
        if(amount == 1){
            this.health --;
        }
    }

    public boolean isShowScore() {
        return showScore;
    }
}
