package bio.gilly.mymod.coloredSign;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ColoredSign extends Block {
	public ColoredSign() {
		super(Material.WOOD);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState bs) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState bs) {
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState bs) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState bs, IBlockAccess ba, BlockPos bp) {
		return NULL_AABB;
	}
	
	public static final PropertyDirection PROPERTY_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<EnumColor> PROPERTY_COLOR = PropertyEnum.create("color", EnumColor.class);
	
	public int damageDropped(IBlockState state) {
		EnumColor enumColor = (EnumColor)state.getValue(PROPERTY_COLOR);
		return enumColor.getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs whichtab, NonNullList<ItemStack> items) {
		EnumColor[] allColors = EnumColor.values();
		for (EnumColor color : allColors) {
			items.add(new ItemStack(this, 1, color.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getHorizontal(meta);
		int colorBits = (meta & 0x0c) >> 2;
		EnumColor color = EnumColor.byMetadata(colorBits);
		return this.getDefaultState().withProperty(PROPERTY_COLOR, color).withProperty(PROPERTY_FACING, facing);
	}
	
	public static enum EnumColor implements IStringSerializable {
		BLUE(0, "blue"),
		RED(1, "red"),
		GREEN(2, "green"),
		YELLOW(3, "yellow");
		
		private final String name;
		private final int meta;
		private static final EnumColor[] META_LOOKUP = new EnumColor[values().length];
		
		private EnumColor(int i_meta, String i_name) {
			this.meta = i_meta;
			this.name= i_name;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public int getMetadata() {
			return this.meta;
		}
		
		public static EnumColor byMetadata(int meta) {
			if (meta < 0 || meta >= values().length) {
				meta = 0;
			}
			
			return META_LOOKUP[meta];
		}
		
		static {
			for (EnumColor color : values()) {
				META_LOOKUP[color.getMetadata()] = color;
			}
		}
	}
}
