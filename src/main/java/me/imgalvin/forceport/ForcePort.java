package me.imgalvin.forceport;

import net.fabricmc.api.ClientModInitializer;

public class ForcePort implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ForcePortIOUtils.createConfigFile();
	}
}