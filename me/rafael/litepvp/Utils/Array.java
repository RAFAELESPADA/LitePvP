package me.rafael.litepvp.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Array
{
  public static String monkCooldownMessage = "§cVoce pode monkar denovo em %s segundos!";
  public String monkedMessage = "§cVoce usou o poder monk !";
  public static int cooldownmonk = 15;
  public static int monkItemId = Material.BLAZE_ROD.getId();
  public static boolean sendThroughInventory = true;
  public static transient HashMap<ItemStack, Long> monkStaff = new HashMap();
  public static ArrayList<String> admin = new ArrayList();
  public static ArrayList<String> report = new ArrayList();
  public static ArrayList<String> used = new ArrayList();
  public static ArrayList<String> warp = new ArrayList();
  public static ArrayList<String> Velotrol2 = new ArrayList();
  public static ArrayList<String> freeze = new ArrayList();
  public static ArrayList<String> freezing = new ArrayList();
  public static HashMap<Player, String> kit = new HashMap();
  
  public static String getShortStr(String name)
  {
    if (name.length() >= 16)
    {
      String shorts = name.substring(0, 13);
      return shorts;
    }
    if (name.length() >= 15)
    {
      String shorts = name.substring(0, 13);
      return shorts;
    }
    return name;
  }
  
  public static String getShortTagMod(String name)
  {
    if (name.length() >= 16)
    {
      String shorts = name.substring(0, 12);
      return shorts;
    }
    if (name.length() >= 15)
    {
      String shorts = name.substring(0, 12);
      return shorts;
    }
    if (name.length() >= 14)
    {
      String shorts = name.substring(0, 12);
      return shorts;
    }
    if (name.length() >= 13)
    {
      String shorts = name.substring(0, 12);
      return shorts;
    }
    return name;
  }
}
