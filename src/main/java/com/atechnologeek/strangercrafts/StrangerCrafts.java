package com.atechnologeek.strangercrafts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.atechnologeek.strangercrafts.init.BlockInit;
import com.atechnologeek.strangercrafts.init.DimensionInit;
import com.atechnologeek.strangercrafts.init.ItemInit;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("strangercrafts")
@Mod.EventBusSubscriber(modid=StrangerCrafts.MOD_ID, bus=Bus.MOD)
public class StrangerCrafts
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "strangercrafts";
    public static StrangerCrafts instance;
    public static final ResourceLocation UPSIDE_DOWN_TYPE = new ResourceLocation(MOD_ID, "upside_down");

    public StrangerCrafts() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        modEventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);
        
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        
        DimensionInit.MOD_DIMENSIONS.register(modEventBus);
        
        instance = this;
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItens(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(StrangerCraftsItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered BlockItems!");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }
    
    public static class StrangerCraftsItemGroup extends ItemGroup {
    	public static final StrangerCraftsItemGroup instance = new StrangerCraftsItemGroup(ItemGroup.GROUPS.length, "stranger_crafts");
    	
    	private StrangerCraftsItemGroup(int index, String label) {
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemInit.PEBBLE.get());
    	}
    }
}
