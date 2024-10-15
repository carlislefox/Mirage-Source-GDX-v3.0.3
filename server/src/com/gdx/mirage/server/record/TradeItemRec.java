package com.gdx.mirage.server.record;

public class TradeItemRec {

    public long giveItem;
    public long giveValue;
    public long getItem;
    public long getValue;

    public TradeItemRec() {
        clear();
    }

    public void clear() {
        giveItem = 0;
        giveValue = 0;
        getItem = 0;
        getValue = 0;
    }

}
