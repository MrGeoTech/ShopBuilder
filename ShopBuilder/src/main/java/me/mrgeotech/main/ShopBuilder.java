package me.mrgeotech.main;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.mrgeotech.data.ShopTemplate;

public class ShopBuilder extends JavaPlugin {
	
	private static FileConfiguration config;
	private static List<ShopTemplate> templates;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		ShopBuilder.config = this.getConfig();
		List<String> shopNames = (List<String>) ShopBuilder.getThisConfig().getList("shops");
		for (String name : shopNames) {
			 templates.add(new ShopTemplate(
					 this.getConfig().getString("shops." + name + ".name"),
					 this.getConfig().getInt("shops." + name + ".cost"),
					 this.getConfig().getString("shops." + name + ".")
					 ));
		}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static FileConfiguration getThisConfig() {
		return config;
	}
	
}