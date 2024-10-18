package me.imgalvin.forceport;

import net.minecraft.client.MinecraftClient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForcePortIOUtils {

    // Get the path to the Minecraft installation directory
    public static Path getMinecraftInstallationLocation() {
        return MinecraftClient.getInstance().runDirectory.toPath();
    }

    // Create a configuration file with the default port
    public static void createConfigFile() {
        Path minecraftDir = getMinecraftInstallationLocation();
        Path configDir = minecraftDir.resolve("config");
        Path configFile = configDir.resolve("ForcePort.txt");

        try {
            if (!Files.exists(configDir)) {
                Files.createDirectories(configDir);
            }

            if (!Files.exists(configFile)) {
                Files.writeString(configFile, "25565");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read the port from the configuration file
    public static int readPortFromFile() {
        Path minecraftDir = getMinecraftInstallationLocation();
        Path configFile = minecraftDir.resolve("config").resolve("ForcePort.txt");

        try {
            if (Files.exists(configFile)) {
                return Integer.parseInt(Files.readString(configFile));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 25565;
    }
}