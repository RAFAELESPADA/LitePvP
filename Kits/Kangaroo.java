package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Kangaroo
  implements Listener, CommandExecutor
{
  ArrayList<String> tempo = new ArrayList();
  ArrayList<String> naofugir = new ArrayList();
  
  @EventHandler
  public void pular(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if ((p.getItemInHand().getType() == Material.FIREWORK) && 
      (Array.kit.get(p) == "Kangaroo"))
    {
      event.setCancelled(true);
      if ((GladiatorHAB.lutando.containsKey(p.getName())) || (InfernorHAB.lutando.containsKey(p.getName())))
      {
        p.sendMessage(String.valueOf("§cVoce nao poder usar seu kit no gladiator(infernor) ent§o vai §aganhar §eum efeito de §aspeed"));
        
        Main.darEfeito(p, PotionEffectType.SPEED, 10, 2);
      }
      else
      {
        event.setCancelled(true);
        Vector vector = p.getEyeLocation().getDirection();
        if (!this.naofugir.contains(p.getName()))
        {
          if (!this.tempo.contains(p.getName()))
          {
            this.tempo.add(p.getName());
            if (!p.isSneaking())
            {
              p.setFallDistance(-1.0F);
              vector.multiply(0.5F);
              vector.setY(1.0D);
              p.setVelocity(vector);
            }
            else
            {
              p.setFallDistance(-1.0F);
              vector.multiply(1.5F);
              vector.setY(0.5D);
              p.setVelocity(vector);
            }
          }
        }
        else if (!this.tempo.contains(p.getName()))
        {
          this.tempo.add(p.getName());
          p.setFallDistance(0.0F);
          vector.multiply(0.0F);
          vector.setY(0.0D);
          p.setVelocity(vector);
        }
        if (this.naofugir.contains(p.getName())) {
          p.sendMessage("§cVoce Nao Pode Usa Esse Kit No Meio Do PvP");
        }
      }
    }
  }
  
  @EventHandler
  public void onDamageds(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if (((event.getEntity() instanceof Player)) && 
        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
        (player.getInventory().contains(Material.FIREWORK)) && 
        (event.getDamage() >= 7.0D)) {
        event.setDamage(7.0D);
      }
    }
  }
  
  @EventHandler
  public void removertempo(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    if (this.tempo.contains(p.getName()))
    {
      Block b = p.getLocation().getBlock();
      if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
        this.tempo.remove(p.getName());
      }
    }
  }
  
  @EventHandler
  public void adicionartempo(EntityDamageByEntityEvent event)
  {
    if (!(event.getEntity() instanceof Player)) {
      return;
    }
    final Player kangaroo = (Player)event.getEntity();
    if ((event.getDamager() instanceof Player))
    {
      Player p = (Player)event.getDamager();
      if (((kangaroo instanceof Player)) && ((p instanceof Player)) && 
        (kangaroo.getInventory().contains(Material.FIREWORK)))
      {
        this.naofugir.add(kangaroo.getName());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            Kangaroo.this.naofugir.remove(kangaroo.getName());
          }
        }, 60L);
      }
    }
  }
  
  @EventHandler
  public void onDrop(PlayerDropItemEvent event)
  {
    if ((event.getItemDrop().getItemStack().getType() == Material.FIREWORK) && (Array.kit.get(event.getPlayer()) == "Kangaroo")) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if (((event.getEntity() instanceof Player)) && 
        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
        (player.getInventory().contains(Material.FIREWORK)) && 
        (event.getDamage() >= 12.0D)) {
        event.setDamage(12.0D);
      }
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
    ItemStack monk = new ItemStack(Material.FIREWORK);
    ItemMeta ims = monk.getItemMeta();
    ims.setDisplayName("§bKangarinho");
    monk.setItemMeta(ims);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("kangaroo"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.kangaroo"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cKangaroo §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Kangaroo");
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      
      Main.give(p);
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { monk });
      Habilidade.setAbility(p, "Kangaroo");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Kangaroo");
      for (int i = 0; i <= 34; i++)
      {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
