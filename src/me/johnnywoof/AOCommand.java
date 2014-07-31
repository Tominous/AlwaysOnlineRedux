package me.johnnywoof;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class AOCommand extends Command{
	
	private AlwaysOnline ao;
	
	public AOCommand(AlwaysOnline ao) {
        super("alwaysonline", "alwaysonline.usage", "ao");
        
        this.ao = ao;
        
    }
 
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
    
		if(args.length <= 0){
			
			this.displayHelp(sender);
			
		}else{
			
			if(args[0].equalsIgnoreCase("toggle")){
				
				AlwaysOnline.mojangonline = !AlwaysOnline.mojangonline;
				
				sender.sendMessage(ChatColor.GOLD + "Mojang offline mode is now " + ((!AlwaysOnline.mojangonline ? ChatColor.GREEN + "enabled" : ChatColor.RED + "disabled")) + ChatColor.GOLD + "!");
				
			}else if(args[0].equalsIgnoreCase("reload")){
				
				ao.reload();
				
				sender.sendMessage(ChatColor.GOLD + "Configuration file has been reloaded!");
				
			}else{
				
				this.displayHelp(sender);
				
			}
			
		}
    	
    }
	
	@SuppressWarnings("deprecation")
	private void displayHelp(CommandSender sender){
		
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "----------" + ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "AlwaysOnline " + ChatColor.GRAY + ao.getDescription().getVersion() + "" + ChatColor.GOLD + "]" + ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "----------");
		
		sender.sendMessage(ChatColor.GOLD + "/alwaysonline toggle - " + ChatColor.DARK_GREEN + "Toggles between mojang online mode");
		sender.sendMessage(ChatColor.GOLD + "/alwaysonline reload - " + ChatColor.DARK_GREEN + "Reloads the configuration file");
		
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------------------");
		
	}
	
}
