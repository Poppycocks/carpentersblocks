package com.carpentersblocks;

import com.carpentersblocks.CarpentersBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static com.carpentersblocks.block.CbBlocks.*;

public class CbBlockTags extends BlockTagsProvider {

    public CbBlockTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, CarpentersBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.BEDS).add(blockBed);
        tag(BlockTags.WALLS).add(blockBarrier);
        tag(BlockTags.FENCES).add(blockBarrier);
        tag(BlockTags.FENCE_GATES).add(blockGate);
        tag(BlockTags.TRAPDOORS).add(blockHatch);
        tag(BlockTags.STAIRS).add(blockStairs);
        tag(BlockTags.BUTTONS).add(blockButton);
        tag(BlockTags.DOORS).add(blockDoor);
        tag(BlockTags.FLOWER_POTS).add(blockFlowerPot);
        tag(BlockTags.CLIMBABLE).add(blockLadder);
    }
}
