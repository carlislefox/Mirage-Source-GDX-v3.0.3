package com.gdx.mirage.server.record;

import com.gdx.mirage.shared.Constants;

public class GuildRec {

    public String name;
    public String founder;
    public final String[] member = new String[Constants.MAX_GUILD_MEMBERS];

}
