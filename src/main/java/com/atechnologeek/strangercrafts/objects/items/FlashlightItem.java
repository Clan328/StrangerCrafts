package com.atechnologeek.strangercrafts.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class FlashlightItem extends Item {
	private boolean isOn = false;
	
	public FlashlightItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (isOn)
			tooltip.add(new StringTextComponent("State: On"));
		else
			tooltip.add(new StringTextComponent("State: Off"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote)
			isOn = !isOn;
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		return super.onEntityItemUpdate(stack, entity);
	}
}
