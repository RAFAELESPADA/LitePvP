package me.rafael.litepvp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.api.API;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player.Spigot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class X1
  implements Listener
{
  private static Main main;
  static Main plugin;
  
  public X1()
  {
    main = main;
    plugin = main;
  }
  
  public static Map<String, String> convites = new HashMap();
  public static Map<String, String> lutadores = new HashMap();
  public static ArrayList<Player> hide = new ArrayList();
  public static ArrayList<Player> inx1 = new ArrayList();
  
  public static void sair1v1(Player p)
  {    
    inx1.remove(p);
    API.ItemSpawn(p);
    p.setHealth(20.0D);
    p.sendMessage("§cVoce saiu do 1v1");
  }
  
  public static void entrar1v1(Player p)
  {
    inx1.add(p);
    
    p.getInventory().clear();
    p.getInventory().setArmorContents(null);
    
    ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
    ItemMeta v12 = v1.getItemMeta();
    v12.setDisplayName("§6Clique para desafiar alguen!");
    v1.setItemMeta(v12);
    ItemStack rd1 = new ItemStack(Material.REDSTONE);
    ItemMeta rd12 = rd1.getItemMeta();
    rd12.setDisplayName("§cSair");
    rd1.setItemMeta(rd12);
    
    double x = Main.getInstace().warps.getDouble("x1.coords.spawn.x");
    double y = Main.getInstace().warps.getDouble("x1.coords.spawn.y");
    double z = Main.getInstace().warps.getDouble("x1.coords.spawn.z");
    Location lobby = new Location(p.getWorld(), x, y, z);
    lobby.setPitch((float)Main.plugin.getConfig().getDouble("x1.coords.spawn.pitch"));
    lobby.setYaw((float)Main.plugin.getConfig().getDouble("x1.coords.spawn.yaw"));
    p.teleport(lobby);
    p.getInventory().clear();
    Habilidade.setAbility(p, "1v1");
    p.getInventory().setItem(0, v1);
    p.getInventory().setItem(8, rd1);
    p.updateInventory();
    
    p.setHealth(20.0D);
    p.setExp(0.0F);
    p.setLevel(0);
  }
  
  public static void set1v1(Player p)
  {
    p.getInventory().clear();
    p.getInventory().setArmorContents(null);
    ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§cEspada");
    dima.setItemMeta(souperaa);
    p.getInventory().addItem(new ItemStack[] { dima });
    p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
    p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
    p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
    p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
    
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopas.setDisplayName("§6Soup");
    sopa.setItemMeta(sopas);
    for (int i = 0; i <= 7; i++)
    {
      p.getInventory().addItem(new ItemStack[] { sopa });
      p.updateInventory();
    }
  }
  
  @EventHandler
  public void cmd(PlayerCommandPreprocessEvent e)
  {
    if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase("1v1")) && (!e.getMessage().equalsIgnoreCase("/spawn")))
    {
      e.getPlayer().sendMessage("§cDigite /spawn para sair da 1v1");
      e.setCancelled(true);
      return;
    }
    if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase("1v1")) && (e.getMessage().equalsIgnoreCase("/spawn")))
    {
      e.setCancelled(false);
      return;
    }
    if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase("1v1")) && (lutadores.containsKey(e.getPlayer())))
    {
      e.getPlayer().sendMessage("§cVoce nao pode digitar comandos enquanto estiver lutando");
      e.setCancelled(true);
      return;
    }
  }
  
  public static void aceitar(Player p1, Player p2)
  {
    p1.teleport(new Location(p1.getWorld(), Main.getInstace().warps.getDouble("x1.coords.loc_1.x"), 
      Main.getInstace().warps.getDouble("x1.coords.loc_1.y"), Main.getInstace().warps.getDouble("x1.coords.loc_1.z"), 
      Float.valueOf((float)Main.getInstace().warps.getDouble("x1.coords.loc_1.yaw")).floatValue(), Float.valueOf((float)Main.getInstace().warps.getDouble("x1.coords.loc_1.pitch")).floatValue()));
    p2.teleport(new Location(p1.getWorld(), Main.getInstace().warps.getDouble("x1.coords.loc_2.x"), 
      Main.getInstace().warps.getDouble("x1.coords.loc_2.y"), Main.getInstace().warps.getDouble("x1.coords.loc_2.z"), 
      Float.valueOf((float)Main.getInstace().warps.getDouble("x1.coords.loc_2.yaw")).floatValue(), Float.valueOf((float)Main.getInstace().warps.getDouble("x1.coords.loc_2.pitch")).floatValue()));
    
    set1v1(p1);
    set1v1(p2);
    lutadores.put(p1.getName(), p2.getName());
    lutadores.put(p2.getName(), p1.getName());
    convites.remove(p1.getName());
    for (Player pp : Bukkit.getOnlinePlayers()) {
      p1.hidePlayer(pp);
    }
    hide.add(p1);
    for (Player pp : Bukkit.getOnlinePlayers()) {
      p2.hidePlayer(pp);
    }
    hide.add(p2);
    p1.showPlayer(p2);
    p2.showPlayer(p1);
    p1.updateInventory();
    p2.updateInventory();
    p1.sendMessage("§cO Player" + p2.getName() + "aceitou seu pedido de 1v1");
    p2.sendMessage("§cVoce aceitou o pedido de" + p1.getName());
  }
  
  @EventHandler
  public void interact(PlayerInteractEvent e)
  {
    if ((inx1.contains(e.getPlayer())) && 
      (e.getAction().name().contains("RIGHT_CLICK")) && 
      (e.getPlayer().getItemInHand().getType().equals(Material.REDSTONE))) {
      sair1v1(e.getPlayer());
    }
  }
  
  @EventHandler
  public void entrar(PlayerJoinEvent e)
  {
    for (Player p : hide) {
      p.hidePlayer(e.getPlayer());
    }
  }
  
  @EventHandler
  public void kick(PlayerQuitEvent e)
  {
    if (lutadores.containsKey(e.getPlayer().getName()))
    {
      Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(e.getPlayer().getName()));
      Player perdedor = e.getPlayer();
      matou.sendMessage("§c" + perdedor.getName() + " Deslogou!");
      hide.remove(perdedor);
      hide.remove(matou);
      for (Player pp : Bukkit.getOnlinePlayers())
      {
        matou.showPlayer(pp);
        perdedor.showPlayer(pp);
      }
      entrar1v1(matou);
    }
  }
  
  @EventHandler
  public void kick(PlayerKickEvent e)
  {
    if (lutadores.containsKey(e.getPlayer().getName()))
    {
      Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(e.getPlayer().getName()));
      Player perdedor = e.getPlayer();
      matou.sendMessage("§eSeu oponente desconectou-se");
      hide.remove(perdedor);
      hide.remove(matou);
      for (Player pp : Bukkit.getOnlinePlayers())
      {
        matou.showPlayer(pp);
        perdedor.showPlayer(pp);
      }
      entrar1v1(matou);
    }
  }
  
  @EventHandler
  public void morrer(final PlayerDeathEvent e)
  {
    Player p = e.getEntity().getPlayer();
    Player k = p.getKiller();
    if (inx1.contains(p.getName())) {
      return;
    }
    if ((e.getEntity() instanceof Player))
    {
      p.spigot().respawn();
      p.setFireTicks(0);
      for (PotionEffect effect : p.getActivePotionEffects()) {
        p.removePotionEffect(effect.getType());
      }
    }
    if (((p instanceof Player)) && ((k instanceof Player)))
    {
      p.spigot().respawn();
      p.setFireTicks(0);
      for (PotionEffect effect : p.getActivePotionEffects()) {
        p.removePotionEffect(effect.getType());
      }
    }
    if (lutadores.containsKey(e.getEntity().getPlayer().getName())) {
      new BukkitRunnable()
      {
        public void run()
        {
          Player matou = Bukkit.getServer()
            .getPlayerExact((String)X1.lutadores.get(e.getEntity().getPlayer().getName()));
          Player morreu = e.getEntity().getPlayer();
          morreu.spigot().respawn();
          X1.lutadores.remove(morreu.getName());
          X1.lutadores.remove(matou.getName());
          X1.hide.remove(matou);
          X1.hide.remove(morreu);
          X1.entrar1v1(matou);
          X1.entrar1v1(morreu);
          morreu.updateInventory();
          matou.updateInventory();
          for (Player online : Bukkit.getOnlinePlayers())
          {
            morreu.showPlayer(online);
            matou.showPlayer(online);
          }
        }
      }.runTaskLater(Main.plugin, 5L);
    }
  }
  
  @EventHandler
  public void InteractItem(PlayerInteractEntityEvent e)
  {
    if ((inx1.contains(e.getPlayer())) && 
      ((e.getRightClicked() instanceof Player)) && 
      (e.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD))
    {
      final Player p = e.getPlayer();
      Player target = (Player)e.getRightClicked();
      if (convites.containsKey(target.getName()))
      {
        if (((String)convites.get(target.getName())).equalsIgnoreCase(p.getName()))
        {
          aceitar(target, p);
        }
        else if (!convites.containsKey(p.getName()))
        {
          p.sendMessage("§eVoce desafiou: " + target.getName());
          target.sendMessage(
            "§eVoce foi desafiado por " + p.getName());
          convites.put(p.getName(), target.getName());
          Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable()
          {
            public void run()
            {
              if (X1.convites.containsKey(p.getName())) {
                X1.convites.remove(p.getName());
              }
            }
          }, 200L);
        }
        else
        {
          p.sendMessage("§cVoce esta em cooldown");
        }
      }
      else if (!convites.containsKey(p.getName()))
      {
        p.sendMessage("§eVoce desafiou: " + target.getName());
        target.sendMessage(
          "§eVoce foi desafiado por " + p.getName());
        convites.put(p.getName(), target.getName());
        Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable()
        {
          public void run()
          {
            if (X1.convites.containsKey(p.getName())) {
              X1.convites.remove(p.getName());
            }
          }
        }, 200L);
      }
      else
      {
        p.sendMessage("§cVoce esta em cooldown");
      }
    }
  }
  
  private static ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore)
  {
    ItemStack item = new ItemStack(material, amount, (short)shrt);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(displayName);
    meta.setLore(lore);
    item.setItemMeta(meta);
    return item;
  }
}
