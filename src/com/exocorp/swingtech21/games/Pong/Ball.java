package com.exocorp.swingtech21.games.Pong;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

import static com.exocorp.swingtech21.games.Pong.Paddle1.dir1;
import static com.exocorp.swingtech21.games.Pong.Paddle2.dir2;

public class Ball extends GameObject {
    private static int parity = 0;

    private Paddle1 paddle1;
    private Paddle2 paddle2;

    public Ball(int x, int y, Handler handler, ID id, Paddle1 paddle1, Paddle2 paddle2) {
        super(x, y, handler, id);
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;

        velX = 4;
        velY = 4;
    }

    public Ball(int x, int y, Handler handler, ID id, Paddle1 paddle1) {
        super(x, y, handler, id);
        this.paddle1 = paddle1;

        velX = 4;
        velY = 4;
    }

    @Override
    public void update() {
        collision();

        if(parity % 2 == 0) {
            x -= velX;
            y -= velY;
        }else{
            x += velX;
            y -= velY;
        }

        if(x <= 0 || x >= Core.getWIDTH() - 26){
            parity++;
            if(x == 0){
                Pong.score2++;
            }else{
                Pong.score1++;
            }
            Pong.scored = true;
            handler.removeObj(this);
        }
        if(y <= 0 || y >= Core.getHEIGHT() - 52) velY *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 24, 24);
    }

    public void collision(){
        for(int i = 0; i < handler.obj.size(); i++){
            GameObject tmpObj = handler.obj.get(i);
            if(tmpObj.getId() == ID.Paddle1 || tmpObj.getId() == ID.Paddle2 || tmpObj.getId() == ID.AI){
                if(getBounds().intersects(tmpObj.getBounds())){
                    if(tmpObj.getId() == ID.Paddle1) {
                        x = paddle1.getX() + 24;
                        physx(dir1);
                    }
                    else if(tmpObj.getId() == ID.Paddle2) {
                        x = paddle2.getX() - 24;
                        physx(dir2);
                    }
                    else {
                        velX *= -1;
                    }
                }
            }
        }
    }

    public void physx(int dir){
        if(velY > 0 && dir == 1){
            velX *= -1;
            velY *= -1;
        }else if(velY < 0 && dir == 2){
            velX *= -1;
            velY *= -1;
        }else velX *= -1;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 24, 24);
    }
}
