package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class OldMapRec {

    public String name;
    public long revision;
    public short moral;
    public int up;
    public int down;
    public int left;
    public int right;
    public short music;
    public int bootMap;
    public short bootX;
    public short bootY;
    public short shop;
    public final TileRec[][] tile = new TileRec[Constants.MAX_MAPX][Constants.MAX_MAPY];
    public final short[] npc = new short[Constants.MAX_MAP_NPCS];

}
