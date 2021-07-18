package com.carpentersblocks.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.carpentersblocks.CarpentersBlocks;
import com.carpentersblocks.block.CbBlocks;
import com.carpentersblocks.config.Configuration;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = CarpentersBlocks.MOD_ID, bus = Bus.MOD)
public class CbItems {

	public static final String REGISTRY_NAME_APPLICATOR = "applicator";
	public static final String REGISTRY_NAME_BED = "bed";
	public static final String REGISTRY_NAME_CHISEL = "chisel";
	public static final String REGISTRY_NAME_DOOR = "door";
	public static final String REGISTRY_NAME_HAMMER = "hammer";
	public static final String REGISTRY_NAME_TILE = "tile";
	
	public static Item itemApplicator;
	public static Item itemBed;
	public static Item itemChisel;
	public static Item itemDoor;
    public static Item itemHammer;
    public static Item itemTile;
    
    public static BlockItem blockItemBarrier;
    public static BlockItem blockItemBlock;
    public static BlockItem blockItemButton;
    public static BlockItem blockItemCollapsibleBlock;
    public static BlockItem blockItemDaylightSensor;
    public static BlockItem blockItemFlowerPot;
    public static BlockItem blockItemGarageDoor;
    public static BlockItem blockItemGate;
    public static BlockItem blockItemHatch;
    public static BlockItem blockItemLadder;
    public static BlockItem blockItemLever;
    public static BlockItem blockItemPressurePlate;
    public static BlockItem blockItemSafe;
    public static BlockItem blockItemSlopeWedge;
    public static BlockItem blockItemSlopeWedgeInterior;
    public static BlockItem blockItemSlopeWedgeExterior;
    public static BlockItem blockItemSlopeObliqueInterior;
    public static BlockItem blockItemSlopeObliqueExterior;
    public static BlockItem blockItemSlopePrismWedge;
    public static BlockItem blockItemSlopePrism;
    public static BlockItem blockItemSlopeInvertedPrism;
    public static BlockItem blockItemStairs;
    public static BlockItem blockItemTorch;
    
    public static final List<BlockItem> slopeBlockItemSubTypes = Collections.synchronizedList(new ArrayList<>());
    
