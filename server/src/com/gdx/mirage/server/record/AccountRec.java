package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class AccountRec {

    // Account
    public String login;
    public String password;

    // Characters
    public final PlayerRec[] characters = new PlayerRec[Constants.MAX_CHARS];

    // None saved local vars
    public String buffer;
    public String incBuffer;
    public byte charNum;
    public boolean ingame;
    public long attackTimer;
    public long dataTimer;
    public long dataBytes;
    public long dataPackets;
    public long partyPlayer;
    public byte inParty;
    public byte targetType;
    public byte target;
    public byte castedSpell;
    public byte partyStarter;
    public byte gettingMap;

    public void clear() {
        login = "";
        password = "";

        for (int i = 0; i < Constants.MAX_CHARS; i++) {
            clearChar(i);
        }

        // Temporary vars
        buffer = "";
        incBuffer = "";
        charNum = 0;
        ingame = false;
        attackTimer = 0;
        dataTimer = 0;
        dataBytes = 0;
        dataPackets = 0;
        partyPlayer = 0;
        inParty = 0;
        target = 0;
        targetType = 0;
        castedSpell = Constants.NO;
        partyStarter = Constants.NO;
        gettingMap = Constants.NO;
    }

    public void clearChar(int charNum) {
        characters[charNum].clear();
    }

    public PlayerRec getChar() {
        return characters[charNum];
    }

}
