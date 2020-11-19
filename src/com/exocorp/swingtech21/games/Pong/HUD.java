package com.exocorp.swingtech21.games.Pong;

import com.exocorp.swingtech21.engine.Core;

import java.awt.*;

import static com.exocorp.swingtech21.games.Pong.Menu.aiPlay;
import static com.exocorp.swingtech21.games.Pong.Pong.score1;
import static com.exocorp.swingtech21.games.Pong.Pong.score2;

public class HUD {
    public static boolean win1 = false, win2 = false;
    public static int fontSize = 70;

    public void render(Graphics g){
        String str1 = Integer.toString(score1);
        String str2 = Integer.toString(score2);

        if (Core.gameState == Core.STATE.Playing) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
            g.drawLine(Core.getWIDTH() / 2, 0, Core.getWIDTH() / 2, Core.getHEIGHT());
            g.drawString(str1, 400, 100);
            g.drawString(str2, 590, 100);
        }
        if (Core.gameState == Core.STATE.Win) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
            g.drawRect(Core.getWIDTH() / 2 - 110, 500, 200, 65);
            g.drawString("Menu", Core.getWIDTH() / 2 - 97, 555);
            g.setFont(new Font("TimesRoman", Font.BOLD, 100));
            if (win1) g.drawString("PLAYER 1 WON!", 110, Core.getHEIGHT() / 3);
            if (win2) {
                if (aiPlay) {
                    g.drawString("COMPUTER WON!", 110, Core.getHEIGHT() / 3);
                } else {
                    g.drawString("PLAYER 2 WON!", 110, Core.getHEIGHT() / 3);
                }
            }
        }
    }
}
