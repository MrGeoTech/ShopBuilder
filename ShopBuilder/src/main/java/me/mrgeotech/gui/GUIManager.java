package me.mrgeotech.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIManager {
	
	public static Inventory createSimpleInv(int rows, String title, ArrayList<ItemStack> contents) {
		Inventory inv = Bukkit.createInventory(null, rows * 9, title);
		for (int i = 0; contents.size() > i; i++) {
			inv.setItem(i, contents.get(i));
		}
		return inv;
	}
	
}
