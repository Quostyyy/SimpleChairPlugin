package pl.quosty.chair;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import pl.quosty.chair.command.ChairCommand;
import pl.quosty.chair.listener.EntityDismountListener;
import pl.quosty.chair.service.ChairService;

/**
 * @author: Patryk 'Quosty' Kowalczyk
 **/

@Getter
public class ChairPlugin extends JavaPlugin {

    @Getter private static ChairPlugin instance;

    private final ChairService chairService = new ChairService();

    @Override
    public void onEnable() {
        instance = this;

        CraftServer craftServer = (CraftServer) getServer();
        craftServer.getCommandMap().register("chair", new ChairCommand());

        Bukkit.getPluginManager().registerEvents(new EntityDismountListener(), this);
    }

}
