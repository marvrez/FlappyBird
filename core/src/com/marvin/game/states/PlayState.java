package com.marvin.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marvin.game.FlappyBird;
import com.marvin.game.sprites.Bird;
import com.marvin.game.sprites.Tube;

/**
 * Created by marvinreza on 05.01.2017.
 */
public class PlayState extends State {
    private Bird bird;
    private Texture background;
    private Tube tube;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        cam.setToOrtho(false, FlappyBird.WIDTH / 2,FlappyBird.HEIGHT / 2);
        background = new Texture("bg.png");
        tube = new Tube(100);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth / 2),0);
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        sb.draw(tube.getTopTube(),tube.getPosTopTube().x,tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
