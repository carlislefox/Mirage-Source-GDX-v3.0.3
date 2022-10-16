package com.gdx.mirage.server;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerApplication {

    private static ServerApplication instance;

    private static Thread libGdxThread;

    private final HeadlessApplication headlessApplication;

    /**
     * Private constructor means this class can only be instantiated via a static call to getInstance().
     */
    private ServerApplication() {
        log.info("Starting headless GDX game loop...");
        // Calling the constructor of HeadlessApplication starts the headless LibGDX game loop in a new thread.
        headlessApplication = new HeadlessApplication(new GameLoop());
    }

    public void init() {
        headlessApplication.postRunnable(() -> libGdxThread = Thread.currentThread());
    }

    /**
     * The singleton pattern dictates we will only ever have one instance of this class, having a static getInstance()
     * method like this means we can get a reference to our class from anywhere in the code by calling.
     */
    public static ServerApplication getInstance() {
        if (instance == null) instance = new ServerApplication();
        return instance;
    }

    /**
     * Allows us to easily check if we are executing from inside the GDX Thread.
     */
    public static boolean isLibGDXThread() {
        return Thread.currentThread() == libGdxThread;
    }

}
