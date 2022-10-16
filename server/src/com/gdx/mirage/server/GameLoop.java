package com.gdx.mirage.server;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gdx.mirage.server.system.GameSystem;
import com.gdx.mirage.server.system.impl.DayNightSystem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * As we are running LibGDX headless (a library that does not render), it might be confusing that we have a render
 * method. What this gives us in reality is a game loop that runs 60 times per second, with a reliable delta value
 * that we can use to track time accurately.
 */
@Slf4j
public class GameLoop extends Game {

    private final ArrayList<? extends GameSystem> gameSystems;

    public GameLoop() {
        gameSystems = new ArrayList<>(Arrays.asList(
                new DayNightSystem()
        ));

        for (GameSystem gameSystem : gameSystems) {
            log.info("Registered GameSystem [{}]", gameSystem.getClass().getSimpleName());
        }
    }

    /**
     * The main game loop of the server. Anything that needs to run as part of the game loop should be added to this
     * method, preferably in the form of a {@link GameSystem}.
     */
    private void gameLoop(float delta) {
        // Use of an index loop prevents instantiation of an iterator every frame.
        for (int i = 0; i < gameSystems.size(); i++) {
            gameSystems.get(i).execute(delta);
        }
    }

    /**
     * This render method is called 60 times a second by LibGDX. Although we don't have anything to render, we can
     * put all of our game logic in here, making use of the delta value. We have overridden the default implementation
     * as we have no need for Screens, being that we have nothing to render.
     */
    @Override
    public void render() {
        gameLoop(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void create() {
        log.info("Headless GDX game loop running.");
    }

}
