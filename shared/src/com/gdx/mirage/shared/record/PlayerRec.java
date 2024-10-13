package com.gdx.mirage.shared.record;

import com.gdx.mirage.shared.Constants;

public class PlayerRec {

    // General
    public String name;
    public byte sex;
    public byte vocation;
    public int sprite;
    public byte level;
    public long exp;
    public byte access;
    public byte pk;
    public byte guild;

    // Vitals
    public long hp;
    public long mp;
    public long sp;

    // Stats
    public byte str;
    public byte def;
    public byte speed;
    public byte magi;
    public byte points;

    // Worn equipment
    public byte armorSlot;
    public byte weaponSlot;
    public byte helmetSlot;
    public byte shieldSlot;

    // Inventory
    public final PlayerInvRec[] inv = new PlayerInvRec[Constants.MAX_INV];
    public final byte[] spell = new byte[Constants.MAX_PLAYER_SPELLS];

    // Position
    public int map;
    public byte x;
    public byte y;
    public byte dir;

}
