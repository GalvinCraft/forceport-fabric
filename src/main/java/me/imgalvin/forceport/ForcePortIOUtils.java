package me.imgalvin.forceport;

import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForcePortIOUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger("ForcePort");

    // Get the path to the Minecraft installation directory
    public static Path getMinecraftInstallationLocation() {
        Minecraft client = Minecraft.getInstance();
        return client.gameDirectory.toPath();
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
            LOGGER.error("An error occurred while creating the configuration file.", e);
        }
    }

    // Check if the port is valid
    public static boolean checkValidation(String portString) {
        if (!portString.matches("\\d+")) {
            return false;
        }
        int port = Integer.parseInt(portString);
        return port > 0 && port < 65535;
    }

    // Read the port from the configuration file
    public static int readPortFromFile() {
        Path minecraftDir = getMinecraftInstallationLocation();
        Path configFile = minecraftDir.resolve("config").resolve("ForcePort.txt");

        try {
            if (Files.exists(configFile)) {
                String portString = Files.readString(configFile).trim();

                if (portString.isBlank()) {
                    LOGGER.warn("ForcePort.txt is empty or invalid, using default 25565.");
                    return 25565;
                }

                boolean isValid = checkValidation(portString);

                if (!isValid) {
                    LOGGER.warn("Invalid port in ForcePort.txt, using default 25565. Please check the file.");
                }
                return isValid ? Integer.parseInt(portString) : 25565;
            }
        } catch (IOException e) {
            LOGGER.error("An error occurred while reading the configuration file.", e);
        }

        return 25565;
    }
}