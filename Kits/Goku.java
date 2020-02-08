package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Cooldown;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.api.API;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class Goku
  implements Listener, CommandExecutor
{
  public static ArrayList<String> emgoku = new ArrayList();
  
  @EventHandler
  public void aoGoku(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("Goku")) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getInventory().getItemInHand().getType() == Material.GOLD_NUGGET))
    {
      if (Cooldown.add(p))
      {
        p.sendMessage("§cVoce esta em Cooldown.");
        return;
      }
      p.setAllowFlight(true);
      p.setFlying(true);
      p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.DIAMOND_BLOCK, 20);
      API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 100, 0);
      API.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 100, 1);
      emgoku.add(p.getName());
      Cooldown.add(p, 30);
      p.getInventory().setHelmet(API.darArmadura(Material.LEATHER_HELMET, Color.YELLOW));
      p.getInventory().setChestplate(API.darArmadura(Material.LEATHER_CHESTPLATE, Color.YELLOW));
      p.getInventory().setLeggings(API.darArmadura(Material.LEATHER_LEGGINGS, Color.YELLOW));
      p.getInventory().setBoots(API.darArmadura(Material.LEATHER_BOOTS, Color.YELLOW));
      p.updateInventory();
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7Poder sayajin acabando em: §b5§7s");
        }
      }, 0L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7Poder sayajin acabando em: §b4§7s");
        }
      }, 20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7Poder sayajin acabando em: §b3§7s");
        }
      }, 40L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7Poder sayajin acabando em: §b2§7s");
        }
      }, 60L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7Poder sayajin acabando em: §b1§7s");
        }
      }, 80L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          API.tirarArmadura(p);
          p.sendMessage(String.valueOf(API.Prefix) + "§7Poder sayajin acabou");
          Goku.emgoku.remove(p.getName());
          p.setAllowFlight(false);
          p.setFlying(false);
          p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
          p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        }
      }, 100L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§2O Cooldown acabou");
        }
      }, 600L);
    }
  }
  
  @EventHandler
  public void clickar(InventoryClickEvent e)
  {
    try
    {
      Player p = (Player)e.getWhoClicked();
      if ((emgoku.contains(p.getName())) && (e.getSlotType().equals(InventoryType.SlotType.ARMOR))) {
        e.setCancelled(true);
      }
    }
    catch (Exception localException) {}
  }
  
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    Player p = (Player)sender;
    ItemStack dima = new ItemStack(Material.STONE_SWORD);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§cEspada");
    dima.setItemMeta(souperaa);
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopas.setDisplayName("§6Sopa");
    sopa.setItemMeta(sopas);
    ItemStack especial = new ItemStack(Material.GOLD_NUGGET);
    ItemMeta especials = especial.getItemMeta();
    especials.setDisplayName("§eKamekameha");
    especial.setItemMeta(especials);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("goku"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.goku"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cGoku §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Goku");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
Main.give(p);
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      Habilidade.setAbility(p, "Goku");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Goku");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
