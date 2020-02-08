package Comandos;

import me.rafael.litepvp.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Site
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("site"))
    {
      p.sendMessage(Main.getInstace().getConfig().getString("Loja").replace("&", "§"));
      p.playSound(p.getLocation(), Sound.BLAZE_HIT, 12.0F, 12.0F);
    }
    return false;
  }
}
