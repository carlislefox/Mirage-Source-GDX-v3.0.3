package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class MapRec {

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
    public short indoors;
    public TileRec[][] tile = new TileRec[Constants.MAX_MAPX][Constants.MAX_MAPY];
    public short[] npc = new short[Constants.MAX_MAP_NPCS];

    public MapRec() {
        clear();
    }

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
                final TileRec tileRec = tile[x][y];

                if (tileRec != null) {
                    tileRec.clear();
                } else {
                    tile[x][y] = new TileRec();
                }
            }
        }
    }

}
