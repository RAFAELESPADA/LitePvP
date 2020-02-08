package Comandos;

import java.util.ArrayList;
import java.util.HashMap;
import me.rafael.litepvp.Main;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SetWarp
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("setwarp"))
    {
      if (!p.hasPermission("set.warp")) {
        return true;
      }
      if (args.length == 0)
      {
        p.sendMessage(" §7§ §cUse /setwarp <Fps,Challenge,Knock,PotPvP,Staff,RDM,MDR> ");
        return true;
      }
      if (args[0].equalsIgnoreCase("fps"))
      {
        Main.getInstace().warps.set("Warps.fps.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.fps.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.fps.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.fps.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.fps.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.fps.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aFPS setada !");
      }
      if (args[0].equalsIgnoreCase("mdr"))
      {
        Main.getInstace().warps.set("Warps.mdr.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.mdr.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.mdr.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.mdr.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.mdr.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.mdr.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aMDR setada !");
      }
      if (args[0].equalsIgnoreCase("potpvp"))
      {
        Main.getInstace().warps.set("Warps.pot.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.pot.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.pot.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.pot.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.pot.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.pot.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aPotPvP setada !");
      }
      if (args[0].equalsIgnoreCase("staff"))
      {
        Main.getInstace().warps.set("Warps.staff.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.staff.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.staff.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.staff.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.staff.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.staff.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aSTAFF setada !");
      }
      if (args[0].equalsIgnoreCase("rdm"))
      {
        Main.getInstace().warps.set("Warps.rdm.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.rdm.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.rdm.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.rdm.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.rdm.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.rdm.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aRDM setada !");
      }
      if (args[0].equalsIgnoreCase("knock"))
      {
        Main.getInstace().warps.set("Warps.knock.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.knock.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.knock.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.knock.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.knock.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.knock.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aKNOCK setada !");
      }
      if (args[0].equalsIgnoreCase("challenge"))
      {
        Main.getInstace().warps.set("Warps.challenge.World", p.getLocation().getWorld().getName());
        Main.getInstace().warps.set("Warps.challenge.X", Double.valueOf(p.getLocation().getX()));
        Main.getInstace().warps.set("Warps.challenge.Y", Double.valueOf(p.getLocation().getY()));
        Main.getInstace().warps.set("Warps.challenge.Z", Double.valueOf(p.getLocation().getZ()));
        Main.getInstace().warps.set("Warps.challenge.Yaw", Float.valueOf(p.getLocation().getYaw()));
        Main.getInstace().warps.set("Warps.challenge.Pitch", Float.valueOf(p.getLocation().getPitch()));
        Main.getInstace().save();
        p.sendMessage(" §7§ §aCHALLENGE setada !");
      }
    }
    if (cmd.getName().equalsIgnoreCase("warp"))
    {
      if (args.length == 0)
      {
        p.sendMessage("§cDigite: /warp (Fps , Challenge , RDM , PotPvP, Knock)");
        return true;
      }
      if (args[0].equalsIgnoreCase("fps"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.fps.World"));
        double x = Main.getInstace().warps.getDouble("Warps.fps.X");
        double y = Main.getInstace().warps.getDouble("Warps.fps.Y");
        double z = Main.getInstace().warps.getDouble("Warps.fps.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.fps.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.fps.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Deshfire.remove(p.getName());
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        Array.warp.add(p.getName());
        p.setAllowFlight(false);
        ItemStack kits = new ItemStack(Material.CHEST);
        ItemMeta kits2 = kits.getItemMeta();
        kits2.setDisplayName("§b» Kits");
        kits.setItemMeta(kits2);
        p.getInventory().setItem(4, kits);
        p.sendMessage("§7§ §aBem vindo a warp §7FPS §a!");
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a Fps!");
      }
      if (args[0].equalsIgnoreCase("knock"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.knock.World"));
        double x = Main.getInstace().warps.getDouble("Warps.knock.X");
        double y = Main.getInstace().warps.getDouble("Warps.knock.Y");
        double z = Main.getInstace().warps.getDouble("Warps.knock.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.knock.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.knock.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Deshfire.remove(p.getName());
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        Array.warp.add(p.getName());
        p.setAllowFlight(false);
        ItemStack kits = new ItemStack(Material.STICK);
        ItemMeta kits2 = kits.getItemMeta();
        kits2.setDisplayName("§b» Graveto");
        kits.setItemMeta(kits2);
        kits.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        p.getInventory().setItem(4, kits);
        p.sendMessage("§7§ §aBem vindo a warp §7KNOCK §a!");
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a KNOCK!");
      }
      if (args[0].equalsIgnoreCase("potpvp"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        p.sendMessage("§7Aguarde §c3 §7segundos !");
        
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.pot.World"));
        double x = Main.getInstace().warps.getDouble("Warps.pot.X");
        double y = Main.getInstace().warps.getDouble("Warps.pot.Y");
        double z = Main.getInstace().warps.getDouble("Warps.pot.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.pot.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.pot.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Deshfire.remove(p.getName());
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        Array.warp.add(p.getName());
        p.setAllowFlight(false);
        ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
        
        ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
        
        ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
        
        ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
        ItemStack Bota1 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cEspada");
        dima.setItemMeta(souperaa);
        ItemStack sopa = new ItemStack(Material.POTION, 1, (short)16421);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§cPocao de Cura");
        sopa.setItemMeta(sopas);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        
        p.getInventory().addItem(new ItemStack[] { dima });
        p.getInventory().setHelmet(capacete0);
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        
        p.getInventory().setBoots(Bota0);
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
        }
        p.sendMessage("§7§ §aBem vindo a warp §7PotPvP §a!");
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a PotPvP!");
      }
      if (args[0].equalsIgnoreCase("staff"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§7§ §cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage(" §7§ §cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        p.sendMessage("§7§ Aguarde §c3 §7segundos !");
        
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.staff.World"));
        double x = Main.getInstace().warps.getDouble("Warps.staff.X");
        double y = Main.getInstace().warps.getDouble("Warps.staff.Y");
        double z = Main.getInstace().warps.getDouble("Warps.staff.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.staff.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.staff.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Deshfire.remove(p.getName());
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        Array.warp.add(p.getName());
        p.setAllowFlight(false);
        
        p.sendMessage("§7§ §aBem vindo a warp §7Staff §a!");
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a Staff!");
      }
      if (args[0].equalsIgnoreCase("mdr"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        p.sendMessage("§7Aguarde §c3 §7segundos !");
        
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.mdr.World"));
        double x = Main.getInstace().warps.getDouble("Warps.mdr.X");
        double y = Main.getInstace().warps.getDouble("Warps.mdr.Y");
        double z = Main.getInstace().warps.getDouble("Warps.mdr.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.mdr.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.mdr.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Deshfire.remove(p.getName());
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        Array.warp.add(p.getName());
        p.setAllowFlight(false);
        
        p.sendMessage("§7§ §aBem vindo a warp §7MDR §a!");
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a Mdr!");
      }
      if (args[0].equalsIgnoreCase("rdm"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        p.sendMessage("§7§ Aguarde §c3 §7segundos !");
        
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.rdm.World"));
        double x = Main.getInstace().warps.getDouble("Warps.rdm.X");
        double y = Main.getInstace().warps.getDouble("Warps.rdm.Y");
        double z = Main.getInstace().warps.getDouble("Warps.rdm.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.rdm.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.rdm.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Deshfire.remove(p.getName());
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        Array.warp.add(p.getName());
        
        ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
        
        ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
        
        ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
        
        ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
        ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cEspada");
        dima.setItemMeta(souperaa);
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§bSopa");
        sopa.setItemMeta(sopas);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        
        p.getInventory().addItem(new ItemStack[] { dima });
        p.getInventory().setHelmet(capacete0);
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        p.getInventory().setBoots(Bota0);
        p.setAllowFlight(false);
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
        }
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a RDM!");
        p.sendMessage("§aBem vindo a warp §7RDM §a!");
      }
      if (args[0].equalsIgnoreCase("challenge"))
      {
        if (Array.used.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja escolheu um kit !");
          return true;
        }
        if (Array.warp.contains(p.getName()))
        {
          p.sendMessage("§cVoce ja esta em uma warp !");
          return true;
        }
        p.getInventory().clear();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        p.sendMessage("§7Aguarde §c3 §7segundos !");
        
        World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.challenge.World"));
        double x = Main.getInstace().warps.getDouble("Warps.challenge.X");
        double y = Main.getInstace().warps.getDouble("Warps.challenge.Y");
        double z = Main.getInstace().warps.getDouble("Warps.challenge.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.challenge.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.challenge.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Main.TirarEfeitos(p);
        Main.Dj.remove(p.getName());
        Main.give(p);
        Array.kit.put(p, "Warp");
        Habilidade.setAbility(p, "Warp");
        p.setAllowFlight(false);
        
        Main.Deshfire.remove(p.getName());
        Array.warp.add(p.getName());
        Main.stomper.remove(p.getName());
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§bSopa");
        sopa.setItemMeta(sopas);
        p.sendMessage("§aBem vindo a warp §7CHALLENGE §a!");
        TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), "§a§lWarp", "§f§lBem vindo a Challenge!");
        for (int i = 0; i <= 35; i++)
        {
          p.getInventory().addItem(new ItemStack[] { sopa });
          Main.give(p);
        }
      }
      return true;
    }
    return false;
  }
}
