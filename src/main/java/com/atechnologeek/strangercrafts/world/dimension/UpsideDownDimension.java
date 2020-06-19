package com.atechnologeek.strangercrafts.world.dimension;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;

public class UpsideDownDimension extends OverworldDimension {
	public UpsideDownDimension(World world, DimensionType type) {
		super(world, type);
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return new Vec3d(84, 110, 79);
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}
	
	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.DENY;
	}
	
	@Override
	public boolean isDaytime() {
		return false;
	}
	
	@Override
	public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {
		// TODO Auto-generated method stub
		super.setAllowedSpawnTypes(false, false);
	}
}
