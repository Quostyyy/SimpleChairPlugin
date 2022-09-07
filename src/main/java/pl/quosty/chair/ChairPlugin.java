package pl.quosty.chair;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import pl.quosty.chair.command.ChairCommand;
import pl.quosty.chair.listener.EntityDismountListener;
import pl.quosty.chair.service.ChairService;

public class ChairPlugin extends JavaPlugin {
    private final ChairService chairService = new ChairService();

    @Override
    public void onEnable() {
        ((CraftServer) this.getServer()).getCommandMap().register("chair", new ChairCommand(chairService));
        Bukkit.getPluginManager().registerEvents(new EntityDismountListener(chairService), this);
    }


}
