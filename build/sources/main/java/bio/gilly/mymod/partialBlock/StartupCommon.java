package bio.gilly.mymod.partialBlock;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class StartupCommon {
	public static PartialBlock partialBlock;
	public static ItemBlock partialBlockItem;
	
	public static void preInitCommon() {
		partialBlock = (PartialBlock)(new PartialBlock().setUnlocalizedName("partial_block_unlocalized_name"));
		partialBlock.setRegistryName("partial_block_registry_name");
		ForgeRegistries.BLOCKS.register(partialBlock);
		
		partialBlockItem = new ItemBlock(partialBlock);
		partialBlockItem.setRegistryName(partialBlock.getRegistryName());
		ForgeRegistries.ITEMS.register(partialBlockItem);
	}
	
	public static void initCommon() {}
	
	public static void postInitCommon() {}
}
