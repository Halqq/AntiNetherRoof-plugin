package halq.netherFix.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Halq
 * @since 30/08/2022
 */

public class ConfigUtil extends JavaPlugin {

    public static boolean b(FileConfiguration c, String path) {
        c.getBoolean(path);
        return c.getBoolean(path);
    }

    public static int i(FileConfiguration c, String path) {
        c.getInt(path);
        return c.getInt(path);
    }
}
