package net.dragonsdoom.metro.kitpvp.Kits.Ninja;

import net.dragonsdoom.metro.kitpvp.Utils.GiveKit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ninja implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("ninja")) {
            GiveKit.NinjaKIT(p);
        }
        return false;
    }
}
