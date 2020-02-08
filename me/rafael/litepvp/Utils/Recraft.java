package me.rafael.litepvp.Utils;

import me.rafael.litepvp.api.API;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Recraft
  implements Listener
{
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("recraft"))
    {
      e.setLine(0, "§b=-=-=-=-=");
      e.setLine(1, "§aPlaca");
      e.setLine(2, "§c(Recraft)");
      e.setLine(3, "§b=-=-=-=-=");
    }
  }
  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    ItemStack red = new ItemStack(Material.RED_MUSHROOM, 64);
    ItemMeta redm = red.getItemMeta();
    redm.setDisplayName("§cCogumelo");
    red.setItemMeta(redm);
    ItemStack brown = new ItemStack(Material.BROWN_MUSHROOM, 64);
    ItemMeta brownm = brown.getItemMeta();
    brownm.setDisplayName("§6Cogumelo");
    brown.setItemMeta(brownm);
    ItemStack pote = new ItemStack(Material.BOWL, 64);
    ItemMeta potem = pote.getItemMeta();
    potem.setDisplayName("§7Pote");
    pote.setItemMeta(potem);
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && ((e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      String[] lines = s.getLines();
      if ((lines.length > 0) && (lines[0].equals("§b=-=-=-=-=")) && (lines.length > 1) && (lines[1].equals("§aPlaca")) && (lines.length > 2) && (lines[2].equals("§c(Recraft)")) && (lines.length > 3) && (lines[3].equals("§b=-=-=-=-=")))
      {
        if ((!CooldownSopa.add(p)) && (!p.hasPermission("kitpvp.vip")))
        {
          CooldownSopa.add(p, 15);
          p.getInventory().addItem(new ItemStack[] { red });
          p.getInventory().addItem(new ItemStack[] { brown });
          p.getInventory().addItem(new ItemStack[] { pote });
          p.sendMessage(API.Prefix + "§aVoce pegou recraft");
        }
        if ((CooldownSopa.add(p)) && (!p.hasPermission("kitpvp.vip")))
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§bVoce tem que esperar: §5" + CooldownSopa.cooldown(p) + "§bs");
          p.sendMessage(API.Prefix + "§bPara pegar recraft de novo");
          return;
        }
        if (p.hasPermission("kitpvp.vip"))
        {
          p.getInventory().addItem(new ItemStack[] { red });
          p.getInventory().addItem(new ItemStack[] { brown });
          p.getInventory().addItem(new ItemStack[] { pote });
          p.sendMessage(API.Prefix + "§aVoce pegou recraft");
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
