package net.simplyrin.chatsendapi;

import org.joor.Reflect;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.simplyrin.chatsendapi.gui.McGuiChat;

/**
 * Created by SimplyRin on 2018/08/07.
 *
 * Copyright (c) 2018 SimplyRin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
@Mod(modid = "ForgeChatSend-API", version = "1.0")
public class Main {

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onInitGui(GuiScreenEvent.InitGuiEvent.Post event) {
		if(FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			if(FMLClientHandler.instance().isGUIOpen(McGuiChat.class)) {
				return;
			}
			GuiChat guiChat = (GuiChat) Minecraft.getMinecraft().currentScreen;

			String defaultInputFieldText = "";
			try {
				defaultInputFieldText = Reflect.on(guiChat).field("field_146409_v").get();
			} catch (Exception e) {
				defaultInputFieldText = Reflect.on(guiChat).field("defaultInputFieldText").get();
			}

			Minecraft.getMinecraft().displayGuiScreen(new McGuiChat(defaultInputFieldText));
		}
	}

}
