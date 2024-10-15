package com.gdx.mirage.server.record;

import com.gdx.mirage.server.module.ModTypes;
import com.gdx.mirage.shared.Constants;
import lombok.Getter;

import java.util.Arrays;

public class PlayerRec {

    // General
    public String name;
    public short sex;
    public short clazz;
    public short sprite;
    public short level;
    public long exp;
    public short access;
    public short pk;
    public short guild;

    // Vitals
    @Getter private long hp;
    @Getter private long mp;
    @Getter private long sp;

    // Stats
    public short str;
    public short def;
    public short speed;
    public short magi;
    public short points;

    // Worn equipment
    public short armorSlot;
    public short weaponSlot;
    public short helmetSlot;
    public short shieldSlot;

    // Inventory
    public final PlayerInvRec[] inv = new PlayerInvRec[Constants.MAX_INV];
    public final short[] spell = new short[Constants.MAX_PLAYER_SPELLS];

    // Position
    public int map;
    public short x;
    public short y;
    public short dir;

    public PlayerRec() {
        clear();
    }

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

        for (int n = 0; n < Constants.MAX_INV; n++) {
            final PlayerInvRec playerInvRec = inv[n];

            if (playerInvRec != null) {
                playerInvRec.clear();
            } else {
                inv[n] = new PlayerInvRec();
            }
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
