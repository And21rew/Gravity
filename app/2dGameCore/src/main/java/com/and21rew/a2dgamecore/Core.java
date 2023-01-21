package com.and21rew.a2dgamecore;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Core extends AppCompatActivity {
    private final float FRAME_BUFFER_WIDTH = 800;
    private final float FRAME_BUFFER_HEIGHT = 600;

    private LoopCore loopCore;
    private GraphicsCore graphicsCore;

    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private SceneCore sceneCore;
    private float sceneWidth;
    private float sceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap((int)FRAME_BUFFER_WIDTH, (int)FRAME_BUFFER_HEIGHT, Bitmap.Config.ARGB_8888);
        sceneWidth = FRAME_BUFFER_WIDTH / sizeDisplay.x;
        sceneHeight = FRAME_BUFFER_HEIGHT / sizeDisplay.y;

        loopCore = new LoopCore(this, frameBuffer);
        graphicsCore = new GraphicsCore(getAssets(), frameBuffer);

        stateOnPause = false;
        stateOnResume = false;
        setContentView(loopCore);
    }

    public Core(){

    }

    public void onResume(){
        super.onResume();
        sceneCore.Resume();
        loopCore.StartGame();
    }

    public void onPause(){
        super.onPause();
        sceneCore.Pause();
        loopCore.StopGame();
        stateOnPause = true;

        if (isFinishing()){
            sceneCore.Dispose();
        }
    }

    public GraphicsCore GetGraphicsCore(){
        return graphicsCore;
    }

    public void SetScene(SceneCore sceneCore){
        if (sceneCore == null){
            throw new IllegalArgumentException("NET TAKOI SCENE");
        }

        this.sceneCore.Pause();
        this.sceneCore.Dispose();
        sceneCore.Resume();
        sceneCore.Update();
        this.sceneCore = sceneCore;
    }

    public SceneCore GetCurrentSceneCore(){
        return sceneCore;
    }

    public SceneCore GetStartScene(){
        return sceneCore;
    }
}
