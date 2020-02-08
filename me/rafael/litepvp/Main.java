package me.rafael.litepvp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Comandos.AllKits;
import Comandos.Aplicar;
import Comandos.Aviso;
import Comandos.BUILD;
import Comandos.Chat;
import Comandos.Fly;
import Comandos.Gamemode;
import Comandos.Head;
import Comandos.Invsee;
import Comandos.Kills;
import Comandos.Kits;
import Comandos.KitsFPS;
import Comandos.Loja;
import Comandos.LojadeKit;
import Comandos.LojadePermissoes;
import Comandos.Morrer;
import Comandos.NoDrops;
import Comandos.Ping;
import Comandos.Ranks;
import Comandos.Report;
import Comandos.SC;
import Comandos.SetArena;
import Comandos.SetSpawn;
import Comandos.SetWarp;
import Comandos.Site;
import Comandos.Skit;
import Comandos.TP;
import Comandos.Tag;
import Comandos.TeleportAll;
import Comandos.TogglePvP;
import Comandos.Viking;
import Comandos.Vip;
import Comandos.Youtuber;
import Kits.Anchor;
import Kits.Archer;
import Kits.Avatar;
import Kits.Barbarian;
import Kits.Camel;
import Kits.Confuser;
import Kits.Dublejump;
import Kits.Deshfire;
import Kits.FArcher;
import Kits.FFisherman;
import Kits.FKangaroo;
import Kits.FPvP;
import Kits.FResouper;
import Kits.FSnail;
import Kits.FSonic;
import Kits.FSwitcher;
import Kits.FViper;
import Kits.Fisherman;
import Kits.Forcefield;
import Kits.Gladiator;
import Kits.GladiatorHAB;
import Kits.Goku;
import Kits.Gun;
import Kits.Hulk;
import Kits.Indio;
import Kits.Infernor;
import Kits.Jumper;
import Kits.Kangaroo;
import Kits.Magma;
import Kits.Monk;
import Kits.Naruto;
import Kits.Ninja;
import Kits.Poseidon;
import Kits.Pyro;
import Kits.Quick;
import Kits.Rain;
import Kits.Reaper;
import Kits.Snail;
import Kits.Sonic;
import Kits.Stomper;
import Kits.Switcher;
import Kits.Thor;
import Kits.ThorCMD;
import Kits.Timelord;
import Kits.Ultimate;
import Kits.Viper;
import Kits.Vitality;
import Kits.Wink;
import Kits.kPvP;
import me.rafael.litepvp.Utils.Array;
import me.rafael.litepvp.Utils.Commands;
import me.rafael.litepvp.Utils.Cooldown;
import me.rafael.litepvp.Utils.CooldownSopa;
import me.rafael.litepvp.Utils.Habilidade;
import me.rafael.litepvp.Utils.InteractEvent;
import me.rafael.litepvp.Utils.Join;
import me.rafael.litepvp.Utils.Mensagens;
import me.rafael.litepvp.Utils.Menu;
import me.rafael.litepvp.Utils.Metrics;
import me.rafael.litepvp.Utils.Motd;
import me.rafael.litepvp.Utils.PlacadeSopa;
import me.rafael.litepvp.Utils.Recraft;
import me.rafael.litepvp.Utils.Soup;
import me.rafael.litepvp.Utils.cmds;
import me.rafael.litepvp.comandos.Admin;
import me.rafael.litepvp.comandos.ClickTest;
import me.rafael.litepvp.comandos.Stats;
import me.rafael.litepvp.comandos.Sudo;
import me.rafael.litepvp.comandos.Tell;
import me.rafael.litepvp.comandos.Treinos;
import me.rafael.litepvp.extras.Heads;
import me.rafael.litepvp.scoreboard.ScoreboardIniciando;
import net.md_5.bungee.api.ChatColor;


