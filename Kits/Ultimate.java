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
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ultimate
  implements CommandExecutor, Listener
{
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
    if (cmd.equalsIgnoreCase("ultimate"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§7§ §cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("litepvp.kit.ultimate"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7§ Voce escolheu o kit §cUltimate §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Ultimate");
      Habilidade.setAbility(p, "Ultimate");
      p.getInventory().addItem(new ItemStack[] { dima });
      Main.stomper.add(p.getName());
      Main.give(p);
      Main.Dj.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit §c§lUltimate");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
  
  @EventHandler
  public void viper(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      LivingEntity entity = (LivingEntity)e.getEntity();
      Player p = (Player)e.getDamager();
      if (Array.kit.get(p) == "Ultimate")
      {
        Random rand = new Random();
        int percent = rand.nextInt(100);
        if (percent <= 33)
        {
          entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 160, 1));
          return;
        }
        return;
      }
      return;
    }
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      LivingEntity entity = (LivingEntity)e.getEntity();
      Player p = (Player)e.getDamager();
      if (Array.kit.get(p) == "Ultimate")
      {
        Random rand = new Random();
        int percent = rand.nextInt(100);
        if (percent <= 33)
        {
          entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 140, 0));
          return;
        }
        return;
      }
      return;
    }
  }
}
