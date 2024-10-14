package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class ShopRec {

    public String name;
    public String joinSay;
    public String leaveSay;
    public byte fixesItems;
    public final TradeItemRec[] tradeItem = new TradeItemRec[Constants.MAX_TRADES];

    public void clear() {
        name = "";
        joinSay = "";
        leaveSay = "";

        for (int i = 0; i < Constants.MAX_TRADES; i++) {
            tradeItem[i].clear();
        }
    }

}
