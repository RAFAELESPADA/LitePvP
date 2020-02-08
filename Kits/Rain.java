package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Cooldown;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Rain
  implements Listener, CommandExecutor
{
  @EventHandler
  public void onCage(PlayerInteractEntityEvent e)
  {
    if (!(e.getRightClicked() instanceof Player)) {
      return;
    }
    final Player p = e.getPlayer();
    final Player t = (Player)e.getRightClicked();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("Rain")) && (p.getItemInHand().getType() == Material.NETHER_STAR))
    {
      if (Cooldown.add(p))
      {
        p.sendMessage("§cVoce esta em cooldown");
        return;
      }
      Cooldown.add(p, 25);
      final Location loc = t.getLocation();
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 0L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 10L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 15L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 25L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 30L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.shootArrow();
          loc.setY(loc.getY() + 1.0D);
          Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
          r.setVelocity(r.getVelocity().multiply(8));
        }
      }, 35L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.sendMessage("§2Cooldown acabou");
        }
      }, 500L);
    }
  }
  
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    Player p = (Player)sender;
    ItemStack dima = new ItemStack(Material.STONE_SWORD);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§cEspada");
    dima.setItemMeta(souperaa);
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopas.setDisplayName("§6Sopa");
    sopa.setItemMeta(sopas);
    ItemStack especial = new ItemStack(Material.NETHER_STAR);
    ItemMeta especial2 = especial.getItemMeta();
    especial2.setDisplayName("§9Chuvinha <3");
    especial.setItemMeta(especial2);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("rain"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.rain"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cRain §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Rain");
      Habilidade.setAbility(p, "Rain");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.stomper.remove(p.getName());
      Main.give(p);
      Main.Dj.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Rain");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
