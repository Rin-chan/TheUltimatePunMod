package github.Rin_Chan.Punmod.entity;

import java.util.Random;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class DropletArrowEntity extends AbstractArrow {
	public DropletArrowEntity(EntityType<DropletArrowEntity> entityType, Level world) {
        super(entityType, world);
    }

    public DropletArrowEntity(EntityType<DropletArrowEntity> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
    
    @Override
    protected void onHitEntity(EntityHitResult ray) {
    	Entity entity = ray.getEntity();
    	
    	Entity entity1 = this.getOwner();
    	DamageSource damagesource;
        if (entity1 == null) {
           damagesource = DamageSource.arrow(this, this);
        } else {
           damagesource = DamageSource.arrow(this, entity1);
           if (entity1 instanceof LivingEntity) {
              ((LivingEntity)entity1).setLastHurtMob(entity);
           }
        }
        
    	if((entity.getType() == EntityType.BLAZE) || (entity.getType() == EntityType.MAGMA_CUBE)) {
    		entity.hurt(damagesource, (float)3);
    	}
    }
    
    @Override
    protected void onHitBlock(BlockHitResult blockHit) {
    	BlockPos blockpos = blockHit.getBlockPos();
    	
    	if (applyBonemeal(this.getLevel(), blockpos)) {
    		if (!level.isClientSide) {
                level.levelEvent(1505, blockpos, 0);
             }
    	}
    	else {
    		growWaterPlant(this.getLevel(), blockpos);
        	if (!level.isClientSide) {
                level.levelEvent(1505, blockpos, 0);
             }
    	}
    }
    
    @Override
    protected void tickDespawn() {
        if (this.inGroundTime > 0){
            this.discard();
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
    public static boolean applyBonemeal(Level p_40629_, BlockPos p_40630_) {
        BlockState blockstate = p_40629_.getBlockState(p_40630_);
        if (blockstate.getBlock() instanceof BonemealableBlock) {
           BonemealableBlock bonemealableblock = (BonemealableBlock)blockstate.getBlock();
           if (bonemealableblock.isValidBonemealTarget(p_40629_, p_40630_, blockstate, p_40629_.isClientSide)) {
              if (p_40629_ instanceof ServerLevel) {
                 if (bonemealableblock.isBonemealSuccess(p_40629_, p_40629_.random, p_40630_, blockstate)) {
                    bonemealableblock.performBonemeal((ServerLevel)p_40629_, p_40629_.random, p_40630_, blockstate);
                 }
              }

              return true;
           }
        }

        return false;
     }
    
    public static boolean growWaterPlant(Level p_40633_, BlockPos p_40634_) {
        if (p_40633_.getBlockState(p_40634_).is(Blocks.WATER) && p_40633_.getFluidState(p_40634_).getAmount() == 8) {
           if (!(p_40633_ instanceof ServerLevel)) {
              return true;
           } else {
              Random random = p_40633_.getRandom();

              label78:
              for(int i = 0; i < 128; ++i) {
                 BlockPos blockpos = p_40634_;
                 BlockState blockstate = Blocks.SEAGRASS.defaultBlockState();

                 for(int j = 0; j < i / 16; ++j) {
                    blockpos = blockpos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                    if (p_40633_.getBlockState(blockpos).isCollisionShapeFullBlock(p_40633_, blockpos)) {
                       continue label78;
                    }
                 }

                 Holder<Biome> holder = p_40633_.getBiome(blockpos);
                 if (holder.is(Biomes.WARM_OCEAN)) {
                    if (i == 0) {
                       blockstate = Registry.BLOCK.getTag(BlockTags.WALL_CORALS).flatMap((p_204098_) -> {
                          return p_204098_.getRandomElement(p_40633_.random);
                       }).map((p_204100_) -> {
                          return p_204100_.value().defaultBlockState();
                       }).orElse(blockstate);
                    } else if (random.nextInt(4) == 0) {
                       blockstate = Registry.BLOCK.getTag(BlockTags.UNDERWATER_BONEMEALS).flatMap((p_204091_) -> {
                          return p_204091_.getRandomElement(p_40633_.random);
                       }).map((p_204095_) -> {
                          return p_204095_.value().defaultBlockState();
                       }).orElse(blockstate);
                    }
                 }

                 if (blockstate.is(BlockTags.WALL_CORALS, (p_204093_) -> {
                    return p_204093_.hasProperty(BaseCoralWallFanBlock.FACING);
                 })) {
                    for(int k = 0; !blockstate.canSurvive(p_40633_, blockpos) && k < 4; ++k) {
                       blockstate = blockstate.setValue(BaseCoralWallFanBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random));
                    }
                 }

                 if (blockstate.canSurvive(p_40633_, blockpos)) {
                    BlockState blockstate1 = p_40633_.getBlockState(blockpos);
                    if (blockstate1.is(Blocks.WATER) && p_40633_.getFluidState(blockpos).getAmount() == 8) {
                       p_40633_.setBlock(blockpos, blockstate, 3);
                    } else if (blockstate1.is(Blocks.SEAGRASS) && random.nextInt(10) == 0) {
                       ((BonemealableBlock)Blocks.SEAGRASS).performBonemeal((ServerLevel)p_40633_, random, blockpos, blockstate1);
                    }
                 }
              }
              return true;
           }
        } else {
           return false;
        }
     }
}
