package me.mrgeotech.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Shop {
	
	private ShopTemplate template;
	private Player owner;
	private Location location;
	
	public Shop(ShopTemplate template, Player owner, Location loc) {
		this.template = template;
		this.owner = owner;
		this.location = loc;
	}

	public ShopTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ShopTemplate template) {
		this.template = template;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
