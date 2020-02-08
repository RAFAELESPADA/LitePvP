package Comandos;

import java.util.Random;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Streak;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetArena
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Sem console");
      return true;
    }
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("setarena")) {
      if (p.hasPermission("kitpvp.staff"))
      {
        if (args.length == 0)
        {
          p.sendMessage(String.valueOf("Sintaxe correta: /setarena (1|7)"));
          return true;
        }
        if (args[0].equalsIgnoreCase("1"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 1"));
          Main.getInstace().arenas.set("arena1.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena1.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena1.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena1.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena1.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena1.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
        if (args[0].equalsIgnoreCase("2"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 2"));
          Main.getInstace().arenas.set("arena2.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena2.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena2.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena2.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena2.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena2.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
        if (args[0].equalsIgnoreCase("3"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 3"));
          Main.getInstace().arenas.set("arena3.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena3.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena3.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena3.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena3.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena3.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
        if (args[0].equalsIgnoreCase("4"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 4"));
          Main.getInstace().arenas.set("arena4.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena4.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena4.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena4.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena4.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena4.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
        if (args[0].equalsIgnoreCase("5"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 5"));
          Main.getInstace().arenas.set("arena5.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena5.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena5.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena5.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena5.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena5.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
        if (args[0].equalsIgnoreCase("6"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 6"));
          Main.getInstace().arenas.set("arena6.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena6.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena6.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena6.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena6.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena6.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
        if (args[0].equalsIgnoreCase("7"))
        {
          p.sendMessage(String.valueOf("§aVoce setou a ARENA 7"));
          Main.getInstace().arenas.set("arena7.x", Double.valueOf(p.getLocation().getX()));
          Main.getInstace().arenas.set("arena7.y", Double.valueOf(p.getLocation().getY()));
          Main.getInstace().arenas.set("arena7.z", Double.valueOf(p.getLocation().getZ()));
          World w = p.getWorld();
          Main.getInstace().arenas.set("arena7.pitch", Float.valueOf(p.getLocation().getPitch()));
          Main.getInstace().arenas.set("arena7.yaw", Float.valueOf(p.getLocation().getYaw()));
          Main.getInstace().arenas.set("arena7.world", p.getLocation().getWorld().getName());
          Main.getInstace().save();
        }
      }
      else
      {
        p.sendMessage("Sem permissao");
      }
    }
    return false;
  }
  
  public static void TeleportArenaRandom(Player p)
  {
    Random dice = new Random();
    int number = dice.nextInt(6);
    switch (number)
    {
    case 0: 
      World w = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena1.world"));
      double x = Main.getInstace().arenas.getDouble("arena1.x");
      double y = Main.getInstace().arenas.getDouble("arena1.y");
      double z = Main.getInstace().arenas.getDouble("arena1.z");
      Location lobby = new Location(w, x, y, z);
      lobby.setPitch((float)Main.getInstace().arenas.getDouble("arena1.pitch"));
      lobby.setYaw((float)Main.getInstace().arenas.getDouble("arena1.yaw"));
      p.getWorld().playEffect(lobby, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby);
      break;
    case 1: 
      World w2 = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena2.world"));
      double x2 = Main.getInstace().arenas.getDouble("arena2.x");
      double y2 = Main.getInstace().arenas.getDouble("arena2.y");
      double z2 = Main.getInstace().arenas.getDouble("arena2.z");
      Location lobby2 = new Location(w2, x2, y2, z2);
      lobby2.setPitch((float)Main.getInstace().arenas.getDouble("arena2.pitch"));
      lobby2.setYaw((float)Main.getInstace().arenas.getDouble("arena2.yaw"));
      p.getWorld().playEffect(lobby2, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby2);
      break;
    case 2: 
      World w3 = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena3.world"));
      double x3 = Main.getInstace().arenas.getDouble("arena3.x");
      double y3 = Main.getInstace().arenas.getDouble("arena3.y");
      double z3 = Main.getInstace().arenas.getDouble("arena3.z");
      Location lobby3 = new Location(w3, x3, y3, z3);
      lobby3.setPitch((float)Main.getInstace().arenas.getDouble("arena3.pitch"));
      lobby3.setYaw((float)Main.getInstace().arenas.getDouble("arena3.yaw"));
      p.getWorld().playEffect(lobby3, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby3);
      break;
    case 3: 
      World w4 = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena4.world"));
      double x4 = Main.getInstace().arenas.getDouble("arena4.x");
      double y4 = Main.getInstace().arenas.getDouble("arena4.y");
      double z4 = Main.getInstace().arenas.getDouble("arena4.z");
      Location lobby4 = new Location(w4, x4, y4, z4);
      lobby4.setPitch((float)Main.getInstace().arenas.getDouble("arena4.pitch"));
      lobby4.setYaw((float)Main.getInstace().arenas.getDouble("arena4.yaw"));
      p.getWorld().playEffect(lobby4, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby4);
      break;
    case 4: 
      World w5 = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena5.world"));
      double x5 = Main.getInstace().arenas.getDouble("arena5.x");
      double y5 = Main.getInstace().arenas.getDouble("arena5.y");
      double z5 = Main.getInstace().arenas.getDouble("arena5.z");
      Location lobby5 = new Location(w5, x5, y5, z5);
      lobby5.setPitch((float)Main.getInstace().arenas.getDouble("arena5.pitch"));
      lobby5.setYaw((float)Main.getInstace().arenas.getDouble("arena5.yaw"));
      p.getWorld().playEffect(lobby5, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby5);
      break;
    case 5: 
      World w6 = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena6.world"));
      double x6 = Main.getInstace().arenas.getDouble("arena6.x");
      double y6 = Main.getInstace().arenas.getDouble("arena6.y");
      double z6 = Main.getInstace().arenas.getDouble("arena6.z");
      Location lobby6 = new Location(w6, x6, y6, z6);
      lobby6.setPitch((float)Main.getInstace().arenas.getDouble("arena6.pitch"));
      lobby6.setYaw((float)Main.getInstace().arenas.getDouble("arena6.yaw"));
      p.getWorld().playEffect(lobby6, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby6);
      break;
    case 6: 
      World w7 = Bukkit.getServer().getWorld(Main.getInstace().arenas.getString("arena7.world"));
      double x7 = Main.getInstace().arenas.getDouble("arena7.x");
      double y7 = Main.getInstace().arenas.getDouble("arena7.y");
      double z7 = Main.getInstace().arenas.getDouble("arena7.z");
      Location lobby7 = new Location(w7, x7, y7, z7);
      lobby7.setPitch((float)Main.getInstace().arenas.getDouble("arena7.pitch"));
      lobby7.setYaw((float)Main.getInstace().arenas.getDouble("arena7.yaw"));
      p.getWorld().playEffect(lobby7, Effect.ENDER_SIGNAL, 5);
      p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      p.teleport(lobby7);
    }
  }
}
