package com.atechnologeek.strangercrafts.init;

import com.atechnologeek.strangercrafts.StrangerCrafts;
import com.atechnologeek.strangercrafts.world.dimension.UpsideDownModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, StrangerCrafts.MOD_ID);
	
	public static final RegistryObject<ModDimension> UPSIDE_DOWN = MOD_DIMENSIONS.register("upside_down", () -> new UpsideDownModDimension());
}
