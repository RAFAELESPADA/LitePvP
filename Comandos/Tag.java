package Comandos;

import java.util.HashMap;
import me.rafael.litepvp.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.nametagedit.plugin.NametagEdit;
import com.nametagedit.plugin.api.INametagApi;

public class Tag
  implements CommandExecutor
{
  
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tag"))
    {
      if (args.length == 0)
      {
        if (p.hasPermission("*"))
        {
          p.sendMessage(
            "§7Suas Tags: §7(§7Normal | §eGravador§7 | §aWinner§7 | §9MvP §7| §2Vip §7| §6Pro §7| §dUltra §7| §1Beta §7| §eSemiYoutuber §7| §bYoutuber §7| §bYoutuber+ §7| §2Builder §7| §dTrial §7| §5Mod | §5Mod+ §7| §cAdmin §7| §4Dono§7)");
          return true;
        }
        if (p.hasPermission("Tag.Admin"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro §7| §eSemiYoutuber §7| §bYoutuber §7| §bYoutuber+ | §dUltra | §2Builder §7 §7| §dTrial §7| §5Mod §7| §cAdmin§7)");
          return true;
        }
        if (p.hasPermission("Tag.sm"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §3SM§7)");
          return true;
        }
        if (p.hasPermission("Tag.Mod+"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro §7| §dTrial §7| §5Mod §7| §5Mod+§7)");
          return true;
        }
        if (p.hasPermission("Tag.Mod"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro §7| §dTrial §7| §5Mod§7)");
          return true;
        }
        if (p.hasPermission("Tag.Trial"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal §7| §9MvP §7| §2Vip §7| §6Pro §7| §dTrial§7)");
          return true;
        }
        if (p.hasPermission("Tag.Youtuber+"))
        {
          p.sendMessage(
            "§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro §7| §eSemiYoutuber §7| §bYoutuber+ §7| §bYoutuber§7)");
          return true;
        }
        if (p.hasPermission("Tag.Youtuber"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro §7| §eSemiYoutuber §7| §bYoutuber§7)");
          return true;
        }
        if (p.hasPermission("Tag.Builder"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro §7| §2Builder");
          return true;
        }
        if (p.hasPermission("Tag.Ultra"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro§7 | §dUltra§7)");
          return true;
        }
        if (p.hasPermission("Tag.Pro"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro§7)");
          return true;
        }
        if (p.hasPermission("Tag.gravador"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §eGravador)");
          return true;
        }
        if (p.hasPermission("Tag.Beta"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §9MvP §7| §2Vip §7| §6Pro§7 | §1Beta§7)");
          return true;
        }
        if (p.hasPermission("Tag.Winner"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §aWinner§7)");
          return true;
        }
        if (p.hasPermission("Tag.SemiYoutuber"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §eSemiYoutuber");
          return true;
        }
        if (p.hasPermission("Tag.Vip"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal §7| §2Vip§7)");
          return true;
        }
        if (p.hasPermission("Tag.MvP"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal | §2Vip§7 §7| §9MvP§7)");
          return true;
        }
        if (p.hasPermission("Tag.Normal"))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal§7)");
          return true;
        }
        if ((!p.hasPermission("Tag.Normal")) && (!p.hasPermission("Tag.MvP")) && (!p.hasPermission("Tag.Pro")) && (!p.hasPermission("Tag.Vip")) && (!p.hasPermission("Tag.Youtuber")) && (!p.hasPermission("Tag.Ultra")) && (!p.hasPermission("Tag.Beta")) && (!p.hasPermission("Tag.Trial")) && (!p.hasPermission("Tag.SemiYoutuber")))
        {
          p.sendMessage("§7Suas Tags: §7(§7Normal§7)");
          return true;
        }
      }
      if ((args[0].equalsIgnoreCase("dono")) && (p.hasPermission("tag.dono")))
      {
        
        p.setDisplayName("§4[DONO] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§4[DONO] ");
        p.setPlayerListName("§4[DONO] " + p.getName());
        
        p.sendMessage(API.Prefix + "Voce esta usando a tag §4§lDONO");
      }
      else if ((args[0].equalsIgnoreCase("admin")) && (p.hasPermission("tag.admin")))
      {
        
        p.setDisplayName("§c[ADMIN] " + p.getName());
        p.setPlayerListName("§c[ADMIN] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§c[ADMIN] ");
        p.sendMessage(API.Prefix + "Voce esta usando a tag §c§lADMIN");
      }
      else if ((args[0].equalsIgnoreCase("winner")) && (p.hasPermission("tag.winner")))
      {
 
        p.setDisplayName("§a[WINNER] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§a[WINNER] ");
        p.setPlayerListName("§a[WINNER] " + p.getName());
        p.sendMessage(API.Prefix + "Voce esta usando a tag §a§lWinner");
      }
      else if ((args[0].equalsIgnoreCase("beta")) && (p.hasPermission("tag.beta")))
      {
        p.setDisplayName("§1[BETA] " + p.getName());
        p.setPlayerListName("§1[BETA] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§1[BETA] ");
        p.sendMessage(API.Prefix + "Voce esta usando a tag §1§lBETA");
      }
      else if ((args[0].equalsIgnoreCase("mod+")) && (p.hasPermission("tag.mod+")))
      {
        p.setDisplayName("§5[MOD+] " + p.getName());
        p.setPlayerListName("§5[MOD+] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§5[MOD+] ");
        p.sendMessage(API.Prefix + "Voce esta usando a tag §5§lMOD+");
      }
      else if ((args[0].equalsIgnoreCase("semiyoutuber")) && (p.hasPermission("tag.semiyoutuber")))
      {
        p.setDisplayName("§e[SEMIYT] " + p.getName());
        p.setPlayerListName("§e[SEMIYT] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§e[SEMIYT] ");
        p.sendMessage(API.Prefix + "Voce esta usando a tag §e§lSEMIYT");
      }
      else if ((args[0].equalsIgnoreCase("ultra")) && (p.hasPermission("tag.ultra")))
      {

        p.setDisplayName("§d[ULTRA] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§d[ULTRA] ");
        p.setPlayerListName("§d[ULTRA] " + p.getName());
        p.sendMessage(API.Prefix + "Voce esta usando a tag §d§lULTRA");
      }
      else if ((args[0].equalsIgnoreCase("mod")) && (p.hasPermission("tag.mod")))
      {
    	  p.setDisplayName("§5[MOD] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§5[MOD] ");
          p.setPlayerListName("§5[MOD] " + p.getName());
          p.sendMessage(API.Prefix + "Voce esta usando a tag §5§lMOD");
      }
      else if ((args[0].equalsIgnoreCase("builder")) && (p.hasPermission("tag.builder")))
      {
    	  p.setDisplayName("§2[BUILDER] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§2[BUILDER] ");
          p.setPlayerListName("§2[BUILDER] " + p.getName());
          p.sendMessage(API.Prefix + "Voce esta usando a tag §2§lBUILDER");
      }
      else if ((args[0].equalsIgnoreCase("trial")) && (p.hasPermission("tag.trial")))
      {
    	  p.setDisplayName("§d[TRIAL] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§d[TRIAL] ");
          p.setPlayerListName("§d[TRIAL] " + p.getName());
        p.sendMessage(API.Prefix + "Voce esta usando a tag §d§lTRIALMOD");
      }
      else if ((args[0].equalsIgnoreCase("gravador")) && (p.hasPermission("tag.gravador")))
      {
        p.setDisplayName("§e[GRAVADOR] " + p.getName());
        NametagEdit.getApi().setPrefix(p.getName(), "§e[GRAVADOR] ");
        p.sendMessage(API.Prefix + "Voce esta usando a tag §e§lGRAVADOR");
        p.setPlayerListName("§e[GRAVADOR] " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("pro")) && (p.hasPermission("tag.pro")))
      {
    	  p.setDisplayName("§6[PRO] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§6[PRO] ");
          p.sendMessage(API.Prefix + "Voce esta usando a tag §6§lPRO");
          p.setPlayerListName("§6[PRO] " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("youtuber")) && (p.hasPermission("tag.youtuber")))
      {
    	  p.setDisplayName("§b[YT] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§b[YT] ");
          p.sendMessage(API.Prefix + "Voce esta usando a tag §b§lYT");
          p.setPlayerListName("§b[YT] " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("youtuber+")) && (p.hasPermission("tag.youtuber+")))
      {
    	  p.setDisplayName("§3[YT+] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§3[YT+] ");
          p.sendMessage(API.Prefix + "Voce esta usando a tag §3§lYOUTUBER+");
          p.setPlayerListName("§3[YT+] " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("vip")) && (p.hasPermission("tag.vip")))
      {
    	  p.setDisplayName("§a[VIP] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§a[VIP] ");
          p.sendMessage(API.Prefix + "Voce esta usando a tag §a§lVIP");
          p.setPlayerListName("§a[VIP] " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("mvp")) && (p.hasPermission("tag.mvp")))
      {
    	  p.setDisplayName("§9[MVP] " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§9[MVP] ");
          p.sendMessage(API.Prefix + "Voce esta usando a tag §9§lMVP");
          p.setPlayerListName("§9[MVP] " + p.getName());
      }
      else if (args[0].equalsIgnoreCase("normal"))
      {
    	  p.setDisplayName("§7" + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§7");
          p.sendMessage(API.Prefix + "Voce esta usando a tag §7§lNORMAL");
          p.setPlayerListName("§7" + p.getName());
      }
    }
    return false;
  }
}
