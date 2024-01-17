package net.wurstclient.mixin;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Tessellator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Tessellator.class)
public class BufferRendererMixin {
    private static final BufferBuilder.BuiltBuffer  = new BufferBuilder(1048576).end();
    // TODO 修改Tessellator中调用drawWithGlobalProgram方法的地方，将值改为调试值
    @Inject(method = "draw", at = @At("HEAD"))
    public void draw(CallbackInfo ci) {
        BufferRenderer.drawWithGlobalProgram(DEFAULT_BUFFER);
    }
}
