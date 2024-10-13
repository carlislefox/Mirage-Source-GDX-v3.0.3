package com.gdx.mirage.server.module;

import com.gdx.mirage.server.record.*;
import com.gdx.mirage.shared.Constants;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

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

    public void clearNpc(int index) {
        final NpcRec npcRec = npc[index];
        npcRec.name = "";
        npcRec.attackSay = "";
        npcRec.sprite = 0;
        npcRec.spawnSecs = 0;
        npcRec.behavior = 0;
        npcRec.range = 0;
        npcRec.dropChance = 0;
        npcRec.dropItem = 0;
        npcRec.dropItemValue = 0;
        npcRec.str = 0;
        npcRec.def = 0;
        npcRec.speed = 0;
        npcRec.magi = 0;
    }

    public void clearNpcs() {
        for (int i = 0; i < Constants.MAX_NPCS; i++) {
            clearNpc(i);
        }
    }

    public void clearMapItem(int index, int mapNum) {
        final MapItemRec mapItemRec = mapItem[mapNum][index];
        mapItemRec.num = 0;
        mapItemRec.value = 0;
        mapItemRec.dur = 0;
        mapItemRec.x = 0;
        mapItemRec.y = 0;
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
        mapNpcRec.num = 0;
        mapNpcRec.target = 0;
        mapNpcRec.hp = 0;
        mapNpcRec.mp = 0;
        mapNpcRec.sp = 0;
        mapNpcRec.x = 0;
        mapNpcRec.y = 0;
        mapNpcRec.dir = 0;

        // Server use only
        mapNpcRec.spawnWait = 0;
        mapNpcRec.attackTimer = 0;
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
        mapRec.name = "";
        mapRec.revision = 0;
        mapRec.moral = 0;
        mapRec.up = -1;
        mapRec.down = -1;
        mapRec.left = -1;
        mapRec.right = -1;

        for (int y = 0; y < Constants.MAX_MAPY; y++) {
            for (int x = 0; x < Constants.MAX_MAPX; x++) {
                final TileRec tileRec = mapRec.tile[x][y];
                tileRec.ground = 0;
                tileRec.mask = 0;
                tileRec.anim = 0;
                tileRec.fringe = 0;
                tileRec.type = 0;
                tileRec.data1 = 0;
                tileRec.data2 = 0;
                tileRec.data3 = 0;
            }
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
        shopRec.name = "";
        shopRec.joinSay = "";
        shopRec.leaveSay = "";

        for (int i = 0; i < Constants.MAX_TRADES; i++) {
            final TradeItemRec tradeItemRec = shopRec.tradeItem[i];
            tradeItemRec.giveItem = 0;
            tradeItemRec.giveValue = 0;
            tradeItemRec.getItem = 0;
            tradeItemRec.getValue = 0;
        }
    }

    public void clearShops() {
        for (int i = 0; i < Constants.MAX_SHOPS; i++) {
            clearShop(i);
        }
    }

    public void clearSpell(int index) {
        final SpellRec spellRec = spell[index];
        spellRec.name = "";
        spellRec.classReq = 0;
        spellRec.levelReq = 0;
        spellRec.type = 0;
        spellRec.data1 = 0;
        spellRec.data2 = 0;
        spellRec.data3 = 0;
    }

    public void clearSpells() {
        for (int i = 0; i < Constants.MAX_SPELLS; i++) {
            clearSpell(i);
        }
    }

    /*
     * Player functions
     */

    public String getPlayerLogin(int index) {
        return players[index].login.trim();
    }

    public void setPlayerLogin(int index, String login) {
        players[index].login = login;
    }

    public String getPlayerPassword(int index) {
        return players[index].password.trim();
    }

    public void setPlayerPassword(int index, String password) {
        players[index].password = password;
    }

    public String getPlayerName(int index) {
        return players[index].characters[players[index].charNum].name;
    }

    public void setPlayerName(int index, String name) {
        players[index].characters[players[index].charNum].name = name;
    }

    public long getPlayerClass(int index) {
        return players[index].characters[players[index].charNum].vocation;
    }

    public void setPlayerClass(int index, long vocation) {
        players[index].characters[players[index].charNum].vocation = (byte) vocation;
    }

    public long getPlayerSprite(int index) {
        return players[index].characters[players[index].charNum].sprite;
    }

    public void setPlayerSprite(int index, long sprite) {
        players[index].characters[players[index].charNum].sprite = (int) sprite;
    }

    public long getPlayerLevel(int index) {
        return players[index].characters[players[index].charNum].level;
    }

    public void setPlayerLevel(int index, long level) {
        players[index].characters[players[index].charNum].level = (byte) level;
    }

    public long getPlayerNextLevel(int index) {
        return (getPlayerLevel(index) + 1) * (getPlayerStr(index) + getPlayerDef(index) + getPlayerMagi(index) + getPlayerSpeed(index) + getPlayerPoints(index)) * 25;
    }

    public long getPlayerExp(int index) {
        return players[index].characters[players[index].charNum].exp;
    }

    public void setPlayerExp(int index, long exp) {
        players[index].characters[players[index].charNum].exp = (int) exp;
    }

    public long getPlayerAccess(int index) {
        return players[index].characters[players[index].charNum].access;
    }

    public void setPlayerAccess(int index, long access) {
        players[index].characters[players[index].charNum].access = (byte) access;
    }

    public long getPlayerPk(int index) {
        return players[index].characters[players[index].charNum].pk;
    }

    public void setPlayerPk(int index, long pk) {
        players[index].characters[players[index].charNum].pk = (byte) pk;
    }

    public long getPlayerHp(int index) {
        return players[index].characters[players[index].charNum].hp;
    }

    public void setPlayerHp(int index, long hp) {
        players[index].characters[players[index].charNum].hp = (byte) hp;

        if (getPlayerHp(index) > getPlayerMaxHp(index)) {
            players[index].characters[players[index].charNum].hp = getPlayerMaxHp(index);
        }

        if (getPlayerHp(index) < 0) {
            players[index].characters[players[index].charNum].hp = 0;
        }
    }

    public long getPlayerMp(int index) {
        return players[index].characters[players[index].charNum].mp;
    }

    public void setPlayerMp(int index, long mp) {
        players[index].characters[players[index].charNum].mp = (byte) mp;

        if (getPlayerMp(index) > getPlayerMaxMp(index)) {
            players[index].characters[players[index].charNum].mp = getPlayerMaxMp(index);
        }

        if (getPlayerMp(index) < 0) {
            players[index].characters[players[index].charNum].mp = 0;
        }
    }

    public long getPlayerSp(int index) {
        return players[index].characters[players[index].charNum].sp;
    }

    public void setPlayerSp(int index, long sp) {
        players[index].characters[players[index].charNum].sp = (byte) sp;

        if (getPlayerSp(index) > getPlayerMaxSp(index)) {
            players[index].characters[players[index].charNum].sp = getPlayerMaxSp(index);
        }

        if (getPlayerSp(index) < 0) {
            players[index].characters[players[index].charNum].sp = 0;
        }
    }

    public long getPlayerMaxHp(int index) {
        final int charNum = players[index].charNum;
        return (players[index].characters[charNum].level + getPlayerStr(index) / 2 + classes[players[index].characters[charNum].vocation].str) * 2;
    }

    // TODO: Port below functions

//    Function GetPlayerMaxMP(ByVal Index As Long) As Long
//    Dim CharNum As Long
//
//    CharNum = Player(Index).CharNum
//            GetPlayerMaxMP = (Player(Index).Char(CharNum).Level + Int(GetPlayerMAGI(Index) / 2) + Class(Player(Index).Char(CharNum).Class).MAGI) * 2
//    End Function
//
//    Function GetPlayerMaxSP(ByVal Index As Long) As Long
//    Dim CharNum As Long
//
//    CharNum = Player(Index).CharNum
//            GetPlayerMaxSP = (Player(Index).Char(CharNum).Level + Int(GetPlayerSPEED(Index) / 2) + Class(Player(Index).Char(CharNum).Class).SPEED) * 2
//    End Function
//
//    Function GetClassName(ByVal ClassNum As Long) As String
//    GetClassName = Trim(Class(ClassNum).Name)
//    End Function
//
//    Function GetClassMaxHP(ByVal ClassNum As Long) As Long
//    GetClassMaxHP = (1 + Int(Class(ClassNum).STR / 2) + Class(ClassNum).STR) * 2
//    End Function
//
//    Function GetClassMaxMP(ByVal ClassNum As Long) As Long
//    GetClassMaxMP = (1 + Int(Class(ClassNum).MAGI / 2) + Class(ClassNum).MAGI) * 2
//    End Function
//
//    Function GetClassMaxSP(ByVal ClassNum As Long) As Long
//    GetClassMaxSP = (1 + Int(Class(ClassNum).SPEED / 2) + Class(ClassNum).SPEED) * 2
//    End Function
//
//    Function GetClassSTR(ByVal ClassNum As Long) As Long
//    GetClassSTR = Class(ClassNum).STR
//    End Function
//
//    Function GetClassDEF(ByVal ClassNum As Long) As Long
//    GetClassDEF = Class(ClassNum).DEF
//    End Function
//
//    Function GetClassSPEED(ByVal ClassNum As Long) As Long
//    GetClassSPEED = Class(ClassNum).SPEED
//    End Function
//
//    Function GetClassMAGI(ByVal ClassNum As Long) As Long
//    GetClassMAGI = Class(ClassNum).MAGI
//    End Function
//
//    Function GetPlayerSTR(ByVal Index As Long) As Long
//    GetPlayerSTR = Player(Index).Char(Player(Index).CharNum).STR
//    End Function
//
//    Sub SetPlayerSTR(ByVal Index As Long, ByVal STR As Long)
//    Player(Index).Char(Player(Index).CharNum).STR = STR
//    End Sub
//
//    Function GetPlayerDEF(ByVal Index As Long) As Long
//    GetPlayerDEF = Player(Index).Char(Player(Index).CharNum).DEF
//    End Function
//
//    Sub SetPlayerDEF(ByVal Index As Long, ByVal DEF As Long)
//    Player(Index).Char(Player(Index).CharNum).DEF = DEF
//    End Sub
//
//    Function GetPlayerSPEED(ByVal Index As Long) As Long
//    GetPlayerSPEED = Player(Index).Char(Player(Index).CharNum).SPEED
//    End Function
//
//    Sub SetPlayerSPEED(ByVal Index As Long, ByVal SPEED As Long)
//    Player(Index).Char(Player(Index).CharNum).SPEED = SPEED
//    End Sub
//
//    Function GetPlayerMAGI(ByVal Index As Long) As Long
//    GetPlayerMAGI = Player(Index).Char(Player(Index).CharNum).MAGI
//    End Function
//
//    Sub SetPlayerMAGI(ByVal Index As Long, ByVal MAGI As Long)
//    Player(Index).Char(Player(Index).CharNum).MAGI = MAGI
//    End Sub
//
//    Function GetPlayerPOINTS(ByVal Index As Long) As Long
//    GetPlayerPOINTS = Player(Index).Char(Player(Index).CharNum).POINTS
//    End Function
//
//    Sub SetPlayerPOINTS(ByVal Index As Long, ByVal POINTS As Long)
//    Player(Index).Char(Player(Index).CharNum).POINTS = POINTS
//    End Sub
//
//    Function GetPlayerMap(ByVal Index As Long) As Long
//    GetPlayerMap = Player(Index).Char(Player(Index).CharNum).Map
//    End Function
//
//    Sub SetPlayerMap(ByVal Index As Long, ByVal MapNum As Long)
//    If MapNum > 0 And MapNum <= MAX_MAPS Then
//    Player(Index).Char(Player(Index).CharNum).Map = MapNum
//    End If
//    End Sub
//
//    Function GetPlayerX(ByVal Index As Long) As Long
//    GetPlayerX = Player(Index).Char(Player(Index).CharNum).x
//    End Function
//
//    Sub SetPlayerX(ByVal Index As Long, ByVal x As Long)
//    Player(Index).Char(Player(Index).CharNum).x = x
//    End Sub
//
//    Function GetPlayerY(ByVal Index As Long) As Long
//    GetPlayerY = Player(Index).Char(Player(Index).CharNum).y
//    End Function
//
//    Sub SetPlayerY(ByVal Index As Long, ByVal y As Long)
//    Player(Index).Char(Player(Index).CharNum).y = y
//    End Sub
//
//    Function GetPlayerDir(ByVal Index As Long) As Long
//    GetPlayerDir = Player(Index).Char(Player(Index).CharNum).Dir
//    End Function
//
//    Sub SetPlayerDir(ByVal Index As Long, ByVal Dir As Long)
//    Player(Index).Char(Player(Index).CharNum).Dir = Dir
//    End Sub
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
//    Function GetPlayerArmorSlot(ByVal Index As Long) As Long
//    GetPlayerArmorSlot = Player(Index).Char(Player(Index).CharNum).ArmorSlot
//    End Function
//
//    Sub SetPlayerArmorSlot(ByVal Index As Long, InvNum As Long)
//    Player(Index).Char(Player(Index).CharNum).ArmorSlot = InvNum
//    End Sub
//
//    Function GetPlayerWeaponSlot(ByVal Index As Long) As Long
//    GetPlayerWeaponSlot = Player(Index).Char(Player(Index).CharNum).WeaponSlot
//    End Function
//
//    Sub SetPlayerWeaponSlot(ByVal Index As Long, InvNum As Long)
//    Player(Index).Char(Player(Index).CharNum).WeaponSlot = InvNum
//    End Sub
//
//    Function GetPlayerHelmetSlot(ByVal Index As Long) As Long
//    GetPlayerHelmetSlot = Player(Index).Char(Player(Index).CharNum).HelmetSlot
//    End Function
//
//    Sub SetPlayerHelmetSlot(ByVal Index As Long, InvNum As Long)
//    Player(Index).Char(Player(Index).CharNum).HelmetSlot = InvNum
//    End Sub
//
//    Function GetPlayerShieldSlot(ByVal Index As Long) As Long
//    GetPlayerShieldSlot = Player(Index).Char(Player(Index).CharNum).ShieldSlot
//    End Function
//
//    Sub SetPlayerShieldSlot(ByVal Index As Long, InvNum As Long)
//    Player(Index).Char(Player(Index).CharNum).ShieldSlot = InvNum
//    End Sub

}
