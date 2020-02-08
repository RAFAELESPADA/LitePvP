package Comandos;

import me.rafael.litepvp.Main;
import me.rafael.litepvp.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Morrer
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("morrer"))
    {
      p.setHealth(0.0D);
      Main.TirarEfeitos(p);
      p.sendMessage(String.valueOf(API.Prefix + "§4§lVoce se matou!"));
      API.ItemSpawn(p);
    }
    return false;
  }
}
