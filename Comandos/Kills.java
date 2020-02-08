package Comandos;

import me.rafael.litepvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Kills
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("kills"))
    {
      Player player = (Player)sender;
      if (!player.hasPermission("kitpvp.givekills"))
      {
        player.sendMessage("§7[§cKitPvP§7] §eSem permissao!");
        return true;
      }
      if (args.length < 3)
      {
        sender.sendMessage("§cUse: /kills give/remove <Player> <Quantia>");
        return true;
      }
      int tanto = Integer.valueOf(args[2]).intValue();
      Player t = Bukkit.getPlayer(args[1]);
      if (args[0].equalsIgnoreCase("give"))
      {
        int k = Main.plugin.getConfig().getInt("a." + player.getName().toLowerCase() + ".k");
        try
        {
          Main.plugin.getConfig().set("a." + t.getName().toLowerCase() + ".k", Integer.valueOf(tanto + k));
          sender.sendMessage("§aVoce deu " + tanto + " Kills para o jogador " + t.getName());
          t.sendMessage("§e" + tanto + " §aKills has been added to your account!");
          Main.getInstace().saveConfig();
        }
        catch (Exception e)
        {
          sender.sendMessage("§cUse apenas numeros!");
        }
      }
      else
      {
        sender.sendMessage("§cUse /kills give <Player> <Quantia>");
      }
      if (args[0].equalsIgnoreCase("remove"))
      {
        int k = Main.plugin.getConfig().getInt("a." + player.getName().toLowerCase() + ".k");
        try
        {
          Main.plugin.getConfig().set("a." + t.getName().toLowerCase() + ".kills", Integer.valueOf(k - tanto));
          sender.sendMessage("§aVoce removeu " + tanto + " Kills do player " + t.getName());
          t.sendMessage("§e" + tanto + " §aKills foi removido da sua conta!");
          Main.getInstace().saveConfig();
        }
        catch (Exception e)
        {
          sender.sendMessage("§cUse apenas numeros!");
        }
      }
      else
      {
        sender.sendMessage("§cUse /kills remove <Player> <Quantia>");
      }
    }
    return false;
  }
}
