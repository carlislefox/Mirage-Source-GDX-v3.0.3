package com.gdx.mirage.server.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Account {

    private String username;

    private String password;

    private ArrayList<PlayerCharacter> playerCharacters;

    public Account() {
        playerCharacters = new ArrayList<>();
    }

    public Account build(String username, String password) {
        this.username = username;
        this.password = password;
        return this;
    }

}
