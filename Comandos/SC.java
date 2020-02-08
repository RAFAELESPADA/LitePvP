package Comandos;

import me.rafael.litepvp.Main;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SC
  implements Listener, CommandExecutor
{
  private Main main;
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cThis command is only for players!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("sc"))
    {
      if (args.length == 0) {
        sender.sendMessage("§7§ §cUse: §7/sc <message>");
      }
      if (args.length > 0)
      {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
          string.append(args[i] + " ");
        }
        String mensagem = string.toString();
        for (Player arrayOfPlayer : Bukkit.getOnlinePlayers())
        {
          Player staff = arrayOfPlayer;
          if (!sender.hasPermission("kitpvp.staff"))
          {
            sender.sendMessage(API.Prefix + "§cVoce nao tem permissao");
            
            return true;
          }
          if (staff.hasPermission("kitpvp.staff")) {
            staff.sendMessage("§5§LSC §b\u279C §6" + sender.getName() + ": §f" + mensagem);
          }
        }
      }
      return false;
    }
    return false;
  }
}
