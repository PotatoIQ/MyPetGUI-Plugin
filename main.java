package me.illuminatiproductions.youtubeplugin;

import me.illuminatiproductions.youtubeplugin.commands.GUICommand;
import me.illuminatiproductions.youtubeplugin.events.GUIMoveItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class YoutubePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("gui").setExecutor(new GUICommand());

        getServer().getPluginManager().registerEvents(new GUIMoveItem(), this);
    }
}
