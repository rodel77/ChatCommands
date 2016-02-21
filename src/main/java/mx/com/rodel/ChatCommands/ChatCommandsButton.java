package mx.com.rodel.ChatCommands;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ChatCommandsButton extends GuiButton{
	private String location;
	public static ResourceLocation res = new ResourceLocation(ChatCommands.MODID+":textures/gui/tile.png");
	
	private int uvx;
	private int uvy;
	private String command;
	public int fcolor = 16777120;
	private int min = 16777000;
	private int max = 16777130;
	//false subir | true bajar
	private boolean side = false;
	private int color;
	
	public ChatCommandsButton(int buttonId, int x, int y, int uvx, int uvy, String command) {
		super(buttonId, x, y, 49, 50, "");
		this.uvx=uvx;
		this.uvy=uvy;
		this.command = command;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if(this.visible){
			FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(res);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition+12 && mouseY >= this.yPosition-12 && mouseX < this.xPosition+12 + this.width && mouseY < this.yPosition-12 + this.height;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            
            int k = uvy;
            
            if(this.hovered){
            	k+=this.height;
            }
            
            this.drawTexturedModalRect(this.xPosition+12, this.yPosition-12, uvx, k, this.width, this.height);
            
            if(true){
            	if(fcolor==max){
            		side = true;
            	}
            	
            	if(fcolor==min){
            		side = false;
            	}
            	
            	if(side){
            		--fcolor;
            	}else{
            		++fcolor;
            	}
            	
           		if(command.contains("Rojo") || command=="Cerrar"){
            			color = 0xFF0000;
            	}else if(command.contains("Amarillo")){
            		color = 0xFFD800;
            	}else if(command.contains("Azul")){
            		color = 0x0069DA;
            	}else if(command.contains("Verde")){
            		color = 0x4CFF00;
            	}else{
        			color = 0x00B7FF;
        		}
            	
           		if(this.hovered){
            		this.drawCenteredString(fontrenderer, command, xPosition+12+this.width/2, yPosition-12, color);
           		}
		}
	}
}
}
