package com.and21rew.gravity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.LoopCore;
import com.and21rew.a2dgamecore.SceneCore;
import com.and21rew.gravity.Classes.LoaderAssets;
import com.and21rew.gravity.Scenes.MainMenuScene;

public class Main extends Core {

    public SceneCore GetStartScene(){
        LoaderAssets loaderAssets = new LoaderAssets(this, this.GetGraphicsCore());
        return new MainMenuScene(this);
    }
}