    @SubscribeEvent
    public static void onRegisterItemEvent(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		// applicator
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
    		itemApplicator = new ItemCarpentersApplicator(properties)
					.setRegistryName(REGISTRY_NAME_APPLICATOR);
			registry.register(itemApplicator);
    	}
    	// barrier
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemBarrier = new BlockItem(CbBlocks.blockBarrier, properties);
			blockItemBarrier.setRegistryName(CbBlocks.blockBarrier.getRegistryName());
			registry.register(blockItemBarrier);
    	}
		// bed
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
    		itemBed = new ItemCarpentersBed(properties)
					.setRegistryName(REGISTRY_NAME_BED);
			registry.register(itemBed);
    	}
		// block
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemBlock = new BlockItem(CbBlocks.blockBlock, properties);
			blockItemBlock.setRegistryName(CbBlocks.blockBlock.getRegistryName());
			registry.register(blockItemBlock);
    	}
    	// button
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemButton = new BlockItem(CbBlocks.blockButton, properties);
			blockItemButton.setRegistryName(CbBlocks.blockButton.getRegistryName());
			registry.register(blockItemButton);
    	}
		// chisel
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
    		if (Configuration.isItemCarpentersToolsDamageable()) {
    			properties.durability(Configuration.getItemCarpentersToolsUses());
    		}
    		itemChisel = new ItemCarpentersHammer(properties)
					.setRegistryName(REGISTRY_NAME_CHISEL);
			registry.register(itemChisel);
    	}
		// collapsible block
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemCollapsibleBlock = new BlockItem(CbBlocks.blockCollapsibleBlock, properties);
			blockItemCollapsibleBlock.setRegistryName(CbBlocks.blockCollapsibleBlock.getRegistryName());
			registry.register(blockItemCollapsibleBlock);
    	}
		// daylight sensor
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
    		blockItemDaylightSensor = new BlockItem(CbBlocks.blockDaylightSensor, properties);
			blockItemDaylightSensor.setRegistryName(CbBlocks.blockDaylightSensor.getRegistryName());
			registry.register(blockItemDaylightSensor);
	    }
		// door
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(3);
    		itemDoor = new ItemCarpentersDoor(properties)
					.setRegistryName(REGISTRY_NAME_DOOR);
			registry.register(itemDoor);
    	}
		// flower pot
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemFlowerPot = new BlockItem(CbBlocks.blockFlowerPot, properties);
			blockItemFlowerPot.setRegistryName(CbBlocks.blockFlowerPot.getRegistryName());
			registry.register(blockItemFlowerPot);
	    }
		// garage door
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemGarageDoor = new BlockItem(CbBlocks.blockGarageDoor, properties);
			blockItemGarageDoor.setRegistryName(CbBlocks.blockGarageDoor.getRegistryName());
			registry.register(blockItemGarageDoor);
	    }
		// gate
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemGate = new BlockItem(CbBlocks.blockGate, properties);
			blockItemGate.setRegistryName(CbBlocks.blockGate.getRegistryName());
			registry.register(blockItemGate);
	    }
		// hammer
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
    		if (Configuration.isItemCarpentersToolsDamageable()) {
    			properties.durability(Configuration.getItemCarpentersToolsUses());
    		}
			itemHammer = new ItemCarpentersHammer(properties)
					.setRegistryName(REGISTRY_NAME_HAMMER);
			registry.register(itemHammer);
    	}
		// hatch
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemHatch = new BlockItem(CbBlocks.blockHatch, properties);
			blockItemHatch.setRegistryName(CbBlocks.blockHatch.getRegistryName());
			registry.register(blockItemHatch);
	    }
		// ladder
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemLadder = new BlockItem(CbBlocks.blockLadder, properties);
			blockItemLadder.setRegistryName(CbBlocks.blockLadder.getRegistryName());
			registry.register(blockItemLadder);
	    }
		// lever
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemLever = new BlockItem(CbBlocks.blockLever, properties);
			blockItemLever.setRegistryName(CbBlocks.blockLever.getRegistryName());
			registry.register(blockItemLever);
	    }
		// pressure plate
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemPressurePlate = new BlockItem(CbBlocks.blockPressurePlate, properties);
			blockItemPressurePlate.setRegistryName(CbBlocks.blockPressurePlate.getRegistryName());
			registry.register(blockItemPressurePlate);
	    }
		// safe
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemSafe = new BlockItem(CbBlocks.blockSafe, properties);
			blockItemSafe.setRegistryName(CbBlocks.blockSafe.getRegistryName());
			registry.register(blockItemSafe);
	    }
		// slope
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(64);
			registry.register(blockItemSlopeInvertedPrism = (BlockItem) new BlockItem(CbBlocks.blockSlopeInvertedPrism, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_INVERTED_PRISM));
			registry.register(blockItemSlopeObliqueExterior = (BlockItem) new BlockItem(CbBlocks.blockSlopeObliqueExterior, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_OBLIQUE_EXTERIOR));
			registry.register(blockItemSlopeObliqueInterior = (BlockItem) new BlockItem(CbBlocks.blockSlopeObliqueInterior, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_OBLIQUE_INTERIOR));
			registry.register(blockItemSlopePrism = (BlockItem) new BlockItem(CbBlocks.blockSlopePrism, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_PRISM));
			registry.register(blockItemSlopePrismWedge = (BlockItem) new BlockItem(CbBlocks.blockSlopePrismWedge, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_PRISM_WEDGE));
			registry.register(blockItemSlopeWedge = (BlockItem) new BlockItem(CbBlocks.blockSlopeWedge, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_WEDGE));
			registry.register(blockItemSlopeWedgeExterior = (BlockItem) new BlockItem(CbBlocks.blockSlopeWedgeExterior, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_WEDGE_EXTERIOR));
			registry.register(blockItemSlopeWedgeInterior = (BlockItem) new BlockItem(CbBlocks.blockSlopeWedgeInterior, properties)
		    		.setRegistryName(CbBlocks.REGISTRY_NAME_SLOPE_WEDGE_INTERIOR));
			slopeBlockItemSubTypes.add(blockItemSlopeWedge);
			slopeBlockItemSubTypes.add(blockItemSlopeWedgeInterior);
			slopeBlockItemSubTypes.add(blockItemSlopeWedgeExterior);
			slopeBlockItemSubTypes.add(blockItemSlopeObliqueInterior);
			slopeBlockItemSubTypes.add(blockItemSlopeObliqueExterior);
			slopeBlockItemSubTypes.add(blockItemSlopePrismWedge);
			slopeBlockItemSubTypes.add(blockItemSlopePrism);
			slopeBlockItemSubTypes.add(blockItemSlopeInvertedPrism);
	    }
		// stairs
		{
			Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(64);
			blockItemStairs = new BlockItem(CbBlocks.blockStairs, properties);
			blockItemStairs.setRegistryName(CbBlocks.blockStairs.getRegistryName());
			registry.register(blockItemStairs);
	    }
		// tile
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(64);
			itemTile = new ItemCarpentersHammer(properties)
					.setRegistryName(REGISTRY_NAME_TILE);
			registry.register(itemTile);
    	}
		// torch
    	{
    		Item.Properties properties = new Item.Properties()
    				.tab(CarpentersBlocks.ITEM_GROUP)
    				.stacksTo(1);
			blockItemTorch = new BlockItem(CbBlocks.blockTorch, properties);
			blockItemTorch.setRegistryName(CbBlocks.blockTorch.getRegistryName());
			registry.register(blockItemTorch);
    	}
    }
    
    /**
     * Gets next slope sub type.
     * 
     * @param currentRegistryName the current registry name
     * @return the next slope block item
     */
    public static BlockItem getNextSlopeSubType(String currentRegistryName) {
		return getIndexedSlopeSubType(currentRegistryName, true);
	}
	
    /**
     * Gets previous slope sub type.
     * 
     * @param currentRegistryName the current registry name
     * @return the previous slope block item
     */
	public static BlockItem getPreviousSlopeSubType(String currentRegistryName) {
		return getIndexedSlopeSubType(currentRegistryName, false);
	}
	
	/**
	 * Gets next or previous slope sub type.
	 * 
	 * @param currentRegistryName the currently held block item
	 * @param next <code>true</code> to get next subtype and <code>false</code> gets previous subtype
	 */
	private static BlockItem getIndexedSlopeSubType(String currentRegistryName, boolean next) {
		BlockItem currentItem = (BlockItem) ForgeRegistries.ITEMS.getValue(new ResourceLocation(currentRegistryName));
		for (int i = 0;; i++) {
			if (slopeBlockItemSubTypes.get(i).equals(currentItem)) {
				if (next) {
					if (i == slopeBlockItemSubTypes.size() - 1) {
						return slopeBlockItemSubTypes.get(0);
					} else {
						return slopeBlockItemSubTypes.get(i + 1);
					}
				} else {
					if (i == 0) {
						return slopeBlockItemSubTypes.get(slopeBlockItemSubTypes.size() - 1);
					} else {
						return slopeBlockItemSubTypes.get(i - 1);
					}
				}
			}
		}
	}
    
}
