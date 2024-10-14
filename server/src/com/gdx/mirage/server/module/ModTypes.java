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
     * The singleton pattern dictates we will only ever have one instance of this class, having a static getInstance()
     * method like this means we can get a reference to our class from anywhere in the code by calling.
     */
    public static ModTypes getInstance() {
        if (instance == null) instance = new ModTypes();
        return instance;
    }

    public void clearTempTile() {
        for (int i = 0; i < Constants.MAX_MAPS; i++) {
            tempTile[i].clear();
        }
    }

    public void clearClasses() {
        for (int i = 0; i < MAX_CLASSES; i++) {
            classes[i].clear();
        }
    }

    public void clearPlayer(int index) {
        players[index].clear();
    }

    public void clearChar(int index, int charNum) {
        players[index].clearChar(charNum);
    }

    public void clearItem(int index) {
        item[index].clear();
    }

    public void clearItems() {
        for (int i = 0; i < Constants.MAX_ITEMS; i++) {
            clearItem(i);
        }
    }

    public void clearNpc(int index) {
        npc[index].clear();
    }

    public void clearNpcs() {
        for (int i = 0; i < Constants.MAX_NPCS; i++) {
            clearNpc(i);
        }
    }

    public void clearMapItem(int index, int mapNum) {
        mapItem[mapNum][index].clear();
    }

    public void clearMapItems() {
        for (int y = 0; y < Constants.MAX_MAPS; y++) {
            for (int x = 0; x < Constants.MAX_MAP_ITEMS; x++) {
                clearMapItem(x, y);
            }
        }
    }

    public void clearMapNpc(int index, int mapNum) {
        mapNpc[mapNum][index].clear();
    }

    public void clearMapNpcs() {
        for (int y = 0; y < Constants.MAX_MAPS; y++) {
            for (int x = 0; x < Constants.MAX_MAP_NPCS; x++) {
                clearMapNpc(x, y);
            }
        }
    }

    public void clearMap(int mapNum) {
        map[mapNum].clear();

        // Reset the values for if a player is on the map or not
        playersOnMap[mapNum] = Constants.NO;
    }

    public void clearMaps() {
        for (int i = 0; i < Constants.MAX_MAPS; i++) {
            clearMap(i);
        }
    }

    public void clearShop(int index) {
        shop[index].clear();
    }

    public void clearShops() {
        for (int i = 0; i < Constants.MAX_SHOPS; i++) {
            clearShop(i);
        }
    }

    public void clearSpell(int index) {
        spell[index].clear();
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
//    Function GetPlayerInvItemNum(ByVal Index As Long, ByVal InvSlot As Long) As Long
//    GetPlayerInvItemNum = Player(Index).Char(Player(Index).CharNum).Inv(InvSlot).Num
//    End Function
//
//    Sub SetPlayerInvItemNum(ByVal Index As Long, ByVal InvSlot As Long, ByVal ItemNum As Long)
//    Player(Index).Char(Player(Index).CharNum).Inv(InvSlot).Num = ItemNum
//    End Sub
//
//    Function GetPlayerInvItemValue(ByVal Index As Long, ByVal InvSlot As Long) As Long
//    GetPlayerInvItemValue = Player(Index).Char(Player(Index).CharNum).Inv(InvSlot).Value
//    End Function
//
//    Sub SetPlayerInvItemValue(ByVal Index As Long, ByVal InvSlot As Long, ByVal ItemValue As Long)
//    Player(Index).Char(Player(Index).CharNum).Inv(InvSlot).Value = ItemValue
//    End Sub
//
//    Function GetPlayerInvItemDur(ByVal Index As Long, ByVal InvSlot As Long) As Long
//    GetPlayerInvItemDur = Player(Index).Char(Player(Index).CharNum).Inv(InvSlot).Dur
//    End Function
//
//    Sub SetPlayerInvItemDur(ByVal Index As Long, ByVal InvSlot As Long, ByVal ItemDur As Long)
//    Player(Index).Char(Player(Index).CharNum).Inv(InvSlot).Dur = ItemDur
//    End Sub
//
//    Function GetPlayerSpell(ByVal Index As Long, ByVal SpellSlot As Long) As Long
//    GetPlayerSpell = Player(Index).Char(Player(Index).CharNum).Spell(SpellSlot)
//    End Function
//
//    Sub SetPlayerSpell(ByVal Index As Long, ByVal SpellSlot As Long, ByVal SpellNum As Long)
//    Player(Index).Char(Player(Index).CharNum).Spell(SpellSlot) = SpellNum
//    End Sub
//

}
