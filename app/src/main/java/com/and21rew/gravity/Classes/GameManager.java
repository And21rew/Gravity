package com.and21rew.gravity.Classes;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.GraphicsCore;
import com.and21rew.gravity.Generators.GeneratorBackground;
import com.and21rew.gravity.Objects.MainPlayer;

public class GameManager {

    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;

    MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;

    public GameManager(Core core, int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = 0;
        mainPlayer = new MainPlayer(core, maxScreenX, maxScreenY, minScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight);
    }

    public void Update(){
        mainPlayer.Update();
        generatorBackground.Update(mainPlayer.getSpeedPlayer());
    }

    public void Drawing(Core core, GraphicsCore graphicsCore){
        mainPlayer.Drawing(graphicsCore);
        generatorBackground.Drawing(graphicsCore);
    }
}
