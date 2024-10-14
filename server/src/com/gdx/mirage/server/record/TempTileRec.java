package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class TempTileRec {

    public final byte[][] doorOpen = new byte[Constants.MAX_MAPX][Constants.MAX_MAPY];
    public long doorTimer;

    public void clear() {
        doorTimer = 0;

        for (int y = 0; y < Constants.MAX_MAPY; y++) {
            for (int x = 0; x < Constants.MAX_MAPX; x++) {
                doorOpen[x][y] = Constants.NO;
            }
        }
    }

}
