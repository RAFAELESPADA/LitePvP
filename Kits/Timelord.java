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
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class Timelord
  implements Listener, CommandExecutor
{
  public static ArrayList<String> playercongelados = new ArrayList();
  
  @EventHandler
  public void onTimerLord(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("TimeLord")) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getInventory().getItemInHand().getType() == Material.WATCH))
    {
      if (Cooldown.add(p))
      {
        p.sendMessage("§4Voce esta em cooldown");
        return;
      }
      Cooldown.add(p, 15);
      p.sendMessage(String.valueOf("§f§lVoc§ congelou"));
      for (final Entity pertos : p.getNearbyEntities(5.0D, 5.0D, 5.0D))
      {
        playercongelados.add(((Player)pertos).getName());
        ((Player)pertos).sendMessage(String.valueOf("§aVoc§ foi congelado por um timelord"));
        ((Player)pertos).playSound(pertos.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            Timelord.playercongelados.remove(((Player)pertos).getName());
            ((Player)pertos).sendMessage(String.valueOf("§aVoc§ n§o esta mais congelado"));
          }
        }, 160L);
      }
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§2Cooldown acabou");
        }
      }, 400L);
    }
  }
  
  @EventHandler
  public void onTimerLordado(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (playercongelados.contains(p.getName())) {
      e.setTo(p.getLocation());
    }
  }
  
  @EventHandler
  public void TirarTimelord(EntityDamageByEntityEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    if (!(e.getDamager() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    Player s = (Player)e.getDamager();
    if ((Habilidade.getAbility(s).equalsIgnoreCase("TimeLord")) && (s.getInventory().getItemInHand() != null)) {
      playercongelados.remove(p.getName());
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
    ItemStack especial = new ItemStack(Material.WATCH);
    ItemMeta especial1 = especial.getItemMeta();
    especial1.setDisplayName("§bTimelord");
    especial.setItemMeta(especial1);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("timelord"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§7§ §cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.timelord"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7§ Voce escolheu o kit §cTimeLord §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "TimeLord");
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      Habilidade.setAbility(p, "TimeLord");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Timelord");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.give(p);
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
