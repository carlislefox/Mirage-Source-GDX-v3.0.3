package com.gdx.mirage.server.module;

import com.gdx.mirage.shared.Constants;
import com.gdx.mirage.shared.record.*;
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
            tempTile[i].doorTimer = 0;

            for (int y = 0; y < Constants.MAX_MAPY; y++) {
                for (int x = 0; x < Constants.MAX_MAPX; x++) {
                    tempTile[i].doorOpen[x][y] = Constants.NO;
                }
            }
        }
    }

    public void clearClasses() {
        for (int i = 0; i < MAX_CLASSES; i++) {
            final ClassRec classRec = classes[i];
            classRec.name = "";
            classRec.str = 0;
            classRec.def = 0;
            classRec.speed = 0;
            classRec.magi = 0;
        }
    }

    public void clearPlayer(int index) {
        final AccountRec accountRec = players[index];
        accountRec.login = "";
        accountRec.password = "";

        for (int i = 0; i < Constants.MAX_CHARS; i++) {
            clearChar(index, i);
        }

        // Temporary vars
        accountRec.buffer = "";
        accountRec.incBuffer = "";
        accountRec.charNum = 0;
        accountRec.ingame = false;
        accountRec.attackTimer = 0;
        accountRec.dataTimer = 0;
        accountRec.dataBytes = 0;
        accountRec.dataPackets = 0;
        accountRec.partyPlayer = 0;
        accountRec.inParty = 0;
        accountRec.target = 0;
        accountRec.targetType = 0;
        accountRec.castedSpell = Constants.NO;
        accountRec.partyStarter = Constants.NO;
        accountRec.gettingMap = Constants.NO;
    }

    public void clearChar(int index, int charNum) {
        final PlayerRec playerRec = players[index].characters[charNum];
        playerRec.vocation = 0;
        playerRec.level = 0;
        playerRec.sprite = 0;
        playerRec.exp = 0;
        playerRec.access = 0;
        playerRec.pk = Constants.NO;
        playerRec.points = 0;
        playerRec.guild = 0;

        playerRec.hp = 0;
        playerRec.mp = 0;
        playerRec.sp = 0;

        playerRec.str = 0;
        playerRec.def = 0;
        playerRec.speed = 0;
        playerRec.magi = 0;

        for (int n = 0; n < Constants.MAX_PLAYER_SPELLS; n++) {
            final PlayerInvRec playerInvRec = playerRec.inv[n];
            playerInvRec.num = 0;
            playerInvRec.value = 0;
            playerInvRec.dur = 0;
        }

        for (int n = 0; n < Constants.MAX_PLAYER_SPELLS; n++) {
            playerRec.spell[n] = 0;
        }

        playerRec.armorSlot = 0;
        playerRec.weaponSlot = 0;
        playerRec.helmetSlot = 0;
        playerRec.shieldSlot = 0;

        playerRec.map = 0;
        playerRec.x = 0;
        playerRec.y = 0;
        playerRec.dir = 0;
    }

    public void clearItem(int index) {
        final ItemRec itemRec = item[index];
        itemRec.name = "";
        itemRec.pic = 0;
        itemRec.type = 0;
        itemRec.data1 = 0;
        itemRec.data2 = 0;
        itemRec.data3 = 0;
    }

    public void clearItems() {
        for (int i = 0; i < Constants.MAX_ITEMS; i++) {
            clearItem(i);
        }
    }

    // TODO: Implement subroutines from 'Sub ClearNpc(ByVal Index As Long)' onwards

}
