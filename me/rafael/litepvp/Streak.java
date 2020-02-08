package me.rafael.litepvp;

import java.util.HashMap;
import java.util.Map;
import me.rafael.litepvp.api.API;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Streak
  implements Listener
{
  static Main plugin;
  public static Map<String, Integer> killstreak = new HashMap();
  
  public void onEnable() {}
  
  @EventHandler
  public void playerdeath(PlayerDeathEvent ev)
  {
    Player p = ev.getEntity();
    if ((p.getKiller() instanceof Player))
    {
      Player killer = p.getKiller();
      p.sendMessage(API.Prefix + ChatColor.RED + "Seu killstreak foi destruido por " + ChatColor.YELLOW + killer.getName());
      addtokillstreak(killer);
      killstreak.put(p.getName(), Integer.valueOf(0));
    }
  }
  
  public void addtokillstreak(Player killer)
  {
    String name = killer.getName();
    if (killstreak.containsKey(name))
    {
      int kills = ((Integer)killstreak.get(name)).intValue();
      kills++;
      killstreak.put(name, Integer.valueOf(kills));
      
      killer.sendMessage(API.rawPrefix + ChatColor.GREEN + "Voce esta com " + ChatColor.RED + Integer.toString(kills) + ChatColor.GREEN + " Killstreak.");
      if (kills == 100)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 100 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 90)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 90 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 80)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 80 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 70)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 70 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 65)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 65 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 60)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 60 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 50)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 50 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 40)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 40 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 30)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 30 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 25)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 25 kills!", killer.getWorld());
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 20)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 20 kills!", killer.getWorld());
        killer.sendMessage(ChatColor.GREEN + "Voce ganhou um capacete de ferro");
        ItemStack peitoral0 = new ItemStack(Material.IRON_HELMET);
        killer.getInventory().setHelmet(peitoral0);
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 15)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 15 kills!", killer.getWorld());
        killer.sendMessage(ChatColor.GREEN + "Voce ganhou um bota de couro");
        ItemStack peitoral0 = new ItemStack(Material.LEATHER_BOOTS);
        killer.getInventory().setBoots(peitoral0);
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 10)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 10 kills!", killer.getWorld());
        killer.sendMessage(ChatColor.GREEN + "Voce ganhou um calca de ferro");
        ItemStack peitoral0 = new ItemStack(Material.IRON_LEGGINGS);
        killer.getInventory().setLeggings(peitoral0);
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 5)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 5 kills!", killer.getWorld());
        killer.sendMessage(ChatColor.GREEN + "Voce ganhou um peitoral de ouro");
        ItemStack peitoral0 = new ItemStack(Material.GOLD_CHESTPLATE);
        killer.getInventory().setChestplate(peitoral0);
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 3)
      {
        broadcast(API.rawPrefix + ChatColor.GREEN + killer.getName() + 
          ChatColor.DARK_RED + " esta com um killstreak de 3 kills!", killer.getWorld());
        killer.sendMessage(ChatColor.GREEN + "Voce ganhou 20 niveis de xp");
        killer.setLevel(killer.getLevel() + 20);
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
      }
      if (kills == 1)
      {
        killstreak.put(name, Integer.valueOf(1));
        killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);
        killer.sendMessage(String.valueOf(API.Prefix) + " Voce esta em um killstreak de " + ChatColor.RED + "1" + ChatColor.WHITE + " Kills.");
      }
    }
  }
  
  public void broadcast(String text, World w)
  {
    for (Player p : w.getPlayers()) {
      p.sendMessage(text);
    }
  }
}
