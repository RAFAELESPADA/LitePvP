package me.rafael.litepvp.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Treinos
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("treinos"))
    {
      Inventory kits = Bukkit.createInventory(p, 27, "§6§lTreinos");
      
      ItemStack vidro = new ItemStack(Material.WOOD_SWORD);
      ItemMeta vidro2 = vidro.getItemMeta();
      vidro2.setDisplayName("§aClick-Test");
      vidro.setItemMeta(vidro2);
      
      ItemStack bd = new ItemStack(Material.BEDROCK);
      ItemMeta bd2 = bd.getItemMeta();
      bd2.setDisplayName("§aVoid-Challenge");
      bd.setItemMeta(bd2);
      kits.setItem(11, vidro);
      kits.setItem(15, bd);
      p.openInventory(kits);
    }
    return false;
  }
  
  @EventHandler
  public void kits(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§6§lTreinos"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aClick-Test"))
        {
          Bukkit.dispatchCommand(p, "clicktest");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aVoid-Challenge"))
        {
          Bukkit.dispatchCommand(p, "voidchallenge");
          p.closeInventory();
        }
      }
    }
  }
}
