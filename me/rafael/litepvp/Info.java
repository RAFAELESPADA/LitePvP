package me.rafael.litepvp;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Info
  implements Listener, CommandExecutor
{
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§eInformacoes"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Loja do Server"))
        {
          Bukkit.dispatchCommand(p, "site");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3Coder"))
        {
          p.sendMessage("§eEsse Plugin de KitPvP e o §6§lLite§F§lPvP §eV5");
          p.sendMessage("§eVersao: §c5.0 (BUILD-05)");
          p.sendMessage("§eAutor: §czEnderX5_ , Rafael Auler");
          p.sendMessage("§eCanal: §chttp://bit.ly/2kC345B");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bYoutuber"))
        {
          Bukkit.dispatchCommand(p, "youtuber");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Vantagens de ser vip"))
        {
          Bukkit.dispatchCommand(p, "vip");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eAplicar para a staff"))
        {
          Bukkit.dispatchCommand(p, "aplicar");
          p.sendMessage("§eNao peca staff ou perdera as chances de ser staff");
          p.sendMessage("§eCaso queira ser da staff faca o formulario");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRegras do Servidor"))
        {
          p.sendMessage("§c(1) §eNao use Programas ilegais (Hacks)");
          p.sendMessage("§c(2) §eNao Divulgue outro servidor ou seu canal");
          p.sendMessage("§c(3) §eNao Abuse de Bugs/Erros do Servidor");
          p.sendMessage("§c(4) §eNao Floode nem fa§a spam no chat");
          p.sendMessage("§c(5) §eNao pe§a tags (como staff , vip)");
          p.sendMessage("§c(6) §eNao Ofenda os outros jogadores ou o servidor");
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cTem um hack no servidor!"))
        {
          p.sendMessage("§eCaso tenha algum hack (cheater) no servidor");
          p.sendMessage("§eDenuncie-o com o /report");
          p.sendMessage("§eCaso nao haja nenhum staff online");
          p.sendMessage("§eGrave-o de hack e poste no youtube");
          p.sendMessage("§eE mande tell para um staff");
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Donos"))
        {
          p.sendMessage("§4Dono do Servidor: " + Main.getInstace().getConfig().getString("Dono").replace("&", "§"));
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
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
    if (cmd.getName().equalsIgnoreCase("information"))
    {
      Inventory warps = Bukkit.createInventory(p, 9, "§eInformacoes");
      
      ItemStack vidrol = new ItemStack(Material.ANVIL);
      ItemMeta vidrol2 = vidrol.getItemMeta();
      vidrol2.setDisplayName("§4Donos");
      vidrol.setItemMeta(vidrol2);
      
      ItemStack vidroa = new ItemStack(Material.REDSTONE);
      ItemMeta vidroa2 = vidroa.getItemMeta();
      vidroa2.setDisplayName("§cTem um hack no servidor!");
      vidroa.setItemMeta(vidroa2);
      
      ItemStack fps = new ItemStack(Material.BOOK);
      ItemMeta fps2 = fps.getItemMeta();
      fps2.setDisplayName("§cRegras do Servidor");
      List<String> lore1 = new ArrayList();
      lore1.add("§7Veja as regras do Server!");
      fps2.setLore(lore1);
      fps.setItemMeta(fps2);
      
      ItemStack LOL = new ItemStack(Material.DOUBLE_PLANT);
      ItemMeta LOL2 = LOL.getItemMeta();
      LOL2.setDisplayName("§2Loja do Server");
      List<String> loreLOL = new ArrayList();
      loreLOL.add("§7Compre vip para ajudar o servidor !");
      LOL2.setLore(loreLOL);
      LOL.setItemMeta(LOL2);
      
      ItemStack VI = new ItemStack(Material.DIAMOND_BLOCK);
      ItemMeta VI2 = VI.getItemMeta();
      VI2.setDisplayName("§bYoutuber");
      List<String> loreVI1 = new ArrayList();
      loreVI1.add("§7Veja os req de youtuber!");
      VI2.setLore(loreVI1);
      VI.setItemMeta(VI2);
      
      ItemStack CD = new ItemStack(Material.EMERALD);
      ItemMeta CD2 = CD.getItemMeta();
      CD2.setDisplayName("§3Coder");
      List<String> CDI1 = new ArrayList();
      CDI1.add("§7Veja quem fez esse plugin!");
      CD2.setLore(CDI1);
      CD.setItemMeta(CD2);
      
      
      
      ItemStack lava = new ItemStack(Material.STAINED_GLASS_PANE);
      ItemMeta lava2 = lava.getItemMeta();
      lava2.setDisplayName("§6-");
      List<String> lore2 = new ArrayList();
      lore2.add("§7!");
      lava2.setLore(lore2);
      lava.setItemMeta(lava2);
      
      ItemStack v1 = new ItemStack(Material.IRON_SWORD);
      ItemMeta v12 = v1.getItemMeta();
      v12.setDisplayName("§eAplicar para a staff");
      List<String> lore3 = new ArrayList();
      lore3.add("§7Clique para aplicar para a staff");
      v12.setLore(lore3);
      v1.setItemMeta(v12);
      
      ItemStack ev = new ItemStack(Material.DIAMOND);
      ItemMeta ev2 = ev.getItemMeta();
      ev2.setDisplayName("§5Vantagens de ser vip");
      List<String> loreev2 = new ArrayList();
      loreev2.add("§7!");
      ev2.setLore(loreev2);
      ev.setItemMeta(ev2);
      
      warps.setItem(5, lava);
      warps.setItem(0, vidroa);
      warps.setItem(1, fps);
      warps.setItem(2, LOL);
      warps.setItem(3, VI);
      warps.setItem(6, CD);
      warps.setItem(4, v1);
      warps.setItem(5, ev);
      warps.setItem(8, lava);
      
      p.openInventory(warps);
    }
    return false;
  }
}
