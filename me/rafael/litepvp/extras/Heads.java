package me.rafael.litepvp.extras;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Heads
  implements Listener
{
  public static ItemStack a;
  public static ItemStack b;
  public static ItemStack c;
  public static ItemStack d;
  public static ItemStack e;
  public static ItemStack f;
  public static ItemStack g;
  public static ItemStack h;
  public static ItemStack i;
  public static ItemStack j;
  public static ItemStack k;
  public static ItemStack l;
  public static ItemStack m;
  public static ItemStack n;
  public static ItemStack o;
  public static ItemStack asd;
  public static ItemStack q;
  public static ItemStack r;
  public static ItemStack s;
  public static ItemStack ZE;
  public static ItemStack t;
  public static ItemStack v;
  public static ItemStack z;
  public static ItemStack page2;
  public static ItemStack page1;
  public static ItemStack reddust;
  
  public static void HeadsGui(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 54, "§cCabeças");
    a = createItem(Material.TNT, ChatColor.GREEN + "Tnt");
    b = createItem(Material.getMaterial(138), ChatColor.GREEN + "Beacon");
    c = createItem(Material.CHEST, ChatColor.GREEN + "Bau");
    d = createItem(Material.FURNACE, ChatColor.GREEN + "Fornalha");
    e = createItem(Material.CACTUS, ChatColor.GREEN + "Cacto");
    f = createItem(Material.DIRT, ChatColor.GREEN + "Terra");
    g = createItem(Material.COAL_BLOCK, ChatColor.GREEN + "Bloco de Carvao");
    h = createItem(Material.DIAMOND_BLOCK, ChatColor.GREEN + "Bloco de Diamante");
    i = createItem(Material.COBBLESTONE, ChatColor.GREEN + "Pedra");
    j = createItem(Material.NOTE_BLOCK, ChatColor.GREEN + "Musica");
    k = createItem(Material.MELON_BLOCK, ChatColor.GREEN + "Bloco de Melao");
    l = createItem(Material.WORKBENCH, ChatColor.GREEN + "Mesa de Trabalho");
    m = createItem(Material.getMaterial(18), ChatColor.GREEN + "Folha");
    n = createItem(Material.getMaterial(62), ChatColor.GREEN + "BUG");
    o = createItem(Material.SNOW_BLOCK, ChatColor.GREEN + "Bloco de Neve");
    asd = createItem(Material.GOLD_BLOCK, ChatColor.GREEN + "Bloco de Ouro");
    q = createItem(Material.HAY_BLOCK, ChatColor.GREEN + "Fardo de Feno");
    r = createItem(Material.getMaterial(95), ChatColor.GREEN + "Vidro Tingido");
    s = createItem(Material.BEDROCK, ChatColor.GREEN + "Bedrock");
    t = createItem(Material.DIAMOND_HELMET, ChatColor.GREEN + "Capacete de Diamante");
    v = createItem(Material.ENDER_CHEST, ChatColor.GREEN + "Bau do fim");
    reddust = createItem(Material.getMaterial(45), ChatColor.GREEN + "RedDust");
    z = createItem(Material.EYE_OF_ENDER, ChatColor.YELLOW + "Tirar cabecas !");
    ItemStack ze = new ItemStack(Material.SKULL_ITEM);
    ze.setDurability((short)3);
    SkullMeta zeMeta = (SkullMeta)ze.getItemMeta();    
    zeMeta.setOwner("zEnderX5_");
    zeMeta.setDisplayName("§7Cabeça do zEnderX5_");
    ze.setItemMeta(zeMeta);
    inv.setItem(33, a);
    inv.setItem(11, b);
    inv.setItem(12, c);
    inv.setItem(13, d);
    inv.setItem(14, e);
    inv.setItem(15, f);
    inv.setItem(16, g);
    inv.setItem(19, h);
    inv.setItem(20, i);
    inv.setItem(21, j);
    inv.setItem(22, k);
    inv.setItem(23, l);
    inv.setItem(34, m);
    inv.setItem(24, n);
    inv.setItem(25, o);
    inv.setItem(32, asd);
    inv.setItem(28, q);
    inv.setItem(29, r);
    inv.setItem(30, s);
    inv.setItem(10, t);
    inv.setItem(31, v);
    inv.setItem(40, ze);
    inv.setItem(49, z);
    inv.setItem(50, page2);
    
    p.openInventory(inv);
  }
  
  public static ItemStack createItem(Material dc, String name)
  {
    ItemStack i = new ItemStack(dc);
    ItemMeta im = i.getItemMeta();
    im.setDisplayName(name);
    i.setItemMeta(im);
    return i;
  }
  
  @EventHandler
  public void Click(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§cCabeças")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.getMaterial(45))
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage("§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.getMaterial(45));
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage("§7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.ENDER_CHEST)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.ENDER_CHEST);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca coloca com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_HELMET)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.DIAMOND_HELMET);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca coloca com sucesso!");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.BEDROCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.BEDROCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.SKULL_ITEM)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
        skullItem.setDurability((short)3);
        SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();    
        skullMeta.setOwner("zEnderX5_");
        skullItem.setItemMeta(skullMeta);
        p.getInventory().setHelmet(skullItem);
        p.sendMessage(
          "§7Cabeca colocada com sucesso!");
        p.closeInventory();
        return;
      }
    }
      if (e.getCurrentItem().getType() == Material.getMaterial(95))
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.getMaterial(95));
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.HAY_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.HAY_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.GOLD_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.GOLD_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.SNOW_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.SNOW_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.getMaterial(62))
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.getMaterial(62));
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.getMaterial(18))
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.getMaterial(18));
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.MELON_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.MELON_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.NOTE_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.NOTE_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.COBBLESTONE)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.COBBLESTONE);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.DIAMOND_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.COAL_BLOCK)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.COAL_BLOCK);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          "§7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIRT)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.DIRT);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.TNT)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete2 = new ItemStack(Material.TNT);
        p.getInventory().setHelmet(Capacete2);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.closeInventory();
        return;
      }
      if (e.getCurrentItem().getType() == Material.BEACON)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete = new ItemStack(Material.getMaterial(138));
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
        p.getInventory().setHelmet(Capacete);
      }
      if (e.getCurrentItem().getType() == Material.CHEST)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete = new ItemStack(Material.CHEST);
        p.getInventory().setHelmet(Capacete);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
      }
      if (e.getCurrentItem().getType() == Material.FURNACE)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete = new ItemStack(Material.FURNACE);
        p.getInventory().setHelmet(Capacete);
        p.sendMessage(
          " §7Cabeca colocada com sucesso !");
      }
      if (e.getCurrentItem().getType() == Material.CACTUS)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete = new ItemStack(Material.CACTUS);
        p.getInventory().setHelmet(Capacete);
        p.sendMessage(
          " §6§ §7Cabeca coloca com sucesso !");
      }
      if (e.getCurrentItem().getType() == Material.WORKBENCH)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            " §7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        ItemStack Capacete = new ItemStack(Material.WORKBENCH);
        p.getInventory().setHelmet(Capacete);
        p.sendMessage(
          " §6§ §7Cabeca coloca com sucesso !");
      }
      if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER)
      {
        if (!p.hasPermission("kitpvp.cabecas"))
        {
          p.sendMessage(
            "§7Voce nao tem acesso as cabecas !");
          
          p.closeInventory();
          return;
        }
        p.getInventory().setHelmet(null);
        p.sendMessage(
          " §cSuas cabecas foram Removidas");
        p.closeInventory();
        return;
      }
    }
  }

