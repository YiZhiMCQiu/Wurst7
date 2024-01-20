package net.wurstclient.hacks;

import net.minecraft.text.Text;
import net.wurstclient.Category;
import net.wurstclient.events.ChatInputListener;
import net.wurstclient.hack.Hack;

import java.util.ArrayList;
import java.util.List;


public class ChatShieldHack extends Hack implements ChatInputListener {
    public static final List<String> SHIELD_STRINGS = List.of("草", "妈", "傻逼", "sb", "射", "撅", "操", "fvv", "fw", "废物", "艹", "逼");
    public ChatShieldHack() {
        super("ChatShield");
        setCategory(Category.CHAT);
    }

    @Override
    protected void onEnable() {
        EVENTS.add(ChatInputListener.class, this);
    }

    @Override
    protected void onDisable() {
        EVENTS.remove(ChatInputListener.class, this);
    }

    @Override
    public void onReceivedMessage(ChatInputEvent event) {
        SHIELD_STRINGS.forEach((str) -> {
            String chatString = event.getComponent().getString();
            event.setComponent(Text.of(chatString.replace(str, "*")));
        });
    }
}
