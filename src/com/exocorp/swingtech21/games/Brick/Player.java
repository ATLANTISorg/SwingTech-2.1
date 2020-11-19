package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.engine.Util;
import com.exocorp.swingtech21.engine.input.Mouse;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Player extends GameObject implements Mouse {
    public static int mX = 0;
    public static int dir = 0;
    private int temp;
    public static int count  = 0;

    public Player(int x, int y, Handler handler, ID id) {
        super(x, y, handler, id);
        temp = x;
    }

    @Override
    public void update() {
        x = mX;
        x = Util.clamp(x, 4, Core.getWIDTH() - 180);
        if(x > temp){
            temp = x;
            dir = 1;
        }else if(x < temp){
            temp = x;
            dir = 2;
        }else dir = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 160, 24);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 160, 24);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        count++;
        if(count == 3) {
            Ball.launched = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mX = e.getX();
    }


    // Overridden Un-Used Methods --------------------------------------------------------------------------------------



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
