package net.dragonsdoom.metro.kitpvp;

import net.dragonsdoom.metro.kitpvp.Commands.KitCommand;
import net.dragonsdoom.metro.kitpvp.GUI.PVPGUI;
import net.dragonsdoom.metro.kitpvp.Kits.Archer;
import net.dragonsdoom.metro.kitpvp.Kits.FishermanKit.Fisherman;
import net.dragonsdoom.metro.kitpvp.Kits.FishermanKit.FishermanEVENT;
import net.dragonsdoom.metro.kitpvp.Kits.Ghost.Ghost;
import net.dragonsdoom.metro.kitpvp.Kits.Ghost.GhostEVENT;
import net.dragonsdoom.metro.kitpvp.Kits.Hulk.Hulk;
import net.dragonsdoom.metro.kitpvp.Kits.Hulk.HulkEVENT;
import net.dragonsdoom.metro.kitpvp.Kits.Kangaroo.Kangaroo;
import net.dragonsdoom.metro.kitpvp.Kits.Kangaroo.KangarooEVENT;
import net.dragonsdoom.metro.kitpvp.Kits.Ninja.Ninja;
import net.dragonsdoom.metro.kitpvp.Kits.Ninja.NinjaEVENT;
import net.dragonsdoom.metro.kitpvp.Kits.PikachuKIT.Pikachu;
import net.dragonsdoom.metro.kitpvp.Kits.PikachuKIT.PikachuEVENT;
import net.dragonsdoom.metro.kitpvp.Kits.PvP;
import net.dragonsdoom.metro.kitpvp.Kits.Tamer.Tamer;
import net.dragonsdoom.metro.kitpvp.Kits.Tamer.TamerEvent;
import net.dragonsdoom.metro.kitpvp.Kits.Turtle.Turtle;
import net.dragonsdoom.metro.kitpvp.Utils.DeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPvP extends JavaPlugin {
private static KitPvP instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        PluginManager pm = Bukkit.getServer().getPluginManager();

        // LISTENERS
        pm.registerEvents(new DeathEvent(), this);
        pm.registerEvents(new PikachuEVENT(), this);
        pm.registerEvents(new FishermanEVENT(), this);
        pm.registerEvents(new KangarooEVENT(), this);
        pm.registerEvents(new GhostEVENT(), this);
        pm.registerEvents(new NinjaEVENT(), this);
        pm.registerEvents(new TamerEvent(), this);
        pm.registerEvents(new HulkEVENT(), this);

        //GUIS
        pm.registerEvents(new PVPGUI(), this);

        //KITS
        getCommand("pvp").setExecutor(new PvP());
        getCommand("archer").setExecutor(new Archer());
        getCommand("tamer").setExecutor(new Tamer());
        getCommand("lol").setExecutor(new stimpay());


        //DONOR KITS
        getCommand("pikachu").setExecutor(new Pikachu());
        getCommand("fisherman").setExecutor(new Fisherman());
        getCommand("kangaroo").setExecutor(new Kangaroo());
        getCommand("ghost").setExecutor(new Ghost());
        getCommand("ninja").setExecutor(new Ninja());
        getCommand("hulk").setExecutor(new Hulk());
        getCommand("turtle").setExecutor(new Turtle());


        //MISC
        getCommand("kit").setExecutor(new KitCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static KitPvP getInstance(){
        return instance;
    }
}
