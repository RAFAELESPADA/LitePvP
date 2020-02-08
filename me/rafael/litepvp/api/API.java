package me.rafael.litepvp.api;

import java.util.Random;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.titleapi.TitleAPI;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class API
{
  public static String Prefix = Main.getInstace().getConfig().getString("Prefix").replace("&", "§") + " §7» ";
  public static String rawPrefix = Main.getInstace().getConfig().getString("Prefix").replace("&", "§");
  public static String ScoreTitle = Main.getInstace().getConfig().getString("ScoreTitle").replace("&", "§");
  
  public static void BroadCast(String msg)
  {
    Bukkit.getServer().broadcastMessage(msg);
  }
  
  public static void Msg(Player p, String msg)
  {
    p.sendMessage(msg);
  }
  
  public static void darItemInv(Inventory inv, Material mat, int quantidade, int modo, String nome, int lugar)
  {
    ItemStack item = new ItemStack(mat, quantidade, (short)modo);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(nome);
    item.setItemMeta(itemmeta);
    inv.setItem(lugar, item);
  }
  
  public static ItemStack Item(Material material, int quantidade, int id, String nome)
  {
    ItemStack item = new ItemStack(material, quantidade, (byte)id);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(nome);
    item.setItemMeta(meta);
    return item;
  }
  

  public static ItemStack capacete;
  public static ItemMeta capacetemeta;
  public static ItemStack peitoral;
  public static ItemMeta peitoralmeta;
  public static ItemStack calça;
  public static ItemMeta calçameta;
  public static ItemStack bota;
  public static ItemMeta botameta;
  public static ItemStack sopa;
  public static ItemMeta sopameta;
  
  public static void CriarItem(Player p, Material material, int quantidade, byte id, String nome, Enchantment ench, int level, boolean trueoufalse, int lugar)
  {
    ItemStack item = new ItemStack(material, quantidade, id);
    ItemMeta itemm = item.getItemMeta();
    itemm.setDisplayName(nome);
    itemm.addEnchant(ench, level, trueoufalse);
    item.setItemMeta(itemm);
    
    p.getInventory().setItem(lugar, item);
  }
  
  public static void ItemSpawn(Player p)
  {
	  World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.Spawn.World"));
      double x = Main.getInstace().warps.getDouble("Warps.Spawn.X");
      double y = Main.getInstace().warps.getDouble("Warps.Spawn.Y");
      double z = Main.getInstace().warps.getDouble("Warps.Spawn.Z");
      Location lobby = new Location(w, x, y, z);
      lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.Spawn.Pitch"));
      lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.Spawn.Yaw"));
      p.teleport(lobby);
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
    Main.TirarEfeitos(p);
    p.getInventory().clear();
    p.getInventory().setArmorContents(null);
    
    p.setGameMode(GameMode.ADVENTURE);
    p.getInventory().setItem(0, warps);
    p.getInventory().setItem(2, FRAME);
    p.getInventory().setItem(4, kits);
    p.getInventory().setItem(6, day);
    p.getInventory().setItem(8, treino);
    p.updateInventory();
    TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), "§aVoce voltou pro spawn");
  }
  
  public static ItemStack darArmadura(Material material, Color cor)
  {
    ItemStack item = new ItemStack(material);
    LeatherArmorMeta itemm = (LeatherArmorMeta)item.getItemMeta();
    itemm.setColor(cor);
    item.setItemMeta(itemm);
    return item;
  }
  
  public static void tirarArmadura(Player p)
  {
    p.getInventory().setHelmet(new ItemStack(Material.AIR));
    p.getInventory().setChestplate(new ItemStack(Material.AIR));
    p.getInventory().setLeggings(new ItemStack(Material.AIR));
    p.getInventory().setBoots(new ItemStack(Material.AIR));
  }
  
  public static void DarSopa(Player p)
  {
    sopa = new ItemStack(Material.MUSHROOM_SOUP);
    sopameta = sopa.getItemMeta();
    sopameta.setDisplayName("§cSopa");
    sopa.setItemMeta(sopameta);
    for (int i = 1; i < 37; i++) {
      p.getInventory().addItem(new ItemStack[] { sopa });
    }
    CriarItem(p, Material.RED_MUSHROOM, 64, (byte)0, "§6Recraft", Enchantment.ARROW_DAMAGE, 0, false, 13);
    CriarItem(p, Material.BROWN_MUSHROOM, 64, (byte)0, "§6Recraft", Enchantment.ARROW_DAMAGE, 0, false, 15);
    CriarItem(p, Material.BOWL, 64, (byte)0, "§6Recraft", Enchantment.ARROW_DAMAGE, 0, false, 14);
  }
  
  public static void ClearPlayer(Player p)
  {
    p.setHealth(20.0D);
    p.setFoodLevel(20);
    p.getInventory().clear();
    p.getInventory().setArmorContents(null);
    for (PotionEffect potion : p.getActivePotionEffects()) {
      p.removePotionEffect(potion.getType());
    }
  }
  
  public static void Som(Player p, Sound som, float volume)
  {
    p.playSound(p.getLocation(), som, volume, volume);
  }
  
  public static void spawnFirework(Location loc)
  {
    Firework fw = (Firework)loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
    FireworkMeta fwm = fw.getFireworkMeta();
    Random r = new Random();
    int rt = r.nextInt(4) + 1;
    FireworkEffect.Type type = FireworkEffect.Type.BALL;
    if (rt == 1) {
      type = FireworkEffect.Type.BALL;
    }
    if (rt == 2) {
      type = FireworkEffect.Type.BALL_LARGE;
    }
    if (rt == 3) {
      type = FireworkEffect.Type.BURST;
    }
    if (rt == 4) {
      type = FireworkEffect.Type.CREEPER;
    }
    if (rt == 5) {
      type = FireworkEffect.Type.STAR;
    }
    Color c1 = Color.RED;
    Color c2 = Color.YELLOW;
    Color c3 = Color.ORANGE;
    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withColor(c2)
      .withFade(c3).with(type).trail(r.nextBoolean()).build();
    fwm.addEffect(effect);
    fwm.setPower(1);
    fw.setFireworkMeta(fwm);
  }
  
  public static void darArmor(Player p)
  {
    capacete = new ItemStack(Material.IRON_HELMET);
    capacetemeta = capacete.getItemMeta();
    capacete.setItemMeta(capacetemeta);
    
    peitoral = new ItemStack(Material.IRON_CHESTPLATE);
    peitoralmeta = peitoral.getItemMeta();
    peitoral.setItemMeta(peitoralmeta);
    
    calça = new ItemStack(Material.IRON_LEGGINGS);
    calçameta = calça.getItemMeta();
    calça.setItemMeta(calçameta);
    
    bota = new ItemStack(Material.IRON_BOOTS);
    botameta = bota.getItemMeta();
    bota.setItemMeta(botameta);
    
    p.getInventory().setHelmet(capacete);
    p.getInventory().setChestplate(peitoral);
    p.getInventory().setLeggings(calça);
    p.getInventory().setBoots(bota);
  }
  
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
  
  public static void darEfeito(Player p, PotionEffectType tipo, int duracao, int level)
  {
    p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
  }
  
  public static void firstEmpty(Inventory inv, ItemStack item)
  {
    ItemStack[] arrayOfItemStack = inv.getContents();
    int j = arrayOfItemStack.length;
    int i = 0;
    while (i < j)
    {
      ItemStack item2 = arrayOfItemStack[i];
      if (item2 == null) {
        inv.setItem(inv.firstEmpty(), item);
      }
      i++;
    }
  }
  
  public static ItemStack itemStack(Material material, String nome)
  {
    ItemStack item = new ItemStack(material);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(nome);
    item.setItemMeta(itemmeta);
    return item;
  }
  
  public static void fillLinhaInventory(Inventory inv, int fristSlot, ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4, ItemStack slot5, ItemStack slot6, ItemStack slot7, ItemStack slot8, ItemStack slot9)
  {
    inv.setItem(fristSlot, slot1);
    inv.setItem(fristSlot + 1, slot2);
    inv.setItem(fristSlot + 2, slot3);
    inv.setItem(fristSlot + 3, slot4);
    inv.setItem(fristSlot + 4, slot5);
    inv.setItem(fristSlot + 5, slot6);
    inv.setItem(fristSlot + 6, slot7);
    inv.setItem(fristSlot + 7, slot8);
    inv.setItem(fristSlot + 8, slot9);
  }
}
