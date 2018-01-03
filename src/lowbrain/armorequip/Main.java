package lowbrain.armorequip;

import org.bukkit.plugin.java.JavaPlugin;

public class Main
        extends JavaPlugin
{
    public void onEnable()
    {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
    }
}
