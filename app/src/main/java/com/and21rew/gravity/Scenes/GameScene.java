package com.and21rew.gravity.Scenes;

import android.graphics.Color;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.GraphicsCore;
import com.and21rew.a2dgamecore.SceneCore;
import com.and21rew.gravity.Generators.GeneratorBackground;
import com.and21rew.gravity.R;

public class GameScene extends SceneCore {

    enum GameState{
        READY,
        RUNNING,
        PAUSE,
        GAMEOVER
    }

    GameState gameState;
    GeneratorBackground generatorBackground;
    public GameScene(Core core) {
        super(core);
        gameState = GameState.READY;
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight);
    }

    @Override
    public void Update() {
        if (gameState == GameState.READY){
            UpdateStateReady();
        }
        if (gameState == GameState.RUNNING){
            UpdateStateRunning();
        }
        if (gameState == GameState.PAUSE){
            UpdateStatePause();
        }
        if (gameState == GameState.GAMEOVER){
            UpdateStateGameOver();
        }
    }

    private void UpdateStateReady() {
        if (core.GetTouchListener().GetTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            gameState = GameState.RUNNING;
        }
    }

    private void UpdateStateRunning() {
        generatorBackground.Update();
    }

    private void UpdateStatePause() {
        
    }

    private void UpdateStateGameOver() {
        
    }

    @Override
    public void Drawing() {
        graphicsCore.ClearScene(Color.BLACK);
        graphicsCore.DrawText("GAME SCENE", 100, 150, Color.GREEN, 60, null);

        if (gameState == GameState.READY){
            DrawingStateReady();
        }
        if (gameState == GameState.RUNNING){
            DrawingStateRunning();
        }
        if (gameState == GameState.PAUSE){
            DrawingStatePause();
        }
        if (gameState == GameState.GAMEOVER){
            DrawingStateGameOver();
        }
    }

    private void DrawingStateReady() {
        graphicsCore.ClearScene(Color.BLACK);
        graphicsCore.DrawText(core.getString(R.string.txt_gameScene_stateReady_ready), 250, 300, Color.WHITE, 60, null);
    }

    private void DrawingStateRunning() {
        graphicsCore.ClearScene(Color.BLACK);
        graphicsCore.DrawText("GAME SCENE", 250, 300, Color.WHITE, 60, null);
        generatorBackground.Drawing(graphicsCore);
    }

    private void DrawingStatePause() {
        
    }

    private void DrawingStateGameOver() {
        
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
