package Comandos;

import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TeleportAll
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (!p.hasPermission("kitpvp.tpall"))
    {
      p.sendMessage(API.Prefix + "Voce nao possue permissao para isso!");
      return true;
    }
    for (Player p2 : Bukkit.getOnlinePlayers()) {
      if (p2 != p)
      {
        p2.teleport(p);
        p2.sendMessage("§7§ §c" + p.getName() + " puxou todos ate ele !");
      }
    }
    p.sendMessage("§7§ §aTodos os jogadores agora estao na sua localizacao !");
    return false;
  }
}
