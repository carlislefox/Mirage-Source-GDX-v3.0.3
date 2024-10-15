package com.gdx.mirage.server.record;

public class PlayerInvRec {

    public short num;
    public long value;
    public int dur;

    public PlayerInvRec() {
        clear();
    }

    public void clear() {
        num = 0;
        value = 0;
        dur = 0;
    }

}