//A CLASSE PRINCIPAL E ONDE REGISTRA TODOS OS COMANDOS E EVENTOS
//E INICIALIZA O PLUGIN
//ELA PRECISA OBRIGATORIAMENTE EXTENDER o JavaPlugin
public class Main
  extends JavaPlugin
{
  public static ReentrantLock lock = new ReentrantLock(true);
  public static String SQL_HOST = null;
  public static ArrayList<String> jp = new ArrayList();
  public static String SQL_PORT = null;
  public static Plugin plugin;
  public static Main instance;
  public static Integer score;
  
  
  public File registrofile;

  public YamlConfiguration registro;
  
  public File warpsfile;
  public YamlConfiguration warps;
  public File statusfile;
  public YamlConfiguration status;
  public File arenasfile;
  public YamlConfiguration arenas;
  
private File warps1;
private File arenas1;
private File status1;
private File registro1;

  public static Boolean COMPASS = Boolean.valueOf(true);
  public static Boolean AUTO_COMPASS = Boolean.valueOf(false);
  public static String SQL_USER = null;
  public static String SQL_PASS = null;
  
  public static ArrayList<String> Sonic = new ArrayList();
  public static ArrayList<String> qd = new ArrayList();
  public static List<String> OiDecompilerEz2 = new ArrayList();
  public static String SQL_DATA = null;
  public static List<Player> Tempo = new ArrayList();
  public static List<String> Ferro2 = new ArrayList();
  public static ArrayList<String> naruto = new ArrayList();
 
 
  public static List<String> Red2 = new ArrayList();
  public static List<String> Terra2 = new ArrayList();
  
 
  public static FileConfiguration config;
  
  public static ArrayList<String> trocador = new ArrayList();
  public static Main main;
  public static ArrayList<String> Dj = new ArrayList();
  public static ArrayList<String> Deshfire = new ArrayList();
  public static ArrayList<String> rain = new ArrayList();
  public static List<Player> cooldownm = new ArrayList();
  public static ArrayList<String> Flames = new ArrayList();
  public static ArrayList<String> Ender = new ArrayList();
  public static ArrayList<String> Redstone = new ArrayList();
  public static ArrayList<String> Diamond = new ArrayList();
  public static ArrayList<String> Water = new ArrayList();
  public static ArrayList<String> Efeitos = new ArrayList();
  public static ArrayList<String> stomper = new ArrayList();
  public static ArrayList<String> Smoke = new ArrayList();
  public static ArrayList<String> EXTINGUISH = new ArrayList();
  public static ArrayList<String> AvatarH = new ArrayList();
  public static Main getInstace() {
		return instance;
	}
  boolean CanPlayersPickItemsOnGround;
  public static ArrayList<String> Avatar = new ArrayList();
  public static ArrayList<String> antistomper = new ArrayList();
  public static ArrayList<String> Potion = new ArrayList();
  private Server server = Bukkit.getServer();

  public static ArrayList<String> Rainbow = new ArrayList();

  public static Main pl;
  
  public static Main getInstance() {
      return Main.instance;
  } {
    
  }
 

  
  
    
  
  
  public void onEnable()
  {
	   Metrics metrics = new Metrics(this);

	  metrics.addCustomChart(new Metrics.DrilldownPie("serverAddress", () -> {
	  	Map<String, Map<String, Integer>> map = new HashMap<>();
	  	Map<String, Integer> entry = new HashMap<>();
	  	
	  	if (getConfig().getBoolean("SendIPAddressData")) entry.put(server.getIp(), 1);
	  	else entry.put("Hidden", 1);
	  	
	  	map.put("Port " + server.getPort(), entry);
	  	
	  	return map;
	  }));
	  plugin = this;
	    instance = this;
	    saveConfig();
		instance = this;
		saveDefaultConfig();
		File warps = new File(getDataFolder(), "warps.yml");
		if (!warps.exists())
			saveResource("warps.yml", false);
		warps1 = new File(getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(warps1);
		
		

		
		File arenas = new File(getDataFolder(), "arenas.yml");
		if (!arenas.exists())
			saveResource("arenas.yml", false);
		arenas1 = new File(getDataFolder(), "arenas.yml");
		this.arenas = YamlConfiguration.loadConfiguration(arenas1);
		
		
		 Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "PLUGIN LITEPVP V5 ATIVADO COM SUCESSO");
		 Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Plugin criado por zEnderX5_  ");
		 Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Canal: https://www.youtube.com/channel/UCb1kjbiQj2B4KnRQpgeUwmQ");
		    
		    
		    
		    
		
  
    
    String prefix = "Plugin LitePvP";
    Bukkit.getServer().getConsoleSender().sendMessage(prefix + " ATIVADO");
    saveDefaultConfig();
    instance = this;
    plugin = this;
    getConfig().options().copyDefaults(true);
    getConfig().options().copyHeader(true);
    saveConfig();
    
    
    
   
    
       
        
       
        
    
    //REGISTRAR OS COMANDOS

    getCommand("chat").setExecutor(new Chat());   
    getCommand("setarena").setExecutor(new SetArena());    
    getCommand("gm").setExecutor(new Gamemode());
    getCommand("kits").setExecutor(new Kits());
    getCommand("chat").setExecutor(new Chat());
    getCommand("build").setExecutor(new BUILD());   
    getCommand("rank").setExecutor(new Ranks());
    getCommand("coins").setExecutor(new Commands(this));   
    getCommand("setspawn").setExecutor(new SetSpawn());
    getCommand("spawn").setExecutor(new SetSpawn());
    getCommand("setwarp").setExecutor(new SetWarp());    
    getCommand("warp").setExecutor(new SetWarp());   
    getCommand("skit").setExecutor(new Skit());
    getCommand("tag").setExecutor(new Tag());
    getCommand("sc").setExecutor(new SC());    
    getCommand("clicktest").setExecutor(new ClickTest());
    getCommand("information").setExecutor(new Info());
    getCommand("tpall").setExecutor(new TeleportAll());
    getCommand("warps").setExecutor(new Warps());
    getCommand("eventos").setExecutor(new Warps());
    getCommand("kills").setExecutor(new Kills());
    getCommand("fly").setExecutor(new Fly());
    getCommand("invsee").setExecutor(new Invsee());
    getCommand("tp").setExecutor(new TP());
    getCommand("togglepvp").setExecutor(new TogglePvP());
    getCommand("tell").setExecutor(new Tell());
    getCommand("report").setExecutor(new Report());
    getCommand("sudo").setExecutor(new Sudo());
    getCommand("consolesudo").setExecutor(new Sudo());
    getCommand("aplicar").setExecutor(new Aplicar());
    getCommand("status").setExecutor(new Stats());
    getCommand("treinos").setExecutor(new Treinos());
    getCommand("kitsfps").setExecutor(new KitsFPS());
    getCommand("admin").setExecutor(new Admin(null));
    getCommand("lojadeperms").setExecutor(new LojadePermissoes(this));
    getCommand("head").setExecutor(new Head(null));
    getCommand("ping").setExecutor(new Ping());
    getCommand("morrer").setExecutor(new Morrer());
    getCommand("aviso").setExecutor(new Aviso());    
    getCommand("mostrarmenu").setExecutor(new Menu());   
    getCommand("youtuber").setExecutor(new Youtuber());
    getCommand("abrirloja").setExecutor(new Loja());
    getCommand("vip").setExecutor(new Vip());
    getCommand("site").setExecutor(new Site());
    getCommand("allkits").setExecutor(new AllKits());

    // REGISTRAR OS EVENTOS
    getServer().getPluginManager().registerEvents(new Archer(), this);
    getServer().getPluginManager().registerEvents(new KitsFPS(), this);
    getServer().getPluginManager().registerEvents(new Loja(), this);
    getServer().getPluginManager().registerEvents(new Info(), this);
    getServer().getPluginManager().registerEvents(new Menu(), this);
    getServer().getPluginManager().registerEvents(new Heads(), this);
    getServer().getPluginManager().registerEvents(new Avatar(), this);
    getServer().getPluginManager().registerEvents(new AllKits(), this);
    getServer().getPluginManager().registerEvents(new Barbarian(), this);
    getServer().getPluginManager().registerEvents(new Comandos.ChatColor(), this);
    getServer().getPluginManager().registerEvents(new GladiatorHAB(), this);
    getServer().getPluginManager().registerEvents(new Confuser(), this);    
    getServer().getPluginManager().registerEvents(new Fisherman(), this);
    getServer().getPluginManager().registerEvents(new Forcefield(), this);
    getServer().getPluginManager().registerEvents(new Gladiator(), this);
    getServer().getPluginManager().registerEvents(new Wink(), this);
    getServer().getPluginManager().registerEvents(new GladiatorHAB(), this);
    getServer().getPluginManager().registerEvents(new Hulk(), this);
    getServer().getPluginManager().registerEvents(new Indio(this), this);
    getServer().getPluginManager().registerEvents(new Infernor(), this);
    getServer().getPluginManager().registerEvents(new Monk(this), this);
    getServer().getPluginManager().registerEvents(new Kangaroo(), this);
    getServer().getPluginManager().registerEvents(new kPvP(), this);
    getServer().getPluginManager().registerEvents(new Monk(this), this);    
    getServer().getPluginManager().registerEvents(new Ninja(), this);
    getServer().getPluginManager().registerEvents(new FSonic(), this);
    getServer().getPluginManager().registerEvents(new FPvP(), this);
    getServer().getPluginManager().registerEvents(new FFisherman(), this);
    getServer().getPluginManager().registerEvents(new FSwitcher(), this);
    getServer().getPluginManager().registerEvents(new FKangaroo(), this);
    getServer().getPluginManager().registerEvents(new FResouper(), this);
    getServer().getPluginManager().registerEvents(new FViper(), this);
    getServer().getPluginManager().registerEvents(new Join(), this);
    getServer().getPluginManager().registerEvents(new FSnail(), this);
    getServer().getPluginManager().registerEvents(new FArcher(), this);
    getServer().getPluginManager().registerEvents(new BlocodeDima(), this);
    getServer().getPluginManager().registerEvents(new Extremo(), this);          
    getServer().getPluginManager().registerEvents(new Dificil(), this);
    getServer().getPluginManager().registerEvents(new Facil(), this);
    getServer().getPluginManager().registerEvents(new Info(), this);
    getServer().getPluginManager().registerEvents(new RDM(), this);
    getServer().getPluginManager().registerEvents(new Streak(), this);
    getServer().getPluginManager().registerEvents(new Warps(), this);
    getServer().getPluginManager().registerEvents(new X1(), this);
    getServer().getPluginManager().registerEvents( new Medio(), this);
    getServer().getPluginManager().registerEvents( new Poseidon(), this);
    getServer().getPluginManager().registerEvents(new Fisherman(), this);        
    getServer().getPluginManager().registerEvents(new Skit(), this);
    getServer().getPluginManager().registerEvents(new LojadeKit(), this);
    getServer().getPluginManager().registerEvents(new SC(), this);
    getServer().getPluginManager().registerEvents(new ClickTest(), this);
    getServer().getPluginManager().registerEvents(new TP(), this);
    getServer().getPluginManager().registerEvents(new TeleportAll(), this);
    getServer().getPluginManager().registerEvents(new Warps(), this);
    getServer().getPluginManager().registerEvents(new Treinos(), this);
    getServer().getPluginManager().registerEvents(new Kits(), this);
    getServer().getPluginManager().registerEvents(new Kangaroo(), this);
    getServer().getPluginManager().registerEvents(new Snail(), this);
    getServer().getPluginManager().registerEvents(new Ultimate(), this);
    getServer().getPluginManager().registerEvents(new Pyro(), this);
    getServer().getPluginManager().registerEvents(new PlacadeSopa(), this);
    getServer().getPluginManager().registerEvents(new Magma(), this);
    getServer().getPluginManager().registerEvents(new Dublejump(), this);
    getServer().getPluginManager().registerEvents(new Archer(), this);             
    getServer().getPluginManager().registerEvents(new BUILD(), this);     
    getServer().getPluginManager().registerEvents(new Motd(), this);
    getServer().getPluginManager().registerEvents(new Rain(), this); 
    getServer().getPluginManager().registerEvents(new Recraft(), this);          
    getServer().getPluginManager().registerEvents(new Heads(), this);
    getServer().getPluginManager().registerEvents(new Poseidon(), this);
    getServer().getPluginManager().registerEvents(new Reaper(), this);
    getServer().getPluginManager().registerEvents(new Snail(), this);
    getServer().getPluginManager().registerEvents(new Stomper(), this);
    getServer().getPluginManager().registerEvents(new Switcher(), this);
    getServer().getPluginManager().registerEvents(new Gun(), this);
    getServer().getPluginManager().registerEvents(new Thor(this), this);
    getServer().getPluginManager().registerEvents(new Timelord(), this);
    getServer().getPluginManager().registerEvents(new Viking(), this);
    getServer().getPluginManager().registerEvents(new Viper(), this);
    getServer().getPluginManager().registerEvents(new Vitality(), this);
    getServer().getPluginManager().registerEvents(new Jumper(), this);
    getServer().getPluginManager().registerEvents(new Admin(this), this);
    getServer().getPluginManager().registerEvents(new InteractEvent(), this);
    getServer().getPluginManager().registerEvents(new Soup(this), this);
    getServer().getPluginManager().registerEvents(new cmds(), this);
    getServer().getPluginManager().registerEvents(new NoDrops(this), this);
    getServer().getPluginManager().registerEvents(new Naruto(), this);
    getServer().getPluginManager().registerEvents(new Facil(), this);
    getServer().getPluginManager().registerEvents(new Deshfire(), this);
    getServer().getPluginManager().registerEvents(new Ninja(), this);
    getServer().getPluginManager().registerEvents(new Info(), this);
    getServer().getPluginManager().registerEvents(new LojadePermissoes(this), this);
    getServer().getPluginManager().registerEvents(new Medio(), this);
    getServer().getPluginManager().registerEvents(new Camel(), this);
    getServer().getPluginManager().registerEvents(new Dificil(), this);
    getServer().getPluginManager().registerEvents(new LojadePermissoes(this), this);
    getServer().getPluginManager().registerEvents(new Goku(), this);
    getServer().getPluginManager().registerEvents(new Extremo(), this);
    
    //REGISTRAR OS COMANDOS DOS KITS
    getCommand("anchor").setExecutor(new Anchor());
    getCommand("archer").setExecutor(new Archer());
    getCommand("barbarian").setExecutor(new Barbarian());
    getCommand("camel").setExecutor(new Camel());
    getCommand("confuser").setExecutor(new Confuser());
    getCommand("sonic").setExecutor(new Sonic());
    getCommand("resouper").setExecutor(new Vitality());
    getCommand("doublejump").setExecutor(new Dublejump());
    getCommand("quickdropper").setExecutor(new Quick());
    getCommand("fisherman").setExecutor(new Fisherman());
    getCommand("forcefield").setExecutor(new Forcefield());
    getCommand("naruto").setExecutor(new Naruto());
    getCommand("magma").setExecutor(new Magma());
    getCommand("ultimate").setExecutor(new Ultimate());
    getCommand("gladiator").setExecutor(new Gladiator());
    getCommand("avatar").setExecutor(new Avatar());
    getCommand("hulk").setExecutor(new Hulk());
    getCommand("indio").setExecutor(new Indio(this));
    getCommand("goku").setExecutor(new Goku());
    getCommand("infernor").setExecutor(new Infernor());
    getCommand("jumper").setExecutor(new Jumper());
    getCommand("kangaroo").setExecutor(new Kangaroo());
    getCommand("pvp").setExecutor(new kPvP());
    getCommand("monk").setExecutor(new Monk(this));
    getCommand("ninja").setExecutor(new Ninja());
    getCommand("poseidon").setExecutor(new Poseidon());
    getCommand("reaper").setExecutor(new Reaper());
    getCommand("snail").setExecutor(new Snail());
    getCommand("stomper").setExecutor(new Stomper());
    getCommand("switcher").setExecutor(new Switcher());   
    getCommand("pyro").setExecutor(new Pyro());
    getCommand("rain").setExecutor(new Rain());
    getCommand("thor").setExecutor(new ThorCMD(this));
    getCommand("timelord").setExecutor(new Timelord());
    getCommand("viking").setExecutor(new Viking());
    getCommand("gun").setExecutor(new Gun());
    getCommand("deshfire").setExecutor(new Deshfire());
    getCommand("viper").setExecutor(new Viper());
    getCommand("fpvp").setExecutor(new FPvP());
    getCommand("fviper").setExecutor(new FViper());
    getCommand("fsnail").setExecutor(new FSnail());
    getCommand("ffisherman").setExecutor(new FFisherman());
    getCommand("fkangaroo").setExecutor(new FKangaroo());
    getCommand("farcher").setExecutor(new FArcher());
    getCommand("fswitcher").setExecutor(new FSwitcher());
    getCommand("fsonic").setExecutor(new FSonic());
    getCommand("fresouper").setExecutor(new FResouper());






    Mensagens.start();
    
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
        for (World World : Bukkit.getServer().getWorlds()) {
          World.setTime(0L);
        }
      }
    }, 20L, 20L);
  
  Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
  {
    public void run()
    {
      for (Player p : Bukkit.getOnlinePlayers()) {
        ScoreboardIniciando.setScoreBoard(p);;
      }
    }
  }, 10L, 10L);
}

