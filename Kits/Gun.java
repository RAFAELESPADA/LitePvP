package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Cooldown;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.api.API;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Gun
  implements Listener, CommandExecutor
{
  public static HashMap<Player, Integer> guntiros = new HashMap();
  
  @EventHandler
  public void ar(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("Gun")) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getType() == Material.WOOD_HOE))
    {
      e.setCancelled(true);
      if ((guntiros.containsKey(p)) && (((Integer)guntiros.get(p)).intValue() == 2)) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            Gun.guntiros.remove(p);
            p.sendMessage(String.valueOf(API.Prefix) + " §aSeu cooldown acabou");
          }
        }, 400L);
      }
      if ((guntiros.containsKey(p)) && (((Integer)guntiros.get(p)).intValue() == 3))
      {
        if (Cooldown.add(p))
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§bVoce esta em cooldown de: §5" + Cooldown.cooldown(p) + "§bs");
          return;
        }
        Cooldown.add(p, 20);
      }
      else if (!guntiros.containsKey(p))
      {
        guntiros.put(p, Integer.valueOf(1));
      }
      else
      {
        guntiros.put(p, Integer.valueOf(((Integer)guntiros.get(p)).intValue() + 1));
      }
      Location loc = p.getLocation().add(0.0D, 1.5D, 0.0D);
      for (int i = 0; i <= 240; i++)
      {
        loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY() - 0.05D, loc.getDirection().getZ());
        p.getWorld().playEffect(loc, Effect.COLOURED_DUST, 15);
        for (Entity ent : getEntitiesByLocation(loc, 1.0F)) {
          if (((ent instanceof LivingEntity)) && (ent != p)) {
            ((LivingEntity)ent).damage(7.0D);
          }
        }
        if (loc.getBlock().getType().isSolid()) {
          break;
        }
      }
      p.getLocation().getWorld().playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 2.0F, 2.0F);
    }
  }
  
  private List<Entity> getEntitiesByLocation(Location loc, float r)
  {
    List<Entity> ent = new ArrayList();
    for (Entity e : loc.getWorld().getEntities()) {
      if (e.getLocation().distanceSquared(loc) <= r) {
        ent.add(e);
      }
    }
    return ent;
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
    ItemStack especial = new ItemStack(Material.WOOD_HOE);
    ItemMeta especials = especial.getItemMeta();
    especials.setDisplayName("§2AK-47");
    especial.setItemMeta(especials);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("gun"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.gun"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cGun §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Gun");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.give(p);
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      Habilidade.setAbility(p, "Gun");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Gun");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
