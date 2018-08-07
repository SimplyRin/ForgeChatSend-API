package net.simplyrin.chatsendapi.gui;

import java.io.IOException;

import org.joor.Reflect;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.simplyrin.chatsendapi.event.ChatSendEvent;

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
public class McGuiChat extends GuiChat {

	@Override
	public void keyTyped(char typedChar, int keyCode) throws IOException {
		try {
			Reflect.on(this).set("field_146414_r", true);
		} catch (Exception e) {
			Reflect.on(this).set("waitingOnAutocomplete", true);
		}

		if(keyCode == 15) {
			this.autocompletePlayerNames();
		} else {
			try {
				Reflect.on(this).set("field_146417_i", false);
			} catch (Exception e) {
				Reflect.on(this).set("playerNamesFound", false);
			}

		}

		if(keyCode == 1) {
			this.mc.displayGuiScreen((GuiScreen)null);
		}
		else if(keyCode != 28 && keyCode != 156) {
			if(keyCode == 200) {
				this.getSentHistory(-1);
			}
			else if(keyCode == 208) {
				this.getSentHistory(1);
			}
			else if(keyCode == 201) {
				this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
			}
			else if(keyCode == 209) {
				this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
			} else {
				this.inputField.textboxKeyTyped(typedChar, keyCode);
			}
		} else {
			String s = this.inputField.getText().trim();

			if(s.length() > 0) {
				ChatSendEvent chatSendEvent = new ChatSendEvent(s);
				MinecraftForge.EVENT_BUS.post(chatSendEvent);
				this.sendChatMessage(s);
			}

			this.mc.displayGuiScreen((GuiScreen)null);
		}
	}

}
