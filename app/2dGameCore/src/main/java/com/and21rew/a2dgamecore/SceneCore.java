package com.and21rew.a2dgamecore;

public abstract class SceneCore {
    public Core core;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicsCore graphicsCore;

    public SceneCore(Core core) {
        this.core = core;
        graphicsCore = core.GetGraphicsCore();
        sceneWidth = core.GetGraphicsCore().GetWidthFrameBuffer();
        sceneHeight = core.GetGraphicsCore().GetHeightFrameBuffer();
    }

    public abstract void Update();
    public abstract void Drawing();
    public abstract void Pause();
    public abstract void Resume();
    public abstract void Dispose();
}
