package com.gdx.mirage.shared.record;

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

}
