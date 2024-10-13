package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class TempTileRec {

    public final byte[][] doorOpen = new byte[Constants.MAX_MAPX][Constants.MAX_MAPY];
    public long doorTimer;

}
