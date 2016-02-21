package mx.com.rodel.ChatCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class ChatCommandsGUI extends GuiScreen{
	int i = 0;
	public ChatCommandsGUI(int i) {
		this.i=i;
	}


	@Override
	public void initGui(){
		int centerX = width/2-37;
		int centerY = height/2-10;
		if(i==0){
			buttonList.add(new ChatCommandsButton(0, centerX, centerY, 0, 101, "Cerrar"));
			buttonList.add(new ChatCommandsButton(1, centerX+60, centerY, 50, 101, "Vamos al Rojo"));
			buttonList.add(new ChatCommandsButton(2, centerX, centerY+60, 99, 101, "Vamos al Amarillo"));
			buttonList.add(new ChatCommandsButton(3, centerX, centerY-60, 149, 101, "Vamos al Azul"));
			buttonList.add(new ChatCommandsButton(4, centerX-60, centerY, 199, 101, "Vamos al Verde"));
		}else if(i==1){
			buttonList.add(new ChatCommandsButton(0, centerX, centerY, 0, 101, "Cerrar"));
			buttonList.add(new ChatCommandsButton(5, centerX, centerY+60, 0, 0, "Siganme"));
			buttonList.add(new ChatCommandsButton(6, centerX, centerY-60, 50, 0, "Agachense"));
			buttonList.add(new ChatCommandsButton(7, centerX-60, centerY, 99, 0, "Gracias"));
			buttonList.add(new ChatCommandsButton(8, centerX+60, centerY, 149, 0, "Necesito Ayuda"));
			buttonList.add(new ChatCommandsButton(9, centerX-60, centerY-60, 199, 0, "Esta muerto"));
		}else if(i==2){
			buttonList.add(new ChatCommandsButton(0, centerX, centerY, 0, 101, "Cerrar"));
			/*buttonList.add(new GuiButton(0, centerX, centerY, 94, 20, "§c§lCerrar"));
			buttonList.add(new GuiButton(11, centerX, centerY+30+10, 94, 20, "Zona despejada"));
			buttonList.add(new GuiButton(12, centerX, centerY-30-10, 94, 20, "Ataquen aquí"));
			buttonList.add(new GuiButton(13, centerX-30-70, centerY, 94, 20, "Necesito apoyo aquí"));
			buttonList.add(new GuiButton(14, centerX+30+70, centerY, 94, 20, "Viene alguien!"));
			buttonList.add(new GuiButton(16, centerX-30-70, centerY+30+10, 94, 20, "Ya esta muerto!"));*/
		}
	}
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		drawDefaultBackground();
		int centerX = width/2-37;
		int centerY = height/2-10;
		if(i==0){
			drawCenteredString(fontRendererObj, "[ChatCommands] Menu de ataque", width/2, 10, 0xD1A3FF);
		}else if(i==1){
			drawCenteredString(fontRendererObj, "[ChatCommands] Menu de equipo/amigos", width/2, 10, 0xD1A3FF);
		}
		//fontRendererObj.drawString("Siganame", width / 2, height / 2, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void updateScreen(){
		super.updateScreen();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 0:
			mc.thePlayer.closeScreen();
			break;
		case 3:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al azul!");
			break;
		case 1:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al rojo!");
			break;
		case 4:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al verde!");
			break;
		case 2:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Vamos al amarillo!");
			break;		
		case 5:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Siganme!");
			break;
		case 6:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Agachense!");
			break;
		case 7:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Gracias!");
			break;
		case 8:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Necesito Ayuda!");
			break;
		case 9:
			mc.thePlayer.closeScreen();
			mc.thePlayer.sendChatMessage("[ChatCommands] Ya esta muerto!");
			break;
		}
	}
	
}
