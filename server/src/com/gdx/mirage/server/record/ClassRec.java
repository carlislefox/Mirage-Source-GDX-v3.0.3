package com.gdx.mirage.server.record;

public class ClassRec {

    public String name;
    public int sprite;
    public short str;
    public short def;
    public short speed;
    public short magi;

    public ClassRec() {
        clear();
    }

    public void clear() {
        name = "";
        str = 0;
        def = 0;
        speed = 0;
        magi = 0;
    }

    public long getMaxHp() {
        return (1 + (str / 2) + str) * 2;
    }

    public long getMaxMp() {
        return (1 + (magi / 2) + magi) * 2;
    }

    public long getMaxSp() {
        return (1 + (speed / 2) + speed) * 2;
    }

}
