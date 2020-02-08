package Comandos;

import java.util.ArrayList;
import me.rafael.litepvp.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BUILD
  implements Listener, CommandExecutor
{
  public static ArrayList<Player> embuild = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("build")) {
      if (p.hasPermission("kitpvp.staff"))
      {
        if (args.length == 0)
        {
          if (!embuild.contains(p))
          {
            embuild.add(p);
            p.sendMessage(String.valueOf(API.Prefix) + "§aVoce ativou seu modo build");
          }
          else
          {
            embuild.remove(p);
            p.sendMessage(String.valueOf(API.Prefix) + "§cVoce desativou seu modo build");
          }
        }
        else
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t == null)
          {
            p.sendMessage(API.Prefix + "§cJogador offline");
            return true;
          }
          if (!embuild.contains(t))
          {
            embuild.add(t);
            p.sendMessage(String.valueOf(API.Prefix) + "§aVoce ativou o modo build de: §7" + t.getName());
          }
          else
          {
            embuild.remove(t);
            p.sendMessage(String.valueOf(API.Prefix) + "§cVoce desativou o modo build de: §7" + t.getName());
          }
        }
      }
      else {
        p.sendMessage(String.valueOf(API.Prefix) + "§cSem permissao");
      }
    }
    return false;
  }
  
  @EventHandler
  public void aoconstruir(BlockPlaceEvent e)
  {
    Player p = e.getPlayer();
    if (!embuild.contains(p)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void aoconstruir(BlockBreakEvent e)
  {
    Player p = e.getPlayer();
    if (!embuild.contains(p)) {
      e.setCancelled(true);
    }
  }
}
