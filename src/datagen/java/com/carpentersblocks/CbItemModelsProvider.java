package com.carpentersblocks;

import com.carpentersblocks.item.CbItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.carpentersblocks.block.CbBlocks.REGISTRY_NAME_BLOCK;
import static com.carpentersblocks.block.CbBlocks.REGISTRY_NAME_STAIRS;

public class CbItemModelsProvider extends ItemModelProvider {

    public CbItemModelsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CarpentersBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerItemModels();
        registerBlockItemModels();
    }

    private void registerItemModels(){
        ModelFile generated = getExistingFile(mcLoc("item/generated"));
        ModelFile handheld = getExistingFile(mcLoc("item/handheld"));

        withExistingMcModelParent(CbItems.REGISTRY_NAME_APPLICATOR, handheld);
        withExistingMcModelParent(CbItems.REGISTRY_NAME_BED, generated);
        withExistingMcModelParent(CbItems.REGISTRY_NAME_CHISEL, generated);
        withExistingMcModelParent(CbItems.REGISTRY_NAME_DOOR, generated);
        withExistingMcModelParent(CbItems.REGISTRY_NAME_HAMMER, handheld);
        withExistingMcModelParent(CbItems.REGISTRY_NAME_TILE, generated);
    }

    private void registerBlockItemModels(){
//        withExistingBlockParent(REGISTRY_NAME_BARRIER);
        withExistingBlockParent(REGISTRY_NAME_BLOCK);
//        withExistingBlockParent(REGISTRY_NAME_BUTTON);
//        withExistingBlockParent(REGISTRY_NAME_COLLAPSIBLE_BLOCK);
//        withExistingBlockParent(REGISTRY_NAME_DAYLIGHT_SENSOR);
//        withExistingBlockParent(REGISTRY_NAME_FLOWER_POT);
//        withExistingBlockParent(REGISTRY_NAME_GARAGE_DOOR);
//        withExistingBlockParent(REGISTRY_NAME_GATE);
//        withExistingBlockParent(REGISTRY_NAME_HATCH);
//        withExistingBlockParent(REGISTRY_NAME_LADDER);
//        withExistingBlockParent(REGISTRY_NAME_LEVER);
//        withExistingBlockParent(REGISTRY_NAME_PRESSURE_PLATE);
//        withExistingBlockParent(REGISTRY_NAME_SAFE);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_WEDGE);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_WEDGE_INTERIOR);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_WEDGE_EXTERIOR);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_OBLIQUE_INTERIOR);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_OBLIQUE_EXTERIOR);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_PRISM_WEDGE);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_PRISM);
//        withExistingBlockParent(REGISTRY_NAME_SLOPE_INVERTED_PRISM);
        withExistingBlockParent(REGISTRY_NAME_STAIRS);
//        withExistingBlockParent(REGISTRY_NAME_TORCH);
    }

    private ItemModelBuilder withExistingBlockParent(String name) {
        return withExistingParent(name, modLoc("block/"+name));
    }

    private ItemModelBuilder withExistingMcModelParent(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "item/"+name);
    }
}