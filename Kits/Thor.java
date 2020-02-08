package Kits;

import java.util.ArrayList;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Cooldown;
import me.rafael.litepvp.Utils.Habilidade;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class Thor
  implements Listener
{
  public Main plugin;
  
  public Thor(Main main)
  {
    this.plugin = main;
  }
  
  public static ArrayList<String> cooldown = new ArrayList();
  
  @EventHandler
  public void onPlayerThor(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }
    if ((p.getItemInHand().getType() == Material.GOLD_AXE) && 
      (Habilidade.getAbility(p) == "Thor"))
    {
      if (Cooldown.add(p))
      {
        e.setCancelled(true);
        p.sendMessage("§cCooldown");
        return;
      }
      e.setCancelled(true);
      Block b = e.getClickedBlock();
      
      World w = p.getWorld();
      
      Location loc = w.getHighestBlockAt(b.getLocation()).getLocation();
      p.getWorld().strikeLightning(loc);
      
      Cooldown.add(p, 5);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          Cooldown.remove(p);
          p.sendMessage("§aVoce pode usar o thor de novo");
        }
      }, 100L);
    }
  }
  
  @EventHandler
  public void OnBlock(BlockIgniteEvent e)
  {
    if (e.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING) {
      e.setCancelled(true);
    } else {
      e.setCancelled(false);
    }
  }
  
  @EventHandler
  public void OnBlockBB(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    if ((Habilidade.getAbility(p) == "Thor") && (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING)) {
      e.setCancelled(true);
    }
  }
}
