package mx.com.rodel.ChatCommands;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import json.JSONObject;
import json.parser.JSONParser;
import json.parser.ParseException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class iKeyHandler {
	static KeyBinding MenuAtaques = new KeyBinding("Comandos de ataque", 19, "ChatCommands");
	static KeyBinding MenuAmigos = new KeyBinding("Comandos de equipo/amigos", 33, "ChatCommands");
	private Minecraft mc;
	
	public iKeyHandler(){
		ClientRegistry.registerKeyBinding(MenuAtaques);
		ClientRegistry.registerKeyBinding(MenuAmigos);
	}
	
	public String getLabel(){
		return "KeyHandler [ChatCommands]";
	}
	
	@SubscribeEvent
	public void tick(InputEvent.KeyInputEvent event){
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		if(!FMLClientHandler.instance().isGUIOpen(GuiChat.class)  && !player.isSneaking()){
			if(MenuAtaques.isKeyDown()){
				FMLClientHandler.instance().displayGuiScreen(FMLClientHandler.instance().getClient().thePlayer, new ChatCommandsGUI(0));
			}
			
			if(MenuAmigos.isKeyDown()){
				FMLClientHandler.instance().displayGuiScreen(FMLClientHandler.instance().getClient().thePlayer, new ChatCommandsGUI(1));
			}
		}
	}
	
	@SubscribeEvent
	public void join(PlayerEvent.PlayerLoggedInEvent e){
		/*
		 * try {
				List<String> log = new ArrayList<String>();
				URL vu = new URL("http://invasion.rodel.com.mx/changelog.txt");
				URLConnection connection = vu.openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = "";
				while((line = br.readLine()) != null){
					log.add(line);
				}
				br.close();
				return log;
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		 * */
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new InputStreamReader(new URL("http://rodel.com.mx/CC/data.json").openStream()));
			JSONObject json = (JSONObject) obj;
			String version = (String) json.get("version");
			if(!version.equals(ChatCommands.VERSION)){
				e.player.addChatComponentMessage(new ChatComponentText("[ChatCommands] Version "+version+" disponible ahora en www.rodel.com.mx/CC/last"));
			}
		}catch (IOException d){}catch (ParseException d){}
	}
}
