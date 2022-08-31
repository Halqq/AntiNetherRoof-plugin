package halq.netherFix.Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Halq
 * @since 30/08/2022
 */

public class util extends JavaPlugin implements Listener {

    public static void tr(PlayerMoveEvent event, FileConfiguration config) {
        Player p = event.getPlayer();
        Location l = new Location(p.getLocation().getWorld(), p.getLocation().getBlockX() + 0.5, config.getInt("Y"), p.getLocation().getBlockZ() + 0.5);
        l.subtract(0, 1, 0).getBlock().setType(Material.AIR);
        l.subtract(0, 1, 0).getBlock().setType(Material.AIR);
        l.subtract(0, 1, 0).getBlock().setType(Material.NETHERRACK);
        p.teleport(l.add(0, 1, 0));
    }
}
