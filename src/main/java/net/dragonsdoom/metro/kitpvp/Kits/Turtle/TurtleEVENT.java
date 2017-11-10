package net.dragonsdoom.metro.kitpvp.Kits.Turtle;

import net.dragonsdoom.metro.kitpvp.Utils.KitArrays;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class TurtleEVENT implements Listener {
    @EventHandler
    public void onDamageFromBehind(EntityDamageByEntityEvent e) {
        final Player damager = (Player) e.getDamager();
        final Player turtle = (Player) e.getEntity();
        double d = e.getDamage();
        double f = d / 2.0;
        Location playerLoc = damager.getLocation();
        Location targetLoc = turtle.getLocation();
        double pvecy = -Math.sin(Math.toRadians(playerLoc.getPitch()));
        double pvecx = -Math.cos(Math.toRadians(playerLoc.getPitch())) * Math.sin(Math.toRadians(playerLoc.getYaw()));
        double pvecz = Math.cos(Math.toRadians(playerLoc.getPitch())) * Math.cos(Math.toRadians(playerLoc.getYaw()));
        double tvecy = -Math.sin(Math.toRadians(targetLoc.getPitch()));
        double tvecx = -Math.cos(Math.toRadians(targetLoc.getPitch())) * Math.sin(Math.toRadians(targetLoc.getYaw()));
        double tvecz = Math.cos(Math.toRadians(targetLoc.getPitch())) * Math.cos(Math.toRadians(targetLoc.getYaw()));
        double dot = tvecx * pvecx + tvecy * pvecy + tvecz * pvecz;
        if (KitArrays.turtleUsed.contains(turtle.getName())) {
            if (dot > 0.6D) {
                e.setDamage(f);
            }
        }
    }
}
