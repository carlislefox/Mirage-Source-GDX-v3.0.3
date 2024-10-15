package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class ShopRec {

    public String name;
    public String joinSay;
    public String leaveSay;
    public short fixesItems;
    public final TradeItemRec[] tradeItem = new TradeItemRec[Constants.MAX_TRADES];

    public ShopRec() {
        clear();
    }

    public void clear() {
        name = "";
        joinSay = "";
        leaveSay = "";

        for (int i = 0; i < Constants.MAX_TRADES; i++) {
            final TradeItemRec tradeItemRec = tradeItem[i];

            if (tradeItemRec != null) {
                tradeItemRec.clear();
            } else {
                tradeItem[i] = new TradeItemRec();
            }
        }
    }

}
