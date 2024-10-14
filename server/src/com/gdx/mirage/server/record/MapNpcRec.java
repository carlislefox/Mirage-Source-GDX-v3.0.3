package com.gdx.mirage.server.record;

public class MapNpcRec {

    public int num;

    public int target;

    public long hp;
    public long mp;
    public long sp;

    public byte x;
    public byte y;
    public int dir;

    // For server use only
    public long spawnWait;
    public long attackTimer;

    public void clear() {
        num = 0;
        target = 0;
        hp = 0;
        mp = 0;
        sp = 0;
        x = 0;
        y = 0;
        dir = 0;

        // Server use only
        spawnWait = 0;
        attackTimer = 0;
    }

}
