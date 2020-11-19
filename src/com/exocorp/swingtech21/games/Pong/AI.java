package com.exocorp.swingtech21.games.Pong;

import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.engine.Util;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

public class AI extends GameObject {
    private Handler handler;

    public AI(int x, int y, ID id, Handler handler) {
        super(x, y, handler, id);
        this.handler = handler;
    }

    @Override
    public void update() {
        int velY = 0;
        for(int i = 0; i < handler.obj.size(); i++) {
            GameObject object = handler.obj.get(i);
            if (object.getId() == ID.BallP){
                if(object.getVelY() > 0){
                    velY -= 3;
                }else if(object.getVelY() < 0){
                    velY += 3;
                }
            }
        }

        move(velX, velY);

        y = Util.clamp(y, 3, 562);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 24, 160);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 24, 160);
    }
}
