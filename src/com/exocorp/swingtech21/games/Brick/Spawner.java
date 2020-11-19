package com.exocorp.swingtech21.games.Brick;

import com.exocorp.swingtech21.engine.Handler;
import com.exocorp.swingtech21.games.ID;

public class Spawner {
    private int health = 1;
    private int parity = 2;

    private Handler handler;

    public Spawner(Handler handler) {
        this.handler = handler;
        this.generateLevel();
    }

    private void generateLevel() {
        for(int i = 0; i < 6; i++){
            if(parity % 2 == 0){
                for(int j = 0; j < 15; j++){
                    handler.addObj(new Brick(20 + j * 66, 25 + i * 44, handler, ID.Brick, health));
                    health++;
                    if(health == 4) health = 1;
                }
                parity++;
            }
            else {
                for(int j = 0; j < 15; j++) {
                    handler.addObj(new Brick(10 + j * 66, 25 + i * 44, handler, ID.Brick, health));
                    health++;
                    if(health == 4) health = 1;
                }
                parity --;
            }
        }
    }
}
