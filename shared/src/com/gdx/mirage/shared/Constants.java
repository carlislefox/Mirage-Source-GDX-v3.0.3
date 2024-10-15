package com.gdx.mirage.shared;

public interface Constants {

    // Socket globals
    int GAME_PORT = 4000;

    // Version Constants
    int CLIENT_MAJOR = 3;
    int CLIENT_MINOR = 0;
    int CLIENT_REVISION = 3;

    // General constants
    String GAME_NAME = "Mirage Online";
    int MAX_PLAYERS = 70;
    int MAX_ITEMS = 255;
    int MAX_NPCS = 255;
    int MAX_INV = 50;
    int MAX_MAP_ITEMS = 20;
    int MAX_MAP_NPCS = 5;
    int MAX_SHOPS = 255;
    int MAX_PLAYER_SPELLS = 255;
    int MAX_SPELLS = 255;
    int MAX_TRADES = 8;
    int MAX_GUILDS = 20;
    int MAX_GUILD_MEMBERS = 10;

    int NO = 0;
    int YES = 1;

    // Account constants
    int NAME_LENGTH = 20;
    int MAX_CHARS = 3;

    // Sex constants
    int SEX_MALE = 0;
    int SEX_FEMALE = 1;

    // Map constants
    int MAX_MAPS = 1000;
    int MAX_MAPX = 15;
    int MAX_MAPY = 11;
    int MAP_MORAL_NONE = 0;
    int MAP_MORAL_SAFE = 1;
    int START_MAP = 1;
    int START_X = MAX_MAPX / 2;
    int START_Y = MAX_MAPY / 2;

    // Image constants
    int PIC_X = 32;
    int PIC_Y = 32;

    // Tile constants
    int TILE_TYPE_WALKABLE = 0;
    int TILE_TYPE_BLOCKED = 1;
    int TILE_TYPE_WARP = 2;
    int TILE_TYPE_ITEM = 3;
    int TILE_TYPE_NPCAVOID = 4;
    int TILE_TYPE_KEY = 5;
    int TILE_TYPE_KEYOPEN = 6;

    // Item constants
    int ITEM_TYPE_NONE = 0;
    int ITEM_TYPE_WEAPON = 1;
    int ITEM_TYPE_ARMOR = 2;
    int ITEM_TYPE_HELMET = 3;
    int ITEM_TYPE_SHIELD = 4;
    int ITEM_TYPE_POTIONADDHP = 5;
    int ITEM_TYPE_POTIONADDMP = 6;
    int ITEM_TYPE_POTIONADDSP = 7;
    int ITEM_TYPE_POTIONSUBHP = 8;
    int ITEM_TYPE_POTIONSUBMP = 9;
    int ITEM_TYPE_POTIONSUBSP = 10;
    int ITEM_TYPE_KEY = 11;
    int ITEM_TYPE_CURRENCY = 12;
    int ITEM_TYPE_SPELL = 13;

    // Direction constants
    int DIR_UP = 0;
    int DIR_DOWN = 1;
    int DIR_LEFT = 2;
    int DIR_RIGHT = 3;

    // Constants for player movement
    int MOVING_WALKING = 1;
    int MOVING_RUNNING = 2;

    // Weather constants
    int WEATHER_NONE = 0;
    int WEATHER_RAINING = 1;
    int WEATHER_SNOWING = 2;

    // Time constants
    int TIME_DAY = 0;
    int TIME_NIGHT = 1;

    // Admin constants
    int ADMIN_MONITER = 1;
    int ADMIN_MAPPER = 2;
    int ADMIN_DEVELOPER = 3;
    int ADMIN_CREATOR = 4;

    // NPC constants
    int NPC_BEHAVIOR_ATTACKONSIGHT = 0;
    int NPC_BEHAVIOR_ATTACKWHENATTACKED = 1;
    int NPC_BEHAVIOR_FRIENDLY = 2;
    int NPC_BEHAVIOR_SHOPKEEPER = 3;
    int NPC_BEHAVIOR_GUARD = 4;

    // Spell constants
    int SPELL_TYPE_ADDHP = 0;
    int SPELL_TYPE_ADDMP = 1;
    int SPELL_TYPE_ADDSP = 2;
    int SPELL_TYPE_SUBHP = 3;
    int SPELL_TYPE_SUBMP = 4;
    int SPELL_TYPE_SUBSP = 5;
    int SPELL_TYPE_GIVEITEM = 6;

    // Target type constants
    int TARGET_TYPE_PLAYER = 0;
    int TARGET_TYPE_NPC = 1;

    // Used for parsing
    char SEP_CHAR = (char) 0;
    char END_CHAR = (char) 237;

}
