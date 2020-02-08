package Kits;

import Comandos.SetArena;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ThorCMD
  implements CommandExecutor
{
  private Main main;
  static Main plugin;
  
  public ThorCMD(Main main)
  {
    this.main = main;
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("kthor"))
    {
      if (!p.hasPermission("kitpvp.kit.thor"))
      {
        p.sendMessage("§cSem permissao");
        return true;
      }
      if (Habilidade.ContainsAbility(p))
      {
        p.sendMessage(String.valueOf("§cVoce ja escolheu um kit"));
        
        return true;
      }
      p.getInventory().clear();
      ItemStack dima = new ItemStack(Material.STONE_SWORD);
      ItemMeta souperaa = dima.getItemMeta();
      souperaa.setDisplayName("§cEspada");
      dima.setItemMeta(souperaa);
      ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
      ItemMeta sopas = sopa.getItemMeta();
      sopas.setDisplayName("§6Sopa");
      sopa.setItemMeta(sopas);
      ItemStack especial = new ItemStack(Material.GOLD_AXE);
      ItemMeta especial2 = especial.getItemMeta();
      especial2.setDisplayName("§cThor Axe!");
      especial.setItemMeta(especial2);
      
      ItemStack capacete0 = new ItemStack(Material.AIR);
      
      ItemStack peitoral0 = new ItemStack(Material.AIR);
      
      ItemStack calca0 = new ItemStack(Material.AIR);
      
      ItemStack Bota0 = new ItemStack(Material.AIR);
      
      p.getInventory().setHelmet(capacete0);
      p.getInventory().setChestplate(peitoral0);
      p.getInventory().setLeggings(calca0);
      p.getInventory().setBoots(Bota0);
      
      p.sendMessage("§cVoce escolheu o kit thor");
      Habilidade.setAbility(p, "Thor");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lVoce escolheu", "§f§lO kit Thor");
      
      SetArena.TeleportArenaRandom(p);
      for (int i = 0; i <= 34; i++)
      {
        p.getInventory().addItem(new ItemStack[] { sopa });
      }
      SetArena.TeleportArenaRandom(p);
    }
    return false;
  }
}
