package Comandos;

import java.util.ArrayList;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report
  implements CommandExecutor
{
  public String[] aliases;
  public String description;
  public static ArrayList<String> reportou = new ArrayList();
  
  public Report()
  {
    this.aliases = new String[] { "report" };
    this.description = "Reportar";
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    if (args.length < 2)
    {
      p.sendMessage(String.valueOf(API.Prefix) + "§cSintaxe correta: /report (nome) (motivo)");
    }
    else if (args.length >= 2)
    {
      Player t = Bukkit.getPlayer(args[0]);
      if (t == null)
      {
        p.sendMessage(API.Prefix + "§cEsse jogador esta offline");
        return true;
      }
      if (t == p)
      {
        p.sendMessage(API.Prefix + "§cVoce nao pode se reportar");
        return true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < args.length; i++) {
        sb.append(args[i]).append(" ");
      }
      String motivo = sb.toString().trim();
      reportou.contains(sender.getName());
      sender.sendMessage(String.valueOf(API.Prefix) + "§bVoc§ reportou: §5" + t.getDisplayName());
      for (Player arrayOfPlayer : Bukkit.getOnlinePlayers())
      {
        Player todos = arrayOfPlayer;
        if (todos.hasPermission("kitpvp.staff"))
        {
          todos.sendMessage("§7-----------§5Report§7-----------");
          todos.sendMessage("§bReporter: §c" + p.getDisplayName());
          todos.sendMessage("§bReportado: §c" + t.getDisplayName());
          todos.sendMessage("§bMotivo: §c" + motivo);
          todos.sendMessage("§7-----------§5Report§7-----------");
          todos.playSound(todos.getLocation(), Sound.ANVIL_LAND, 3.0F, 1.0F);
        }
      }
    }
    return true;
  }
}
