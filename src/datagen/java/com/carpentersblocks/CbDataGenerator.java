package com.carpentersblocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CarpentersBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CbDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper exHelper = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();

        CbBlockStateProvider blockStates = new CbBlockStateProvider(gen, exHelper);
        gen.addProvider(blockStates);

        gen.addProvider(new CbItemModelsProvider(gen, exHelper));

        CbBlockTags cbBlockTags = new CbBlockTags(gen, exHelper);
        gen.addProvider(cbBlockTags);
//            gen.addProvider(new CBItemTags(gen, cbBlockTags, exHelper));
//            gen.addProvider(new TileTags(gen, exHelper));
//            gen.addProvider(new Recipes(gen));

//        }
    }
}
