package me.rafael.litepvp.comandos;

import java.util.ArrayList;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class ClickTest
  implements CommandExecutor, Listener
{
  public static ArrayList<String> emclicktest = new ArrayList();
  public static ArrayList<String> fazendoclicktest = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    final Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
      p.sendMessage("O Console nao pode executar esse comando.");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("clicktest"))
    {
      if (fazendoclicktest.contains(p.getName()))
      {
        p.sendMessage(String.valueOf(API.Prefix) + "§cVoce ja esta em clicktest");
        return true;
      }
      fazendoclicktest.add(p.getName());
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest iniciando em §b5§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 0L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest iniciando em §b4§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest iniciando em §b3§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 40L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest iniciando em §b2§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 60L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest iniciando em §b1§7s");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
        }
      }, 80L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest iniciado");
          p.playSound(p.getLocation(), Sound.CLICK, 5.0F, 5.0F);
          ClickTest.emclicktest.add(p.getName());
        }
      }, 100L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if (p.getLevel() >= 200)
          {
            Bukkit.broadcast("§b" + p.getDisplayName() + " §7Pode estar de macro quantidade de clicks no clicktest: §b" + p.getLevel(), "flame.staff");
            ClickTest.emclicktest.remove(p.getName());
            ClickTest.fazendoclicktest.remove(p.getName());
          }
          p.sendMessage(String.valueOf(API.Prefix) + "§7ClickTest acabado quantidade de clicks §bABAIXO");
          p.sendMessage(String.valueOf(API.Prefix) + "§7Quantidade de click(s) dado: §b" + p.getLevel());
          ClickTest.emclicktest.remove(p.getName());
          ClickTest.fazendoclicktest.remove(p.getName());
          p.setLevel(0);
        }
      }, 250L);
    }
    return false;
  }
  
  @EventHandler
  public void comandos(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if ((emclicktest.contains(p.getName())) && (e.getMessage().startsWith("/")))
    {
      e.setCancelled(true);
      p.sendMessage(String.valueOf(API.Prefix) + "§7Voce nao pode digitar comandos quando estiver fazendo clicktest");
    }
  }
  
  @EventHandler
  public void click(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((emclicktest.contains(p.getName())) && (e.getAction() == Action.LEFT_CLICK_AIR)) {
      p.setLevel(p.getLevel() + 1);
    }
  }
}
