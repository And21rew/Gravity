package com.and21rew.gravity.Generators;

import android.graphics.Color;

import com.and21rew.a2dgamecore.GraphicsCore;
import com.and21rew.gravity.Objects.Star;

import java.util.ArrayList;

public class GeneratorBackground {

    public ArrayList<Star> starArrayList = new ArrayList<Star>();

    public GeneratorBackground(int sceneWidth, int sceneHeight) {
        int starsSpeak = 50;

        for (int i = 0; i < starsSpeak; i++){
            Star star = new Star(sceneWidth, sceneHeight);
            starArrayList.add(star);
        }
    }

    public void Update(double speedPlayer){
        for (int i = 0; i < starArrayList.size(); i++){
            starArrayList.get(i).Update(speedPlayer);
        }
    }

    public void Drawing(GraphicsCore graphicsCore){
        for (int i = 0; i < starArrayList.size(); i++){
            graphicsCore.DrawPixel(starArrayList.get(i).getX(), starArrayList.get(i).getY(), Color.WHITE);
        }
    }
}
