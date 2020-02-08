package me.rafael.litepvp.comandos;

import java.util.ArrayList;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class voidtest
  implements CommandExecutor, Listener
{
  public static ArrayList<String> emvoidtest = new ArrayList();
  public static ArrayList<String> fazendovoidtest = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    final Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
      p.sendMessage("O Console nao pode executar esse comando.");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("voidchallenge"))
    {
      if (fazendovoidtest.contains(p.getName()))
      {
        p.sendMessage(String.valueOf(API.Prefix) + "§cVoc§ j§ esta no void challenge");
        return true;
      }
      fazendovoidtest.add(p.getName());
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7VoidChallenge iniciando em §b5§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 0L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7VoidChallenge iniciando em §b4§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7VoidChallenge iniciando em §b3§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 40L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7VoidChallenge iniciando em §b2§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 60L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7VoidChallenge iniciando em §b1§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 80L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7VoidChallenge iniciado");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
          World w = p.getWorld();
          double x = 785460.0D;
          double y = -2.0D;
          double z = 9848455.0D;
          ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
          ItemMeta sopas = sopa.getItemMeta();
          sopas.setDisplayName("§6Sopa");
          sopa.setItemMeta(sopas);
          Location lobby = new Location(w, x, y, z);
          p.teleport(lobby);
          p.getInventory().clear();
          Main.give(p);
          for (int i = 0; i <= 34; i++) {
            p.getInventory().addItem(new ItemStack[] { sopa });
          }
        }
      }, 100L);
    }
    return false;
  }
}
