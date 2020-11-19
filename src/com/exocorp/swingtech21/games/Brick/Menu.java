package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.engine.input.Mouse;
import com.exocorp.swingtech21.games.Pong.Paddle2;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.exocorp.swingtech21.engine.Core.gameState;

public class Menu implements Mouse {

    private Handler handler;

    public Menu(Handler handler){
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(gameState == Core.STATE.GameMenu) {
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 200, 200, 65)) {
                handler.removeAllObj();
                gameState = Core.STATE.Playing;
                Breaker.score = 0;
                Breaker.life = 3;
                Breaker.firstTime = true;
            }
            //if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 350, 200, 65)) {
            //    handler.removeAllObj();
            //    gameState = Core.STATE.Score;
            //}
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 500, 200, 65)) {
                handler.removeAllObj();
                gameState = Core.STATE.Menu;
            }
        }
        if(gameState == Core.STATE.Win || gameState == Core.STATE.Loose) {
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 500, 200, 65)) {
                gameState = Core.STATE.GameMenu;
                handler.removeAllObj();
            }
        }
        if(gameState == Core.STATE.Score){
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 500, 200, 65)) {
                gameState = Core.STATE.GameMenu;
                handler.removeAllObj();
                //ScoreBoard.once = true;
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 60));

        if(gameState == Core.STATE.GameMenu){
            g.drawString("Breaker Breaker", Core.getWIDTH()/2 - 230, 80);

            g.setFont(new Font("TimesRoman", Font.BOLD, 50));
            g.drawRect(Core.getWIDTH() / 2 - 110, 200, 200, 65);
            g.drawString("Play", Core.getWIDTH() / 2 - 60, 250);

            //g.drawRect(Core.getWIDTH() / 2 - 110, 350, 200, 65);
            //g.drawString("Score", Core.getWIDTH() / 2 - 80, 400);

            g.drawRect(Core.getWIDTH() / 2 - 110, 500, 200, 65);
            g.drawString("Return", Core.getWIDTH() / 2 - 88, 550);
        }

        if(gameState == Core.STATE.Win || gameState == Core.STATE.Loose){
            g.setFont(new Font("TimesRoman", Font.BOLD, 60));
            g.drawRect(Core.getWIDTH() / 2 - 110, 500, 200, 65);
            g.drawString("Return", Core.getWIDTH() / 2 - 105, 550);
        }

        if(gameState == Core.STATE.Score){
            g.drawRect(Core.getWIDTH() / 2 - 110, 500, 200, 65);
            g.drawString("Return", Core.getWIDTH() / 2 - 105, 555);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
    public void mouseClicked(MouseEvent e) {

    }
}
