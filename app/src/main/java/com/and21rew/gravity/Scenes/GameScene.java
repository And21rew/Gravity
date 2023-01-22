package com.and21rew.gravity.Scenes;

import android.graphics.Color;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.SceneCore;

public class GameScene extends SceneCore {
    public GameScene(Core core) {
        super(core);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Drawing() {
        graphicsCore.ClearScene(Color.BLACK);
        graphicsCore.DrawText("GAME SCENE", 100, 150, Color.GREEN, 60, null);
    }

    @Override
    public void Pause() {

    }

    @Override
    public void Resume() {

    }

    @Override
    public void Dispose() {

    }
}
