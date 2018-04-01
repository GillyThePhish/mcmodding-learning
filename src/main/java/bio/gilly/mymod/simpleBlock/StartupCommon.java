package bio.gilly.mymod.simpleBlock;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class StartupCommon {
	public static SimpleBlock simpleBlock;
	public static ItemBlock itemSimpleBlock;
	
	public static void preInitCommon() {
		// Register Block
		simpleBlock = (SimpleBlock)(new SimpleBlock().setUnlocalizedName("simple_block_unlocalized_name"));
		simpleBlock.setRegistryName("simple_block_registry_name");
		ForgeRegistries.BLOCKS.register(simpleBlock);
		
		// Register Item Block
		itemSimpleBlock = new ItemBlock(simpleBlock);
		itemSimpleBlock.setRegistryName(simpleBlock.getRegistryName());
		ForgeRegistries.ITEMS.register(itemSimpleBlock);
	}
	
	public static void initCommon() {
		
	}
	
	public static void postInitCommon() {
		
	}
}
