package pl.quosty.chair.service;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * @author: Patryk 'Quosty' Kowalczyk
 **/

public class ChairService {

    private final ArrayList<Player> sittingPlayers = new ArrayList<>();

    public void addPlayerToChair(Player player){
        if(isPlayerSitting(player)){
            return;
        }

        sittingPlayers.add(player);
        setChair(player.getLocation()).setPassenger(player);
    }

    public void removePlayerFromChair(Player player, ArmorStand chair){
        if(!isPlayerSitting(player)){
            return;
        }
        if(!(player.getVehicle() instanceof ArmorStand)){
            return;
        }

        sittingPlayers.remove(player);
        chair.remove();
    }

    private ArmorStand setChair(Location location){
        final World world = location.getWorld();
        final ArmorStand chair = (ArmorStand) world.spawnEntity(location.subtract(0,1.6,0), EntityType.ARMOR_STAND);
        chair.setGravity(false);
        chair.setVisible(false);
        return chair;
    }

    protected boolean isPlayerSitting(Player player){
        return sittingPlayers.contains(player);
    }

}
