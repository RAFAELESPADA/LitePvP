package Comandos;

import java.util.List;
import me.rafael.litepvp.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Youtuber
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("youtuber"))
    {
      List<String> list = Main.plugin.getConfig().getStringList("BLOCKED_COMMANDS");
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG1").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG2").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG3").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG4").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG5").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG6").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG7").replace("&", "§"));
      p.sendMessage(Main.getInstace().getConfig().getString("YTMSG8").replace("&", "§"));
    }
    return false;
  }
}
