package com.atechnologeek.strangercrafts.events;

import com.atechnologeek.strangercrafts.StrangerCrafts;

import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid=StrangerCrafts.MOD_ID, bus=Bus.FORGE)
public class OnBlockChangedEvent {
	@SubscribeEvent
	public static void onBlockPlacedEvent(EntityPlaceEvent event) {
		StrangerCrafts.LOGGER.info("Block Placed Event Fired!");
		World overworld = event.getEntity().getServer().getWorld(DimensionType.OVERWORLD);
		World upsideDown = event.getEntity().getServer().getWorld(DimensionType.byName(StrangerCrafts.UPSIDE_DOWN_TYPE));
		BlockState block = event.getPlacedBlock();
		overworld.setBlockState(event.getPos(), block);
		upsideDown.setBlockState(event.getPos(), block);
	}
	
	@SubscribeEvent
	public static void onBlockBreakEvent(BreakEvent event) {
		StrangerCrafts.LOGGER.info("Block Break Event Fired!");
		World overworld = event.getPlayer().getServer().getWorld(DimensionType.OVERWORLD);
		World upsideDown = event.getPlayer().getServer().getWorld(DimensionType.byName(StrangerCrafts.UPSIDE_DOWN_TYPE));
		overworld.destroyBlock(event.getPos(), false);
		upsideDown.destroyBlock(event.getPos(), false);
	}
}
