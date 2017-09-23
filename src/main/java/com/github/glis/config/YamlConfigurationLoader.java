package com.github.glis.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author Glis
 */
public abstract class YamlConfigurationLoader implements Configuration<YamlConfiguration> {
    /**
     * The name of the file we are loading.
     */
    private final String fileName;

    /**
     * The {@link JavaPlugin} the configuration is for.
     */
    private final JavaPlugin javaPlugin;

    /**
     * @param javaPlugin The {@link JavaPlugin} the configuration is for.
     */
    public YamlConfigurationLoader(String fileName, JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        this.fileName = fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public YamlConfiguration loadConfiguration() throws IOException, InvalidConfigurationException {
        final YamlConfiguration yamlConfiguration = new YamlConfiguration();
        File file = new File(javaPlugin.getDataFolder(), fileName);
        if (!file.exists() && file.mkdirs()) {
            javaPlugin.saveResource(fileName, false);
            createDefaults();
            yamlConfiguration.save(file);
        } else {
            yamlConfiguration.load(file);
        }
        return yamlConfiguration;
    }

    /**
     * Creates the default configuration.
     */
    protected abstract void createDefaults();
}
