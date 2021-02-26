package me.mrgeotech.data;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopTemplate {
	
	private String name;
	private int cost;
	private String schemeName;
	private Material material;
	
	public ShopTemplate(String name, int cost, String schemeName, String material) {
		this.name = name;
		this.cost = cost;
		this.schemeName = schemeName;
		this.setMaterial(Material.getMaterial(material));
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public ItemStack getDisplayItem() {
		ItemStack item = new ItemStack(material, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		List<String> lore = new ArrayList<String>();
		lore.add("Click on me to make a");
		lore.add(name + " shop building!");
		item.setItemMeta(meta);
		return item;
	}
	
}
