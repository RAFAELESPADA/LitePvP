package me.rafael.litepvp.Utils;

import me.rafael.litepvp.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Motd
  implements Listener
{
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPing(ServerListPingEvent e)
  {
    e.setMotd(Main.getInstace().getConfig().getString("MotdLine1").replace("&", "§") + "\n" + Main.getInstace().getConfig().getString("MotdLine2").replace("&", "§"));
  }
}
