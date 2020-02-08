package Kits;

import Comandos.SetArena;
import java.text.DecimalFormat;
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
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class Reverse
  implements Listener, CommandExecutor
{
  public HashMap<Player, Player> ajinhash;
  public HashMap<Player, Long> ajincooldown;
  
  public Reverse()
  {
    this.ajinhash = new HashMap();
    this.ajincooldown = new HashMap();
  }
  
  @EventHandler
  public void a(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
    {
      Player p = (Player)e.getDamager();
      Player t = (Player)e.getEntity();
      if (Habilidade.getAbility(p).equalsIgnoreCase("Reverse"))
      {
        this.ajinhash.put(p, t);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run() {}
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void aPlayerToggle(PlayerToggleSneakEvent e)
  {
    final Player p = e.getPlayer();
    if (Cooldown.add(p))
    {
      p.sendMessage("§9Voce esta em cooldown");
      return;
    }
    if ((e.isSneaking()) && (Habilidade.getAbility(p).equalsIgnoreCase("Reverse")) && (this.ajinhash.containsKey(p)))
    {
      Player t = (Player)this.ajinhash.get(p);
      if ((t != null) && (!t.isDead()))
      {
        String s = null;
        if (this.ajincooldown.get(p) != null)
        {
          long l = ((Long)this.ajincooldown.get(p)).longValue() - System.currentTimeMillis();
          DecimalFormat localDecimalFormat = new DecimalFormat("##");
          int i = (int)l / 1000;
          s = localDecimalFormat.format(i);
        }
        if (p.getLocation().distance(t.getLocation()) < 200.0D)
        {
          Location loc = p.getLocation();
          Location loc2 = t.getLocation();
          
          t.teleport(loc);
          p.teleport(loc2);
          
          t.sendMessage(p.getName() + " §aTrocou De Lugar Com Voc§!");
          p.sendMessage("§aVoce trocou de lugar com " + t.getName());
          Cooldown.add(p, 3);
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
          {
            public void run()
            {
              p.sendMessage("§5Cooldown acabou");
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§cO Ultimo jogador hitado esta muito longe!");
        }
      }
    }
  }
  
  @EventHandler
  public void aomorrer(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    Player t = (Player)this.ajinhash.get(p);
    this.ajinhash.remove(t);
    this.ajinhash.remove(p);
  }
  
  @EventHandler
  public void aosair(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    Player t = (Player)this.ajinhash.get(p);
    this.ajinhash.remove(t);
    this.ajinhash.remove(p);
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
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("reverse"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.reverse"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cReverse §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Reverse");
      Habilidade.setAbility(p, "Reverse");
      p.getInventory().addItem(new ItemStack[] { dima });      
      Main.give(p);
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Reverse");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
