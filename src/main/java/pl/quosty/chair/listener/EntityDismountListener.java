package pl.quosty.chair.listener;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;
import pl.quosty.chair.service.ChairService;

/**
 * @author: Patryk 'Quosty' Kowalczyk
 */
@RequiredArgsConstructor
public final class EntityDismountListener implements Listener {

    private final ChairService chairService;

    @EventHandler
    private void onEntityDismount(EntityDismountEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        if (!(event.getDismounted() instanceof ArmorStand)) return;
        chairService.removePlayerFromChair(player, (ArmorStand) event.getDismounted());
    }

}