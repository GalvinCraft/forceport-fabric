package me.imgalvin.forceport.mixin;

import me.imgalvin.forceport.ForcePortIOUtils;
import net.minecraft.util.NetworkUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NetworkUtils.class)
public class ForcePortMixin {
	@Overwrite
	public static int findLocalPort() {
		return ForcePortIOUtils.readPortFromFile();
	}
}