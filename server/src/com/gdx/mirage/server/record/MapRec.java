package com.gdx.mirage.server.record;

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

    public void clear() {
        name = "";
        revision = 0;
        moral = 0;
        up = -1;
        down = -1;
        left = -1;
        right = -1;

        for (int y = 0; y < Constants.MAX_MAPY; y++) {
            for (int x = 0; x < Constants.MAX_MAPX; x++) {
                tile[x][y].clear();
            }
        }
    }

}
