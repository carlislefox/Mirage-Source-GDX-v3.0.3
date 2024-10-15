package com.gdx.mirage.server.module;

import com.gdx.mirage.server.record.*;
import com.gdx.mirage.shared.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModTypes {

    private static ModTypes instance;

    // Maximum classes
    public byte MAX_CLASSES;

    public final MapRec[] map = new MapRec[Constants.MAX_MAPS];
    public final TempTileRec[] tempTile = new TempTileRec[Constants.MAX_MAPS];
    public final long[] playersOnMap = new long[Constants.MAX_MAPS];
    private AccountRec[] players = new AccountRec[Constants.MAX_PLAYERS];
    public ClassRec[] classes;
    public ItemRec[] item = new ItemRec[Constants.MAX_ITEMS];
    public NpcRec[] npc = new NpcRec[Constants.MAX_NPCS];
    public MapItemRec[][] mapItem = new MapItemRec[Constants.MAX_MAPS][Constants.MAX_MAP_ITEMS];
    public MapNpcRec[][] mapNpc = new MapNpcRec[Constants.MAX_MAPS][Constants.MAX_MAP_NPCS];
    public ShopRec[] shop = new ShopRec[Constants.MAX_SHOPS];
    public SpellRec[] spell = new SpellRec[Constants.MAX_SPELLS];
    public GuildRec[] guild = new GuildRec[Constants.MAX_GUILDS];

    private ModTypes() {
        log.info("Instantiating ModTypes...");
    }

    /**
     * Singleton.
     */
    public static ModTypes getInstance() {
        if (instance == null) instance = new ModTypes();
        return instance;
    }

    public void clearTempTile() {
        for (int i = 0; i < Constants.MAX_MAPS; i++) {
            tempTile[i] = new TempTileRec();
        }
    }

    public void clearClasses() {
        for (int i = 0; i < MAX_CLASSES; i++) {
            final ClassRec classRec = classes[i];

            if (classRec != null) {
                classRec.clear();
            } else {
                classes[i] = new ClassRec();
            }
        }
    }

    public AccountRec clearPlayer(int index) {
        final AccountRec accountRec = players[index];

        if (accountRec != null) {
            accountRec.clear();
        } else {
            players[index] = new AccountRec();
        }

        return players[index];
    }

    public void clearChar(int index, int charNum) {
        if (players[index] == null) {
            clearPlayer(index);
        }

        players[index].clearChar(charNum);
    }

    public void clearItem(int index) {
        final ItemRec itemRec = item[index];

        if (itemRec != null) {
            itemRec.clear();
        } else {
            item[index] = new ItemRec();
        }
    }

    public void clearItems() {
        for (int i = 0; i < Constants.MAX_ITEMS; i++) {
            clearItem(i);
        }
    }

    public void clearNpc(int index) {
        final NpcRec npcRec = npc[index];

        if (npcRec != null) {
            npcRec.clear();
        } else {
            npc[index] = new NpcRec();
        }
    }

    public void clearNpcs() {
        for (int i = 0; i < Constants.MAX_NPCS; i++) {
            clearNpc(i);
        }
    }

    public void clearMapItem(int index, int mapNum) {
        MapItemRec mapItemRec = mapItem[mapNum][index];

        if (mapItemRec != null) {
            mapItemRec.clear();
        } else {
            mapItem[mapNum][index] = new MapItemRec();
        }
    }

    public void clearMapItems() {
        for (int y = 0; y < Constants.MAX_MAPS; y++) {
            for (int x = 0; x < Constants.MAX_MAP_ITEMS; x++) {
                clearMapItem(x, y);
            }
        }
    }

    public void clearMapNpc(int index, int mapNum) {
        final MapNpcRec mapNpcRec = mapNpc[mapNum][index];

        if (mapNpcRec != null) {
            mapNpcRec.clear();
        } else {
            mapNpc[mapNum][index] = new MapNpcRec();
        }
    }

    public void clearMapNpcs() {
        for (int y = 0; y < Constants.MAX_MAPS; y++) {
            for (int x = 0; x < Constants.MAX_MAP_NPCS; x++) {
                clearMapNpc(x, y);
            }
        }
    }

    public void clearMap(int mapNum) {
        final MapRec mapRec = map[mapNum];

        if (mapRec != null) {
            mapRec.clear();
        } else {
            map[mapNum] = new MapRec();
        }

        // Reset the values for if a player is on the map or not
        playersOnMap[mapNum] = Constants.NO;
    }

    public void clearMaps() {
        for (int i = 0; i < Constants.MAX_MAPS; i++) {
            clearMap(i);
        }
    }

    public void clearShop(int index) {
        final ShopRec shopRec = shop[index];

        if (shopRec != null) {
            shopRec.clear();
        } else {
            shop[index] = new ShopRec();
        }
    }

    public void clearShops() {
        for (int i = 0; i < Constants.MAX_SHOPS; i++) {
            clearShop(i);
        }
    }

    public void clearSpell(int index) {
        final SpellRec spellRec = spell[index];

        if (spellRec != null) {
            spellRec.clear();
        } else {
            spell[index] = new SpellRec();
        }
    }

    public void clearSpells() {
        for (int i = 0; i < Constants.MAX_SPELLS; i++) {
            clearSpell(i);
        }
    }

    /*
     * Player functions
     */

    public AccountRec getPlayer(int index) {
        return players[index];
    }

    // TODO: Port below functions

//
//    Function GetPlayerIP(ByVal Index As Long) As String
//    GetPlayerIP = frmServer.Socket(Index).RemoteHostIP
//    End Function
//

}
