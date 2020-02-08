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

public class Warps
  implements Listener, CommandExecutor
{
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§nWarps"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6FPS"))
        {
          Bukkit.dispatchCommand(p, "warp fps");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Lava Challenge"))
        {
          Bukkit.dispatchCommand(p, "warp challenge");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aEventos")) {
          Bukkit.dispatchCommand(p, "eventos");
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2STAFF"))
        {
          Bukkit.dispatchCommand(p, "warp staff");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6PotPvP"))
        {
          Bukkit.dispatchCommand(p, "warp potpvp");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6KNOCK"))
        {
          Bukkit.dispatchCommand(p, "warp knock");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§61v1"))
        {
          Bukkit.dispatchCommand(p, "1v1");
          p.closeInventory();
        }
      }
    }
      }
      @EventHandler
      public void warpsa(InventoryClickEvent e)
      {
        if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
        {
          Inventory inv = e.getInventory();
          Player p = (Player)e.getWhoClicked();
          if (inv.getTitle().equals("§nEventos"))
          {
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aWarps"))
              {
                Bukkit.dispatchCommand(p, "warps");
              }
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6MDR"))
              {
                Bukkit.dispatchCommand(p, "warp mdr");
              }
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6RDM"))
              {
                Bukkit.dispatchCommand(p, "warp rdm");
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
    if (cmd.getName().equalsIgnoreCase("warps"))
    {
      Inventory warps = Bukkit.createInventory(p, 9, "§nWarps");
      
      ItemStack vidrol = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
      ItemMeta vidrol2 = vidrol.getItemMeta();
      vidrol2.setDisplayName(" ");
      vidrol.setItemMeta(vidrol2);
      
      ItemStack vidroa = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta vidroa2 = vidroa.getItemMeta();
      vidroa2.setDisplayName(" ");
      vidroa.setItemMeta(vidroa2);
      
      ItemStack fps = new ItemStack(Material.GLASS);
      ItemMeta fps2 = fps.getItemMeta();
      fps2.setDisplayName("§6FPS");
      List<String> lore1 = new ArrayList();
      lore1.add("§7Warp para aumentar o FPS do seu mine !");
      fps2.setLore(lore1);
      fps.setItemMeta(fps2);
      ItemStack potion = new ItemStack(Material.POTION, 1, (short)16421);
      ItemMeta potion2 = potion.getItemMeta();
      potion2.setDisplayName("§6PotPvP");
      List<String> potionlore1 = new ArrayList();
      potionlore1.add("§7Treine pvp com po§§o !");
      potion2.setLore(potionlore1);
      potion.setItemMeta(potion2);
      
      ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
      ItemMeta lava2 = lava.getItemMeta();
      lava2.setDisplayName("§6Lava Challenge");
      List<String> lore2 = new ArrayList();
      lore2.add("§7Treine seu refil e recraft nesta warp !");
      lava2.setLore(lore2);
      lava.setItemMeta(lava2);
      
      ItemStack staff = new ItemStack(Material.GOLDEN_APPLE);
      ItemMeta staff2 = staff.getItemMeta();
      staff2.setDisplayName("§2STAFF");
      List<String> stafflore2 = new ArrayList();
      stafflore2.add("§7Veja os staffs do server !");
      staff2.setLore(stafflore2);
      staff.setItemMeta(staff2);
      
      ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
      ItemMeta v12 = v1.getItemMeta();
      v12.setDisplayName("§61v1");
      List<String> lore3 = new ArrayList();
      lore3.add("§7Tire um x1 com outros jogadores !");
      v12.setLore(lore3);
      v1.setItemMeta(v12);
      
      ItemStack k1 = new ItemStack(Material.STICK);
      ItemMeta k12 = k1.getItemMeta();
      k12.setDisplayName("§6KNOCK");
      List<String> lorek3 = new ArrayList();
      lorek3.add("§7Empurre jogadores para fora da arena !");
      k12.setLore(lorek3);
      k1.setItemMeta(k12);
      
      ItemStack ev = new ItemStack(Material.BOOK);
      ItemMeta ev2 = ev.getItemMeta();
      ev2.setDisplayName("§aEventos");
      List<String> loreev2 = new ArrayList();
      loreev2.add("§7Clique aqui para ver os eventos !");
      ev2.setLore(loreev2);
      ev.setItemMeta(ev2);
      
      warps.setItem(0, vidrol);
      warps.setItem(1, k1);
      warps.setItem(2, staff);
      warps.setItem(6, potion);
      warps.setItem(3, lava);
      warps.setItem(4, fps);
      warps.setItem(5, v1);
      warps.setItem(7, vidroa);
      warps.setItem(8, ev);
      
      p.openInventory(warps);
    }
   
    {
  if(cmd.getName().equalsIgnoreCase("eventos")){
		
		Inventory eventos = Bukkit.createInventory(p, 27, "§nEventos");
		
		ItemStack voltar = new ItemStack(Material.STONE_BUTTON);
		ItemMeta voltar2 = voltar.getItemMeta();
		voltar2.setDisplayName("§aWarps");
		voltar.setItemMeta(voltar2);
		
		ItemStack vidrol = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
		ItemMeta vidrol2 = vidrol.getItemMeta();
		vidrol2.setDisplayName(" ");
		vidrol.setItemMeta(vidrol2);
		
		ItemStack vidroa = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
		ItemMeta vidroa2 = vidroa.getItemMeta();
		vidroa2.setDisplayName(" ");
		vidroa.setItemMeta(vidroa2);
		
		ItemStack rdm = new ItemStack(Material.WORKBENCH);
		ItemMeta rdm2 = rdm.getItemMeta();
		rdm2.setDisplayName("§6RDM");
		List<String> lore1 = new ArrayList();
		lore1.add("§7Evento Rei da Mesa");
		rdm2.setLore(lore1);
		rdm.setItemMeta(rdm2);
		
		
		ItemStack mdr = new ItemStack(Material.CAKE);
		ItemMeta mdr2 = mdr.getItemMeta();
		mdr2.setDisplayName("§6MDR");
		List<String> lore3 = new ArrayList();
		lore3.add("§7Evento Mae da Rua");
		lore3.add("");
		mdr2.setLore(lore3);
		mdr.setItemMeta(mdr2);
		
		eventos.setItem(0, voltar);
		eventos.setItem(1, vidroa);
		eventos.setItem(2, vidrol);
		eventos.setItem(3, vidroa);
		eventos.setItem(4, vidrol);
		eventos.setItem(5, vidroa);
		eventos.setItem(6, vidrol);
		eventos.setItem(7, vidroa);
		eventos.setItem(8, vidrol);
		eventos.setItem(9, vidroa);
		eventos.setItem(10, vidrol);
		eventos.setItem(11, vidroa);
		eventos.setItem(12, rdm);
		eventos.setItem(13, vidrol);
		eventos.setItem(14, mdr);
		eventos.setItem(15, vidroa);
		eventos.setItem(16, vidrol);
		eventos.setItem(17, vidroa);
		eventos.setItem(18, vidrol);
		eventos.setItem(19, vidroa);
		eventos.setItem(20, vidrol);
		eventos.setItem(21, vidroa);
		eventos.setItem(22, vidrol);
		eventos.setItem(23, vidroa);
		eventos.setItem(24, vidrol);
		eventos.setItem(25, vidroa);
		eventos.setItem(26, vidrol);
		
		p.openInventory(eventos);
	}
	return true;
}
}
  }
