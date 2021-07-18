package com.carpentersblocks.block;

import com.carpentersblocks.config.Configuration;
import com.carpentersblocks.nbt.CbTileEntity;
import com.carpentersblocks.util.states.StateConstants;
import com.carpentersblocks.util.states.StateMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockCarpentersStairs extends AbstractCoverableBlock implements IStateImplementor {

	private static StateMap _stateMap;
	
	public BlockCarpentersStairs(Properties properties, StateMap stateMap) {
		super(properties);
		_stateMap = stateMap;
	}

	@Override
	/**
	 * Alters block direction.
	 */
	protected boolean onHammerLeftClick(CbTileEntity cbTileEntity, PlayerEntity playerEntity) {
		//SlopeData.rotate(cbTileEntity, EventHandler.getRayTraceResult().getDirection().getAxis());
		return true;
	}

	@Override
	protected void damageItemWithChance(World world, PlayerEntity playerEntity, Hand hand) {
		if (world.random.nextFloat() <= Configuration.getItemHammerDamageChanceFromStairs()) {
			super.damageItemWithChance(world, playerEntity, hand);
		}
	}

	@Override
	public String getStateDescriptor(CbTileEntity cbTileEntity) {
		return StateConstants.DEFAULT_STATE;
	}

	@Override
	public StateMap getStateMap() {
		return _stateMap;
	}

	/**
	 * We want to reduce the shape by just a fraction so that
	 * occlusion doesn't darken the interior faces of slopes.
	 */
	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_,
							   ISelectionContext p_220053_4_) {
		return Block.box(0.0001D, 0.0001D, 0.0001D, 15.9999D, 15.9999D, 15.9999D);
	}

}
