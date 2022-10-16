package com.gdx.mirage.server;

import com.gdx.mirage.shared.EngineConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerLauncher implements EngineConstants {

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        log.info("Starting [{}] v[{}.{}.{}]...", PROJECT_NAME, CLIENT_MAJOR_VERSION, CLIENT_MINOR_VERSION, CLIENT_REVISION_VERSION);
        ServerApplication.getInstance().init();
    }

}