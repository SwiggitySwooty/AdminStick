package com.swiggityswooty.adminstick;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
	
	AdminStick plugin;
	
	public EventListener(AdminStick plugin)
	{
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		
		Action action = event.getAction();
		
		if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			
			Player player = event.getPlayer();
			
			if (player.hasPermission("adminstick.*")) {
				
				World world = player.getWorld();
				ItemStack hand = player.getItemInHand();
				
			    if(hand.getType() == Material.STICK && hand.getItemMeta().getLore().get(0).equals(":D")){
			    	
					Location loc = player.getTargetBlock(null, 500).getLocation();
			        player.launchProjectile(Arrow.class);
			        world.createExplosion(loc.getX(), loc.getY(), loc.getZ(), 20.0F, false, false);
			        for (int i = 0; i < 20; i++) {
				        world.strikeLightning(loc);	
			        }
			    }	
			}
		}
	}
	
}
