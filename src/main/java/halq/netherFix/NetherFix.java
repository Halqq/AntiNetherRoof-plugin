package halq.netherFix;

import halq.netherFix.Utils.ConfigUtil;
import halq.netherFix.Utils.util;
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

public class NetherFix extends JavaPlugin implements Listener {

    String a = "\u00A7e" + "[NetherFix]" + "\u00A7f";

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage(a + "enabled" +
                "\n" +
                "Author: @Halqq");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayer(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        if (p.isOp()) {
        } else if (p.getWorld().getEnvironment() == World.Environment.NETHER) {
            if (p.getLocation().getBlockY() > ConfigUtil.i(getConfig(), "Y")) {
                //teleport player
                if (ConfigUtil.b(getConfig(), "Teleport")) {
                    util.tr(event, getConfig());
                }

                if (ConfigUtil.b(getConfig(), "AntiVeihicleBypass")) {
                    p.leaveVehicle();
                    util.tr(event, getConfig());
                }

                //send chat alert
                if (ConfigUtil.b(getConfig(), "Alert")) {
                    p.sendRawMessage(a + "\u00A7 " + "Nether Roof Disable!!");
                }

                //play sound
                if (ConfigUtil.b(getConfig(), "Sound")) {
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, 1);
                }

                //ban player (no ip)
                if (ConfigUtil.b(getConfig(), "Ban")) {
                    p.banPlayer(a + "\u00A7c" + " you you tried to go to the nether roof");
                }

                //kick player
                if (ConfigUtil.b(getConfig(), "Kick")) {
                    p.kickPlayer("you you tried to go to the nether roof");
                }

                //send log in cmd
                if (ConfigUtil.b(getConfig(), "Log")) {
                    getServer().getConsoleSender().sendMessage(a + "\u00A7c " + p.getName() + " tried to bug the nether roof" + " X:" + p.getLocation().getBlockX() + " Y:" + p.getLocation().getBlockY() + " Z:" + p.getLocation().getBlockZ());
                }

                //kill player
                if (ConfigUtil.b(getConfig(), "Kill")) {
                    p.setHealth(0);
                }

            }
        }
    }
}