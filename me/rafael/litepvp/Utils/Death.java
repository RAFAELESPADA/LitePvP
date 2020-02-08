package me.rafael.litepvp.Utils;

import java.util.List;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.api.API;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Death
  implements Listener
{
  @EventHandler
  public void Matança(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if ((e.getEntity().getKiller() instanceof Player))
    {
      Player t = p.getKiller();
      int d = Main.getInstace().getConfig().getInt("a." + p.getName().toLowerCase() + ".d");
      
      Main.getInstace().getConfig().set("a." + p.getName().toLowerCase() + ".d", Integer.valueOf(d + 1));
      
      int k = Main.getInstace().getConfig().getInt("a." + t.getName().toLowerCase() + ".k");
      
      Main.getInstace().getConfig().set("a." + t.getName().toLowerCase() + ".k", Integer.valueOf(k + 1));
      Main.getInstace().saveConfig();
      Habilidade.removeAbility(p);
      Main.TirarEfeitos(p);
      e.setDeathMessage(null);
      Coins.addCoins(t.getName(), 100.0D);
      Coins.removeCoins(p.getName(), 50.0D);
      Coins.saveCoins();
      Coins.loadCoins();
      TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(20), "§c§lVoce morreu", "§c§lPor: " + t.getName());
      p.sendMessage("§c§lVoce morreu para " + t.getDisplayName());
      p.sendMessage("");
      p.sendMessage("§c§lSe voce nao recebeu seus itens");
      p.sendMessage("§c§lDigite /spawn");
      t.sendMessage("§a§lVoce matou " + p.getDisplayName());
      t.playSound(t.getLocation(), Sound.LEVEL_UP, 3.0F, 1.0F);      
      Main.TirarEfeitos(p);
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
      
      p.getInventory().setArmorContents(null);
      p.teleport(p.getWorld().getSpawnLocation());
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().setItem(0, warps);
      p.getInventory().setItem(2, FRAME);
      p.getInventory().setItem(4, kits);
      p.getInventory().setItem(6, day);
      p.getInventory().setItem(8, treino);
      p.updateInventory();
    }
    else
    {
      TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(20), "§c§lVoce morreu", "");
      p.sendMessage("§7Voce morreu sozinho");
      p.sendMessage("");
      p.sendMessage("§c§lSe voce nao recebeu seus itens");
      p.sendMessage("§c§lDigite /spawn");
      API.ItemSpawn(p);
    }
  }
}
