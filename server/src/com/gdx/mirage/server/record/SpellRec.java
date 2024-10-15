package com.gdx.mirage.server.record;

public class SpellRec {

    public String name;
    public short classReq;
    public short levelReq;
    public short type;
    public int data1;
    public int data2;
    public int data3;

    public SpellRec() {
        clear();
    }

    public void clear() {
        name = "";
        classReq = 0;
        levelReq = 0;
        type = 0;
        data1 = 0;
        data2 = 0;
        data3 = 0;
    }

}
