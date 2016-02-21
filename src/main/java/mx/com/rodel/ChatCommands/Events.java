package mx.com.rodel.ChatCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class Events {
	private Minecraft mc;
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent e){
		mc = Minecraft.getMinecraft();
		FontRenderer font = mc.fontRendererObj;
		String attack = "Atacar Nexo ("+Keyboard.getKeyName(iKeyHandler.MenuAtaques.getKeyCode())+")";
		String team = "Menu Equipo ("+Keyboard.getKeyName(iKeyHandler.MenuAmigos.getKeyCode())+")";
		
    	if(mc.thePlayer.isSneaking()){
    		font.drawString(attack, e.resolution.getScaledWidth()/2 - mc.fontRendererObj.getStringWidth(attack) /2, e.resolution.getScaledHeight()-40, (int)0xFFFFFF);
    		font.drawString(team, e.resolution.getScaledWidth()/2 - mc.fontRendererObj.getStringWidth(attack) /2, e.resolution.getScaledHeight()-80, (int)0xFFFFFF);
    	}
    	
    	List<String> ataquesMenu = new ArrayList<String>();
    	ataquesMenu.add("Atacar azul ("+getKeyName(0)+")");
    	ataquesMenu.add("Atacar amarillo ("+getKeyName(1)+")");
    	ataquesMenu.add("Atacar verde ("+getKeyName(2)+")");
    	ataquesMenu.add("Atacar rojo ("+getKeyName(3)+")");
    	
    	/*if(iKeyHandler.MenuAtaques.isKeyDown()){
    		if(isPressed(0)){
    			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al azul!");
    		}
    		
    		if(isPressed(1)){
    			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al amarillo!");
    		}
    		
    		if(isPressed(2)){
    			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al verde!");
    		}
    		
    		if(isPressed(3)){
    			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al rojo!");
    		}
    		
    		for (int i = 0; i < ataquesMenu.size(); i++) {
    			font.drawString(ataquesMenu.get(i), 16, 16+(16*i), (int)0xFFFFFF);
			}
    	}*/
	}
	
	public String getKeyName(int hotbar){
		return Keyboard.getKeyName(mc.gameSettings.keyBindsHotbar[hotbar].getKeyCode());
	}
	
	public boolean isPressed(int hotbar){
		return mc.gameSettings.keyBindsHotbar[hotbar].isPressed();
	}
}
