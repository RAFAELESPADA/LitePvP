package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Habilidade;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class InfernorHAB
  implements Listener
{
  public static ArrayList<String> gladinfernor = new ArrayList();
  public boolean generateGLASS;
  public HashMap<String, Location> oldl;
  public static HashMap<String, String> lutando = new HashMap();
  public HashMap<Integer, ArrayList<Location>> blocks;
  public HashMap<Player, Location> localizacao;
  public HashMap<Location, Block> bloco;
  public HashMap<Integer, String[]> players;
  public HashMap<String, Integer> tasks;
  int nextID;
  public int id1;
  public int id2;
  
  public InfernorHAB()
  {
    this.generateGLASS = true;
    this.oldl = new HashMap();
    this.blocks = new HashMap();
    this.localizacao = new HashMap();
    this.bloco = new HashMap();
    this.players = new HashMap();
    this.tasks = new HashMap();
    this.nextID = 0;
  }
  
  @EventHandler
  public void aoComando(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if ((lutando.containsKey(p.getName())) && (e.getMessage().startsWith("/")))
    {
      e.setCancelled(true);
      p.sendMessage(String.valueOf("§cVoc§ n§o pode utilizar comando quanto estiver lutando"));
    }
  }
  
  @EventHandler
  public void aoInfernor(PlayerInteractEntityEvent event)
  {
    final Player p = event.getPlayer();
    if ((event.getRightClicked() instanceof Player))
    {
      final Player r = (Player)event.getRightClicked();
      if ((p.getItemInHand().getType() == Material.NETHER_FENCE) && (Habilidade.getAbility(p).equalsIgnoreCase("Infernor")))
      {
        Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ());
        this.localizacao.put(p, loc);
        this.localizacao.put(r, loc);
        Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX() - 5, p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ() - 5);
        Location loc3 = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ() + 6);
        if ((GladiatorHAB.lutando.containsKey(p.getName())) || (GladiatorHAB.lutando.containsKey(r.getName())) || (lutando.containsKey(p.getName())) || (lutando.containsKey(r.getName())))
        {
          event.setCancelled(true);
          p.sendMessage(String.valueOf("§7Voce ja esta em combate!"));
          return;
        }
        Integer currentID = Integer.valueOf(this.nextID);
        this.nextID += 1;
        ArrayList<String> list = new ArrayList();
        list.add(p.getName());
        list.add(r.getName());
        this.players.put(currentID, (String[])list.toArray(new String[1]));
        this.oldl.put(p.getName(), p.getLocation());
        this.oldl.put(r.getName(), r.getLocation());
        if (this.generateGLASS)
        {
          List<Location> cuboid = new ArrayList();
          cuboid.clear();
          int bZ;
          for (int bX = -8; bX <= 8; bX++) {
            for (bZ = -8; bZ <= 8; bZ++) {
              for (int bY = -1; bY <= 4; bY++)
              {
                Block b = loc.clone().add(bX, bY, bZ).getBlock();
                if (!b.isEmpty())
                {
                  event.setCancelled(true);
                  p.sendMessage(String.valueOf("§cVoce nao pode criar sua arena aqui"));
                  return;
                }
                if (bY == 4) {
                  cuboid.add(loc.clone().add(bX, bY, bZ));
                } else if (bY == -1) {
                  cuboid.add(loc.clone().add(bX, bY, bZ));
                } else if ((bX == -8) || (bZ == -8) || (bX == 8) || (bZ == 8)) {
                  cuboid.add(loc.clone().add(bX, bY, bZ));
                }
              }
            }
          }
          for (Location loc4 : cuboid)
          {
            loc4.getBlock().setType(Material.STAINED_GLASS);
            loc4.getBlock().setData(DyeColor.RED.getData());
            this.bloco.put(loc4, loc4.getBlock());
          }
          loc2.setYaw(-75.0F);
          p.teleport(loc2);
          loc3.setYaw(75.0F);
          r.teleport(loc3);
          Main.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 5, 5);
          Main.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 16, 1);
          Main.darEfeito(r, PotionEffectType.DAMAGE_RESISTANCE, 5, 5);
          p.sendMessage(String.valueOf("§7Voce desafiou um jogador! Voce tem 5 segundos de invencibilidade!"));
          p.sendMessage(String.valueOf("§7Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!"));
          r.sendMessage(String.valueOf("§7Voce foi desafiado! Voce tem 5 segundos de invencibilidade!"));
          r.sendMessage(String.valueOf("§7 Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!"));
          lutando.put(p.getName(), r.getName());
          lutando.put(r.getName(), p.getName());
          gladinfernor.add(p.getName());
          gladinfernor.add(r.getName());
          this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
          {
            public void run()
            {
              if ((InfernorHAB.lutando.containsKey(p.getName())) && (((String)InfernorHAB.lutando.get(p.getName())).equalsIgnoreCase(r.getName())) && (InfernorHAB.lutando.containsKey(r.getName())) && (((String)InfernorHAB.lutando.get(r.getName())).equalsIgnoreCase(p.getName())))
              {
                p.setFireTicks(9999999);
                r.setFireTicks(9999999);
              }
            }
          }, 2400L);
          this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
          {
            public void run()
            {
              if ((InfernorHAB.lutando.containsKey(p.getName())) && (((String)InfernorHAB.lutando.get(p.getName())).equalsIgnoreCase(r.getName())) && (InfernorHAB.lutando.containsKey(r.getName())) && (((String)InfernorHAB.lutando.get(r.getName())).equalsIgnoreCase(p.getName())))
              {
                InfernorHAB.lutando.remove(p.getName());
                InfernorHAB.lutando.remove(r.getName());
                InfernorHAB.gladinfernor.remove(p.getName());
                InfernorHAB.gladinfernor.remove(r.getName());
                p.teleport((Location)InfernorHAB.this.oldl.get(p.getName()));
                r.teleport((Location)InfernorHAB.this.oldl.get(r.getName()));
                InfernorHAB.this.oldl.remove(p.getName());
                InfernorHAB.this.oldl.remove(r.getName());
                p.sendMessage(String.valueOf("§7N§o houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!"));
                r.sendMessage(String.valueOf("§7N§o houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!"));
                r.setFireTicks(0);
                p.setFireTicks(0);
                Location loc = (Location)InfernorHAB.this.localizacao.get(p);
                List<Location> cuboid = new ArrayList();
                int bZ;
                for (int bX = -8; bX <= 8; bX++) {
                  for (bZ = -8; bZ <= 8; bZ++) {
                    for (int bY = -1; bY <= 4; bY++) {
                      if (bY == 4) {
                        cuboid.add(loc.clone().add(bX, bY, bZ));
                      } else if (bY == -1) {
                        cuboid.add(loc.clone().add(bX, bY, bZ));
                      } else if ((bX == -8) || (bZ == -8) || (bX == 8) || (bZ == 8)) {
                        cuboid.add(loc.clone().add(bX, bY, bZ));
                      }
                    }
                  }
                }
                for (Location loc2 : cuboid)
                {
                  loc2.getBlock().setType(Material.AIR);
                  ((Block)InfernorHAB.this.bloco.get(loc2)).setType(Material.AIR);
                }
              }
            }
          }, 4800L);
        }
      }
    }
  }
  
  @EventHandler
  public void onPlayerInteractGlad(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.NETHER_FENCE) && (Habilidade.getAbility(p).equalsIgnoreCase("Infernor")))
    {
      e.setCancelled(true);
      p.updateInventory();
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlyaerInteract(final PlayerInteractEvent e)
  {
    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.STAINED_GLASS) && (e.getClickedBlock().getData() == DyeColor.RED.getData()) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (lutando.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getClickedBlock().setType(Material.BEDROCK);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if (InfernorHAB.lutando.containsKey(e.getPlayer().getName()))
          {
            e.getClickedBlock().setType(Material.STAINED_GLASS);
            e.getClickedBlock().setData(DyeColor.RED.getData());
          }
        }
      }, 30L);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onBlockBreak(final BlockBreakEvent e)
  {
    if ((e.getBlock().getType() == Material.STAINED_GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (lutando.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getBlock().setType(Material.BEDROCK);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (InfernorHAB.lutando.containsKey(e.getPlayer().getName())))
          {
            e.getBlock().setType(Material.STAINED_GLASS);
            e.getBlock().setData(DyeColor.RED.getData());
          }
        }
      }, 30L);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlyaerInteract2(final PlayerInteractEvent e)
  {
    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.NETHERRACK) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (lutando.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getClickedBlock().setType(Material.BEDROCK);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if (InfernorHAB.lutando.containsKey(e.getPlayer().getName()))
          {
            e.getClickedBlock().setType(Material.STAINED_GLASS);
            e.getClickedBlock().setData(DyeColor.RED.getData());
          }
        }
      }, 30L);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onBlockBreak2(final BlockBreakEvent e)
  {
    if ((e.getBlock().getType() == Material.NETHERRACK) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (lutando.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getBlock().setType(Material.BEDROCK);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (InfernorHAB.lutando.containsKey(e.getPlayer().getName())))
          {
            e.getBlock().setType(Material.STAINED_GLASS);
            e.getBlock().setData(DyeColor.RED.getData());
          }
        }
      }, 30L);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerLeft(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (lutando.containsKey(p.getName()))
    {
      Player t = Bukkit.getServer().getPlayer((String)lutando.get(p.getName()));
      lutando.remove(t.getName());
      lutando.remove(p.getName());
      gladinfernor.remove(p.getName());
      gladinfernor.remove(t.getName());
      Location old = (Location)this.oldl.get(t.getName());
      t.teleport(old);
      t.sendMessage(String.valueOf("§cO jogador " + p.getName() + " deslogou"));
      Bukkit.getScheduler().cancelTask(this.id1);
      Bukkit.getScheduler().cancelTask(this.id2);
      t.setFireTicks(0);
      p.setFireTicks(0);
      Location loc = (Location)this.localizacao.get(p);
      List<Location> cuboid = new ArrayList();
      int bZ;
      for (int bX = -8; bX <= 8; bX++) {
        for (bZ = -8; bZ <= 8; bZ++) {
          for (int bY = -1; bY <= 4; bY++) {
            if (bY == 4) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if (bY == -1) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if ((bX == -8) || (bZ == -8) || (bX == 8) || (bZ == 8)) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            }
          }
        }
      }
      for (Location loc2 : cuboid)
      {
        loc2.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc2)).setType(Material.AIR);
      }
      for (Location loc2 : cuboid)
      {
        loc2.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc2)).setType(Material.AIR);
      }
      for (Location loc2 : cuboid)
      {
        loc2.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc2)).setType(Material.AIR);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDeathInfernor(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (lutando.containsKey(p.getName()))
    {
      Player k = Bukkit.getServer().getPlayer((String)lutando.get(p.getName()));
      Location old = (Location)this.oldl.get(p.getName());
      k.teleport(old);
      k.sendMessage(String.valueOf("§7Voce ganhou a batalha contra " + p.getName()));
      Bukkit.getScheduler().cancelTask(this.id1);
      Bukkit.getScheduler().cancelTask(this.id2);
      k.setFireTicks(0);
      p.setFireTicks(0);
      k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
      lutando.remove(k.getName());
      lutando.remove(p.getName());
      gladinfernor.remove(p.getName());
      gladinfernor.remove(k.getName());
      Location loc = (Location)this.localizacao.get(p);
      List<Location> cuboid = new ArrayList();
      cuboid.clear();
      int bZ;
      for (int bX = -8; bX <= 8; bX++) {
        for (bZ = -8; bZ <= 8; bZ++) {
          for (int bY = -1; bY <= 4; bY++) {
            if (bY == 4) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if (bY == -1) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if ((bX == -8) || (bZ == -8) || (bX == 8) || (bZ == 8)) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            }
          }
        }
      }
      for (Location loc2 : cuboid)
      {
        loc2.getBlock().setType(Material.AIR);
        if (this.bloco.containsKey(loc2)) {
          ((Block)this.bloco.get(loc2)).setType(Material.AIR);
        }
      }
    }
  }
}
