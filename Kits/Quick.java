package Kits;

import Comandos.SetArena;
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
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Quick
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    Player p = (Player)sender;
    ItemStack dima = new ItemStack(Material.STONE_SWORD);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§cEspada");
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
    if (cmd.equalsIgnoreCase("quickdropper"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.quickdropper"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7Voce escolheu o kit §cQuickdropper §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "QuickDropper");
      Habilidade.setAbility(p, "QuickDropper");
      p.getInventory().addItem(new ItemStack[] { dima });
      Main.stomper.remove(p.getName());
      Main.give(p);
      Main.Dj.remove(p.getName());
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Quickdropper");
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
