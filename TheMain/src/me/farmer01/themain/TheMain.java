package me.farmer01.themain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TheMain extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getServer().getLogger().info("--- TheMain started up with no errors! ---");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {
		Bukkit.getServer().getLogger().info("--- TheMain has been disabled ---");
	}
	
	
	
	@EventHandler
	
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.sendMessage(ChatColor.GOLD + "TheMain should be working, if not, I messed up!");
		p.playSound(p.getLocation(), Sound.GHAST_MOAN, 9, 1);
		
	}
	public void deathSign(Player p, Block b) {
		b.setType(Material.SIGN_POST);
		 
		Sign s = (Sign) b.getState();
		s.setLine(1, ChatColor.RED + "Rest In Peace");
		s.setLine(2, p.getName());
		s.update(true);
		}
	
	@EventHandler
	
	public void onPlayerDeath(EntityDeathEvent event) {
		
		Entity entity = event.getEntity();
		 
		if (entity instanceof Player) {
		Player p = (Player) entity;
		p.sendMessage(ChatColor.GREEN + "A sign has been placed at your death spot!");
		deathSign(p, event.getEntity().getLocation().getBlock());
		
		}
		
	}
	
}
