package net.loopprint;

import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;

    public void onEnable() {
        Main.plugin = this;
        long startTime = System.currentTimeMillis();

        System.out.println("HelloPlugin | Wlaczono plugin w " + (System.currentTimeMillis() - startTime) + "ms!");
        Bukkit.broadcastMessage("Hello World!");
    }

    public void onDisable() {
        long startTime = System.currentTimeMillis();
        System.out.println("HelloPlugin | Wylaczono plugin w " + (System.currentTimeMillis() - startTime) + "ms!");
    }
}
