package Comandos;

import java.util.ArrayList;
import me.rafael.litepvp.Utils.Coins;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojadeKit
  implements Listener
{
  public static String semxp = String.valueOf(API.Prefix) + "§cVoce nao tem xp suficiente";
  
  public static void GuiLojaKit(Player p)
  {
    Inventory inv = Bukkit.createInventory(null, 27, "§cLoja De Kit");
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
    ItemMeta vidrom = vidro.getItemMeta();
    vidrom.setDisplayName("§7Vidro");
    vidro.setItemMeta(vidrom);
    inv.setItem(0, vidro);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, vidro);
    if (!p.hasPermission("kitpvp.kit.gaara"))
    {
      ItemStack gaara = new ItemStack(Material.SAND);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §eGaara");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l12.000XP");
      desc.add("§7§lPrenda os players no caixao de areia");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(9, gaara);
    }
    else if (p.hasPermission("kitpvp.kit.gaara"))
    {
      ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §cGaara");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(9, gaara);
    }
    if (!p.hasPermission("kitpvp.kit.gun"))
    {
      ItemStack gaara = new ItemStack(Material.IRON_HOE);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §eGun");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l7.500XP");
      desc.add("§7§lTenha uma ak47");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(4, gaara);
    }
    else if (p.hasPermission("kitpvp.kit.gun"))
    {
      ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §cGun");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(4, gaara);
    }
    if (!p.hasPermission("kitpvp.kit.goku"))
    {
      ItemStack gaara = new ItemStack(Material.GOLD_NUGGET);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §eGoku");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l12.500XP");
      desc.add("§7§lVire super sayadin");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(23, gaara);
    }
    else if (p.hasPermission("kitpvp.kit.goku"))
    {
      ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §cGoku");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(23, gaara);
    }
    if (!p.hasPermission("kitpvp.kit.jumper"))
    {
      ItemStack j = new ItemStack(Material.EYE_OF_ENDER);
      ItemMeta jm = j.getItemMeta();
      jm.setDisplayName("§7Kit §eJumper");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l8.000XP");
      desc.add("§7§lTeporte-se com seu item");
      jm.setLore(desc);
      j.setItemMeta(jm);
      inv.setItem(10, j);
    }
    else if (p.hasPermission("kitpvp.kit.jumper"))
    {
      ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §cJumper");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(10, gaara);
    }
    if (!p.hasPermission("kitpvp.kit.stomper"))
    {
      ItemStack j = new ItemStack(Material.IRON_BOOTS);
      ItemMeta jm = j.getItemMeta();
      jm.setDisplayName("§7Kit §eStomper");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l15.000XP");
      desc.add("§7§lEsmague seus inimigos");
      jm.setLore(desc);
      j.setItemMeta(jm);
      inv.setItem(12, j);
    }
    else if (p.hasPermission("kitpvp.kit.stomper"))
    {
      ItemStack j = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta jm = j.getItemMeta();
      jm.setDisplayName("§7Kit §cStomper");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      jm.setLore(desc);
      j.setItemMeta(jm);
      inv.setItem(12, j);
    }
    if (!p.hasPermission("kitpvp.kit.camel"))
    {
      ItemStack gaara = new ItemStack(Material.SANDSTONE);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §eCamel");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l5.000XP");
      desc.add("§7§lGanhe vantagens em desertos");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(5, gaara);
    }
    else if (p.hasPermission("kitpvp.kit.camel"))
    {
      ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta gaaram = gaara.getItemMeta();
      gaaram.setDisplayName("§7Kit §cCamel");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      gaaram.setLore(desc);
      gaara.setItemMeta(gaaram);
      inv.setItem(5, gaara);
    }
    if (!p.hasPermission("kitpvp.kit.magma"))
    {
      ItemStack magma = new ItemStack(Material.LAVA_BUCKET);
      ItemMeta magmam = magma.getItemMeta();
      magmam.setDisplayName("§7Kit §eMagma");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l8.000XP");
      desc.add("§7§lSeja imune a lava");
      desc.add("§7§lE Bote fogo a cada hit");
      magmam.setLore(desc);
      magma.setItemMeta(magmam);
      inv.setItem(11, magma);
    }
    else if (p.hasPermission("kitpvp.kit.magma"))
    {
      ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta magmam = magma.getItemMeta();
      magmam.setDisplayName("§7Kit §cMagma");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      magmam.setLore(desc);
      magma.setItemMeta(magmam);
      inv.setItem(11, magma);
    }
    if (!p.hasPermission("kitpvp.kit.avatar"))
    {
      ItemStack avatar = new ItemStack(Material.BEACON);
      ItemMeta avatarm = avatar.getItemMeta();
      avatarm.setDisplayName("§7Kit §eAvatar");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l15.000XP");
      desc.add("§7§lDomine os quatro elementos");
      avatarm.setLore(desc);
      avatar.setItemMeta(avatarm);
      inv.setItem(13, avatar);
    }
    else if (p.hasPermission("kitpvp.kit.avatar"))
    {
      ItemStack avatar = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta avatarm = avatar.getItemMeta();
      avatarm.setDisplayName("§7Kit §cAvatar");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      avatarm.setLore(desc);
      avatar.setItemMeta(avatarm);
      inv.setItem(13, avatar);
    }
    if (!p.hasPermission("kitpvp.kit.naruto"))
    {
      ItemStack shooter = new ItemStack(Material.NETHER_STAR);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §eNaruto");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l13.000XP");
      desc.add("§7§lEntre no modo nove caudas");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(15, shooter);
    }
    else if (p.hasPermission("kitpvp.kit.naruto"))
    {
      ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §cNaruto");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(15, shooter);
    }
    if (!p.hasPermission("kitpvp.kit.gladiator"))
    {
      ItemStack shooter = new ItemStack(Material.IRON_FENCE);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §eGladiator");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l15.000XP");
      desc.add("§7§lDesafie seus inimigos para uma arena de vidro");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(14, shooter);
    }
    else if (p.hasPermission("kitpvp.kit.gladiator"))
    {
      ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §cGladiator");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(14, shooter);
    }
    if (!p.hasPermission("kitpvp.kit.indio"))
    {
      ItemStack shooter = new ItemStack(Material.PUMPKIN_SEEDS);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §eIndio");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l9.000XP");
      desc.add("§7§lLance um dardo venenoso com seu item");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(16, shooter);
    }
    else if (p.hasPermission("kitpvp.kit.indio"))
    {
      ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §cIndio");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(16, shooter);
    }
    if (!p.hasPermission("kitpvp.kit.doublejump"))
    {
      ItemStack shooter = new ItemStack(Material.CHAINMAIL_BOOTS);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §eDoubleJump");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l10.000XP");
      desc.add("§7§lDe pulos duplos sem cooldown");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(22, shooter);
    }
    else if (p.hasPermission("kitpvp.kit.doublejump"))
    {
      ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta shooterm = shooter.getItemMeta();
      shooterm.setDisplayName("§7Kit §cDoublejump");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      shooterm.setLore(desc);
      shooter.setItemMeta(shooterm);
      inv.setItem(22, shooter);
    }
    if (!p.hasPermission("kitpvp.kit.reaper"))
    {
      ItemStack hotpotato = new ItemStack(Material.WOOD_HOE);
      ItemMeta hotpotatom = hotpotato.getItemMeta();
      hotpotatom.setDisplayName("§7Kit §eReaper");
      ArrayList<String> desc = new ArrayList();
      desc.add("§a§lCusto: §e§l8.000XP");
      desc.add("§7§lSeja o ceifador e apodre§a");
      desc.add("§7§lOs seus inimigos");
      hotpotatom.setLore(desc);
      hotpotato.setItemMeta(hotpotatom);
      inv.setItem(17, hotpotato);
    }
    else if (p.hasPermission("kitpvp.kit.reaper"))
    {
      ItemStack hotpotato = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta hotpotatom = hotpotato.getItemMeta();
      hotpotatom.setDisplayName("§7Kit §cReaper");
      ArrayList<String> desc = new ArrayList();
      desc.add("§cVoce ja tem esse kit");
      hotpotatom.setLore(desc);
      hotpotato.setItemMeta(hotpotatom);
      inv.setItem(17, hotpotato);
    }
    inv.setItem(19, vidro);
    inv.setItem(18, vidro);
    inv.setItem(21, vidro);
    inv.setItem(20, vidro);
    
    inv.setItem(24, vidro);
    inv.setItem(26, vidro);
    
    inv.setItem(25, vidro);
    
    p.openInventory(inv);
  }
  
  @EventHandler
  public void inventarioKit(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§cLoja De Kit")) && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE)
      {
        e.setCancelled(true);
        return;
      }
      venderItem(e, p, Material.SAND, 12000, "§7Voce comprou o kit: §bGaara", "kitpvp.kit.gaara");
      venderItem(e, p, Material.GOLD_NUGGET, 12500, "§7Voce comprou o kit: §bGoku", "kitpvp.kit.goku");
      venderItem(e, p, Material.PUMPKIN_SEEDS, 9000, "§7Voce comprou o kit: §bIndio", "kitpvp.kit.indio");
      
      venderItem(e, p, Material.IRON_HOE, 7500, "§7Voce comprou o kit: §bGun", "kitpvp.kit.gun");
      venderItem(e, p, Material.LAVA_BUCKET, 8000, "§7Voce comprou o kit: §bMagma", "kitpvp.kit.magma");
      venderItem(e, p, Material.BEACON, 15000, "§7Voce comprou o kit: §bAvatar", "kitpvp.kit.avatar");
      venderItem(e, p, Material.NETHER_STAR, 13000, "§7Voce comprou o kit: §bNaruto", "kitpvp.kit.naruto");
      venderItem(e, p, Material.WOOD_HOE, 8000, "§7Voce comprou o kit: §bReaper", "kitpvp.kit.reaper");
      venderItem(e, p, Material.EYE_OF_ENDER, 8000, "§7Voce comprou o kit: §bJumper", "kitpvp.kit.jumper");
      venderItem(e, p, Material.IRON_BOOTS, 15000, "§7Voce comprou o kit: §bStomper", "kitpvp.kit.stomper");
      venderItem(e, p, Material.IRON_FENCE, 15000, "§7Voce comprou o kit: §bGladiator", "kitpvp.kit.gladiator");
      venderItem(e, p, Material.SANDSTONE, 5000, "§7Voce comprou o kit: §bCamel", "kitpvp.kit.camel");
      venderItem(e, p, Material.CHAINMAIL_BOOTS, 10000, "§7Voce comprou o kit: §bDoublejump", "kitpvp.kit.doublejump");
    }
  }

  public static void venderItem(InventoryClickEvent e, Player p, Material materialdoinv, int preco, String coisacomprada, String permissao)
  {
    if (e.getCurrentItem().getType() == materialdoinv)
    {
      e.setCancelled(true);
      if (Coins.getCoins(p.getName()).doubleValue() >= preco)
      {
        Coins.removeCoins(p.getName(), preco);
        p.sendMessage(String.valueOf(API.Prefix) + coisacomprada);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set " + permissao);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission " + permissao + " local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission " + permissao + " global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add " + permissao);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + permissao + " true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + "" + permissao);
        p.closeInventory();
      }
      else
      {
        p.sendMessage(String.valueOf(API.Prefix) + "§cVoce nao possui coins o suficiente");
      }
    }
  }
}

