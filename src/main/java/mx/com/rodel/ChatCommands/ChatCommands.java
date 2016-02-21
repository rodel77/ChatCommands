package mx.com.rodel.ChatCommands;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="ChatCommands", name="ChatCommands", version=ChatCommands.VERSION, clientSideOnly=true)
public class ChatCommands {
	public static final String MODID = "ChatCommands";
	public static final String VERSION = "1.0";
	public static boolean first = true;
	
	public static int menuType;
	
	@Instance("ChatCommands")
	public static ChatCommands instance;
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new Events());
		FMLCommonHandler.instance().bus().register(new iKeyHandler());
	}
	
	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event){
		FMLCommonHandler.instance().bus().register(new Events());
		
		/*Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		Property type = config.get(Configuration.CATEGORY_GENERAL, "menuType", 1);
		
		type.comment = "1 = Abrir GUI como inventario, 0 = Como csgo, battlefield etc";
		
		menuType = type.getInt();
		
		config.save();*/
	}
}
