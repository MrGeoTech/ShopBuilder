package me.mrgeotech.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeotech.main.ShopBuilder;

public class ShopCommand implements CommandExecutor {
	
	private ShopBuilder main;
	
	public ShopCommand(ShopBuilder main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (check(sender)) return true;
		
		return true;
	}
	
	private boolean check(CommandSender sender) {
		if (!sender.hasPermission("player.shop.create")) {
			sender.sendMessage(CommandHandler.NO_PERMISSION_MSG);
			return true;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage(CommandHandler.MUST_BE_PLAYER_MSG);
			return true;
		}
		return false;
	}
	
}
