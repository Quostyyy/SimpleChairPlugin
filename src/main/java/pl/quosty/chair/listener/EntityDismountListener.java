package pl.quosty.chair.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;
import pl.quosty.chair.service.ChairService;

public class EntityDismountListener implements Listener {

    private final ChairService chairService;

    public EntityDismountListener(ChairService chairService) {
        this.chairService = chairService;
    }

    @EventHandler
    public void onEntityDismount(EntityDismountEvent event) {
        Player player = (Player) event.getEntity();
        if (!(event.getEntity() instanceof Player) || !(event.getDismounted() instanceof ArmorStand)) {
            return;
        }

        this.chairService.removePlayerFromChair(player, (ArmorStand) event.getDismounted());
    }
}
