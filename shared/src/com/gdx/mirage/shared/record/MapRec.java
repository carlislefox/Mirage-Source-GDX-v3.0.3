package com.gdx.mirage.shared.record;

import com.gdx.mirage.shared.Constants;

public class MapRec {

    public String name;
    public long revision;
    public byte moral;
    public int up;
    public int down;
    public int left;
    public int right;
    public byte music;
    public int bootMap;
    public byte bootX;
    public byte bootY;
    public byte shop;
    public byte indoors;
    public TileRec[][] tile = new TileRec[Constants.MAX_MAPX][Constants.MAX_MAPY];
    public byte[] npc = new byte[Constants.MAX_MAP_NPCS];

}
