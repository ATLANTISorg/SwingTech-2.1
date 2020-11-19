package com.exocorp.swingtech21.games;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.input.Mouse;
import com.exocorp.swingtech21.games.Brick.Breaker;
import com.exocorp.swingtech21.games.Pong.Pong;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GameSelector implements Mouse {
    public boolean hP = false, hB = false, hQ = false;

    public enum GAME{
        Pong,
        Brick,
        Menu
    }
    public static GAME game = GAME.Menu;

    private Core core;
    private Pong pong;
    private Breaker breaker;

    public GameSelector(Core core){
        this.core = core;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Core.gameState == Core.STATE.Menu || Core.gameState == Core.STATE.Win){
            if(Mouse.mouseHover(e.getX(), e.getY(), 50, 200, 350, 65)){
                pong = new Pong(core);
                game = GAME.Pong;
            }

            if(Mouse.mouseHover(e.getX(), e.getY(), 50, 350, 350, 65)){
                breaker = new Breaker(core);
                game = GAME.Brick;
            }

            if (Mouse.mouseHover(e.getX(), e.getY(), 50, 500, 350, 65)) {
                System.exit(1);
            }
        }
    }

    public void mouseMoved(MouseEvent e){
        if(Mouse.mouseHover(e.getX(), e.getY(), 50, 200, 350, 65)){
            hP = true;
        } else hP = false;

        if(Mouse.mouseHover(e.getX(), e.getY(), 50, 350, 350, 65)){
            hB = true;
        } else hB = false;

        if(Mouse.mouseHover(e.getX(), e.getY(), 50, 500, 350, 65)){
            hQ = true;
        } else hQ = false;
    }

    public void renderMenu(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 70));

        g.drawString("Choose a game!", 50, 80);

        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.drawRect(50, 200, 350, 65);
        g.drawString("Pong", 160, 250);

        g.drawRect(50, 350, 350, 65);
        g.drawString("Block Breaker", 55, 400);

        g.drawRect(50, 500, 350, 65);
        g.drawString("Quit", 170, 550);

        g.drawRect(500, 200, 365, 365);

        if(hP){
            g.fillRect(515, 285, 20, 70);
            g.fillRect(830, 430, 20, 70);
            g.fillOval(630, 350, 20, 20);
            g.drawLine(683, 210, 683, 555);
        }

        if(hB){
            g.fillRect(600, 535, 70, 20);
            g.fillOval(700, 380, 20, 20);
            g.fillRect(720, 300, 25, 10);
            g.fillRect(780, 280, 25, 10);
            g.fillRect(650, 260, 25, 10);
            g.fillRect(550, 220, 25, 10);
            g.fillRect(590, 310, 25, 10);
        }

        if(hQ){
            g.setFont(new Font("TimesRoman", Font.BOLD, 200));
            g.drawString("X", 625, 450);
        }
    }


    public void updateGame(){
        if(game == GAME.Pong) pong.update();
        else breaker.update();
    }
    public void renderGame(Graphics g){
        if(game == GAME.Pong) pong.renderP(g);
        if(game == GAME.Brick) breaker.render(g);
    }

    // Overridden Un-Used Methods --------------------------------------------------------------------------------------



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

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
