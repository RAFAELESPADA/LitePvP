package Comandos;

import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Gamemode
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(API.Prefix + "§aComandos apenas no servidor!");
      return true;
    }
    Player player = (Player)sender;
    if (!player.hasPermission("kitpvp.staff"))
    {
      player.sendMessage(API.Prefix + "Voc§ n§o possue permiss§o para isso!");
      return true;
    }
    if (args.length == 0)
    {
      sender.sendMessage(API.Prefix + "Use /gm [gamemode] [player] ou /gm [gamemode]");
      return true;
    }
    if (args.length == 1)
    {
      if (args[0].equalsIgnoreCase("0"))
      {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(API.Prefix + "Seu gamemode foi atualizado para survival.");
      }
      else if (args[0].equalsIgnoreCase("1"))
      {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(API.Prefix + "Seu gamemode foi atualizado para criativo.");
        Bukkit.broadcast(API.Prefix + "§a" + player.getName() + ChatColor.GRAY + " Entrou no gamemode 1!", "kitpvp.staff");
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(API.Prefix + "Seu gamemode foi atualizado para adventure.");
      }
      else
      {
        sender.sendMessage(API.Prefix + "Esse gamemode n§o existe!");
        return true;
      }
      return true;
    }
    if (args.length == 2)
    {
      Player target = Bukkit.getPlayerExact(args[1]);
      if ((target == null) || (!(target instanceof Player)))
      {
        player.sendMessage(API.Prefix + "Jogador n§o encontrado!");
        return true;
      }
      if (args[0].equalsIgnoreCase("0"))
      {
        target.setGameMode(GameMode.SURVIVAL);
        target.sendMessage(API.Prefix + "Voc§ entrou no modo §asurvival.");
        target.sendMessage(API.Prefix + "§a" + target.getName() + " atualizou seu gamemode para survival.");
        Bukkit.broadcast(API.Prefix + "§a" + player.getName() + ChatColor.GRAY + " Atualizou o gamemode de §a" + target.getName() + " para 0 (Survival)", "kitpvp.staff");
      }
      else if (args[0].equalsIgnoreCase("1"))
      {
        target.setGameMode(GameMode.CREATIVE);
        target.sendMessage(API.Prefix + "Voc§ entrou no modo criativo.");
        target.sendMessage(API.Prefix + "§a " + target.getName() + "§7 atualizou seu gamemode para criativo.");
        Bukkit.broadcast(API.Prefix + "§a" + player.getName() + ChatColor.GRAY + " Atualizou o gamemode de §a" + target.getName() + " para 1 (Criativo)", "kitpvp.staff");
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        target.setGameMode(GameMode.ADVENTURE);
        target.sendMessage(API.Prefix + "Voc§ entrou no modo adventure.");
        target.sendMessage(API.Prefix + "§a" + target.getName() + "§7 atualizou seu gamemode para adventure.");
        Bukkit.broadcast(API.Prefix + "§a" + player.getName() + ChatColor.GRAY + " Atualizou o gamemode de §a" + target.getName() + " para 2 (Aventura)", "kitpvp.staff");
      }
      else
      {
        sender.sendMessage(API.Prefix + "Esse gamemode nao existe!");
        return true;
      }
      return false;
    }
    if (args.length > 2)
    {
      sender.sendMessage(API.Prefix + "Use /gm [gamemode] [player] ou /gm [gamemode]");
      return true;
    }
    return false;
  }
}
