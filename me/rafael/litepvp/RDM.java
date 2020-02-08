package me.rafael.litepvp;

import java.util.ArrayList;
import java.util.List;
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

public class RDM
  implements Listener, CommandExecutor
{
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§nEventos"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6RDM"))
        {
          Bukkit.dispatchCommand(p, "warp rdm");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9MDR"))
        {
          Bukkit.dispatchCommand(p, "warp mdr");
          p.closeInventory();
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("eventos"))
    {
      Inventory warps = Bukkit.createInventory(p, 9, "§nEventos");
      
      ItemStack vidrol = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
      ItemMeta vidrol2 = vidrol.getItemMeta();
      vidrol2.setDisplayName(" ");
      vidrol.setItemMeta(vidrol2);
      
      ItemStack vidroa = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta vidroa2 = vidroa.getItemMeta();
      vidroa2.setDisplayName(" ");
      vidroa.setItemMeta(vidroa2);
      
      ItemStack fps = new ItemStack(Material.CAKE);
      ItemMeta fps2 = fps.getItemMeta();
      fps2.setDisplayName("§6RDM");
      List<String> lore1 = new ArrayList();
      lore1.add("§7Evento Rei da Mesa !");
      fps2.setLore(lore1);
      fps.setItemMeta(fps2);
      
      ItemStack mdr = new ItemStack(Material.BED);
      ItemMeta mdr2 = mdr.getItemMeta();
      mdr2.setDisplayName("§9MDR");
      List<String> lore11 = new ArrayList();
      lore11.add("§7Evento Mae da Rua !");
      mdr2.setLore(lore11);
      mdr.setItemMeta(mdr2);
      
      warps.setItem(0, vidrol);
      warps.setItem(1, vidroa);
      warps.setItem(2, vidrol);
      warps.setItem(3, mdr);
      warps.setItem(4, fps);
      warps.setItem(5, vidrol);
      warps.setItem(6, vidroa);
      warps.setItem(7, vidrol);
      warps.setItem(8, vidroa);
      
      p.openInventory(warps);
    }
    return false;
  }
}
