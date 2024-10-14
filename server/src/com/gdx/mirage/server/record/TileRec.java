package com.gdx.mirage.server.record;

public class TileRec {

    public int ground;
    public int mask;
    public int anim;
    public int fringe;
    public byte type;
    public int data1;
    public int data2;
    public int data3;

    public void clear() {
        ground = 0;
        mask = 0;
        anim = 0;
        fringe = 0;
        type = 0;
        data1 = 0;
        data2 = 0;
        data3 = 0;
    }

}
