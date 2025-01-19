package fr.korbow.graffitikore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CloudParticleEvent implements Listener {
    //Event for spawn custom particle
    @EventHandler
    public void onItemFramePlace(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.ITEM_FRAME) {
            ItemFrame itemFrame = (ItemFrame) event.getEntity();
            Location location = itemFrame.getLocation();

            // Here you can change the type and the properties of the particles
            location.getWorld().spawnParticle(Particle.CLOUD, location.add(0.5, 0.5, 0.5), 150, 0.2, 0.2, 0.2, 0.05);
        }
    }
}