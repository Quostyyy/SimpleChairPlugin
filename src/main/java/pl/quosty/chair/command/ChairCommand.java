package pl.quosty.chair.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.quosty.chair.service.ChairService;

import java.util.Arrays;

/**
 * @author: Patryk 'Quosty' Kowalczyk
 */
public final class ChairCommand extends Command {

    private final ChairService chairService;

    public ChairCommand(ChairService chairService) {
        super("chair", "Basic command to put down a chair", "Correct usage: /chair", Arrays.asList("chairs", "sit"));
        this.setPermission("chair.command");
        this.chairService = chairService;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can use this command!");
            return false;
        }

        Player player = (Player) commandSender;
        if (!player.hasPermission(this.getPermission())) {
            player.sendMessage("You are not allowed to use this command");
            return false;
        }

        chairService.addPlayerToChair(player);
        return false;
    }
}
