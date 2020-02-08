package me.rafael.litepvp.Utils;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractEvent
  implements Listener
{
  public static ArrayList<String> aocaixa;
  
  @EventHandler
  public void onBauKit(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.REDSTONE_COMPARATOR)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9» Treinos")))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
        Bukkit.dispatchCommand(p, "treinos");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
    }
  }
  
  @EventHandler
  public void onWarp(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.PAPER)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c» Warps")))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
        Bukkit.dispatchCommand(p, "warps");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
    }
  }
  
  @EventHandler
  public void onLojas(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.DAYLIGHT_DETECTOR)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e» Menu")))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
        Bukkit.dispatchCommand(p, "mostrarmenu");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
    }
  }
  
  @EventHandler
  public void onRanks(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.CHEST)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4» Kits")))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
        Bukkit.dispatchCommand(p, "kits");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
    }
  }
  
  @EventHandler
  public void onRanksat(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.CHEST)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§b» Kits")))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
        Bukkit.dispatchCommand(p, "kitsfps");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
    }
  }
  
  @EventHandler
  public void onRanksa(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType().equals(Material.ENDER_PORTAL_FRAME)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a» Loja")))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
        Bukkit.dispatchCommand(p, "abrirloja");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
    }
  }
}
