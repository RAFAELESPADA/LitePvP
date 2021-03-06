package Comandos;

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

public class Loja
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("abrirloja"))
    {
      Inventory kits = Bukkit.createInventory(p, 27, "§c§lLoja");
      
      ItemStack vidro = new ItemStack(Material.IRON_SWORD);
      ItemMeta vidro2 = vidro.getItemMeta();
      vidro2.setDisplayName("§aLoja de Kits");
      vidro.setItemMeta(vidro2);
      
      ItemStack bd = new ItemStack(Material.PAPER);
      ItemMeta bd2 = bd.getItemMeta();
      bd2.setDisplayName("§aLoja de Permissoes");
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
      if (inv.getTitle().equals("§c§lLoja"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLoja de Kits")) {
          LojadeKit.GuiLojaKit(p);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLoja de Permissoes")) {
          Bukkit.dispatchCommand(p, "lojadeperms");
        }
      }
    }
  }
}
