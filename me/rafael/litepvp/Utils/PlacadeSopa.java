package me.rafael.litepvp.Utils;

import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlacadeSopa
  implements Listener
{
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("sopa"))
    {
      e.setLine(0, "§b=-=-=-=-=");
      e.setLine(1, "§aPlaca");
      e.setLine(2, "§c(Sopas)");
      e.setLine(3, "§b=-=-=-=-=");
    }
  }
  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopasm = sopas.getItemMeta();
    sopasm.setDisplayName("§aSopinha");
    sopas.setItemMeta(sopasm);
    Inventory inve = Bukkit.getServer().createInventory(p, 36, "§aSopas");
    inve.setItem(0, sopas);
    inve.setItem(1, sopas);
    inve.setItem(2, sopas);
    inve.setItem(3, sopas);
    inve.setItem(4, sopas);
    inve.setItem(5, sopas);
    inve.setItem(6, sopas);
    inve.setItem(7, sopas);
    inve.setItem(8, sopas);
    inve.setItem(9, sopas);
    inve.setItem(10, sopas);
    inve.setItem(11, sopas);
    inve.setItem(12, sopas);
    inve.setItem(13, sopas);
    inve.setItem(14, sopas);
    inve.setItem(15, sopas);
    inve.setItem(16, sopas);
    inve.setItem(17, sopas);
    inve.setItem(18, sopas);
    inve.setItem(19, sopas);
    inve.setItem(20, sopas);
    inve.setItem(21, sopas);
    inve.setItem(22, sopas);
    inve.setItem(23, sopas);
    inve.setItem(24, sopas);
    inve.setItem(25, sopas);
    inve.setItem(26, sopas);
    inve.setItem(27, sopas);
    inve.setItem(28, sopas);
    inve.setItem(29, sopas);
    inve.setItem(30, sopas);
    inve.setItem(31, sopas);
    inve.setItem(32, sopas);
    inve.setItem(33, sopas);
    inve.setItem(34, sopas);
    inve.setItem(35, sopas);
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && ((e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      String[] lines = s.getLines();
      if ((lines.length > 0) && (lines[0].equals("§b=-=-=-=-=")) && (lines.length > 1) && (lines[1].equals("§aPlaca")) && (lines.length > 2) && (lines[2].equals("§c(Sopas)")) && (lines.length > 3) && (lines[3].equals("§b=-=-=-=-=")))
      {
        if ((!CooldownSopa.add(p)) && (!p.hasPermission("kitpvp.vip")))
        {
          CooldownSopa.add(p, 15);
          p.openInventory(inve);
        }
        if ((CooldownSopa.add(p)) && (!p.hasPermission("kitpvp.vip")))
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§bVoce tem que esperar: §5" + CooldownSopa.cooldown(p) + "§bs");
          p.sendMessage(API.Prefix + "§bPara pegar sopa de novo");
          return;
        }
        if (p.hasPermission("kitpvp.vip")) {
          p.openInventory(inve);
        }
      }
    }
  }
  
  @EventHandler
  public void onPlayerColor(SignChangeEvent e)
  {
    if (e.getLine(0).contains("&")) {
      e.setLine(0, e.getLine(0).replace("&", "§"));
    }
    if (e.getLine(1).contains("&")) {
      e.setLine(1, e.getLine(1).replace("&", "§"));
    }
    if (e.getLine(2).contains("&")) {
      e.setLine(2, e.getLine(2).replace("&", "§"));
    }
    if (e.getLine(3).contains("&")) {
      e.setLine(3, e.getLine(3).replace("&", "§"));
    }
  }
}
