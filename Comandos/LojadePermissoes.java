package Comandos;

import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Coins;
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
import org.bukkit.inventory.meta.SkullMeta;

public class LojadePermissoes
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro2;
  public static ItemMeta vidro2meta;
  public static ItemStack resetkdr;
  public static ItemMeta resetkdrmeta;
  public static ItemStack todososkits;
  public static ItemMeta todososkitsmeta;
  public static ItemStack winner;
  public static ItemMeta winnermeta;
  public static ItemStack ef;
  public static ItemMeta efmeta;
  public static ItemStack randomkit;
  public static ItemMeta randomkitmeta;
  public static ItemStack akit;
  public static ItemMeta akitmeta;
  public static ItemStack head;
  public static ItemMeta ZEmeta;
  
  public LojadePermissoes(Main main) {}
  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals(" §eLoja de Permissoes"))
      {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        e.setCancelled(true);
      }
      if (e.getCurrentItem().isSimilar(todososkits)) {
        if (Coins.getCoins(p.getName()).doubleValue() < 20000.0D)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
        }
        else
        {
          Coins.removeCoins(p.getName(), 20000.0D);
          p.sendMessage(" Voce comprou §a§lPerm para tirar cooldown das placas de sopas/recraft §c- 20.000 Coins!");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.vip");
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(winner)) {
        if (Coins.getCoins(p.getName()).doubleValue() < 10000.0D)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
        }
        else
        {
          Coins.removeCoins(p.getName(), 10000.0D);
          p.sendMessage("§aVoce comprou §c§la tag §a§lWinner! §9§l- 10.000 de XP!");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add tag.winner");
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(randomkit)) {
        if (Coins.getCoins(p.getName()).doubleValue() < 25000.0D)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
        }
        else
        {
          Coins.removeCoins(p.getName(), 25000.0D);
          p.sendMessage("Voce comprou §c§lPerm para falar colorido! §9§l- 25.000 de XP!");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.cores");
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(head)) {
          if (Coins.getCoins(p.getName()).doubleValue() < 12000.0D)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
          }
          else
          {
            Coins.removeCoins(p.getName(), 12000.0D);
            p.sendMessage("§bVoce comprou as cabeças! §9§l- 12.000 de XP!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.cabecas");
            p.closeInventory();
          }
        }
        if (e.getCurrentItem().isSimilar(akit)) {
        if (Coins.getCoins(p.getName()).doubleValue() < 90000.0D)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
        }
        else
        {
          Coins.removeCoins(p.getName(), 90000.0D);
          p.sendMessage("§aVoce comprou §c§las §a§lTodos os Kits! §9§l- 90.000 de XP!");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.*");
          p.closeInventory();
        }
        }
      }
      }
    
    
  
      
      
    
  public static ItemStack createItem(Material dc, String name)
  {
    ItemStack i = new ItemStack(dc);
    ItemMeta im = i.getItemMeta();
    im.setDisplayName(name);
    i.setItemMeta(im);
    return i;
  }
  
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("lojadeperms"))
    {
      Inventory lojadeoutros = Bukkit.createInventory(p, 27, " §eLoja de Permissoes");
      
      vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      vidrometa = vidro.getItemMeta();
      vidrometa.setDisplayName("§cLoja de Permissoes");
      vidro.setItemMeta(vidrometa);
      
      vidro2 = new ItemStack(Material.getMaterial(160), 1, (short)1);
      vidro2meta = vidro2.getItemMeta();
      vidro2meta.setDisplayName("§eLoja de Permissoes");
      vidro2.setItemMeta(vidro2meta);
      
      todososkits = new ItemStack(Material.SIGN);
      todososkitsmeta = todososkits.getItemMeta();
      todososkitsmeta.setDisplayName("§6Tirar cooldown das placas - 20.000 XP");
      todososkits.setItemMeta(todososkitsmeta);
      
      winner = new ItemStack(Material.EMERALD_BLOCK);
      winnermeta = winner.getItemMeta();
      winnermeta.setDisplayName("§aTag Winner - 10.000 XP");
      winner.setItemMeta(winnermeta);
      
      head = new ItemStack(Material.SKULL_ITEM);
      head.setDurability((short)3);
      ZEmeta = head.getItemMeta();
      ZEmeta.setDisplayName("§aUsar as cabeças - 12.000 XP");
      head.setItemMeta(ZEmeta);
      
      randomkit = new ItemStack(Material.PAPER);
      randomkitmeta = randomkit.getItemMeta();
      randomkitmeta.setDisplayName("§6Falar §aC§bO§cL§eO§1R§3I§2D§9O - 25.000 XP");
      randomkit.setItemMeta(randomkitmeta);
      
      akit = new ItemStack(Material.JUKEBOX);
      akitmeta = akit.getItemMeta();
      akitmeta.setDisplayName("§6TODOS OS KITS - 90.000 XP");
      akit.setItemMeta(akitmeta);
      for (int i = 0; i != 27; i++)
      {
        lojadeoutros.setItem(i, vidro);
        lojadeoutros.setItem(1, vidro2);
        lojadeoutros.setItem(4, akit);
        lojadeoutros.setItem(3, vidro2);
        lojadeoutros.setItem(5, vidro2);
        lojadeoutros.setItem(7, vidro2);
        lojadeoutros.setItem(9, vidro2);
        lojadeoutros.setItem(11, todososkits);
        lojadeoutros.setItem(13, randomkit);
        lojadeoutros.setItem(15, winner);
        
        lojadeoutros.setItem(17, vidro2);
        lojadeoutros.setItem(19, vidro2);
        lojadeoutros.setItem(21, vidro2);
        lojadeoutros.setItem(22, head);
        lojadeoutros.setItem(23, vidro2);
        lojadeoutros.setItem(25, vidro2);
      }
      p.openInventory(lojadeoutros);
      return true;
    }    
    return true;
  }
}
