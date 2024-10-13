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

}
