package com.and21rew.gravity.Objects;

import com.and21rew.a2dgamecore.GraphicsCore;
import com.and21rew.a2dgamecore.ObjectCore;
import com.and21rew.a2dgamecore.Utilities.UtilResource;
import com.and21rew.gravity.Classes.AnimationGame;

public class MainPlayer extends ObjectCore {

    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationGame animSpriteMainPlayer;

    public MainPlayer(int maxScreenX, int maxScreenY, int minScreenY) {
        x = 20;
        y = 200;
        speed = 1;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        animSpriteMainPlayer = new AnimationGame(speed, UtilResource.spritePlayer.get(0), UtilResource.spritePlayer.get(1), UtilResource.spritePlayer.get(2), UtilResource.spritePlayer.get(3));
    }

    public void Update(){
        y -= speed + GRAVITY;
        if (y < minScreenY){
            y = minScreenY;
        }
        if (y > maxScreenY){
            y = maxScreenY;
        }
        animSpriteMainPlayer.RunAnimation();
    }

    public void Drawing(GraphicsCore graphicsCore){
        animSpriteMainPlayer.DrawingAnimation(graphicsCore, x, y);
    }
}
