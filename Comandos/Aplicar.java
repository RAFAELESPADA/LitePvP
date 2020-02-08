package Comandos;

import me.rafael.litepvp.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Aplicar
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("aplicar"))
    {
      p.sendMessage("§e§lSite do form §c§l" + Main.getInstace().getConfig().getString("Formulario").replace("&", "§"));
      p.playSound(p.getLocation(), Sound.BLAZE_HIT, 12.0F, 12.0F);
    }
    return false;
  }
}
