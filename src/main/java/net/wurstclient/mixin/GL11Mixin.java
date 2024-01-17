package net.wurstclient.mixin;

import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GL11.class)
public class Gl11Mixin {
    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public static void glBlendFunc(int sfactor, int dfactor) {
        
    }
}
