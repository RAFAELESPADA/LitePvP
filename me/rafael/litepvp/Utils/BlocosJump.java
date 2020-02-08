package me.rafael.litepvp.Utils;

import java.util.ArrayList;
import me.rafael.litepvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class BlocosJump
  implements Listener
{
  public static ArrayList<String> naotomardanoqueda = new ArrayList();
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void aoBlocoJump(PlayerMoveEvent e)
  {
    final Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE)
    {
      naotomardanoqueda.add(p.getName());
      Location loc = e.getTo().getBlock().getLocation();
      Vector v = p.getVelocity().setY(4).multiply(2);
      p.setVelocity(v);
      p.playSound(loc, Sound.ENDERMAN_TELEPORT, 6.0F, 1.0F);
      p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, null);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          BlocosJump.naotomardanoqueda.remove(p.getName());
        }
      }, 200L);
    }
  }
  
  @EventHandler
  public void aoCair(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && (naotomardanoqueda.contains(p.getName())))
      {
        e.setCancelled(true);
        e.setDamage(0.0D);
      }
    }
  }
  
  @EventHandler
  public void aoMorrer(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (naotomardanoqueda.contains(p.getName())) {
      naotomardanoqueda.remove(p.getName());
    }
  }
  
  @EventHandler
  public void aoSair(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (naotomardanoqueda.contains(p.getName())) {
      naotomardanoqueda.remove(p.getName());
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void aoBlocoJumpPraFrente(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL)
    {
      Location loc = e.getTo().getBlock().getLocation();
      Vector v = p.getLocation().getDirection().multiply(4).setY(1);
      p.setVelocity(v);
      p.playSound(loc, Sound.HORSE_JUMP, 6.0F, 1.0F);
      p.playEffect(loc, Effect.MAGIC_CRIT, null);
    }
  }
}
