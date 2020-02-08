package Comandos;

import java.util.ArrayList;
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

public class KitsFPS
  implements Listener, CommandExecutor
{
  @EventHandler
  public void kits(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§cKits da FPS"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPvP"))
        {
          Bukkit.dispatchCommand(p, "fpvp");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lQuickdropper"))
        {
          Bukkit.dispatchCommand(p, "fquickdropper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lArcher"))
        {
          Bukkit.dispatchCommand(p, "farcher");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFisherman"))
        {
          Bukkit.dispatchCommand(p, "ffisherman");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lKangaroo"))
        {
          Bukkit.dispatchCommand(p, "fkangaroo");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lViper"))
        {
          Bukkit.dispatchCommand(p, "fviper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSnail"))
        {
          Bukkit.dispatchCommand(p, "fsnail");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSwitcher"))
        {
          Bukkit.dispatchCommand(p, "fswitcher");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lResouper"))
        {
          Bukkit.dispatchCommand(p, "fresouper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSonic"))
        {
          Bukkit.dispatchCommand(p, "fsonic");
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
    if (cmd.getName().equalsIgnoreCase("kitsfps"))
    {
      Inventory kits = Bukkit.createInventory(p, 27, "§cKits da FPS");
      
      ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta vidrob2 = vidrob.getItemMeta();
      vidrob2.setDisplayName(" ");
      vidrob.setItemMeta(vidrob2);
      { 
      ItemStack pyro = new ItemStack(Material.STONE_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lPvP");
      ArrayList indiob = new ArrayList();
      indiob.add("§7Ganhe espada encantada!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
    }
      {
      ItemStack pyro = new ItemStack(Material.BOW);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lArcher");
      ArrayList indiob = new ArrayList();
      indiob.add("§7Ganhe um arco!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {
      ItemStack pyro = new ItemStack(Material.FIREWORK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lKangaroo");
      ArrayList indiob = new ArrayList();
      indiob.add("§7De pulos duplos!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {
      ItemStack pyro = new ItemStack(Material.FISHING_ROD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lFisherman");
      ArrayList indiob = new ArrayList();
      indiob.add("§7Fisgue players!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {
      ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lViper");
      ArrayList indiob = new ArrayList();
      indiob.add("§7De veneno em cada hit!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {
      ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lSnail");
      ArrayList indiob = new ArrayList();
      indiob.add("§7De lentidao em cada hit!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {
      ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lSonic");
      ArrayList indiob = new ArrayList();
      indiob.add("§7De um boost e bote veneno!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {      
      ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lResouper");
      ArrayList indiob = new ArrayList();
      indiob.add("§7Mate um inimigo e");
      indiob.add("§7encha seu inv de sopa");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      {      
      ItemStack pyro = new ItemStack(Material.SNOW_BALL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §e§lSwitcher");
      ArrayList indiob = new ArrayList();
      indiob.add("§7Troque de lugar!");
      indiob.add("§7Com o inimigo!");
      metapyro.setLore(indiob);
      pyro.setItemMeta(metapyro);
      kits.addItem(new ItemStack[] { pyro });
      }
      ItemStack[] arrayOfItemStack;
      int descpyro1 = (arrayOfItemStack = kits.getContents()).length;
      for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
      {
        ItemStack item = arrayOfItemStack[metapyro1];
        if (item == null) {
          kits.setItem(kits.firstEmpty(), vidrob);
        }
        p.openInventory(kits);
      }
    }
    return false;
  }
}
