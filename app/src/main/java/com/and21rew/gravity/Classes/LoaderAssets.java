package com.and21rew.gravity.Classes;

import com.and21rew.a2dgamecore.Core;
import com.and21rew.a2dgamecore.GraphicsCore;
import com.and21rew.a2dgamecore.Utilities.UtilResource;

import java.util.ArrayList;

public class LoaderAssets {

    public LoaderAssets(Core core, GraphicsCore graphicsCore) {
        LoadTexture(graphicsCore);
        LoadSpritePlayer(graphicsCore);
    }

    private void LoadTexture(GraphicsCore graphicsCore){
        UtilResource.textureAtlas = graphicsCore.UpdateTexture("texture_atlas.png");
    }

    private void LoadSpritePlayer(GraphicsCore graphicsCore){
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayer.add(graphicsCore.UpdateSprite(UtilResource.textureAtlas, 0, 0, 64, 64));
        UtilResource.spritePlayer.add(graphicsCore.UpdateSprite(UtilResource.textureAtlas, 64, 0, 64, 64));
        UtilResource.spritePlayer.add(graphicsCore.UpdateSprite(UtilResource.textureAtlas, 128, 0, 64, 64));
        UtilResource.spritePlayer.add(graphicsCore.UpdateSprite(UtilResource.textureAtlas, 192, 0, 64, 64));
    }
}
