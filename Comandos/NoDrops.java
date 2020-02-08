package Comandos;

import me.rafael.litepvp.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class NoDrops
  implements Listener
{
  private Main main;
  
  public NoDrops(Main main) {}
  
  @EventHandler
  public void onPlayerDropItem(PlayerDropItemEvent paramPlayerPickupItemEvent)
  {
    if (paramPlayerPickupItemEvent.getItemDrop().getItemStack().getType() == Material.BOWL)
    {
      paramPlayerPickupItemEvent.setCancelled(false);
      paramPlayerPickupItemEvent.getPlayer().playSound(paramPlayerPickupItemEvent.getPlayer().getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
    }
    else
    {
      paramPlayerPickupItemEvent.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPlayerPickupItem(PlayerPickupItemEvent paramPlayerPickupItemEvent)
  {
    if ((paramPlayerPickupItemEvent.getItem().getItemStack().getType() == Material.BOWL) || (paramPlayerPickupItemEvent.getItem().getItemStack().getType() == Material.MUSHROOM_SOUP)) {
      paramPlayerPickupItemEvent.setCancelled(false);
    } else {
      paramPlayerPickupItemEvent.setCancelled(true);
    }
  }
}
