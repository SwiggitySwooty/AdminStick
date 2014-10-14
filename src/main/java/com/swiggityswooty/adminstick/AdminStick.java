package com.swiggityswooty.adminstick;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminStick extends JavaPlugin {
	
	private final String version = "1.0";

	@Override
	public void onEnable() {
		
		this.getCommand("adminstick").setExecutor(new CommandHandler(this));
		getServer().getPluginManager().registerEvents(new EventListener(this), this);
		
	}

	@Override
	public void onDisable() {
	}

	public void giveStick(Player player) {
		
		ItemStack stick = new ItemStack(Material.STICK, 1);
		ItemMeta meta = stick.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(":D");
		
		meta.setLore(lore);
		meta.setDisplayName(ChatColor.DARK_RED + "Admin Stick");
		
		stick.setItemMeta(meta);
		
		player.getInventory().addItem(stick);
	}
	
	public void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(message);
	}
	
	public void sendMessage(CommandSender sender, String message, ChatColor color) {
		sender.sendMessage(color + message);
	}

	public void info(String info) {
		getLogger().info(info);
	}

	public String getVersion() {
		return version;
	}
	
}
