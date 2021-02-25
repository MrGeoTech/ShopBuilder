package me.mrgeotech.guis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.mrgeotech.main.ShopBuilder;

public class CreateGUI {
	
	private Inventory inv;
	private List<ItemStack> shopTypes;
	private Map<Integer, ItemStack> currentView;
	
	public CreateGUI() {
		inv = Bukkit.createInventory(null, 9, "Create Shop");
		currentView = new HashMap<Integer, ItemStack>();
		
	}
	
}
