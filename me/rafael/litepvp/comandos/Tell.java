package me.rafael.litepvp.comandos;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tell
  implements CommandExecutor, Listener
{
  public static HashMap<Player, Player> gettell = new HashMap();
  static ArrayList<Player> telloff = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("tell"))
    {
      if (args.length == 0)
      {
        p.sendMessage(String.valueOf("§cSintaxe correta /tell (nome) (msg)"));
        return true;
      }
      Player target = Bukkit.getPlayer(args[0]);
      if (args[0].toLowerCase().equalsIgnoreCase("on"))
      {
        telloff.remove(p);
        p.sendMessage(String.valueOf("§7Voc§ §bativou §7seu tell"));
      }
      else if (args[0].toLowerCase().equalsIgnoreCase("off"))
      {
        telloff.add(p);
        p.sendMessage(String.valueOf("§7Voc§ §bdesativou §7seu tell"));
      }
      if (args.length > 1)
      {
        if (target == null)
        {
          p.sendMessage("§cEsse jogador esta offline");
          return true;
        }
        if (telloff.contains(target))
        {
          p.sendMessage(String.valueOf("§cO tell desse player esta off"));
          return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
          sb.append(args[i]).append(" ");
        }
        String allArgs = sb.toString().trim();
        p.sendMessage("§7[§aEu§r --> §a" + target.getDisplayName() + "§7]§f: " + allArgs);
        target.sendMessage("§7[§a" + p.getDisplayName() + " §f--> §aEu§7]§f: " + allArgs);
        gettell.put(p, target);
        gettell.put(target, p);
      }
    }
    else if (label.equalsIgnoreCase("off"))
    {
      if (args.length == 0)
      {
        p.sendMessage(String.valueOf("§7fale com o player no chat normal"));
        return true;
      }
      if (!gettell.containsKey(p))
      {
        p.sendMessage(String.valueOf("§7Voce nao tem ninguem para responder"));
        return true;
      }
      Player deslogo = (Player)gettell.get(p);
      if (deslogo == null)
      {
        p.sendMessage("§cEsse jogador nao esta online");
        return true;
      }
      if (telloff.contains(deslogo))
      {
        p.sendMessage(String.valueOf("§cO tell desse player esta off"));
        return true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < args.length; i++) {
        sb.append(args[i]).append(" ");
      }
      String allArgs = sb.toString().trim();
      p.sendMessage("§7[§aEu§r --> §a" + deslogo.getDisplayName() + "§7]§f: " + allArgs);
      deslogo.sendMessage("§7[§a" + p.getDisplayName() + " §f--> §aEu§7]§f: " + allArgs);
    }
    return false;
  }
}