//CODIGO PARA TIRAR OS EFEITOS E HASHMAPS DOS PLAYERS
  public static void TirarEfeitos(Player p)
  {
    p.removePotionEffect(PotionEffectType.ABSORPTION);
    p.removePotionEffect(PotionEffectType.BLINDNESS);
    p.removePotionEffect(PotionEffectType.CONFUSION);
    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.HARM);
    p.removePotionEffect(PotionEffectType.HEAL);
    p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    p.removePotionEffect(PotionEffectType.HUNGER);
    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    p.removePotionEffect(PotionEffectType.INVISIBILITY);
    p.removePotionEffect(PotionEffectType.JUMP);
    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    p.removePotionEffect(PotionEffectType.POISON);
    p.removePotionEffect(PotionEffectType.REGENERATION);
    p.removePotionEffect(PotionEffectType.SATURATION);
    p.removePotionEffect(PotionEffectType.SLOW);
    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    p.removePotionEffect(PotionEffectType.SPEED);
    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    p.removePotionEffect(PotionEffectType.WEAKNESS);
    p.removePotionEffect(PotionEffectType.WITHER);
    Array.admin.remove(p.getName());
    Array.used.remove(p.getName());
    ClickTest.fazendoclicktest.remove(p.getName());
    ClickTest.emclicktest.remove(p.getName());
    Array.warp.remove(p.getName());
    Forcefield.forcefielddano.remove(p);
    Main.stomper.remove(p.getName());
    Main.Avatar.remove(p.getName());
    Array.freeze.remove(p.getName());
    Array.freezing.remove(p.getName());
    Array.Velotrol2.remove(p.getName());
    Habilidade.removeAbility(p);
    Array.kit.put(p, "Sem Kit");
    Cooldown.remove(p);
    CooldownSopa.remove(p);
  }
  
  //Dar bussola e recraft pros player quando eles escolherem um kit
  public static void give(Player p)
  {
	  ItemStack marrom21 = new ItemStack(Material.COMPASS);
  	ItemMeta marrom211 = marrom21.getItemMeta();
  	marrom211.setDisplayName("§eBussola");
  	 List<String> itemlorem11 = new ArrayList();
  	itemlorem11.add("§cAche os seus inimigos proximos de voce");
	    marrom211.setLore(itemlorem11);
  	marrom21.setItemMeta(marrom211);
    
    ItemStack vermelho = new ItemStack(Material.RED_MUSHROOM, 64);
    ItemMeta vermelho2 = vermelho.getItemMeta();
    vermelho2.setDisplayName("§cCogumelo Vermelho");
    vermelho.setItemMeta(vermelho2);
    
    ItemStack marrom = new ItemStack(Material.BROWN_MUSHROOM, 64);
    ItemMeta marrom2 = marrom.getItemMeta();
    marrom2.setDisplayName("§8Cogumelo Marrom");
    marrom.setItemMeta(marrom2);
    
    ItemStack item = new ItemStack(Material.BOWL, 64);
    ItemMeta item2 = item.getItemMeta();
    item2.setDisplayName("§7Pote");
    @SuppressWarnings({ "unchecked", "rawtypes" })
	List<String> itemlore = new ArrayList();
    itemlore.add("§4use para fazer sopas!");
    item2.setLore(itemlore);
    item.setItemMeta(item2);
    p.getInventory().setItem(8, marrom21);
    p.getInventory().setItem(14, vermelho);
    p.getInventory().setItem(15, marrom);
    p.getInventory().setItem(13, item);
  }


 

  
  
  
  public void saveConfig() {}






public void save() {
	try {
		
		this.warps.save(this.warps1);
		this.arenas.save(this.arenas1);
		

				
		
} catch (IOException e) {
	e.printStackTrace();
}
}

//METODO PARA DAR ALGUM EFEITO PARA UM PLAYER
public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
    p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
}   

public static org.bukkit.plugin.Plugin getPlugin()
{
  return plugin;
} { 


 
}

}


