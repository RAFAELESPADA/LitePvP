package me.rafael.litepvp.Utils;

import java.util.HashMap;
import me.rafael.litepvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class CooldownSopa
{
  public static HashMap<Player, Long> run;
  
  static
  {
    CooldownSopa.run = new HashMap();
  }
  
  public static void add(Player p, int seconds)
  {
    long cooldownLength = System.currentTimeMillis() + seconds * 1000;
    Cooldown.run.remove(p);
    Cooldown.run.put(p, Long.valueOf(cooldownLength));
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
    {
      public void run()
      {
    	  CooldownSopa.run.remove(p);
      }
    }, seconds * 20);
  }
  
  public static long cooldown(Player p)
  {
    long cooldownLength = ((Long)Cooldown.run.get(p)).longValue();
    long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
    return left;
  }
  
  public static boolean add(Player p)
  {
    return CooldownSopa.run.containsKey(p);
  }
  
  public static void remove(Player p)
  {
    CooldownSopa.run.remove(p);
  }
}
