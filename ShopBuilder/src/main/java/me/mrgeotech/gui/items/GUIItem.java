package me.mrgeotech.gui.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mrgeotech.processes.Triggered;

public class GUIItem {
	
	private ItemStack item;
	
	
	
	public GUIItem(Material mat, int amount, String name, List<String> lore, Triggered triggered) {
		item = new ItemStack(mat, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
	}
	
	public void setTriggered(Triggered triggered) {
		triggered.run();
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getCurrentItem() != item) return;
		
	}
	
}
