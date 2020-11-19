package com.exocorp.swingtech21.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface Mouse extends MouseListener, MouseMotionListener {

    void mousePressed(MouseEvent e);

    static boolean mouseHover(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            return my > y && my < y + height;
        }else return false;
    }
}
