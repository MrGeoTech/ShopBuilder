package me.mrgeotech.guis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mrgeotech.data.ShopTemplate;
import me.mrgeotech.main.ShopBuilder;

public class CreateGUI implements Listener {
	
	private Inventory inv;
	private List<ShopTemplate> shopTypes;
	
	private boolean big = false;
	private int offset = 0;
	
	private ItemStack first;
	private ItemStack last;
	
	/**
	 * By calling this class, you will make a ne player inventory that can be showed to a player. This inventory is used to make a new shop.
	 * 
	 * @param main The plugin's main class
	 */
	public CreateGUI(ShopBuilder main) {
		main.getServer().getPluginManager().registerEvents(this, main);
		inv = Bukkit.createInventory(null, 9, "Create Shop");
		shopTypes = main.getTemplates();
		if (shopTypes.size() > 9) {
			big = true;
			first = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
			ItemMeta meta = first.getItemMeta();
			meta.setDisplayName("<- Iterate");
			meta.setLore(new ArrayList<String>());
			first.setItemMeta(meta);
			last = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
			meta = last.getItemMeta();
			meta.setDisplayName("Iterate ->");
			meta.setLore(new ArrayList<String>());
			first.setItemMeta(meta);
			renderInventory(-1);
		} else {
			renderInventory(0);
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getClickedInventory() != inv) return;
		if (e.getCurrentItem() == first) {
			renderInventory(1);
		}
		if (e.getCurrentItem() == last) {
			renderInventory(-1);
		}
	}
	
	public Inventory getInv() {
		return inv;
	}

	private void renderInventory(int direction) {
		offset += direction;
		int offset = this.offset;
		if (big) {
			for (int i = 0; shopTypes.size() > i; i++) {
				if (i + offset > shopTypes.size()) offset -= shopTypes.size();
				if (i + offset < 0) offset += shopTypes.size();
				ItemStack item = shopTypes.get(i + offset).getDisplayItem();
				inv.setItem(i, item);
			}
			ItemStack first = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
			ItemMeta meta = first.getItemMeta();
			meta.setDisplayName("<- Iterate");
			meta.setLore(new ArrayList<String>());
			first.setItemMeta(meta);
			ItemStack last = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
			meta = last.getItemMeta();
			meta.setDisplayName("Iterate ->");
			meta.setLore(new ArrayList<String>());
			first.setItemMeta(meta);
		} else {
			for (int i = 0; shopTypes.size() > i; i++) {
				if (i + offset > shopTypes.size()) offset -= shopTypes.size();
				if (i + offset < 0) offset += shopTypes.size();
				ItemStack item = shopTypes.get(i + offset).getDisplayItem();
				inv.setItem(i, item);
			}
		}
	}
	
	public Inventory getInventory() {
		return inv;
	}
	
}
