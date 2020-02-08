package Comandos;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vip
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("vip"))
    {
      p.sendMessage("§a§l§m------§f§l§m------§a§l§m------§f§l§m------");
      p.sendMessage("");
      p.sendMessage("§e§lVANTAGENS DE SER VIP");
      p.sendMessage("");
      p.sendMessage("§b§lTem mais kits que player normal §a§l(O §6§lPro para cima tem todos os kits)");
      p.sendMessage("§b§lNao tem cooldown ao usar placa de sopa/recraft");
      p.sendMessage("§b§lTem os skype dos donos");
      p.sendMessage("§b§lTem a tag diferenciada (dependendo do vip que voce comprar)");
      p.sendMessage("§b§lPode falar colorido no chat");
      p.sendMessage("§b§lTem privilegio nos eventos");
      p.sendMessage("§b§lTem mais chance de virar staff");
      p.sendMessage("§b§lPode falar com o chat mutado");
      p.sendMessage("§b§lTem acesso as cabe§as");
      p.sendMessage("§b§lPodera voar (So ultra para cima pode voar)");
      
      p.sendMessage("");
      p.sendMessage("§a§l§m------§f§l§m------§a§l§m------§f§l§m------");
      p.playSound(p.getLocation(), Sound.CLICK, 12.0F, 12.0F);
    }
    return false;
  }
}
