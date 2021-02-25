package me.mrgeotech.commands;

import me.mrgeotech.main.ShopBuilder;
import net.md_5.bungee.api.ChatColor;

public class CommandHandler {
	
	/**
	 * The default message to send to any player that does not have the correct permission.
	 */
	public static final String NO_PERMISSION_MSG = ChatColor.RED + "I'm sorry but you do not have permission to use this command. If you think that this is a mistake, please contact the server adminstrator.";
	
	/**
	 * The default message to send to the console when they try to run a command that can only be executed by players. For instance, if it opens an inventory.
	 */
	public static final String MUST_BE_PLAYER_MSG = ChatColor.RED + "I'm sorry but only players can execute this command.";
	
	// This class will register all the commands to not fill up the main method
	public CommandHandler(ShopBuilder main) {
		ShopCommand sp = new ShopCommand(main);
		
		main.getCommand("shop").setExecutor(sp);
	}
	
}
