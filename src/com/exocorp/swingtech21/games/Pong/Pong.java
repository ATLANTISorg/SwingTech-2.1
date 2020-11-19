package com.exocorp.swingtech21.games.Pong;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

import static com.exocorp.swingtech21.games.Pong.Menu.aiPlay;

public class Pong {
    public static boolean scored = false;
    public static boolean firstTime = true;
    public static int score1 = 0, score2 = 0;

    private Core core;
    private Handler handler;
    private Menu menu;
    private HUD hud;
    private Paddle1 paddle1;
    private Paddle2 paddle2;

    public Pong(Core core){
        this.core = core;
        handler = new Handler();
        menu = new Menu(handler); core.addMouseListener(menu);
        hud = new HUD();
        Core.gameState = Core.STATE.GameMenu;

        paddle1 = new Paddle1(10, Core.getHEIGHT() / 2 - 270, ID.Paddle1, handler);
        paddle2 = new Paddle2(974, Core.getHEIGHT() / 2 - 270, ID.Paddle2, handler);
    }

    public void startHGame(){
        handler.addObj(paddle1);
        handler.addObj(paddle2);
        handler.addObj(new Ball(Core.getWIDTH()/2, Core.getHEIGHT()/2, handler, ID.BallP, paddle1, paddle2));
        firstTime = false;
    }
    public void startCGame(){
        handler.addObj(paddle1);
        handler.addObj(new AI(974, Core.getHEIGHT() / 2 - 160, ID.AI, handler));
        handler.addObj(new Ball(Core.getWIDTH()/2, Core.getHEIGHT()/2, handler, ID.BallP, paddle1));
        firstTime = false;
    }

    public void update(){
        handler.update();
        if(Core.gameState == Core.STATE.Playing && !aiPlay && firstTime) startHGame();
        if(Core.gameState == Core.STATE.Playing && aiPlay && firstTime) startCGame();
        if(score1 == 10 || score2 == 10){
            Core.gameState = Core.STATE.Win;
            if(score1 == 10) HUD.win1 = true;
            if(score2 == 10) HUD.win2 = true;
            scored = false;
        }
        if(Core.gameState == Core.STATE.Playing && !firstTime){
            if(scored){
                if(aiPlay){
                    handler.addObj(new Ball(Core.getWIDTH()/2, Core.getHEIGHT()/2, handler, ID.BallP, paddle1));
                }else handler.addObj(new Ball(Core.getWIDTH()/2, Core.getHEIGHT()/2, handler, ID.BallP, paddle1, paddle2));

                scored = false;
            }
        }
        if(Core.gameState == Core.STATE.Win){
            handler.removeAllObj();
            aiPlay = false;
            score1 = score2 = 0;
        }
    }

    public void renderP(Graphics g){
        if(Core.gameState == Core.STATE.GameMenu){
            menu.render(g);
        }
        if(Core.gameState == Core.STATE.Playing){
            handler.render(g);
            hud.render(g);
        }
        hud.render(g);
    }
}
