package com.exocorp.swingtech21.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private boolean[] keys1 = new boolean[120];
    private boolean[] keys2 = new boolean[120];
    public static boolean up1, down1, left1, right1;
    public static boolean up2, down2, left2, right2;

    public void update(){
        // Player 1
        up1 = keys1[KeyEvent.VK_W];
        down1 = keys1[KeyEvent.VK_S];
        left1 = keys1[KeyEvent.VK_A];
        right1 = keys1[KeyEvent.VK_D];

        // Player 2
        up2 = keys2[KeyEvent.VK_UP];
        down2 = keys2[KeyEvent.VK_DOWN];
        left2 = keys2[KeyEvent.VK_LEFT];
        right2 = keys2[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys1[e.getKeyCode()] = true;
        keys2[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys1[e.getKeyCode()] = false;
        keys2[e.getKeyCode()] = false;
    }
}
