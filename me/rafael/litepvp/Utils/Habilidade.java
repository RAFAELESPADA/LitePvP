package me.rafael.litepvp.Utils;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class Habilidade
{
  public static Map<String, String> powerMap = new HashMap();
  
  public static String NomeDoKit(String original)
  {
    if (original.length() == 0) {
      return original;
    }
    return String.valueOf(original.substring(0, 1).toUpperCase()) + original.substring(1);
  }
  
  public static String getAbility(Player player)
  {
    if (!powerMap.containsKey(player.getName())) {
      powerMap.put(player.getName(), "Nenhum");
    }
    return (String)powerMap.get(player.getName());
  }
  
  public static void setAbility(Player player, String ability)
  {
    powerMap.put(player.getName(), ability);
  }
  
  public static void removeAbility(Player p)
  {
    powerMap.remove(p.getName());
  }
  
  public static boolean ContainsAbility(Player player)
  {
    if (getAbility(player) != "None") {
      return true;
    }
    return false;
  }
}
