package com.gdx.mirage.server.module;

import com.gdx.mirage.server.record.AccountRec;
import com.gdx.mirage.server.record.PlayerInvRec;
import com.gdx.mirage.server.record.PlayerRec;
import com.gdx.mirage.shared.Constants;
import lombok.extern.slf4j.Slf4j;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ModDatabase {

    private static ModDatabase instance;

    private ModDatabase() {
        log.info("Instantiating ModTypes...");
    }

    /**
     * Singleton.
     */
    public static ModDatabase getInstance() {
        if (instance == null) instance = new ModDatabase();
        return instance;
    }

    private String getAccountFileName(String login) {
        return "accounts" + File.separator + login.trim() + ".ini";
    }

    public void savePlayer(AccountRec accountRec) {
        final String fileName = getAccountFileName(accountRec.login);

        try {
            final Wini ini = new Wini(new File(fileName));
            ini.put("GENERAL", "Login", accountRec.login.trim());
            ini.put("GENERAL", "Password", accountRec.password.trim());

            for (int i = 0; i < Constants.MAX_CHARS; i++) {
                final PlayerRec playerRec = accountRec.characters[i];

                // General
                ini.put("CHAR" + i, "Name", playerRec.name);
                ini.put("CHAR" + i, "Class", playerRec.clazz);
                ini.put("CHAR" + i, "Sex", playerRec.sex);
                ini.put("CHAR" + i, "Sprite", playerRec.sprite);
                ini.put("CHAR" + i, "Level", playerRec.level);
                ini.put("CHAR" + i, "Exp", playerRec.exp);
                ini.put("CHAR" + i, "Access", playerRec.access);
                ini.put("CHAR" + i, "PK", playerRec.pk);
                ini.put("CHAR" + i, "Guild", playerRec.guild);

                // Vitals
                ini.put("CHAR" + i, "HP", playerRec.getHp());
                ini.put("CHAR" + i, "MP", playerRec.getMp());
                ini.put("CHAR" + i, "SP", playerRec.getSp());

                // Stats
                ini.put("CHAR" + i, "STR", playerRec.str);
                ini.put("CHAR" + i, "DEF", playerRec.def);
                ini.put("CHAR" + i, "SPEED", playerRec.speed);
                ini.put("CHAR" + i, "MAGI", playerRec.magi);
                ini.put("CHAR" + i, "POINTS", playerRec.points);

                // Worn equipment
                ini.put("CHAR" + i, "ArmorSlot", playerRec.armorSlot);
                ini.put("CHAR" + i, "WeaponSlot", playerRec.weaponSlot);
                ini.put("CHAR" + i, "HelmetSlot", playerRec.helmetSlot);
                ini.put("CHAR" + i, "ShieldSlot", playerRec.shieldSlot);

                // Check to make sure that they aren't on map o, if so reset'm
                if (playerRec.map <= 0) {
                    playerRec.map = Constants.START_MAP;
                    playerRec.x = Constants.START_X;
                    playerRec.y = Constants.START_Y;
                }

                // Position
                ini.put("CHAR" + i, "Map", playerRec.map);
                ini.put("CHAR" + i, "X", playerRec.x);
                ini.put("CHAR" + i, "Y", playerRec.y);
                ini.put("CHAR" + i, "Dir", playerRec.dir);

                // Inventory
                for (int n = 0; n < Constants.MAX_INV; n++) {
                    final PlayerInvRec playerInvRec = playerRec.inv[n];
                    ini.put("CHAR" + i, "InvItemNum" + n, playerInvRec.num);
                    ini.put("CHAR" + i, "InvItemVal" + n, playerInvRec.value);
                    ini.put("CHAR" + i, "InvItemDur" + n, playerInvRec.dur);
                }

                // Spells
                for (int n = 0; n < Constants.MAX_SPELLS; n++) {
                    ini.put("CHAR" + i, "Spell" + n, playerRec.spell[n]);
                }
            }

            ini.store();
        } catch (IOException e) {
            log.error("Error saving account [{}]", accountRec.login.trim(), e);
        }
    }

    public void loadPlayer(int index, String name) {
        final AccountRec accountRec = ModTypes.getInstance().clearPlayer(index);
        final String fileName = getAccountFileName(name);

        try {
            final Wini ini = new Wini(new File(fileName));
            accountRec.login = ini.get("GENERAL", "Login");
            accountRec.password = ini.get("GENERAL", "Password");

            for (int i = 0; i < Constants.MAX_CHARS; i++) {
                final PlayerRec playerRec = accountRec.characters[i];
                playerRec.name = ini.get("CHAR" + i, "Name", String.class);
                playerRec.sex = ini.get("CHAR" + i, "Sex", Short.class);
                playerRec.clazz = ini.get("CHAR" + i, "Class", Short.class);
                playerRec.sprite = ini.get("CHAR" + i, "Sprite", Short.class);
                playerRec.level = ini.get("CHAR" + i, "Level", Short.class);
                playerRec.exp = ini.get("CHAR" + i, "Exp", Long.class);
                playerRec.access = ini.get("CHAR" + i, "Access", Short.class);
                playerRec.pk = ini.get("CHAR" + i, "PK", Short.class);
                playerRec.guild = ini.get("CHAR" + i, "Guild", Short.class);

                // Vitals
                playerRec.setHp(ini.get("CHAR" + i, "HP", Long.class));
                playerRec.setMp(ini.get("CHAR" + i, "MP", Long.class));
                playerRec.setSp(ini.get("CHAR" + i, "SP", Long.class));

                // Stats
                playerRec.str = ini.get("CHAR" + i, "STR", Short.class);
                playerRec.def = ini.get("CHAR" + i, "DEF", Short.class);
                playerRec.speed = ini.get("CHAR" + i, "SPEED", Short.class);
                playerRec.magi = ini.get("CHAR" + i, "MAGI", Short.class);
                playerRec.points = ini.get("CHAR" + i, "POINTS", Short.class);

                // Worn equipment
                playerRec.armorSlot = ini.get("CHAR" + i, "ArmorSlot", Short.class);
                playerRec.weaponSlot = ini.get("CHAR" + i, "WeaponSlot", Short.class);
                playerRec.helmetSlot = ini.get("CHAR" + i, "HelmetSlot", Short.class);
                playerRec.shieldSlot = ini.get("CHAR" + i, "ShieldSlot", Short.class);

                // Position
                playerRec.map = ini.get("CHAR" + i, "Map", Integer.class);
                playerRec.x = ini.get("CHAR" + i, "X", Short.class);
                playerRec.y = ini.get("CHAR" + i, "Y", Short.class);
                playerRec.dir = ini.get("CHAR" + i, "Dir", Short.class);

                // Check to make sure that they aren't on map 0, if so reset'm
                if (playerRec.map <= 0) {
                    playerRec.map = Constants.START_MAP;
                    playerRec.x = Constants.START_X;
                    playerRec.y = Constants.START_Y;
                }

                // Inventory
                for (int n = 0; n < Constants.MAX_INV; n++) {
                    final PlayerInvRec playerInvRec = playerRec.inv[n];
                    playerInvRec.num = ini.get("CHAR" + i, "InvItemNum" + n, Short.class);
                    playerInvRec.value = ini.get("CHAR" + i, "InvItemVal" + n, Long.class);
                    playerInvRec.dur = ini.get("CHAR" + i, "InvItemDur" + n, Integer.class);
                }

                // Spells
                for (int n = 0; n < Constants.MAX_SPELLS; n++) {
                    playerRec.spell[n] = ini.get("CHAR" + i, "Spell" + n, Short.class);
                }
            }
        } catch (IOException e) {
            log.error("Error saving account [{}]", name, e);
        }
    }

    public boolean accountExist(String name) {
        final File file = new File(getAccountFileName(name));
        return file.exists();
    }

    // TODO: Implement the rest of the module

}
