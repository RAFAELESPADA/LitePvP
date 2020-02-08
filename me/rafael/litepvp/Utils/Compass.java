package me.rafael.litepvp.Utils;

import java.util.HashMap;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Compass
  implements Listener
{
  @EventHandler
  public void onCompass(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if ((Array.kit.get(p) != "Nenhum") && (p.getItemInHand().getType() == Material.COMPASS) && ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)))
    {
      Boolean pesquisado = Boolean.valueOf(false);
      for (int i = 0; i < 1000; i++)
      {
        List<Entity> pertos = p.getNearbyEntities(i, 128.0D, i);
        for (Object e : pertos) {
          if ((((Entity)e).getType().equals(EntityType.PLAYER)) && (p.getLocation().distance(((Entity)e).getLocation()) > 0.0D))
          {
            p.setCompassTarget(((Entity)e).getLocation());
            p.sendMessage(String.valueOf("§fBussola apontando para: §5" + ((Player)e).getName()));
            pesquisado = Boolean.valueOf(true);
            break;
          }
        }
        if (pesquisado.booleanValue()) {
          break;
        }
      }
      if (!pesquisado.booleanValue())
      {
        p.sendMessage(String.valueOf("§cNenhum jogador encontrado bussola apontando para o spawn!"));
        p.setCompassTarget(p.getWorld().getSpawnLocation());
      }
    }
  }
}
