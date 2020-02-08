package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class FPvP
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    Player p = (Player)sender;
    ItemStack dima = new ItemStack(Material.STONE_SWORD);
    dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§2Espada Real");
    dima.setItemMeta(souperaa);
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopas.setDisplayName("§6Sopa");
    sopa.setItemMeta(sopas);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("fpvp"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§7» §cVoce ja esta usando um kit!");
        return true;
      }
      if (!Array.warp.contains(p.getName()))
      {
        p.sendMessage("§7» §cVoce precisa estar numa warp!");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7» Voce escolheu o kit §cPvP §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "FpsPvP");
      p.getInventory().addItem(new ItemStack[] { dima });
      Main.give(p);
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
      
      Habilidade.setAbility(p, "PvP");
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit PvP");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
    }
    return false;
  }
}
