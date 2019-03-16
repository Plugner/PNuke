package br;

import com.sun.media.jfxmedia.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.ArrayList;

public class TNT implements Listener {
    ArrayList<Location> tntsnuke = new ArrayList<Location>();

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {

        if(e.getBlock().getType() == Material.TNT) {
            e.getPlayer().sendMessage("§c§lVocê colocou uma TNT Nuclear! Corra!!!");

            tntsnuke.add(e.getBlock().getLocation());

        }
        return;
    }





    @EventHandler
    public void TNTExplode(EntitySpawnEvent e) {
        if(e.getEntity() instanceof TNTPrimed) {
            TNTPrimed tnt = (TNTPrimed)e.getEntity();
            boolean real = false;
            for(Location loc : tntsnuke) {
                if(loc.toString().equalsIgnoreCase(tnt.getLocation().toString())) {
                    tnt.getWorld().createExplosion(tnt.getLocation(), 15f);
                    tnt.remove();
                    real = true;
                }else{
                    real = false;
                }

            }








        }
        return;
    }

}
