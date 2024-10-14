package com.gdx.mirage.server.record;

public class ItemRec {

    public String name;
    public int pic;
    public byte type;
    public int data1;
    public int data2;
    public int data3;

    public void clear() {
        name = "";
        pic = 0;
        type = 0;
        data1 = 0;
        data2 = 0;
        data3 = 0;
    }

}
