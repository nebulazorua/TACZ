package com.tacz.guns.entity;

import com.tacz.guns.api.util.LuaScriptAPI;
import com.tacz.guns.util.ExplodeUtil;
import com.tacz.guns.util.TacHitResult;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EntityKineticBulletScriptAPI extends LuaScriptAPI {
	private Entity owner;

	private EntityKineticBullet bullet;

	private TacHitResult result;

	private BlockHitResult blockResult;

	private Vec3 startVec;
	
	private Vec3 endVec;

	public void createExplosion(Vec3 position, float damage, float radius, boolean knockback, boolean destroysBlocks){
		ExplodeUtil.createExplosion(owner, (Entity) bullet, damage, radius, knockback, destroysBlocks, position);
	}

	public Direction getHitBlockFace(){
		return blockResult.getDirection();
	}

	public Vec3 getLocation(){
		if(blockResult != null)
			return blockResult.getLocation();
		
		return result.getLocation();
	}

	public BlockPos getHitBlockPos() {
		return blockResult.getBlockPos();
	}

	public HitResult.Type getHitBlockResultType() {
		return blockResult.getType();
	}

	public boolean isInsideBlock(){
		return blockResult.isInside();
	}

	public BlockHitResult getBlockHitResult() {
		return blockResult;
	}
	
	public TacHitResult getEntityHitResult() {
		return result;
	}
	
	public Entity getOwner(){
		return owner;
	}

	public void setOwner(Entity owner){
		this.owner = owner;
	}

	public void setBullet(EntityKineticBullet bullet) {
		this.bullet = bullet;
	}

	public void setResult(TacHitResult result) {
		this.result = result;
	}

	public void setBlockResult(BlockHitResult result) {
		this.blockResult = result;
	}

	public void setStartVec(Vec3 vec){
		this.startVec = vec;
	}

	public void setEndVec(Vec3 vec){
		this.endVec = vec;
	}

}
