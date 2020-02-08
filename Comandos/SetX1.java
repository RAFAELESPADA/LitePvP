package Comandos;

import me.rafael.litepvp.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetX1
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("This command is only for players =)");
      return true;
    }
    Player p = (Player)sender;
    if (!p.hasPermission("kitpvp.set1v1"))
    {
      p.sendMessage("§cYou dont have the permission kitpvp.set1v1");
      return true;
    }
    Location loc = p.getLocation();
    Double x = Double.valueOf(loc.getX());
    Double y = Double.valueOf(loc.getY());
    Double z = Double.valueOf(loc.getZ());
    Float yaw = Float.valueOf(loc.getYaw());
    Float pitch = Float.valueOf(loc.getPitch());
    if (args.length == 0)
    {
      p.sendMessage("§cUse /set1v1 <spawn/loc1/loc2>");
      return true;
    }
    if (args[0].equalsIgnoreCase("spawn"))
    {
      Main.getInstace().warps.set("x1.coords.spawn.x", x);
      Main.getInstace().warps.set("x1.coords.spawn.y", y);
      Main.getInstace().warps.set("x1.coords.spawn.z", z);
      Main.getInstace().warps.set("x1.coords.spawn.yaw", yaw);
      Main.getInstace().warps.set("x1.coords.spawn.pitch", pitch);
      Main.getInstace().save();
      p.sendMessage("§cSetted");
      return true;
    }
    if (args[0].equalsIgnoreCase("loc1"))
    {
      Main.getInstace().warps.set("x1.coords.loc_1.x", x);
      Main.getInstace().warps.set("x1.coords.loc_1.y", y);
      Main.getInstace().warps.set("x1.coords.loc_1.z", z);
      Main.getInstace().warps.set("x1.coords.loc_1.yaw", yaw);
      Main.getInstace().warps.set("x1.coords.loc_1.pitch", pitch);
      Main.getInstace().save();
      p.sendMessage("§cSetted");
      return true;
    }
    if (args[0].equalsIgnoreCase("loc2"))
    {
      Main.getInstace().warps.set("x1.coords.loc_2.x", x);
      Main.getInstace().warps.set("x1.coords.loc_2.y", y);
      Main.getInstace().warps.set("x1.coords.loc_2.z", z);
      Main.getInstace().warps.set("x1.coords.loc_2.yaw", yaw);
      Main.getInstace().warps.set("x1.coords.loc_2.pitch", pitch);
      Main.getInstace().save();
      p.sendMessage("§cSetted");
      return true;
    }
    p.sendMessage("§cUse /set1v1 <spawn/loc1/loc2>");
    
    return false;
  }
}
