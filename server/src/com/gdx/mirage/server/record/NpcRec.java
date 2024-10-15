package com.gdx.mirage.server.record;

public class NpcRec {

    public String name;
    public String attackSay;

    public int sprite;
    public long spawnSecs;
    public short behavior;
    public short range;

    public int dropChance;
    public short dropItem;
    public int dropItemValue;

    public short str;
    public short def;
    public short speed;
    public short magi;

    public NpcRec() {
        clear();
    }

    public void clear() {
        name = "";
        attackSay = "";
        sprite = 0;
        spawnSecs = 0;
        behavior = 0;
        range = 0;
        dropChance = 0;
        dropItem = 0;
        dropItemValue = 0;
        str = 0;
        def = 0;
        speed = 0;
        magi = 0;
    }

}
