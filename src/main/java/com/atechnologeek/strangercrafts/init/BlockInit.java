package com.atechnologeek.strangercrafts.init;

import com.atechnologeek.strangercrafts.StrangerCrafts;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, StrangerCrafts.MOD_ID);
	
	public static final RegistryObject<Block> UPSIDE_DOWN_DIRT = BLOCKS.register("upside_down_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).hardnessAndResistance(0.5F).sound(SoundType.GROUND)));
}
