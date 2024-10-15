package com.gdx.mirage.server.record;

public class MapItemRec {

    public byte num;
    public long value;
    public int dur;

    public short x;
    public short y;

    public MapItemRec() {
        clear();
    }

    public void clear() {
        num = 0;
        value = 0;
        dur = 0;
        x = 0;
        y = 0;
    }

}
