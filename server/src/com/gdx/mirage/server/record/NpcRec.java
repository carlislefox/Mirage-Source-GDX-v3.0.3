package com.gdx.mirage.server.record;

public class NpcRec {

    public String name;
    public String attackSay;

    public int sprite;
    public long spawnSecs;
    public byte behavior;
    public byte range;

    public int dropChance;
    public byte dropItem;
    public int dropItemValue;

    public byte str;
    public byte def;
    public byte speed;
    public byte magi;

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
