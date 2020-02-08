package me.rafael.litepvp.scoreboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Streak;
import me.rafael.litepvp.Utils.Coins;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardIniciando
{
  public static ArrayList<String> score = new ArrayList();
  
  public static void setScoreBoard(Player player)
  {
    SimpleScoreboard scoreboard = new SimpleScoreboard(API.ScoreTitle);
    
    int k = Main.getInstace().getConfig().getInt("a." + player.getName().toLowerCase() + ".k");
    int d = Main.getInstace().getConfig().getInt("a." + player.getName().toLowerCase() + ".d");
    String jogadoronline = String.valueOf(new StringBuilder("§e").append(Bukkit.getServer().getOnlinePlayers().size()).toString()) + "§7/" + Bukkit.getServer().getMaxPlayers();
    scoreboard.add(" ");
    scoreboard.add(" §7Grupo: " + GetGrupo(player));
    scoreboard.add(" §7Nick: §e" + player.getName());
    scoreboard.add(" §7Coins: §e" + Coins.getCoins(player.getName()));
    scoreboard.add(" §7Jogadores: §e" + jogadoronline);
    scoreboard.add(" §7Rank: " + getRank(player));
    scoreboard.add(" ");
    scoreboard.add(" §7Matou: §e" + k);
    scoreboard.add(" §7Morreu: §e" + d);
    scoreboard.add(" §7Streak: §e" + Streak.killstreak.get(player.getName()));
    scoreboard.build();
    
    scoreboard.send(new Player[] { player });
  }
  
  public static String GetGrupo(Player p)
  {
    if (p.hasPermission("*")) {
      return "§4§lDono";
    }
    if (p.hasPermission("rank.admin")) {
      return "§c§lAdmin";
    }
    if (p.hasPermission("rank.mod")) {
      return "§5§lMod";
    }
    if (p.hasPermission("rank.trialmod")) {
      return "§d§lTrialMod";
    }
    if (p.hasPermission("rank.youtuber+")) {
      return "§3§lYoutuberPlus";
    }
    if (p.hasPermission("rank.youtuber")) {
      return "§b§lYoutuber";
    }
    if (p.hasPermission("rank.builder")) {
      return "§2§lBuilder";
    }
    if (p.hasPermission("rank.pro")) {
      return "§6§lPro";
    }
    if (p.hasPermission("rank.beta")) {
      return "§1§lBeta";
    }
    if (p.hasPermission("rank.mvp")) {
      return "§9§lMvP";
    }
    if (p.hasPermission("rank.vip")) {
      return "§a§lVip";
    }
    if (p.hasPermission("rank.ultra")) {
      return "§d§lUltra";
    }
    if (p.hasPermission("rank.semiyoutuber")) {
      return "§e§lSemiYoutuber";
    }
    if (p.hasPermission("rank.winner")) {
      return "§a§lWinner";
    }
    return "§7§lMembro";
  }
  
  public static String getRank(Player p)
  {
    int a = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".k");
    if (a <= 50.0D) {
      return ChatColor.WHITE + "Unranked";
    }
    if (a <= 200.0D) {
      return ChatColor.GREEN + "Primary";
    }
    if (a <= 400.0D) {
      return ChatColor.YELLOW + "Advanced";
    }
    if (a <= 600.0D) {
      return ChatColor.DARK_BLUE + "Expert";
    }
    if (a <= 800.0D) {
      return ChatColor.GRAY + "Silver";
    }
    if (a <= 1000.0D) {
      return ChatColor.GOLD + "Gold";
    }
    if (a <= 1400.0D) {
      return ChatColor.BLUE + "Diamond";
    }
    if (a <= 1700.0D) {
      return ChatColor.DARK_GREEN + "Emerald";
    }
    if (a <= 2000.0D) {
      return ChatColor.DARK_PURPLE + "Elite";
    }
    if (a <= 2500.0D) {
      return ChatColor.RED + "Master";
    }
    if (a <= 3000.0D) {
      return ChatColor.DARK_RED + "Legendary";
    }
    return ChatColor.DARK_RED + "Legendary";
  }
  
  public static Scoreboard getScoreBoard()
  {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    return board;
  }
  
  public static void clearScoreBoard(Player p)
  {
    Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
    Objective o = score.registerNewObjective("tuts", "PvP");
    o.setDisplaySlot(DisplaySlot.SIDEBAR);
    o.setDisplayName("");
    p.setScoreboard(score);
  }
}
