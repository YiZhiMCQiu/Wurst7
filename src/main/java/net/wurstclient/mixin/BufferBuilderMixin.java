package net.wurstclient.mixin;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormatElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.ByteBuffer;

@Mixin(BufferBuilder.class)
public abstract class BufferBuilderMixin {
    @Shadow
    private boolean building;
    @Shadow
    private VertexFormat.DrawMode drawMode;
    @Shadow
    private void setFormat(VertexFormat format) {}
    @Shadow
    private VertexFormatElement currentElement;
    @Shadow
    private int currentElementId;
    @Shadow
    private ByteBuffer buffer;
    // TODO 注入begin方法, 使调用DEBUG开头的DrawMode改为普通的
    @Inject(at = @At("HEAD"), method = "begin", cancellable = true)
    public void begin(VertexFormat.DrawMode drawMode, VertexFormat format, CallbackInfo ci) {
        if (!this.building) {
            drawMode = drawMode == VertexFormat.DrawMode.DEBUG_LINE_STRIP ? VertexFormat.DrawMode.LINE_STRIP : drawMode;
            drawMode = drawMode == VertexFormat.DrawMode.DEBUG_LINES ? VertexFormat.DrawMode.LINES : drawMode;
            drawMode = drawMode == VertexFormat.DrawMode.LINES ? VertexFormat.DrawMode.QUADS : drawMode;
            this.building = true;
            this.drawMode = drawMode;
            this.setFormat(format);
            this.currentElement = (VertexFormatElement)format.getElements().get(0);
            this.currentElementId = 0;
            this.buffer.rewind();
        }
        ci.cancel();
    }
}
