package com.gdx.mirage.server;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import lombok.extern.slf4j.Slf4j;

/**
 * As we are running LibGDX headless (a library that does not render), it might be confusing that we have a render
 * method. What this gives us in reality is a game loop that runs 60 times per second, with a reliable delta value
 * that we can use to track time accurately.
 */
@Slf4j
public class GameLoop extends Game {

    private void gameLoop(float delta) {
        //
    }

    @Override
    public void render() {
        gameLoop(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void create() {
        log.info("Headless GDX game loop running.");
    }

}
