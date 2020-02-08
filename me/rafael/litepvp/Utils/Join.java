package me.rafael.litepvp.Utils;

import java.util.ArrayList;
import java.util.Map;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Streak;
import me.rafael.litepvp.api.API;
import me.rafael.litepvp.comandos.Admin;
import me.rafael.litepvp.scoreboard.ScoreboardIniciando;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Join
  implements Listener
{
  @EventHandler
  public void onJoinr(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    int kills = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".k");
    int deaths = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".d");
    if ((kills == 0) && (deaths == 0))
    {
      Main.getInstace().getConfig().set("a." + p.getName().toLowerCase() + ".k", Integer.valueOf(kills + 1));
      Main.getInstace().getConfig().set("a." + p.getName().toLowerCase() + ".d", Integer.valueOf(deaths + 1));
      Main.getInstace().saveConfig();
    }
  }
  
  @EventHandler
  public void entrar(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    
    String d = p.getName();
    Main.TirarEfeitos(p);
    ItemStack kits = new ItemStack(Material.CHEST);
    ItemMeta kits2 = kits.getItemMeta();
    kits2.setDisplayName("§4» Kits");
    kits.setItemMeta(kits2);
    e.setJoinMessage("§c[§a+§c] §b" + p.getName());
    
    ItemStack warps = new ItemStack(Material.PAPER);
    ItemMeta warps2 = warps.getItemMeta();
    warps2.setDisplayName("§c» Warps");
    warps.setItemMeta(warps2);
    
    ItemStack day = new ItemStack(Material.DAYLIGHT_DETECTOR);
    ItemMeta day2 = day.getItemMeta();
    day2.setDisplayName("§e» Menu");
    day.setItemMeta(day2);
    
    ItemStack FRAME = new ItemStack(Material.ENDER_PORTAL_FRAME);
    ItemMeta FRAME2 = FRAME.getItemMeta();
    FRAME2.setDisplayName("§a» Loja");
    FRAME.setItemMeta(FRAME2);
    ItemStack treino = new ItemStack(Material.REDSTONE_COMPARATOR);
    ItemMeta treino2 = treino.getItemMeta();
    treino2.setDisplayName("§9» Treinos");
    treino.setItemMeta(treino2);
    
    p.getInventory().clear();
    p.getInventory().setArmorContents(null);
    p.teleport(p.getWorld().getSpawnLocation());
    p.setGameMode(GameMode.ADVENTURE);
    p.getInventory().setItem(0, warps);
    p.getInventory().setItem(2, FRAME);
    p.getInventory().setItem(4, kits);
    p.getInventory().setItem(6, day);
    p.getInventory().setItem(8, treino);
    
    p.setFireTicks(0);
    ScoreboardIniciando.setScoreBoard(p);
    p.playSound(p.getLocation(), Sound.LEVEL_UP, 8.0F, 5.0F);
    Admin.admin.remove(p.getName());
    p.sendMessage("§eBem vindo ao " + API.rawPrefix);
    p.sendMessage("§eAqui voce pode treinar seu pvp");
    p.sendMessage("§eQualquer duvida fale com um staff");
    p.sendMessage("§eSe encontrar um hack digite /report <nick> <motivo>");
    p.sendMessage("§bDigite /tag para ver as tags que voce possui");
    p.sendMessage("§eTenha um bom jogo =)");
    
    p.chat("/tag normal");
    TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), "§a§lBem vindo", "§f§lAo Servidor " + API.rawPrefix);
    if (Streak.killstreak.get(p.getName()) == null) {}
    Streak.killstreak.put(p.getName(), Integer.valueOf(0));
  }
  @EventHandler
  public void entrar(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    API.ItemSpawn(p);
  }
  
  @EventHandler
  public void entrar(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    e.setQuitMessage("§b[§4-§b] §a" + p.getName());
  }
}
