package com.gdx.mirage.server.system;

/**
 * A system that should execute each frame of the server's game logic loop.
 */
public abstract class GameSystem {

    /**
     * Implement this system's game logic.
     * @param delta The time that has passed since the previous frame's execution.
     */
    public abstract void execute(float delta);

}
