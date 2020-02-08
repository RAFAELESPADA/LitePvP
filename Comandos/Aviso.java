package Comandos;

import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Aviso
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("aviso"))
    {
      if (sender.hasPermission("kitpvp.aviso"))
      {
        if (args.length == 0)
        {
          sender.sendMessage(String.valueOf(API.Prefix) + " §cSintaxe correta: /aviso (msg)");
          return true;
        }
        String msg = "";
        String[] arrayOfString;
        int j = (arrayOfString = args).length;
        for (int i = 0; i < j; i++)
        {
          String msg2 = arrayOfString[i];
          msg = String.valueOf(String.valueOf(msg)) + msg2 + " ";
        }
        Bukkit.broadcastMessage(String.valueOf(API.Prefix) + ChatColor.RESET + msg.replace("&", "§"));
        return true;
      }
      sender.sendMessage(API.Prefix + "§cVoce nao tem permissao");
    }
    return false;
  }
}
