package com.and21rew.gravity.Objects;

import com.and21rew.a2dgamecore.ObjectCore;
import com.and21rew.a2dgamecore.Utilities.UtilRandomCore;

public class Star extends ObjectCore {

    public Star(int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = 0;
        this.speed = 2;
        this.x = UtilRandomCore.GetCasualNumber(maxScreenX);
        this.y = UtilRandomCore.GetCasualNumber(maxScreenY);
    }

    public void Update(){
        setX((int)(getX() - getSpeed()));

        if (getX() < 0){
            x = maxScreenX;
            y = UtilRandomCore.GetCasualNumber(maxScreenY);
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
