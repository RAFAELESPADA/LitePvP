package me.rafael.litepvp.comandos;

import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Coins;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Stats
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("status"))
    {
      if (args.length == 0)
      {
        int k = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".k");
        int d = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".d");
        p.sendMessage("§b");
        Double coins = Coins.getCoins(p.getName());
        p.sendMessage("4» §b§lSeus status §e" + p.getName());
        p.sendMessage("§bKills §8»§e " + k);
        p.sendMessage("§bDeaths §8»§e " + d);
        p.sendMessage("§bCoins §8»§e " + coins);
        
        p.sendMessage("§b");
      }
      if ((args.length > 0) && (args.length < 2))
      {
        Player t = Bukkit.getServer().getPlayer(args[0]);
        if (t != null)
        {
          Double coins = Coins.getCoins(t.getName());
          p.sendMessage("§b");
          p.sendMessage("4» §b§lStatus de §e" + t.getName());
          int k = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".k");
          int d = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".d");
          p.sendMessage("§bKills §8»§e " + k);
          
          p.sendMessage("§bDeaths §8»§e " + d);
          p.sendMessage("§bCoins §8»§e " + coins);
          
          p.sendMessage("§b");
        }
        return true;
      }
    }
    return false;
  }
}
