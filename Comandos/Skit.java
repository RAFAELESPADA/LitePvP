package Comandos;

import java.util.HashMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Skit
  implements Listener, CommandExecutor
{
  public HashMap<String, ItemStack[]> kit = new HashMap();
  public HashMap<String, ItemStack[]> armadura = new HashMap();
  
  public boolean isInt(String s)
  {
    try
    {
      Integer.parseInt(s);
      return true;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return false;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("skit")) && 
      (p.hasPermission("kitpvp.skit")))
    {
      if (args.length == 0)
      {
        p.sendMessage("§7» §cUse /skit criar|aplicar [nome]|[raio]");
        return true;
      }
      if (args[0].equalsIgnoreCase("criar"))
      {
        if (args.length == 1)
        {
          p.sendMessage("§7» §cUse /skit criar [nome]");
          return true;
        }
        String name = args[1];
        this.kit.put(name, p.getInventory().getContents());
        this.armadura.put(name, p.getInventory().getArmorContents());
        p.sendMessage("§7» §aKit " + args[1] + " §acriado com sucesso!");
        return true;
      }
      if (args[0].equalsIgnoreCase("aplicar"))
      {
        if (args.length <= 2)
        {
          p.sendMessage("§7» §cUse /skit aplicar [kits] [distancia]");
          return true;
        }
        String name = args[1];
        if ((!this.kit.containsKey(name)) && (!this.armadura.containsKey(name)))
        {
          p.sendMessage("§7» §cKit " + name + " nao encontrado!");
          return true;
        }
        if (isInt(args[2]))
        {
          int numero = Integer.parseInt(args[2]);
          for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
            if ((ent instanceof Player))
            {
              Player plr = (Player)ent;
              plr.getInventory().setArmorContents((ItemStack[])this.armadura.get(name));
              plr.getInventory().setContents((ItemStack[])this.kit.get(name));
            }
          }
          p.sendMessage("§7» §aKit " + name + " aplicado para jogadores em um raio de " + numero + " blocos");
          return true;
        }
      }
    }
    return true;
  }
}
