package com.gdx.mirage.server.record;

import com.gdx.mirage.server.module.ModTypes;
import com.gdx.mirage.shared.Constants;
import lombok.Getter;

import java.util.Arrays;

public class PlayerRec {

    // General
    public String name;
    public byte sex;
    public byte clazz;
    public int sprite;
    public byte level;
    public long exp;
    public byte access;
    public byte pk;
    public byte guild;

    // Vitals
    @Getter private long hp;
    @Getter private long mp;
    @Getter private long sp;

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

    public void clear() {
        clazz = 0;
        level = 0;
        sprite = 0;
        exp = 0;
        access = 0;
        pk = Constants.NO;
        points = 0;
        guild = 0;
        hp = 0;
        mp = 0;
        sp = 0;
        str = 0;
        def = 0;
        speed = 0;
        magi = 0;

        for (int n = 0; n < Constants.MAX_PLAYER_SPELLS; n++) {
            inv[n].clear();
        }

        Arrays.fill(spell, (byte) 0);

        armorSlot = 0;
        weaponSlot = 0;
        helmetSlot = 0;
        shieldSlot = 0;

        map = 0;
        x = 0;
        y = 0;
        dir = 0;
    }

    public long getNextLevel() {
        return (level + 1) * (str + def + magi + speed + points) * 25;
    }

    public void setHp(long hp) {
        this.hp = Math.max(0, Math.max(hp, getMaxHp()));
    }

    public long getMaxHp() {
        return (level + (str / 2) + ModTypes.getInstance().classes[clazz].str) * 2;
    }

    public void setMp(long mp) {
        this.hp = Math.max(0, Math.max(hp, getMaxMp()));
    }

    public long getMaxMp() {
        return (level + (magi / 2) + ModTypes.getInstance().classes[clazz].magi) * 2;
    }

    public void setSp(long sp) {
        this.hp = Math.max(0, Math.max(hp, getMaxSp()));
    }

    public long getMaxSp() {
        return (level + (speed / 2) + ModTypes.getInstance().classes[clazz].speed) * 2;
    }

}
