package com.exocorp.swingtech21.games.Pong;

import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.engine.Util;
import com.exocorp.swingtech21.engine.input.Keyboard;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

public class Paddle1 extends GameObject {
    public static int dir1 = 0;
    private int temp;

    public Paddle1(int x, int y, ID id, Handler handler) {
        super(x, y, handler, id);

        temp = y;
    }

    @Override
    public void update() {
        int velY = 0;
        if(Keyboard.up1) velY -= 3;
        if(Keyboard.down1) velY += 3;

        if(velY != 0) move(velX, velY);
        y = Util.clamp(y, 3, 562);

        if(y > temp){
            temp = y;
            dir1 = 1;
        }else if(y < temp){
            temp = y;
            dir1 = 2;
        }else dir1 = 0;
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
