package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

public class Splash {
    private int score;
    private boolean high;

    public Splash(int score, boolean high, Handler handler){
        this.score = score;
        this.high = high;

        for(int i = 0; i < handler.obj.size(); i++){
            GameObject tmpObj = handler.obj.get(i);
            if(tmpObj.getId() == ID.Brick){
                handler.removeObj(tmpObj);
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 70));

        if(Core.gameState == Core.STATE.Win){
            g.drawString("You WIN!", Core.getWIDTH()/2 - 165, Core.getHEIGHT()/2 + 50);
        }

        if(Core.gameState == Core.STATE.Loose){
            g.drawString("You Loose!", Core.getWIDTH()/2 - 190, Core.getHEIGHT()/2 + 50);
        }

        if(high) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString("High Score!", Core.getWIDTH() / 2 - 115, Core.getHEIGHT() / 2 - 100);
        }

        g.setFont(new Font("TimesRoman", Font.BOLD, 60));
        g.drawString("Score: " + score, Core.getWIDTH()/2 - 125, Core.getHEIGHT()/2 - 200);
    }

    public void setHigh(boolean high) {
        this.high = high;
    }
}
