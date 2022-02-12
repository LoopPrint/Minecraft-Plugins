package pl.reslay;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

import pl.reslay.checks.UpdateChecker;
import pl.reslay.configs.Config;
import pl.reslay.listeners.*;

public class Main extends JavaPlugin {

	@SuppressWarnings("unused")
	private static Main plugin;
	UpdateChecker updateChecker;
	
	private static Main instance;
	private Config config;
	
	public void onEnable() {
		plugin = this;
		instance = this;
		saveDefaultConfig();

		config = new Config();
        config.loadConfiguration();
		
		this.updateChecker = new UpdateChecker(this);
		registerListeners();
		
		long startTime = System.currentTimeMillis();

		System.out.println("RL-Chat | Wlaczono plugin w " + (System.currentTimeMillis() - startTime) + "ms!");
		
		Logger logger = this.getLogger();
		
		new UpdateChecker(this, 86246).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("[HeartDisplay] You have the latest version of this plugin.");
            } else {
                logger.info("[HeartDisplay] There is a new update available.");
                logger.info("[HeartDisplay] New version: " + version);
                logger.info("[HeartDisplay] Your version: "+ this.getDescription().getVersion());
                logger.info("[HeartDisplay] Download it from here:");
                logger.info("[HeartDisplay] https://www.spigotmc.org/resources/86246/");
            }
        });

    }
	
	public void registerListeners() {
        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);
    }
	
	public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }
}