package com.and21rew.a2dgamecore;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class GraphicsCore {
    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame;
    private Canvas canvasGame;
    private Paint paintGame;
    private Bitmap textureGame;

    public GraphicsCore(AssetManager assetManagerGame, Bitmap frameBufferGame){
        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    public void ClearScene(int colorRGB){
        canvasGame.drawRGB(colorRGB, colorRGB, colorRGB);
    }

    public void DrawPixel(int x, int y, int color){
        paintGame.setColor(color);
        canvasGame.drawPoint(x, y, paintGame);
    }

    public void DrawLine(int startX, int startY, int stopX, int stopY, int color){
        paintGame.setColor(color);
        canvasGame.drawLine(startX, startY, stopX, stopY, paintGame);
    }

    public void DrawText(String text, int x, int y, int color, int sizeText, Typeface font){
        paintGame.setColor(color);
        paintGame.setTextSize(sizeText);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }

    public void DrawTexture(Bitmap textureGame, int x, int y){
        canvasGame.drawBitmap(textureGame, x, y, null);
    }

    public int GetWidthFrameBuffer(){
        return frameBufferGame.getWidth();
    }

    public int GetHeightFrameBuffer(){
        return frameBufferGame.getHeight();
    }

    public Bitmap UpdateTexture(String fileName){
        InputStream inputStream = null;
        try {
            inputStream = assetManagerGame.open(fileName);
            textureGame = BitmapFactory.decodeStream(inputStream);

            if (textureGame == null)
                throw new RuntimeException("NET TAKOGO FAILA" + fileName);
        } catch (IOException e) {
            throw new RuntimeException("NET TAKOGO FAILA" + fileName);
        }

        if (inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return textureGame;
    }

    public Bitmap UpdateSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite){
        return Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
    }
}
