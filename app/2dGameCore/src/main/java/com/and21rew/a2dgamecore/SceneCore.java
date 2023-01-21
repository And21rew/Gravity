package com.and21rew.a2dgamecore;

public abstract class SceneCore {
    private Core core;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicsCore graphicsCore;

    public SceneCore(Core core) {
        this.core = core;
    }

    public abstract void Update();
    public abstract void Drawing();
    public abstract void Pause();
    public abstract void Resume();
    public abstract void Dispose();
}
