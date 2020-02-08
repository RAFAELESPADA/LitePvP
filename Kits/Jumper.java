package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class Jumper
  implements Listener, CommandExecutor
{
  public static HashMap<String, Long> cooldown = new HashMap();
  
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
    ItemStack especial = new ItemStack(Material.EYE_OF_ENDER);
    ItemMeta especial1 = especial.getItemMeta();
    especial1.setDisplayName("§aOlho que tudo teleporta");
    especial.setItemMeta(especial1);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("jumper"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.jumper"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cJumper §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Main.jp.add(p.getName());
      Array.kit.put(p, "Jumper");
      Main.Dj.remove(p.getName());
      Habilidade.setAbility(p, "Jumper");
      Main.stomper.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Jumper");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.give(p);
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
  
  @EventHandler
  public void interact(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_AIR)) && 
      (Main.jp.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.EYE_OF_ENDER)) {
      if ((GladiatorHAB.lutando.containsKey(p.getName())) || (InfernorHAB.lutando.containsKey(p.getName())))
      {
        p.sendMessage(String.valueOf("§cVoce nao poder usar seu kit no gladiator(infernor) ent§o vai §aganhar §eum efeito de §aspeed"));
        
        Main.darEfeito(p, PotionEffectType.SPEED, 10, 2);
      }
      else
      {
        e.setCancelled(true);
        if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
        {
          e.setCancelled(true);
          p.launchProjectile(EnderPearl.class);
          cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10L)));
          return;
        }
        p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
      }
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if (((event.getEntity() instanceof Player)) && 
        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
        (player.getInventory().contains(Material.EYE_OF_ENDER)) && 
        (event.getDamage() >= 12.0D)) {
        event.setDamage(12.0D);
      }
    }
  }
}
