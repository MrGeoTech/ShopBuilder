package me.mrgeotech.gui.classes;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lombok.Getter;
import lombok.Setter;
import me.mrgeotech.processes.Triggered;
import net.md_5.bungee.api.ChatColor;

public class GUIItem {
	
	@Getter
	private ItemStack item;
	
	@Setter
	private Triggered triggered;
	
	/**
	 * Make a item that is specifically for a GUI inventory. It has added features to make it more useful than just an ItemStack.
	 * 
	 * @param mat The material that you want the item to be.
	 * @param amount The amount of the material you want.
	 * @param name The displayed name of the item.
	 * @param lore The lore of the item.
	 */
	public GUIItem(Material mat, int amount, String name, List<String> lore) {
		item = new ItemStack(mat, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		
	}
	
	/**
	 * Make a item that is specifically for a GUI inventory. It has added features to make it more useful than just an ItemStack.
	 * 
	 * @param mat The material that you want the item to be.
	 * @param amount The amount of the material you want.
	 * @param name The displayed name of the item.
	 * @param lore The lore of the item.
	 * @param triggered The triggered process that you want this item to trigger when clicked.
	 */
	public GUIItem(Material mat, int amount, String name, List<String> lore, Triggered triggered) {
		item = new ItemStack(mat, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		this.triggered = triggered;
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getCurrentItem() != item) return;
		e.getWhoClicked().closeInventory();
		triggered.run();
	}
	
}
