package com.carpentersblocks;

import com.carpentersblocks.block.CbBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.carpentersblocks.block.CbBlocks.REGISTRY_NAME_BLOCK;
import static com.carpentersblocks.block.CbBlocks.REGISTRY_NAME_STAIRS;

public class CbBlockStateProvider extends BlockStateProvider {

    public CbBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CarpentersBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ResourceLocation t_uQFrame = modLoc("block/general/uncovered_quartered_frame");

        simpleBlock(CbBlocks.blockBlock, models().cubeAll(REGISTRY_NAME_BLOCK, t_uQFrame));
        simpleBlock(CbBlocks.blockStairs, models().stairs(REGISTRY_NAME_STAIRS, t_uQFrame, t_uQFrame, t_uQFrame));
    }
}
