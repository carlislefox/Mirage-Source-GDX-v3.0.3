package com.gdx.mirage.server.system.impl;

import com.gdx.mirage.server.system.GameSystem;
import com.gdx.mirage.shared.EngineConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * This is just a basic demonstration of how game systems work.
 */
@Slf4j
public class DayNightSystem extends GameSystem implements EngineConstants {

    private float timeElapsed;

    private boolean dayTime;

    public DayNightSystem() {
        timeElapsed = 0;
        dayTime = true;
    }

    @Override
    public void execute(float delta) {
        timeElapsed += delta;

        if (dayTime && timeElapsed >= LENGTH_OF_DAY_SECONDS) {
            timeElapsed -= LENGTH_OF_DAY_SECONDS;
            dayTime = false;
            log.info("Night has fallen.");
        } else if (!dayTime && timeElapsed >= LENGTH_OF_NIGHT_SECONDS) {
            timeElapsed -= LENGTH_OF_NIGHT_SECONDS;
            dayTime = true;
            log.info("The sun has risen.");
        }
    }

}
