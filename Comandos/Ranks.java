package Comandos;

import me.rafael.litepvp.api.API;
import me.rafael.litepvp.scoreboard.ScoreboardIniciando;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ranks
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("rank"))
    {
      if (args.length == 0)
      {
        p.sendMessage(String.valueOf(API.Prefix) + "§7Seu rank é: " + ScoreboardIniciando.getRank(p));
        p.sendMessage("§4§lDICA: §fUtilize /rank info para ver todos os ranks");
        return true;
      }
      if ((args.length > 0) && (args.length < 2))
      {
        Player t = Bukkit.getServer().getPlayer(args[0]);
        if (t != null)
        {
          p.sendMessage(String.valueOf(API.Prefix) + "§7O rank de: §5" + t.getDisplayName() + " §7§: " + ScoreboardIniciando.getRank(t));
          return true;
        }
      }
      if (args[0].equalsIgnoreCase("info"))
      {
        p.sendMessage("§9§l§m------§f§l§m------§e§l&oInformaçoes dos ranks§9§l§m------§f§l§m------");
        p.sendMessage("§f§lUnranked: §f0 a 50 kills");
        p.sendMessage("§a§lPrimary: §f50 a 200 kills");
        p.sendMessage("§e§lAdvanced: §f200 a 400 kills");
        p.sendMessage("§1§lExpert: §f400 a 600 kills");
        p.sendMessage("§7§lSilver: §f600 a 800 kills");
        p.sendMessage("§6§lGold: §f800 a 1000 kills");
        p.sendMessage("§b§lDiamond: §f1000 a 1400 kills");
        p.sendMessage("§2§lEmerald: §f1400 a 1700 kills");
        p.sendMessage("§5§lElite: §f1700 a 2000 kills");
        p.sendMessage("§c§lMaster: §f2000 a 2500 kills");
        p.sendMessage("§4§lLegendary: §fUltimo rank");
        p.sendMessage("§9§l§m------§f§l§m------§e§l&oInformaçoes dos ranks§9§l§m------§f§l§m------");
      }
    }
    return false;
  }
}
