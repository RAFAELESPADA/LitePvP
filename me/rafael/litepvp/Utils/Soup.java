package me.rafael.litepvp.Utils;

import me.rafael.litepvp.Main;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Soup
  implements Listener
{
  private Main main;
  public int vida = 7;
  public int fome = 7;
  
  public Soup(Main main)
  {
    this.main = main;
  }
  
  @EventHandler
  public void UsarSopa(PlayerInteractEvent e)
  {
    if (e.getItem() == null) {
      return;
    }
    Player p = e.getPlayer();
    if ((p.getHealth() < 20.0D) && (p.getItemInHand().getType() == Material.MUSHROOM_SOUP))
    {
      e.setCancelled(true);
      
      p.setHealth(p.getHealth() + this.vida >= 20.0D ? 20.0D : p.getHealth() + this.vida);
      p.setFoodLevel(20);
      p.playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
      p.getWorld().playEffect(p.getLocation().add(0.0D, 1.5D, 0.0D), Effect.HEART, 7);
      e.getItem().setType(Material.BOWL);
      if ((Habilidade.getAbility(p) == "QuickDropper") || (Habilidade.getAbility(p) == "FpsQuickDropper"))
      {
        p.setItemInHand(null);
        ItemStack Bota0 = new ItemStack(Material.BOWL);
        p.getWorld().dropItem(p.getEyeLocation(), Bota0);
      }
    }
  }
}
