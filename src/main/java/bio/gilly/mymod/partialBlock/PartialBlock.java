package bio.gilly.mymod.partialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartialBlock extends Block {
	public PartialBlock() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
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
}
