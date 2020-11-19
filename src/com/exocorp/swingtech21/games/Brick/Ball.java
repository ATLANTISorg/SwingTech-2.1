package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Core;
import com.exocorp.swingtech21.engine.GameObject;
import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.games.ID;

import java.awt.*;

import static com.exocorp.swingtech21.games.Brick.Breaker.life;
import static com.exocorp.swingtech21.games.Brick.Player.dir;
import static com.exocorp.swingtech21.games.Brick.Player.mX;

public class Ball extends GameObject {
    public static boolean launched = false;
    private boolean hitPlayer = false;
    private boolean control = false;
    public static int amountHitPlayer = 0, yMove = 0;
    private int yP = 0;

    private  Player player;

    public Ball(int x, int y, Handler handler, ID id, Player player) {
        super(x, y, handler, id);
        this.player = player;

        velX = 0;
        velY = 8;
    }

    @Override
    public void update() {
        if(!launched){
            x = mX + 70;
            if(x >= Core.getWIDTH() - 110) x = Core.getWIDTH() - 110;
        }

        collision();

        if(launched){
            y -= velY;
            if(hitPlayer && dir != 0 && !control){
                velX = 4;
                control = true;
            }
            hitPlayer = false;
            x -= velX;
        }

        if(x <= 0 || x >= Core.getWIDTH() - 40) velX *= -1;
        if(y <= 0) velY *= -1;
        if(y >= Core.getHEIGHT() - 26){
            life--;
            launched = false;
            Player.count = 2;
            handler.removeObj(this);
        }

        if(Ball.amountHitPlayer == 3){
            if(yMove < 20){
                for(int i = 0; i < handler.obj.size(); i++){
                    GameObject tmpObj = handler.obj.get(i);
                    if(tmpObj.getId() == ID.Brick){
                        tmpObj.setY(1);
                    }
                }
                yMove++;
            }else {
                Ball.amountHitPlayer = 0;
                yMove = 0;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 24, 24);
    }

    public void collision(){
        for(int i = 0; i < handler.obj.size(); i++){
            GameObject tmpObj = handler.obj.get(i);
            if(tmpObj.getId() == ID.Player){
                if(getBounds().intersects(tmpObj.getBounds())){
                    physics(Player.dir);
                    hitPlayer = true;
                    amountHitPlayer ++;
                }
            }else if(tmpObj.getId() == ID.Brick && !tmpObj.isShowScore()){
                if(getBounds().intersects((tmpObj.getBounds()))){
                    velY *= -1;
                    tmpObj.setHealth(1);
                }
            }
        }
    }

    public void physics(int dir){
        if(velX > 0 && dir == 1){
            y = player.getY() - 24;

            velX *= -1;
            velY *= -1;
        }else if(velX < 0 && dir == 2){
            y = player.getY() - 24;

            velX *= -1;
            velY *= -1;
        }else {
            y = player.getY() - 24;

            velY *= -1;
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 25, 25);
    }
}
