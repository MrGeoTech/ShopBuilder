package me.mrgeotech.gui.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mrgeotech.processes.Triggered;
import net.md_5.bungee.api.ChatColor;

public class GUIItem {
	
	private ItemStack item;
	
	private Triggered triggered;
	
	public GUIItem(Material mat, int amount, String name, List<String> lore, Triggered triggered) {
		item = new ItemStack(mat, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		
	}
	
	public void setTriggered(Triggered triggered) {
		this.triggered = triggered;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getCurrentItem() != item) return;
		e.getWhoClicked().closeInventory();
		triggered.run();
	}
	
}
