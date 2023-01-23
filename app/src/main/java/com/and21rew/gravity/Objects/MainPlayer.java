package com.and21rew.gravity.Objects;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.GraphicsCore;
import com.and21rew.a2dgamecore.ObjectCore;
import com.and21rew.gravity.Utilities.UtilResource;
import com.and21rew.a2dgamecore.AnimationCore;

public class MainPlayer extends ObjectCore {

    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationCore animMainPlayer;
    AnimationCore animMainPlayerBoost;
    Core core;

    boolean boosting;

    public MainPlayer(Core core, int maxScreenX, int maxScreenY, int minScreenY) {
        x = 20;
        y = 200;
        speed = 1;
        boosting = false;
        this.core = core;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        animMainPlayer = new AnimationCore(1, UtilResource.spritePlayer.get(0), UtilResource.spritePlayer.get(1), UtilResource.spritePlayer.get(2), UtilResource.spritePlayer.get(3));
        animMainPlayerBoost = new AnimationCore(1, UtilResource.spritePlayerBoost.get(0), UtilResource.spritePlayerBoost.get(1), UtilResource.spritePlayerBoost.get(2), UtilResource.spritePlayerBoost.get(3));
    }

    public void Update(){

        if (core.GetTouchListener().GetTouchDown(0, maxScreenY, maxScreenX, maxScreenY)){
            StartBoosting();
        }

        if (core.GetTouchListener().GetTouchUp(0, maxScreenY, maxScreenX, maxScreenY)){
            StopBoosting();
        }

        if (boosting){
            speed += 0.1;
        }
        else {
            speed -= 3;
        }

        if (speed > MAX_SPEED){
            speed = MAX_SPEED;
        }
        if (speed < MIN_SPEED){
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;
        if (y < minScreenY){
            y = minScreenY;
        }
        if (y > maxScreenY){
            y = maxScreenY;
        }
        if (boosting){
            animMainPlayerBoost.RunAnimation();
        }
        else {
            animMainPlayer.RunAnimation();
        }
    }

    public void Drawing(GraphicsCore graphicsCore){
        if (boosting){
            animMainPlayerBoost.DrawingAnimation(graphicsCore, x, y);
        }
        else {
            animMainPlayer.DrawingAnimation(graphicsCore, x, y);
        }
    }

    private void StartBoosting(){
        boosting = true;
    }

    private void StopBoosting(){
        boosting = false;
    }

    public double getSpeedPlayer(){
        return speed;
    }
}
