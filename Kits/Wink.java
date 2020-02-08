package Kits;

import Comandos.SetArena;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Cooldown;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Wink
  implements CommandExecutor, Listener
{
  private List<UUID> blocos;
  
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
    ItemStack especial = new ItemStack(Material.SAND);
    ItemMeta especial1 = especial.getItemMeta();
    especial1.setDisplayName("§6Caixao de Areia");
    especial.setItemMeta(especial1);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("gaara"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.gaara"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7>> Voce escolheu o kit §cGaara §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Gaara");
      Habilidade.setAbility(p, "Gaara");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.give(p);
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Gaara");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
  
  public Wink()
  {
    this.blocos = new ArrayList();
  }
  
  @EventHandler
  private void blocosGaara(EntityChangeBlockEvent evento)
  {
    if (this.blocos.contains(evento.getEntity().getUniqueId())) {
      evento.setCancelled(true);
    }
  }
  
  @EventHandler
  private void eventoGaara(final PlayerInteractEntityEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getRightClicked() instanceof Player)) && (Array.kit.get(p) == "Gaara") && (p.getItemInHand().getType() == Material.SAND)) {
      if ((GladiatorHAB.lutando.containsKey(p.getName())) || (InfernorHAB.lutando.containsKey(p.getName())))
      {
        p.sendMessage(String.valueOf("§cVoce nao poder usar seu kit no gladiator(infernor) entao vai §aganhar §eum efeito de §aspeed"));
        
        Main.darEfeito(p, PotionEffectType.SPEED, 10, 2);
      }
      else
      {
        if (Cooldown.add(p))
        {
          p.sendMessage("§cCooldown");
          return;
        }
        Cooldown.add(p, 15);
        Main.darEfeito(p, PotionEffectType.SPEED, 10, 1);
        new BukkitRunnable()
        {
          Location[] oldLoc = null;
          Location[] loc = new Location[20];
          int contador = -1;
          
          public void run()
          {
            if ((e.getPlayer() != null) && (e.getRightClicked() != null) && (e.getPlayer().isOnline()) && (((Player)e.getRightClicked()).isOnline()))
            {
              if (++this.contador != 3)
              {
                if (this.oldLoc != null)
                {
                  Location[] oldLoc;
                  int length = (oldLoc = this.oldLoc).length;
                  for (int i = 0; i < length; i++)
                  {
                    Location old = oldLoc[i];
                    old.getBlock().setType(Material.AIR);
                  }
                }
                int x = e.getRightClicked().getLocation().getBlockX();
                int y = e.getRightClicked().getLocation().getBlockY();
                int z = e.getRightClicked().getLocation().getBlockZ();
                e.getRightClicked().teleport(new Location(e.getRightClicked().getWorld(), x + 0.5D, y + 4 + this.contador, z + 0.5D));
                this.loc[0] = e.getRightClicked().getLocation().add(0.0D, -1.0D, 0.0D);
                this.loc[1] = e.getRightClicked().getLocation().add(0.0D, -1.0D, 0.0D);
                this.loc[2] = e.getRightClicked().getLocation().add(1.0D, 1.0D, 1.0D);
                this.loc[3] = e.getRightClicked().getLocation().add(-1.0D, 1.0D, -1.0D);
                this.loc[4] = e.getRightClicked().getLocation().add(1.0D, 1.0D, -1.0D);
                this.loc[5] = e.getRightClicked().getLocation().add(-1.0D, 1.0D, 1.0D);
                this.loc[6] = e.getRightClicked().getLocation().add(0.0D, 0.0D, -1.0D);
                this.loc[7] = e.getRightClicked().getLocation().add(-1.0D, 0.0D, 0.0D);
                this.loc[8] = e.getRightClicked().getLocation().add(1.0D, 0.0D, 0.0D);
                this.loc[9] = e.getRightClicked().getLocation().add(0.0D, 0.0D, 1.0D);
                this.loc[10] = e.getRightClicked().getLocation().add(0.0D, 3.0D, 0.0D);
                this.loc[11] = e.getRightClicked().getLocation().add(0.0D, 2.0D, -1.0D);
                this.loc[12] = e.getRightClicked().getLocation().add(-1.0D, 2.0D, 0.0D);
                this.loc[13] = e.getRightClicked().getLocation().add(1.0D, 2.0D, 0.0D);
                this.loc[14] = e.getRightClicked().getLocation().add(0.0D, 2.0D, 1.0D);
                this.loc[15] = e.getRightClicked().getLocation().add(0.0D, 1.0D, -1.0D);
                this.loc[16] = e.getRightClicked().getLocation().add(-1.0D, 1.0D, 0.0D);
                this.loc[17] = e.getRightClicked().getLocation().add(1.0D, 1.0D, 0.0D);
                this.loc[18] = e.getRightClicked().getLocation().add(0.0D, 1.0D, 1.0D);
                this.loc[19] = e.getRightClicked().getLocation().add(0.0D, 2.0D, 0.0D);
                Location[] loc;
                int length2 = (loc = this.loc).length;
                for (int j = 0; j < length2; j++)
                {
                  Location locais = loc[j];
                  locais.getBlock().setType(Material.SANDSTONE);
                }
                this.oldLoc = this.loc;
              }
              else
              {
                this.loc[0] = e.getRightClicked().getLocation().add(0.0D, -1.0D, 0.0D);
                this.loc[1] = e.getRightClicked().getLocation().add(0.0D, -1.0D, 0.0D);
                this.loc[2] = e.getRightClicked().getLocation().add(1.0D, 1.0D, 1.0D);
                this.loc[3] = e.getRightClicked().getLocation().add(-1.0D, 1.0D, -1.0D);
                this.loc[4] = e.getRightClicked().getLocation().add(1.0D, 1.0D, -1.0D);
                this.loc[5] = e.getRightClicked().getLocation().add(-1.0D, 1.0D, 1.0D);
                this.loc[6] = e.getRightClicked().getLocation().add(0.0D, 0.0D, -1.0D);
                this.loc[7] = e.getRightClicked().getLocation().add(-1.0D, 0.0D, 0.0D);
                this.loc[8] = e.getRightClicked().getLocation().add(1.0D, 0.0D, 0.0D);
                this.loc[9] = e.getRightClicked().getLocation().add(0.0D, 0.0D, 1.0D);
                this.loc[10] = e.getRightClicked().getLocation().add(0.0D, 3.0D, 0.0D);
                this.loc[11] = e.getRightClicked().getLocation().add(0.0D, 2.0D, -1.0D);
                this.loc[12] = e.getRightClicked().getLocation().add(-1.0D, 2.0D, 0.0D);
                this.loc[13] = e.getRightClicked().getLocation().add(1.0D, 2.0D, 0.0D);
                this.loc[14] = e.getRightClicked().getLocation().add(0.0D, 2.0D, 1.0D);
                this.loc[15] = e.getRightClicked().getLocation().add(0.0D, 1.0D, -1.0D);
                this.loc[16] = e.getRightClicked().getLocation().add(-1.0D, 1.0D, 0.0D);
                this.loc[17] = e.getRightClicked().getLocation().add(1.0D, 1.0D, 0.0D);
                this.loc[18] = e.getRightClicked().getLocation().add(0.0D, 1.0D, 1.0D);
                this.loc[19] = e.getRightClicked().getLocation().add(0.0D, 2.0D, 0.0D);
                Location[] oldLoc2;
                int length3 = (oldLoc2 = this.oldLoc).length;
                for (int k = 0; k < length3; k++)
                {
                  Location old = oldLoc2[k];
                  old.getBlock().setType(Material.AIR);
                }
                Location[] loc2;
                int length4 = (loc2 = this.loc).length;
                for (int l = 0; l < length4; l++)
                {
                  Location locais2 = loc2[l];
                  FallingBlock bloco = locais2.getBlock().getWorld().spawnFallingBlock(locais2, Material.SAND, (byte)0);
                  Wink.this.blocos.add(bloco.getUniqueId());
                }
                e.getRightClicked().setFallDistance(-10.0F);
                e.getRightClicked().getWorld().createExplosion(this.loc[19], 2.0F, true);
                cancel();
              }
            }
            else
            {
              Location[] loc3;
              int length5 = (loc3 = this.loc).length;
              for (int n = 0; n < length5; n++)
              {
                Location locais2 = loc3[n];
                locais2.getBlock().setType(Material.AIR);
              }
              if (this.oldLoc != null)
              {
                Location[] oldLoc3;
                int length6 = (oldLoc3 = this.oldLoc).length;
                for (int n2 = 0; n2 < length6; n2++)
                {
                  Location old = oldLoc3[n2];
                  old.getBlock().setType(Material.AIR);
                }
              }
              cancel();
            }
          }
        }.runTaskTimer(Main.getInstace(), 0L, 8L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            p.sendMessage("§aJa pode usar novamente");
          }
        }, 300L);
      }
    }
  }
}
