package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Magma
  implements Listener, CommandExecutor
{
  @EventHandler
  public void damage(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("Magma")) && ((e.getCause() == EntityDamageEvent.DamageCause.LAVA) || (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void aoPassar(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    Material block = p.getLocation().getBlock().getType();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("Magma")) && ((block == Material.STATIONARY_WATER) || (block == Material.WATER))) {
      p.damage(1.0D);
    }
  }
  
  @EventHandler
  public void Fogo(EntityDamageByEntityEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    if (!(e.getDamager() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    Player s = (Player)e.getDamager();
    if ((Habilidade.getAbility(s).equalsIgnoreCase("Magma")) && (s.getInventory().getItemInHand() != null))
    {
      Random rand = new Random();
      int percent = rand.nextInt(100);
      if (percent <= 33) {
        p.setFireTicks(50);
      }
    }
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
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("magma"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.magma"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cMagma §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Magma");
      Habilidade.setAbility(p, "Magma");
      p.getInventory().addItem(new ItemStack[] { dima });
      Main.stomper.remove(p.getName());
      Main.give(p);
      Main.Dj.remove(p.getName());
      Habilidade.setAbility(p, "Magma");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Magma");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
