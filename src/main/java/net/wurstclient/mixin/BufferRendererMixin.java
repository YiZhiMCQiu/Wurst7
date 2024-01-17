package net.wurstclient.mixin;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BufferRenderer.class)
public class BufferRendererMixin {
    /**
     * @author YiZhiMCQiu
     * @reason Fix VulkanMod error
     */
    @Overwrite(remap = false)
    public static void drawWithGlobalProgram(BufferBuilder.BuiltBuffer buffer) {

    }
}
