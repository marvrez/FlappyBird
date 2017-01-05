package com.marvin.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by marvinreza on 05.01.2017.
 */
public class Animation {
    private ArrayList<TextureRegion> frames;
    private float maxFrameTime;
    private float curFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new ArrayList<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for(int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt) {
        curFrameTime += dt;
        if(curFrameTime > maxFrameTime){
            frame++;
            curFrameTime = 0;
        }
        if (frame >= frameCount)
            frame = 0;
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }
}
