package com.carpentersblocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CBItemTags extends ItemTagsProvider {
    public CBItemTags(DataGenerator gen, CbBlockTags cbBlockTags, ExistingFileHelper exHelper) {
        super(gen, cbBlockTags, CarpentersBlocks.MOD_ID, exHelper);
    }

    @Override
    protected void addTags() {

    }

}
