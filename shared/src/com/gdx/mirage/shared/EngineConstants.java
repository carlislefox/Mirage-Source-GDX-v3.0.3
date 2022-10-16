package com.gdx.mirage.shared;

import java.util.concurrent.TimeUnit;

public interface EngineConstants {

    /*
     * Project
     */

    String PROJECT_NAME = "MirageGDX";
    int CLIENT_MAJOR_VERSION = 3;
    int CLIENT_MINOR_VERSION = 0;
    int CLIENT_REVISION_VERSION = 3;

    /*
     * Day and Night
     */

    float LENGTH_OF_DAY_SECONDS = TimeUnit.MINUTES.toSeconds(3);
    float LENGTH_OF_NIGHT_SECONDS = TimeUnit.MINUTES.toSeconds(1);

}
