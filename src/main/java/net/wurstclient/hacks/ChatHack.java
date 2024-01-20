package net.wurstclient.hacks;

import net.minecraft.text.Text;
import net.wurstclient.Category;
import net.wurstclient.WurstClient;
import net.wurstclient.events.ChatOutputListener;
import net.wurstclient.hack.Hack;
import net.wurstclient.settings.CheckboxSetting;

import java.util.List;

public class ChatHack extends Hack implements ChatOutputListener {
    public static final List<Character> BANNED_CHARS = List.of('.', '/');
    public ChatHack() {
        super("Chat");
        setCategory(Category.CHAT);
        addSetting(randomPrefix);
    }
    private final CheckboxSetting randomPrefix = new CheckboxSetting(
            "Random prefix",
            "Add a random prefix so that the sent chats are not duplicated, which is suitable for servers that send duplicate chats multiple times.",
            true);

    @Override
    protected void onEnable() {
        EVENTS.add(ChatOutputListener.class, this);
    }

    @Override
    protected void onDisable() {
        EVENTS.remove(ChatOutputListener.class, this);
    }

    @Override
    public void onSentMessage(ChatOutputEvent event) {
        if (!BANNED_CHARS.contains(event.getMessage().charAt(0))) {
            String prefix = "";
            if (randomPrefix.isChecked()) {
                prefix = "(" + String.format("%03d", Math.round(Math.random() * 100)) + ") ";
            }
            String suffix = " | WuRsT VkFiX By yIzHiMcQiU";
            String newMessage = prefix + event.getMessage() + suffix;
            event.cancel();
            MC.getNetworkHandler().sendChatMessage(newMessage);
        }
    }
}
