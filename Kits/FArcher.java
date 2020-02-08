package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class FArcher
  implements Listener, CommandExecutor
{
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Arrow)) && 
      ((((Arrow)e.getDamager()).getShooter() instanceof Player)))
    {
      Arrow arrow = (Arrow)e.getDamager();
      Player p = (Player)arrow.getShooter();
      p.getLocation().distance(e.getEntity().getLocation());
      if (((e.getEntity() instanceof Player)) && 
        (Array.kit.get(p) == "FpsArcher")) {
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 3.0F, 3.0F);
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
    
    ItemStack especial = new ItemStack(Material.ARROW);
    ItemStack especial2 = new ItemStack(Material.BOW);
    especial2.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
    especial2.addEnchantment(Enchantment.ARROW_INFINITE, 1);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("farcher"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§7» §cVoce ja esta usando um kit!");
        return true;
      }
      if (!Array.warp.contains(p.getName()))
      {
        p.sendMessage("§7» §cVoce precisa estar numa warp!");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7» Voce escolheu o kit §cArcher §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "FpsArcher");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial2 });
      p.getInventory().addItem(new ItemStack[] { especial });
      
      
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      Habilidade.setAbility(p, "Archer");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Archer");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
    }
    return false;
  }
}
