package me.mrgeotech.main;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.mrgeotech.data.ShopTemplate;

public class ShopBuilder extends JavaPlugin {
	
	private FileConfiguration config;
	private List<ShopTemplate> templates;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.config = this.getConfig();
		@SuppressWarnings("unchecked")
		List<String> shopNames = (List<String>) config.getList("shops");
		for (String name : shopNames) {
			 templates.add(new ShopTemplate(
					 this.getConfig().getString("shops." + name + ".name"),
					 this.getConfig().getInt("shops." + name + ".cost"),
					 this.getConfig().getString("shops." + name + ".scheme"),
					 this.getConfig().getString("shops." + name + ".display-material")
					 ));
		}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public FileConfiguration getThisConfig() {
		return config;
	}
	
	public List<ShopTemplate> getTemplates() {
		return templates;
	}
	
}