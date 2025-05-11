package me.imgalvin.forceport.mixin;

import me.imgalvin.forceport.ForcePortIOUtils;
import net.minecraft.util.NetworkUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NetworkUtils.class)
public class ForcePortMixin {
	/**
	 * @author GalvinPython
	 * @reason Normally, this method will find a random port for the server to bind to; but we don't want it to :)
	 */
	@Overwrite
	public static int findLocalPort() {
		return ForcePortIOUtils.readPortFromFile();
	}
}