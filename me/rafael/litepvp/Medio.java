package me.rafael.litepvp;

import me.rafael.litepvp.Utils.Coins;
import me.rafael.litepvp.api.API;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Medio
  implements Listener
{
  private Medio plugin;
  
  public Medio(Medio instance)
  {
    this.plugin = instance;
  }
  
  public Medio() {}
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("Medio"))
    {
      e.setLine(0, "§eChallenge");
      e.setLine(1, "§cRecompensa");
      e.setLine(2, "§cLV Medio");
      e.setLine(3, "§eClique aqui");
    }
  }
  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      String[] lines = s.getLines();
      if ((lines.length > 0) && (lines[0].equals("§eChallenge")) && 
        (lines.length > 1) && (lines[1].equals("§cRecompensa")) && 
        (lines.length > 2) && (lines[2].equals("§cLV Medio")) && 
        (lines.length > 3) && (lines[3].equals("§eClique aqui")))
      {
        Coins.addCoins(p.getName(), 700.0D);
        p.sendMessage("§aVoce ganhou 700 de xp por passar");
        p.sendMessage("§cO Nivel Medio do challenge");
        
API.ItemSpawn(p);
        TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), "§aVoce voltou pro spawn");
        p.sendMessage(API.Prefix + "§aVoce voltou pro spawn");
      }
    }
  }
}
