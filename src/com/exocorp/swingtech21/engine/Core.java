package com.exocorp.swingtech21.engine;

import com.exocorp.swingtech21.engine.input.Keyboard;
import com.exocorp.swingtech21.games.GameSelector;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.file.Files;

public class Core extends Canvas implements Runnable {
    private static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;
    private final String TITLE = "SwingTech 2.1";
    private boolean running = false;
    public static double deltaV;

    public enum STATE{
        Playing,
        Menu,
        GameMenu,
        Win,
        Loose,
        Score
    }

    private Thread thread;
    public Keyboard key;
    private GameSelector game;

    public static STATE gameState = STATE.Menu;

    public Core(){
        new Window(WIDTH, HEIGHT, TITLE, this);
        key = new Keyboard(); addKeyListener(key);
        game = new GameSelector(this); addMouseListener(game); addMouseMotionListener(game);

        StringBuilder s = new StringBuilder();

        
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        requestFocus();
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            deltaV = delta;
            while(delta >=1)
            {
                update();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    public void update(){
        key.update();
        if(gameState == STATE.Playing) game.updateGame();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if(GameSelector.game == GameSelector.GAME.Brick && gameState == STATE.Playing){
            g.setColor(new Color(0, 0, 40));
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }else{
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }

        if(gameState == STATE.Menu) game.renderMenu(g);
        if(gameState == STATE.Playing || gameState == STATE.GameMenu || gameState == STATE.Win || gameState == STATE.Loose || gameState == STATE.Score) { game.renderGame(g); }


        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        thread = new Thread(this, "SW 2.1");
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Core();
    }

    // Setters and Getters ---------------------------------------------------------------------------------------------


    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public String getTITLE() {
        return TITLE;
    }
}
