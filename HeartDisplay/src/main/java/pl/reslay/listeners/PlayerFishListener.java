package pl.reslay.listeners;

import pl.reslay.*;
import pl.reslay.utils.*;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishListener implements Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (event.getCaught() != null && event.getCaught().getType().equals(EntityType.PLAYER)) {
            Player playerTo = (Player)event.getCaught();
            if (playerTo != null) {
                ChatUtil.sendMessage(player, Main.getInstance().getConfiguration().getMessageFishingRod().replace("{PLAYER}", playerTo.getName()).replace("{HP}", Math.floor((playerTo.getHealth() / 2)) + ""));
            }
        }
    }
}