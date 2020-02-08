package Comandos;

import me.rafael.litepvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;

public class ChatColor
  implements Listener
{
  @EventHandler(priority=EventPriority.NORMAL)
  public void onColorandChangeChat(PlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if (!p.hasPermission("kitpvp.cores")) {
      e.setFormat("§7 " + p.getDisplayName() + " §6»" + "§7 " + e.getMessage());
    } else {
      e.setFormat("§7 " + p.getDisplayName() + " §6»" + "§f " + e.getMessage().replaceAll("&", "§"));
    }
  }
  
  @EventHandler
  public void cor(SignChangeEvent e)
  {
    Player p = e.getPlayer();
    if (!p.hasPermission("kitpvp.admin")) {
      return;
    }
    for (int i = 0; i <= 3; i++)
    {
      String line = e.getLine(i);
      
      line = org.bukkit.ChatColor.translateAlternateColorCodes('&', line);
      e.setLine(i, line);
    }
  }
  
  @EventHandler
  public void nohunger(FoodLevelChangeEvent event)
  {
    event.setCancelled(true);
    event.setFoodLevel(20);
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onCreeperExplosion(EntityExplodeEvent event)
  {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void onItemDrop(final ItemSpawnEvent e)
  {
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
    {
      public void run()
      {
        e.getEntity().remove();
        e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
      }
    }, 60L);
  }
  
  @EventHandler
  public void Quebrar(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    ItemStack item1 = p.getItemInHand();
    Material material1 = Material.getMaterial(item1.getTypeId());
    if ((!material1.isBlock()) && (material1.getMaxDurability() >= 1) && (item1.getDurability() != 0))
    {
      p.getItemInHand().setDurability((short)0);
      p.updateInventory();
    }
    PlayerInventory item2 = p.getInventory();
    if (p.getInventory().getHelmet() != null)
    {
      Material material2 = Material.getMaterial(item2.getHelmet().getTypeId());
      if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && (item2.getHelmet().getDurability() != 0)) {
        p.getInventory().getHelmet().setDurability((short)1);
      }
    }
    if (p.getInventory().getChestplate() != null)
    {
      Material material2 = Material.getMaterial(item2.getChestplate().getTypeId());
      if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && (item2.getChestplate().getDurability() != 0)) {
        p.getInventory().getChestplate().setDurability((short)1);
      }
    }
    if (p.getInventory().getLeggings() != null)
    {
      Material material2 = Material.getMaterial(item2.getLeggings().getTypeId());
      if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && (item2.getLeggings().getDurability() != 0)) {
        p.getInventory().getLeggings().setDurability((short)1);
      }
    }
    if (p.getInventory().getBoots() != null)
    {
      Material material2 = Material.getMaterial(item2.getBoots().getTypeId());
      if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && (item2.getBoots().getDurability() != 0)) {
        p.getInventory().getBoots().setDurability((short)1);
      }
    }
  }
}
