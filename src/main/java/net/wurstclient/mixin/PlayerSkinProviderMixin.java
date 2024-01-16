/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import net.minecraft.client.texture.PlayerSkinProvider;
import net.minecraft.client.texture.PlayerSkinTexture;

@Mixin(PlayerSkinProvider.class)
public abstract class PlayerSkinProviderMixin
{
	private static JsonObject capes;
	private MinecraftProfileTexture currentCape;
	

	
	private void setupWurstCapes()
	{
		try
		{
			// TODO: download capes to file
			URL url = new URL("https://www.wurstclient.net/api/v1/capes.json");
			
			capes =
				JsonParser.parseReader(new InputStreamReader(url.openStream()))
					.getAsJsonObject();
			
		}catch(Exception e)
		{
			System.err
				.println("[Wurst] Failed to load capes from wurstclient.net!");
			
			e.printStackTrace();
		}
	}
}
