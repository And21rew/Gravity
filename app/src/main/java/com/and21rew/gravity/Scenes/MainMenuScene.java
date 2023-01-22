package com.and21rew.gravity.Scenes;

import android.graphics.Color;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.SceneCore;
import com.and21rew.gravity.R;

public class MainMenuScene extends SceneCore {
    public MainMenuScene(Core core) {
        super(core);
    }

    @Override
    public void Update() {
        if (core.GetTouchListener().GetTouchUp(20, 300, 100, 50)){
            core.SetScene(new GameScene(core));
        }
    }

    @Override
    public void Drawing() {
        graphicsCore.ClearScene(Color.BLACK);
        graphicsCore.DrawText(core.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.BLUE, 60, null);
        graphicsCore.DrawText(core.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.BLUE, 40, null);
        graphicsCore.DrawText(core.getString(R.string.txt_mainMenu_settings), 20, 350, Color.BLUE, 40, null);
        graphicsCore.DrawText(core.getString(R.string.txt_mainMenu_results), 20, 400, Color.BLUE, 40, null);
        graphicsCore.DrawText(core.getString(R.string.txt_mainMenu_exitGame), 20, 450, Color.BLUE, 40, null);
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
