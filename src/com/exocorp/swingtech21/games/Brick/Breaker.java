package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

public class Breaker {
    public static boolean firstTime = true;
    public static int life = 3;
    public static int score = 0;
    private boolean high;

    private Handler handler;
    private Menu menu;
    private Splash splash;
    private ScoreBoard scoreBoard;
    private Player player;

    public Breaker(Core core){
        handler = new Handler();
        menu = new Menu(handler); core.addMouseListener(menu);
        scoreBoard = new ScoreBoard();
        Core.gameState = Core.STATE.GameMenu;
        player = new Player(Core.getWIDTH()/2, Core.getHEIGHT() - 74, handler, ID.Player); core.addMouseMotionListener(player); core.addMouseListener(player);
    }

    public void update(){
        handler.update();

        if(firstTime){
            handler.addObj(player);
            new Spawner(handler);
            firstTime = false;
        }

        if(!handler.searchByID(ID.BallB) && life != 0){
           handler.addObj(new Ball(Player.mX + 80, Core.getHEIGHT() - 100, handler, ID.BallB, player));
        }
        if(life == 0) {
            handler.removeAllObj();
            Core.gameState = Core.STATE.Loose;
        }

        if(!handler.searchByID(ID.Brick)){
            handler.removeAllObj();
            Core.gameState = Core.STATE.Win;
        }

        if(Core.gameState == Core.STATE.Score){
            scoreBoard.showScoreBoard(scoreBoard.getScoreBoard());
        }
        if(Core.gameState == Core.STATE.Loose || Core.gameState == Core.STATE.Win){
            scoreBoard.updateScore(score);
            high = ScoreBoard.high;
            splash = new Splash(score, high, handler);
        }
    }

    public void render(Graphics g){
        handler.render(g);

        if(Core.gameState == Core.STATE.GameMenu){
            menu.render(g);
        }
        if(Core.gameState == Core.STATE.Score){
            //scoreBoard.render(g);
            menu.render(g);
        }
        if(Core.gameState == Core.STATE.Loose || Core.gameState == Core.STATE.Win){
            splash.render(g);
            menu.render(g);
        }
    }
}
