package net.wurstclient.mixin;

import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GL11.class)
public class Gl11Mixin {
    /**
     * @author YiZhiMCQiu
     * @reason disable blend to fix not supported method.
     */
    @Overwrite(remap = false)
    public static void glBlendFunc(int sfactor, int dfactor) {
        
    }
    /**
     * @author YiZhiMCQiu
     * @reason disable depth mask to fix not supported method.
     */
    @Overwrite(remap = false)
    public static void glDepthMask(boolean flag) {

    }
}
