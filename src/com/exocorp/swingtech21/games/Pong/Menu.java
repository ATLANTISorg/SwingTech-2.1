package com.exocorp.swingtech21.games.Pong;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.engine.input.Mouse;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.exocorp.swingtech21.engine.Core.gameState;

public class Menu implements Mouse {
    public static boolean aiPlay = false;

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
            }
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 300, 200, 65)) {
                handler.removeAllObj();
                gameState = Core.STATE.Playing;
                aiPlay = true;
            }
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 500, 200, 65)) {
                gameState = Core.STATE.Menu;
            }
        }
        if(gameState == Core.STATE.Win) {
            if (Mouse.mouseHover(e.getX(), e.getY(), Core.getWIDTH() / 2 - 110, 500, 200, 65)) {
                gameState = Core.STATE.GameMenu;
                Pong.firstTime = true;
                HUD.win1 = HUD.win2 = false;
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 70));

        g.drawString("Pong", Core.getWIDTH()/2 - 97, 80);

        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.drawRect(Core.getWIDTH() / 2 - 110, 200, 200, 65);
        g.drawString("P v P", Core.getWIDTH() / 2 - 67, 250);

        g.drawRect(Core.getWIDTH() / 2 - 110, 300, 200, 65);
        g.drawString("P v C", Core.getWIDTH() / 2 - 67, 350);

        g.drawRect(Core.getWIDTH() / 2 - 110, 500, 200, 65);
        g.drawString("Return", Core.getWIDTH() / 2 - 85, 550);
    }




    @Override
    public void mouseClicked(MouseEvent e) {

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
}
