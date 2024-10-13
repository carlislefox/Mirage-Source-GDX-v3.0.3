package com.gdx.mirage.server;

import com.gdx.mirage.shared.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerLauncher implements Constants {

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        log.info("Starting [{}] v[{}.{}.{}]...", GAME_NAME, CLIENT_MAJOR, CLIENT_MINOR, CLIENT_REVISION);
        ServerApplication.getInstance().init();
    }

}