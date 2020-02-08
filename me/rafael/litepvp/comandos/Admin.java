package me.rafael.litepvp.comandos;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Coins;
import me.rafael.litepvp.Utils.Habilidade;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class Admin
  implements CommandExecutor, Listener
{
  private Main main;
  
  public Admin(Main main)
  {
    this.main = main;
  }
  
  public static ArrayList<String> admin = new ArrayList();
  public static HashMap<String, ItemStack[]> saveinv = new HashMap();
  public static HashMap<String, ItemStack[]> savearmor = new HashMap();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§bConsole nao pode executar esse comando");
      return true;
    }
    Player p = (Player)sender;
    if (!sender.hasPermission("kitpvp.staff"))
    {
      sender.sendMessage("§cVoce nao tem permissao");
      
      return true;
    }
    if (args.length == 0)
    {
      Object estrelameta;
      if (!admin.contains(p.getName()))
      {
        p.sendMessage("§b§lVoce entrou no modo admin!");
        for (Player s : Bukkit.getOnlinePlayers()) {
          if (!s.hasPermission("kitpvp.admin")) {
            s.hidePlayer(p);
          }
        }
        p.setGameMode(GameMode.CREATIVE);
        admin.add(p.getName());
        saveinv.put(p.getName(), p.getInventory().getContents());
        savearmor.put(p.getName(), p.getInventory().getArmorContents());
        p.setAllowFlight(true);
        p.getInventory().clear();
        
        ItemStack estrela = new ItemStack(Material.SLIME_BALL);
        estrelameta = estrela.getItemMeta();
        ((ItemMeta)estrelameta).setDisplayName("§a§lTroca Rapida!");
        estrela.setItemMeta((ItemMeta)estrelameta);
        
        ItemStack barra = new ItemStack(Material.IRON_FENCE);
        ItemMeta barrameta = barra.getItemMeta();
        barrameta.setDisplayName("§a§lPrender!");
        barra.setItemMeta(barrameta);
        
        ItemStack etiqueta = new ItemStack(Material.FEATHER);
        ItemMeta etiquetameta = etiqueta.getItemMeta();
        etiquetameta.setDisplayName("§a§lTeste de NOFALL!");
        etiqueta.setItemMeta(etiquetameta);
        
        ItemStack kb = new ItemStack(Material.STICK);
        ItemMeta kbmeta = kb.getItemMeta();
        kbmeta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        kbmeta.setDisplayName("§a§lTeste de AntiKB!");
        kb.setItemMeta(kbmeta);
        
        ItemStack kb1 = new ItemStack(Material.CLAY_BRICK);
        ItemMeta kbmeta1 = kb1.getItemMeta();
        
        kbmeta1.setDisplayName("§b§lInformacao do Jogador!");
        kb1.setItemMeta(kbmeta1);
        
        p.getInventory().setItem(0, kb);
        
        p.getInventory().setItem(2, estrela);
        p.getInventory().setItem(4, etiqueta);
        p.getInventory().setItem(6, barra);
        p.getInventory().setItem(8, kb1);
        
        p.updateInventory();
      }
      else
      {
        p.sendMessage("§a§lVoce saiu do modo admin!");
        p.setHealth(20.0D);
        p.getInventory().clear();
        admin.remove(p.getName());
        for (estrelameta = Bukkit.getOnlinePlayers().iterator(); ((Iterator)estrelameta).hasNext();)
        {
          Player s = (Player)((Iterator)estrelameta).next();
          if (!s.hasPermission("kitpvp.admin")) {
            s.showPlayer(p);
          }
        }
        p.setGameMode(GameMode.SURVIVAL);
        p.getInventory().setContents((ItemStack[])saveinv.get(p.getName()));
        p.getInventory().setItem(2, new ItemStack(Material.AIR));
        p.getInventory().setArmorContents((ItemStack[])savearmor.get(p.getName()));
      }
    }
    return false;
  }
  
  public static int getMaterial(Player p, Material m)
  {
    int value = 0;
    ItemStack[] arrayOfItemStack;
    int j = (arrayOfItemStack = p.getInventory().getContents()).length;
    for (int i = 0; i < j; i++)
    {
      ItemStack item = arrayOfItemStack[i];
      if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
        value += item.getAmount();
      }
    }
    return value;
  }
  
  @EventHandler
  public void onInteractPlayerSlimeFun(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((admin.contains(p.getName())) && (
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR))) {
      if (p.getItemInHand().getType() == Material.SLIME_BALL)
      {
        p.chat("/admin");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            p.chat("/admin");
          }
        }, 10L);
      }
    }
  }
  
  @EventHandler
  public void onPlayerInfo(PlayerInteractEntityEvent e)
  {
    Player p = e.getPlayer();
    if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.CLAY_BRICK))
    {
      Player p1 = (Player)e.getRightClicked();
      Damageable hp = p1;
      
      String kitpvp = "§aYes";
      String nokitpvp = "§cNo";
      p.sendMessage("§b§lInformacao de: §6§l" + p1.getName());
      if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.CLAY_BRICK))
      {
        p.sendMessage("§eVida: §c§l" + (int)hp.getHealth());
        
        p.sendMessage("§eGamemode: §c§l" + p1.getGameMode());
        
        p.sendMessage("§eCoins: §c§l" + Coins.getCoins(p1.getName()));
        p.sendMessage("§eKit: §c§l" + Habilidade.getAbility(p1));
        p.sendMessage("§eEsta voando? §c§l" + p1.isFlying());
        
        Player target = null;
        p.sendMessage("§eIp: §c§l" + p1.getAddress().getHostName());
      }
    }
  }
  
  @EventHandler
  public void ClickOpeninventory(PlayerInteractEntityEvent e)
  {
    if (((e.getRightClicked() instanceof Player)) && (e.getPlayer().getItemInHand().getType() == Material.AIR) && (admin.contains(e.getPlayer().getName())))
    {
      Player t = (Player)e.getRightClicked();
      e.getPlayer().openInventory(t.getInventory());
    }
  }
  
  @EventHandler
  public void onAdminArena(PlayerInteractEntityEvent event)
  {
    Player p = event.getPlayer();
    if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.IRON_FENCE))
    {
      Player p1 = (Player)event.getRightClicked();
      if (p1 != null)
      {
        p1.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
        p1.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
        p1.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
        p1.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
        p1.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
        p1.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
        p1.teleport(p1.getLocation().add(0.0D, 11.0D, -0.05D));
        p.sendMessage("§aVoce prendeu o jogador " + p1.getName());
      }
    }
  }
  
  @EventHandler
  public void onAdminNoFall(PlayerInteractEntityEvent event)
  {
    Player p = event.getPlayer();
    if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.FEATHER))
    {
      Player p1 = (Player)event.getRightClicked();
      if (p1 != null)
      {
        p1.getLocation().add(0.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
        p1.getLocation().add(0.0D, 40.0D, 1.0D).getBlock().setType(Material.AIR);
        p1.getLocation().add(1.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
        p1.getLocation().add(0.0D, 40.0D, -1.0D).getBlock().setType(Material.AIR);
        p1.getLocation().add(-1.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
        p1.getLocation().add(0.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
        p1.teleport(p1.getLocation().add(0.0D, 11.0D, -0.05D));
      }
    }
  }
}
