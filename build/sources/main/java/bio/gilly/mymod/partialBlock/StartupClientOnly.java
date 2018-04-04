package bio.gilly.mymod.partialBlock;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly {
	public static void preInitClientOnly() {
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("mymod:partial_block", "inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		ModelLoader.setCustomModelResourceLocation(StartupCommon.partialBlockItem, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}
	
	public static void initClientOnly() {}
	public static void postInitClientOnly() {}
}
