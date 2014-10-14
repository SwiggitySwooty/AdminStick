package com.swiggityswooty.adminstick;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
	
	AdminStick plugin;
	
	public CommandHandler(AdminStick plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!sender.hasPermission("adminstick.*"))
		{
			plugin.sendMessage(sender, "You do not have permission for this", ChatColor.DARK_RED);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("adminstick")) {

			if (args.length == 0) {
				plugin.sendMessage(sender, "===== AdminStick =====", ChatColor.DARK_RED);
				plugin.sendMessage(sender, "/adminstick get - " + ChatColor.DARK_GREEN + " get a stick", ChatColor.YELLOW);
				plugin.sendMessage(sender, "/adminstick info - " + ChatColor.DARK_GREEN + " view info", ChatColor.YELLOW);
			} 
			else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("get")) {
					
					if (!(sender instanceof Player)) {
						plugin.sendMessage(sender, "Only ingame players can get a stick.", ChatColor.RED);
						return true;
					}
					
					plugin.sendMessage(sender, "Here's your stick.", ChatColor.DARK_PURPLE);
					plugin.info(sender.getName() + " has an Admin Stick.");
					plugin.giveBow((Player) sender);
					
				}
				else if (args[0].equalsIgnoreCase("info")) {
					plugin.sendMessage(sender, ChatColor.DARK_AQUA + "AdminStick v " + plugin.getVersion() + ChatColor.DARK_PURPLE + "\nMade by Wahoozel");
				}
			}
			
			return true;
		}

		return false;
	}
	
}
