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
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class Pyro
  implements Listener, CommandExecutor
{
  @EventHandler
  public void aopyro(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("Pyro")) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getType() == Material.FIREBALL))
    {
      if (Cooldown.add(p))
      {
        p.sendMessage("§cVoce precisa esperar " + Cooldown.cooldown(p) + " segundos para usar de novo");
        return;
      }
      Cooldown.add(p, 25);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
          fire.setFireTicks(30);
        }
      }, 0L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
          fire.setFireTicks(30);
        }
      }, 15L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
          fire.setFireTicks(30);
        }
      }, 20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
          fire.setFireTicks(30);
        }
      }, 25L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
          fire.setFireTicks(30);
        }
      }, 30L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
      public void run()
      {
        Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
        fire.setFireTicks(30);
      }
    }, 35L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.sendMessage("§aCooldown acabou");
        }
      }, 420L);
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
    ItemStack monk = new ItemStack(Material.FIREBALL);
    ItemMeta ims = monk.getItemMeta();
    ims.setDisplayName("§4Poder-Pyro");
    monk.setItemMeta(ims);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("pyro"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.pyro"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7§ Voce escolheu o kit §cPyro §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Pyro");
      Habilidade.setAbility(p, "Pyro");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { monk });
      Main.stomper.remove(p.getName());
      Main.Dj.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Pyro");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
