package com.and21rew.a2dgamecore;

import java.util.Date;

public class LoopCore implements Runnable{

    private final float FPS = 60f;
    private final float SECOND = 10_000_000f;
    private final float UPDATE_TIME = SECOND / FPS;

    private boolean running = false;

    Thread gameThread = null;

    //TEMP
    float updates = 0;
    float drawing = 0;
    long timer = 0;
    //TEMP

    @Override
    public void run() {
        float lastTime = System.nanoTime();
        float deltaTime = 0f;
        timer = System.nanoTime();

        while (running){
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            deltaTime += elapsedTime/UPDATE_TIME;

            if (deltaTime > 1){
                UpdateGame();
                DrawingGame();
                deltaTime--;
            }

            if (System.currentTimeMillis() - timer > 1000){
                Date date = new Date();
                System.out.println("Updates" + updates + "\n" + "Drawing"+ drawing + "\n"+ "Date"+ date);
                updates = 0;
                drawing = 0;
                timer += 1000;
            }
        }
    }

    private void UpdateGame(){
        updates++;
    }

    private void DrawingGame(){
        drawing++;
    }

    public void StartGame(){
        if (running)
            return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void StopGame(){
        if (!running)
            return;

        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
