package com.carpentersblocks.network;

import java.util.function.Supplier;

import com.carpentersblocks.CarpentersBlocks;
import com.carpentersblocks.ICarpentersChisel;
import com.carpentersblocks.ICarpentersHammer;
import com.carpentersblocks.block.AbstractCoverableBlock;
import com.carpentersblocks.util.BlockUtil;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.NetworkEvent.Context;

@EventBusSubscriber(modid = CarpentersBlocks.MOD_ID)
public class PacketAttackBlock implements ICarpentersBlocksPacket {

	protected BlockRayTraceResult blockRayTraceResult;
	protected Hand hand;
	
	public PacketAttackBlock() {}
	
    public PacketAttackBlock(BlockRayTraceResult blockRayTraceResult, Hand hand) {
    	this.hand = hand;
    	this.blockRayTraceResult = blockRayTraceResult;
    }
    
    public PacketAttackBlock(PacketBuffer packetBuffer) {
    	hand = packetBuffer.readEnum(Hand.class);
    	blockRayTraceResult = packetBuffer.readBlockHitResult();
    }
    
	public static void encode(final PacketAttackBlock msg, PacketBuffer buffer) {
		buffer.writeEnum(msg.hand);
		buffer.writeBlockHitResult(msg.blockRayTraceResult);
	}
	
	public static void handle(final PacketAttackBlock msg, Supplier<Context> ctx) {
		ctx.get().enqueueWork(() -> {
			if (!BlockUtil.isAreaLoaded(ctx.get().getSender().getLevel(), msg.blockRayTraceResult.getBlockPos())) {
				return;
			}
			ServerPlayerEntity serverPlayerEntity = ctx.get().getSender();
			BlockRayTraceResult blockRayTraceResult = msg.blockRayTraceResult;
			BlockState blockState = serverPlayerEntity.getLevel().getBlockState(blockRayTraceResult.getBlockPos());
	    	((AbstractCoverableBlock)blockState.getBlock()).attack(
	    			blockState, serverPlayerEntity.getLevel(), blockRayTraceResult.getBlockPos(), serverPlayerEntity, msg.hand, blockRayTraceResult);
		});
	}
	
	/**
     * Intercepts block left click action and sends packet to
     * server with {@link BlockRayTraceResult} if conditions
     * are met.
     * 
     * @param event the event
     */
    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
    	// skip event if holding nothing, or if not holding Carpenter's tool
    	ItemStack itemStack = event.getPlayer().getItemInHand(event.getHand());
    	if (itemStack == null ||
    			!(itemStack.getItem() instanceof ICarpentersChisel || itemStack.getItem() instanceof ICarpentersHammer)) {
    		return;
    	}
    	
    	// skip if not clicking on a Carpenter's block
    	if (!(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof AbstractCoverableBlock)) {
    		return;
    	}
    	
    	// we want to cancel this event once it reaches the server
    	// this doesn't do anything client side, so we check that below before performing more work
    	event.setCanceled(true);
    	
    	// skip if player holding attack key
    	if (event.getPlayer().swinging) {
    		return;
    	}
		
    	// handle client side tasks
    	if (event.getWorld().isClientSide()) {
	    	// send packet with attack hit vector and hand included for Carpenter's tool interactions
	    	BlockRayTraceResult blockRayTraceResult = (BlockRayTraceResult) Minecraft.getInstance().hitResult;
	    	if (BlockUtil.isValidTileEntity(event.getWorld(), event.getPos())) {
	    		CarpentersBlocksPacketHandler.sendToServer(new PacketAttackBlock(blockRayTraceResult, event.getHand()));
	    	}
	    	// call custom attack method to update block display on client only
	    	BlockState blockState = event.getPlayer().level.getBlockState(event.getPos());
			((AbstractCoverableBlock)blockState.getBlock()).attack(blockState, event.getWorld(), event.getPos(), event.getPlayer(), event.getHand(), blockRayTraceResult);
    	}
    }
	
}