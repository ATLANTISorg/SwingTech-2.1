package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.engine.Util;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

import static com.exocorp.swingtech21.games.Brick.Ball.yMove;

public class Brick extends GameObject {
    private int scoreMultiplier = 100;
    private int yM = 0;

    public Brick(int x, int y, Handler handler, ID id, int health) {
        super(x, y, handler, id);
        this.health = health;

        scoreMultiplier *= health;
    }

    @Override
    public void update() {
        if(health == 0){
            Breaker.score += scoreMultiplier;
            showScore = true;
        }

        if(y >= Core.getHEIGHT() - 100){
            Core.gameState = Core.STATE.Loose;
        }

        if(showScore){
            if(yM < 50) {
                y -= 1 *Core.deltaV;
                yM++;
            }
            else {
                handler.removeObj(this);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if(!showScore){
            if(health == 1){
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, 45, 24);
            }
            if(health == 2){
                g.setColor(new Color(255, 153, 0));
                g.fillRect(x, y, 45, 24);
            }
            if(health == 3){
                g.setColor(Color.RED);
                g.fillRect(x, y, 45, 24);
            }
        }else{
            g.setColor(Color.WHITE);
            g.drawString("+ " + scoreMultiplier, x, y);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 45, 24);
    }

}
