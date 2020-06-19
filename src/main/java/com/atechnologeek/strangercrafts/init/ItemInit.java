package com.atechnologeek.strangercrafts.init;

import com.atechnologeek.strangercrafts.StrangerCrafts;
import com.atechnologeek.strangercrafts.StrangerCrafts.StrangerCraftsItemGroup;
import com.atechnologeek.strangercrafts.objects.items.FlashlightItem;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, StrangerCrafts.MOD_ID);
	
	public static final RegistryObject<Item> PEBBLE = ITEMS.register("pebble", () -> new Item(new Item.Properties().group(StrangerCraftsItemGroup.instance)));
	public static final RegistryObject<Item> NAIL = ITEMS.register("nail", () -> new Item(new Item.Properties().group(StrangerCraftsItemGroup.instance)));
	public static final RegistryObject<Item> WAFFLE = ITEMS.register("waffle", () -> new Item(new Item.Properties().group(StrangerCraftsItemGroup.instance).food(new Food.Builder().hunger(6).saturation(0.3f).build())));
	public static final RegistryObject<Item> BAT = ITEMS.register("bat", () -> new SwordItem(ItemTier.WOOD, 5, -3.3f, new Item.Properties().group(StrangerCraftsItemGroup.instance)));
	public static final RegistryObject<Item> SPIKED_BAT = ITEMS.register("spiked_bat", () -> new SwordItem(ItemTier.WOOD, 8, -3.3f, new Item.Properties().group(StrangerCraftsItemGroup.instance)));
	public static final RegistryObject<Item> FLASHLIGHT = ITEMS.register("flashlight", () -> new FlashlightItem(new Item.Properties().group(StrangerCraftsItemGroup.instance)));
}
