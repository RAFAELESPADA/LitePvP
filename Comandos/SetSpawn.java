package Comandos;

import me.rafael.litepvp.Main;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class SetSpawn
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("setspawn"))
    {
      if (!p.hasPermission("set.spawn")) {
        return true;
      }
      Main.getInstace().warps.set("Warps.Spawn.World", p.getLocation().getWorld().getName());
      Main.getInstace().warps.set("Warps.Spawn.X", Double.valueOf(p.getLocation().getX()));
      Main.getInstace().warps.set("Warps.Spawn.Y", Double.valueOf(p.getLocation().getY()));
      Main.getInstace().warps.set("Warps.Spawn.Z", Double.valueOf(p.getLocation().getZ()));
      Main.getInstace().warps.set("Warps.Spawn.Pitch", Float.valueOf(p.getLocation().getPitch()));
      Main.getInstace().warps.set("Warps.Spawn.Yaw", Float.valueOf(p.getLocation().getYaw()));
      Main.getInstace().save();
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      p.sendMessage("§7§ §aSpawn setado!");
    }
    if (cmd.getName().equalsIgnoreCase("spawn"))
    {
      World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.Spawn.World"));
      double x = Main.getInstace().warps.getDouble("Warps.Spawn.X");
      double y = Main.getInstace().warps.getDouble("Warps.Spawn.Y");
      double z = Main.getInstace().warps.getDouble("Warps.Spawn.Z");
      Location lobby = new Location(w, x, y, z);
      lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.Spawn.Pitch"));
      lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.Spawn.Yaw"));
      p.teleport(lobby);
      Main.TirarEfeitos(p);
      p.getInventory().clear();
      ItemStack kits = new ItemStack(Material.CHEST);
      ItemMeta kits2 = kits.getItemMeta();
      kits2.setDisplayName("§4» Kits");
      kits.setItemMeta(kits2);
      ItemStack day = new ItemStack(Material.DAYLIGHT_DETECTOR);
      ItemMeta day2 = day.getItemMeta();
      day2.setDisplayName("§e» Menu");
      day.setItemMeta(day2);
      
      ItemStack warps = new ItemStack(Material.PAPER);
      ItemMeta warps2 = warps.getItemMeta();
      warps2.setDisplayName("§c» Warps");
      warps.setItemMeta(warps2);
      ItemStack FRAME = new ItemStack(Material.ENDER_PORTAL_FRAME);
      ItemMeta FRAME2 = FRAME.getItemMeta();
      FRAME2.setDisplayName("§a» Loja");
      FRAME.setItemMeta(FRAME2);
      ItemStack treino = new ItemStack(Material.REDSTONE_COMPARATOR);
      ItemMeta treino2 = treino.getItemMeta();
      treino2.setDisplayName("§9» Treinos");
      treino.setItemMeta(treino2);
      
      p.getInventory().setItem(0, warps);
      p.getInventory().setItem(2, FRAME);
      p.getInventory().setItem(4, kits);
      p.getInventory().setItem(6, day);
      p.getInventory().setItem(8, treino);
      TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), "§aVoce voltou pro spawn");
      p.sendMessage("§aVoce voltou pro spawn");
    }
    return false;
  }
}
