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

public class Kits
  implements Listener, CommandExecutor
{
  @EventHandler
  public void kits(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§cKits"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aProxima pagina")) {
          p.sendMessage("§cSem proxima pagina");
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLoja")) {
          Bukkit.dispatchCommand(p, "abrirloja");
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPvP"))
        {
          Bukkit.dispatchCommand(p, "pvp");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lQuickdropper"))
        {
          Bukkit.dispatchCommand(p, "quickdropper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAnchor"))
        {
          Bukkit.dispatchCommand(p, "anchor");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDoublejump"))
        {
          Bukkit.dispatchCommand(p, "doublejump");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lArcher"))
        {
          Bukkit.dispatchCommand(p, "archer");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lChestplate"))
        {
          Bukkit.dispatchCommand(p, "chestplate");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBarbarian"))
        {
          Bukkit.dispatchCommand(p, "barbarian");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBoxer"))
        {
          Bukkit.dispatchCommand(p, "boxer");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCamel"))
        {
          Bukkit.dispatchCommand(p, "camel");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCicle-Fire"))
        {
          Bukkit.dispatchCommand(p, "ciclefire");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lConfuser"))
        {
          Bukkit.dispatchCommand(p, "confuser");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCritical"))
        {
          Bukkit.dispatchCommand(p, "critical");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCyclope"))
        {
          Bukkit.dispatchCommand(p, "cyclope");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDarkGod"))
        {
          Bukkit.dispatchCommand(p, "darkgod");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDrain"))
        {
          Bukkit.dispatchCommand(p, "drain");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lEbola"))
        {
          Bukkit.dispatchCommand(p, "ebola");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFireMan"))
        {
          Bukkit.dispatchCommand(p, "fireman");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFisherMan"))
        {
          Bukkit.dispatchCommand(p, "fisherman");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lForcefield"))
        {
          Bukkit.dispatchCommand(p, "forcefield");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFujao"))
        {
          Bukkit.dispatchCommand(p, "fujao");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGladiator"))
        {
          Bukkit.dispatchCommand(p, "gladiator");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGolen"))
        {
          Bukkit.dispatchCommand(p, "golen");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGun"))
        {
          Bukkit.dispatchCommand(p, "gun");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lHulk"))
        {
          Bukkit.dispatchCommand(p, "hulk");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lIndio"))
        {
          Bukkit.dispatchCommand(p, "indio");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lInfernor"))
        {
          Bukkit.dispatchCommand(p, "infernor");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lKangaroo"))
        {
          Bukkit.dispatchCommand(p, "kangaroo");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lLauncher"))
        {
          Bukkit.dispatchCommand(p, "launcher");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSonic"))
        {
          Bukkit.dispatchCommand(p, "sonic");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDeshfire"))
        {
          Bukkit.dispatchCommand(p, "deshfire");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lStomper"))
        {
          Bukkit.dispatchCommand(p, "stomper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGaara"))
        {
          Bukkit.dispatchCommand(p, "gaara");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSwitcher"))
        {
          Bukkit.dispatchCommand(p, "switcher");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lQuickdropper"))
        {
          Bukkit.dispatchCommand(p, "quickdropper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNinja"))
        {
          Bukkit.dispatchCommand(p, "ninja");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFisherman"))
        {
          Bukkit.dispatchCommand(p, "fisherman");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTimelord"))
        {
          Bukkit.dispatchCommand(p, "timelord");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAvatar"))
        {
          Bukkit.dispatchCommand(p, "avatar");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lViper"))
        {
          Bukkit.dispatchCommand(p, "viper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSnail"))
        {
          Bukkit.dispatchCommand(p, "snail");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lViking"))
        {
          Bukkit.dispatchCommand(p, "viking");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNaruto"))
        {
          Bukkit.dispatchCommand(p, "naruto");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lReverse"))
        {
          Bukkit.dispatchCommand(p, "reverse");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lReaper"))
        {
          Bukkit.dispatchCommand(p, "reaper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lMagma"))
        {
          Bukkit.dispatchCommand(p, "magma");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCamel"))
        {
          Bukkit.dispatchCommand(p, "camel");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPyro"))
        {
          Bukkit.dispatchCommand(p, "pyro");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lResouper"))
        {
          Bukkit.dispatchCommand(p, "resouper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lMagma"))
        {
          Bukkit.dispatchCommand(p, "magma");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPoseidon"))
        {
          Bukkit.dispatchCommand(p, "poseidon");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGoku"))
        {
          Bukkit.dispatchCommand(p, "goku");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lJumper"))
        {
          Bukkit.dispatchCommand(p, "jumper");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lThor"))
        {
          Bukkit.dispatchCommand(p, "kthor");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lRain"))
        {
          Bukkit.dispatchCommand(p, "rain");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §4§lUltimate"))
        {
          Bukkit.dispatchCommand(p, "ultimate");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cVeja todos os kits"))
        {
          Bukkit.dispatchCommand(p, "allkits");
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lMonk"))
        {
          Bukkit.dispatchCommand(p, "monk");
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
    if (cmd.getName().equalsIgnoreCase("kits"))
    {
      Inventory kits = Bukkit.createInventory(p, 54, "§cKits");
      
      ItemStack vidro = new ItemStack(Material.THIN_GLASS);
      ItemMeta vidro2 = vidro.getItemMeta();
      vidro2.setDisplayName("§cCompre kits no shop para desbloquear");
      vidro.setItemMeta(vidro2);
      
      ItemStack vidroc = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
      ItemMeta vidroc2 = vidroc.getItemMeta();
      vidroc2.setDisplayName(" ");
      vidroc.setItemMeta(vidroc2);
      
      ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta vidrob2 = vidrob.getItemMeta();
      vidrob2.setDisplayName(" ");
      vidrob.setItemMeta(vidrob2);
      
      ItemStack loja = new ItemStack(Material.EMERALD);
      ItemMeta loja2 = loja.getItemMeta();
      loja2.setDisplayName("§aLoja");
      loja.setItemMeta(loja2);
      {
      ItemStack status = new ItemStack(Material.SKULL_ITEM);
      ItemMeta status2 = status.getItemMeta();
      status2.setDisplayName("§cVeja todos os kits");
      ArrayList indiob = new ArrayList();
      indiob.add("§7Veja todos os kits");
      indiob.add("§7Que temos no servidor!");
      status2.setLore(indiob);
      status.setItemMeta(status2);
      kits.setItem(4, status);
      }
      ItemStack passar = new ItemStack(Material.INK_SACK, 1, (short)10);
      ItemMeta passar2 = passar.getItemMeta();
      passar2.setDisplayName("§aProxima pagina");
      passar.setItemMeta(passar2);
      
      ItemStack voltar = new ItemStack(Material.INK_SACK, 1, (short)8);
      ItemMeta voltar2 = voltar.getItemMeta();
      voltar2.setDisplayName("§7Pagina anterior");
      voltar.setItemMeta(voltar2);
      
      kits.setItem(0, voltar);
      kits.setItem(1, vidrob);
      kits.setItem(2, loja);
      kits.setItem(3, vidroc);
      
      kits.setItem(5, vidrob);
      kits.setItem(6, loja);
      kits.setItem(7, vidroc);
      kits.setItem(8, passar);
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
      if (p.hasPermission("kitpvp.kit.archer"))
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
      if (p.hasPermission("kitpvp.kit.kangaroo"))
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
      if (p.hasPermission("kitpvp.kit.avatar"))
      {
        ItemStack pyro = new ItemStack(Material.BEACON);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lAvatar");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Controle os 4 elementos!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.gladiator"))
      {
        ItemStack pyro = new ItemStack(Material.IRON_FENCE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lGladiator");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Chame o inimigo para x1!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.gun"))
      {
        ItemStack pyro = new ItemStack(Material.WOOD_HOE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lGun");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Ganhe uma ak-47!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.viper"))
      {
        ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lViper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7De veneno no inimigo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.snail"))
      {
        ItemStack pyro = new ItemStack(Material.WEB);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lSnail");
        ArrayList indiob = new ArrayList();
        indiob.add("§7De lentidao no inimigo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.quickdropper"))
      {
        ItemStack pyro = new ItemStack(Material.BOWL);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lQuickdropper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Drope potes automaticamente!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.infernor"))
      {
        ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lInfernor");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Crie uma arena infernal!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.sonic"))
      {
        ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lSonic");
        ArrayList indiob = new ArrayList();
        indiob.add("§7De um deshe bote veneno!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.deshfire"))
      {
        ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lDeshfire");
        ArrayList indiob = new ArrayList();
        indiob.add("§7De um deshe bote fogo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.indio"))
      {
        ItemStack pyro = new ItemStack(Material.PUMPKIN_SEEDS);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lIndio");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Solte macumba contra o inimigo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.naruto"))
      {
        ItemStack pyro = new ItemStack(Material.NETHER_STAR);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lNaruto");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Entre no modo 9 caudas!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.jumper"))
      {
        ItemStack pyro = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lJumper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Teleport-se com seu item!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.gaara"))
      {
        ItemStack pyro = new ItemStack(Material.SANDSTONE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lGaara");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Prenda seu inimigo no caixao de areia!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.monk"))
      {
        ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lMonk");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Fa§a bagun§a no inv inimigo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.thor"))
      {
        ItemStack pyro = new ItemStack(Material.GOLD_AXE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lThor");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Solte raios no inimigo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.forcefield"))
      {
        ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lForcefield");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Crie um campo de for§a");
        indiob.add("§7Que te protege");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.stomper"))
      {
        ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lStomper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Esmague o inimigo!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.switcher"))
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
      if (p.hasPermission("kitpvp.kit.fisherman"))
      {
        ItemStack pyro = new ItemStack(Material.FISHING_ROD);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lFisherman");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Vire um pescador!");
        indiob.add("§7de players!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.ninja"))
      {
        ItemStack pyro = new ItemStack(Material.FENCE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lNinja");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Teleporte ao player hitado");
        indiob.add("§7Apertando shift");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.magma"))
      {
        ItemStack pyro = new ItemStack(Material.FIRE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lMagma");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Bote fogo nos players");
        indiob.add("§7Seja imune a fogo/lava");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.anchor"))
      {
        ItemStack pyro = new ItemStack(Material.ANVIL);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lAnchor");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Nao tome");
        indiob.add("§7Nem leve kb");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.barbarian"))
      {
        ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lBarbarian");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Upe de espada");
        indiob.add("§7a cada kill");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.reaper"))
      {
        ItemStack pyro = new ItemStack(Material.WOOD_HOE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lReaper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Seja o ceifador");
        indiob.add("§7e apodreça os players");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.viking"))
      {
        ItemStack pyro = new ItemStack(Material.STONE_AXE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lViking");
        ArrayList indiob = new ArrayList();
        indiob.add("§7De dano extra");
        indiob.add("§7com seu machado");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.confuser"))
      {
        ItemStack pyro = new ItemStack(Material.POTION);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lConfuser");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Deixe seus ");
        indiob.add("§7inimigos confusos");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.resouper"))
      {
        ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lResouper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Faça resoup");
        indiob.add("§7Ao matar um player");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.hulk"))
      {
        ItemStack pyro = new ItemStack(Material.SADDLE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lHulk");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Segure seu inimigo");
        indiob.add("§7e lance ele");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.goku"))
      {
        ItemStack pyro = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lGoku");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Vire um super sayajin");
        indiob.add("§7E seja foda!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.rain"))
      {
        ItemStack pyro = new ItemStack(Material.ARROW);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lRain");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Faca uma chuva de");
        indiob.add("§7flechas!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.pyro"))
      {
        ItemStack pyro = new ItemStack(Material.FIREBALL);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lPyro");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Lance bolas de fogo");
        indiob.add("§7Igual um ghast!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.camel"))
      {
        ItemStack pyro = new ItemStack(Material.SAND);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lCamel");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Ganhe vantagens");
        indiob.add("§7No deserto!");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.doublejump"))
      {
        ItemStack pyro = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lDoublejump");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Seja um kangaroo");
        indiob.add("§7Sem ser nerfado");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.reverse"))
      {
        ItemStack pyro = new ItemStack(Material.WOOL);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lReverse");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Troque de lugar com os player");
        indiob.add("§7De um jeito bem maneiro");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.magma"))
      {
        ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lMagma");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Bote fogo nos inimigos");
        indiob.add("§7E nao leve dano de fogo/lava");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("litepvp.kit.ultimate"))
      {
        ItemStack pyro = new ItemStack(Material.NETHER_STAR);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §4§lUltimate");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Tenha 3 kits em 1 so");
        indiob.add("§7Stomper/Viper/Snail");
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
          kits.setItem(kits.firstEmpty(), vidro);
        }
      }
      p.openInventory(kits);
    }
    return true;
  }
}
