package halq.antiroofnether;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author halqq
 * @apiNote lmao, this is so  easy
 * @since 28/08/2022
 */

public final class AntiRoofNether extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage("\u00A7e" + "[AntiRoofNether] enabled" +
                "\n" +
                "Author: @Halqq");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayer(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        if (p.getWorld().getEnvironment() == World.Environment.NETHER) {
            if (p.getLocation().getBlockY() > getConfig().getInt("Y")) {

                Location l = new Location(p.getLocation().getWorld(), p.getLocation().getBlockX() + 0.5, getConfig().getInt("Y"), p.getLocation().getBlockZ() + 0.5);
                l.subtract(0, 1, 0).getBlock().setType(Material.AIR);
                l.subtract(0, 1, 0).getBlock().setType(Material.AIR);
                l.subtract(0, 1, 0).getBlock().setType(Material.NETHERRACK);
                p.teleport(l.add(0, 1, 0));


                //send chat alert
                if (getConfig().getBoolean("Alert") == true) {
                    p.sendRawMessage("\u00A7e" + "[AntiRoofNether]" + "\u00A7 " + "Nether Roof Disable!!");
                } else {
                }

                //play sound
                if (getConfig().getBoolean("Sound") == true) {
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, 1);
                }

                //ban player (no ip)
                if (getConfig().getBoolean("Ban") == true) {
                    p.banPlayer("\u00A7e" + "[AntiRoofNether]" + "\u00A7c" + " you you tried to go to the nether roof");
                } else {
                }

                //kick player
                if (getConfig().getBoolean("Kick") == true) {
                    p.kickPlayer("you you tried to go to the nether roof");
                } else {
                }

                //send log in cmd
                if (getConfig().getBoolean("Log")) {
                    getServer().getConsoleSender().sendMessage("\u00A7c " + p.getName() + " tried to bug the nether roof" + " X:" + p.getLocation().getBlockX() + " Y:" + p.getLocation().getBlockY() + " Z:" + p.getLocation().getBlockZ());
                } else {
                }
            }
        }
    }
}