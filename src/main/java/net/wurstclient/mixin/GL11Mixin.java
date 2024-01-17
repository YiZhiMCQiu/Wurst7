package net.wurstclient.mixin;

import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GL11.class)
public class GL11Mixin {
    @Inject(at=@At("HEAD"), method="glBlendFunc", cancellable = true)
    private static void glBlendFunc(int sfactor, int dfactor, CallbackInfo ci) {
        return;
    }
}
