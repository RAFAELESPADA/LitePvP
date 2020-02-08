package me.rafael.litepvp.Utils;

import me.rafael.litepvp.Main;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;

public class Mensagens
  implements Listener
{
  public static void start()
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
    {
      String[] msg = {
      
        Main.getPlugin().getConfig().getString("Msg10").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg9").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg8").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg7").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg6").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg5").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg4").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg3").replace("&", "§"), 
        
        Main.getPlugin().getConfig().getString("Msg2").replace("&", "§"), 
        Main.getPlugin().getConfig().getString("Msg1").replace("&", "§") };
      
      public void run()
      {
        Bukkit.broadcastMessage(API.Prefix + " " + this.msg[new java.util.Random().nextInt(this.msg.length)]);
      }
    }, 800L);
  }
}
