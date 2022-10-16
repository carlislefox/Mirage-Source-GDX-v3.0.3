package com.gdx.mirage.server.domain;

import lombok.Data;

@Data
public class PlayerCharacter {

    private String name;

    private int sprite;

    private Vitals vitals;

    private Experience experience;

    private Stats stats;

    public PlayerCharacter build(String name, int sprite, Vitals vitals, Experience experience, Stats stats) {
        this.name = name;
        this.sprite = sprite;
        this.vitals = vitals;
        this.experience = experience;
        this.stats = stats;
        return this;
    }

    @Data
    public static class Vitals {

        private int hp;

        private int mp;

        private int sp;

        public Vitals build(int hp, int mp, int sp) {
            this.hp = hp;
            this.mp = mp;
            this.sp = sp;
            return this;
        }

    }

    @Data
    public static class Experience {

        private int level;

        private long exp;

        public Experience build(int level, long exp) {
            this.level = level;
            this.exp = exp;
            return this;
        }

    }

    @Data
    public static class Stats {

        private int strength;

        private int defence;

        private int speed;

        private int magic;

        private int unspentStatPoints;

        public Stats build(int strength, int defence, int speed, int magic, int unspentStatPoints) {
            this.strength = strength;
            this.defence = defence;
            this.speed = speed;
            this.magic = magic;
            this.unspentStatPoints = unspentStatPoints;
            return this;
        }

    }

}
