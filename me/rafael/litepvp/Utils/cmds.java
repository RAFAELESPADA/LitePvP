package me.rafael.litepvp.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class cmds
  implements Listener
{
  @EventHandler
  private void onCommandb(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (e.getMessage().contains("/me")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
  }
  
  @EventHandler
  private void onCommandc(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (e.getMessage().contains("/ME")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
  }
  
  @EventHandler
  private void onCommandct(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (e.getMessage().contains("/minecraft:me")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
    if (e.getMessage().contains("/Me")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
    if (e.getMessage().contains("/mE")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
  }
  
  @EventHandler
  private void onCommandcttt(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (e.getMessage().contains("/minecraft:ME")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
  }
  
  @EventHandler
  private void onCommandctt(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (e.getMessage().contains("/minecraft:Me")) {
      if (!p.hasPermission("kitpvp.me"))
      {
        e.setCancelled(true);
        p.sendMessage("§cVoce nao tem permissao");
      }
    }
  }
  
  @EventHandler
  private void onCommanda(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if (e.getMessage().equalsIgnoreCase("/kill"))
    {
      e.setCancelled(true);
      p.sendMessage("§cUtilize o /morrer para se matar!");
    }
  }
}
