# Force Port
[Download from Modrinth](https://modrinth.com/mod/forceport)

A mod that forces the port to always be the same when using the "Open To LAN" feature!

*Client-side only!*

![Demonstration](https://raw.githubusercontent.com/GalvinCraft/forceport-fabric/main/.github/assets/java_KexlmNWPWE.png)

*The configuration menu on recent Minecraft versions*

# Usage
Force Port allows you to modify the default port used when opening your world to LAN. This is useful for those who want to use a specific port for their server.

Just go to the installation location for that Minecraft instance, and open the `config` folder. You should see a file called `forceport.txt`. Open it with a text editor and change the port to your desired port.

# Compatible Versions
All versions of Minecraft from 1.14 to the latest version are supported, including snapshots!
- 1.0.0 and 1.0.1 are compatible from 1.14 to 1.21.11
- 1.0.2 and above are compatible with 26.1 snapshots and above.

# Important Note
- This mod hasn't been tested full on older Quilt versions or older mod loaders. However, this mod does work on Fabric for 1.14 and above using Mod Loader 0.16.0+
  - If you're using the latest Minecraft versions, you can use this mod without any issues.
- The Fabric API is NOT required for this mod to work.
- If playing on versions before 1.20.5, you need to set your instance to use Java 21. For versions after, just use the default Java version.
- As of 1.0.1, if the config file is not valid, it will default to `25565` (the default port for Minecraft servers). This is to prevent the mod from crashing. If the mod doesn't seem to work, please verify your config file!

# Changelog
## 1.0.2
- Added support for Minecraft 26.1 snapshots and above.

## 1.0.1
- Fixed a bug where the mod would crash if newlines were added into the `forceport.txt` file (a default feature in some Linux text editors).
- Added a check to make sure the port is a number and is between 0 and 65535.
