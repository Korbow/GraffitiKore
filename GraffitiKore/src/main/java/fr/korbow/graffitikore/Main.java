package fr.korbow.graffitikore;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("le plugin Koregraffiti est démarré");
        CustomBook customBook = new CustomBook();
        this.getCommand("graffiti").setExecutor(new Commande(customBook));
        this.getCommand("book").setExecutor(new Commande(customBook));
        getServer().getPluginManager().registerEvents(new CloudParticleEvent(), this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Main getInstance() {
        return instance;
    }
}