package github.Rin_Chan.Punmod.item.projectile;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ExplosiveSnowballProjectile extends ThrowableItemProjectile {
	private int damageFromProjectile = 0;
	private boolean breakBlocks = false;
	private int explosionPower = 1;
	private BlockInteraction actionBreak = Explosion.BlockInteraction.DESTROY;
	
	public ExplosiveSnowballProjectile(Level level, LivingEntity player, int damage, boolean breakBlock) {
		super(EntityType.SNOWBALL, player, level);
		this.damageFromProjectile = damage;
		this.breakBlocks = breakBlock;
	}
	
	@Override
	protected Item getDefaultItem() {
		return Items.SNOWBALL;
	}
	
	@Override
	protected void onHit(HitResult p_37260_) {
		HitResult.Type hitresult$type = p_37260_.getType();
		if (hitresult$type == HitResult.Type.ENTITY) {
			this.onHitEntity((EntityHitResult)p_37260_);
		} else if (hitresult$type == HitResult.Type.BLOCK) {
			this.onHitBlock((BlockHitResult)p_37260_);
		}

		if (hitresult$type != HitResult.Type.MISS) {
			this.gameEvent(GameEvent.PROJECTILE_LAND, this.getOwner());
		}
		
		if (!this.level.isClientSide) {
			boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
			
			if (flag && breakBlocks) {
				actionBreak = Explosion.BlockInteraction.DESTROY;
			}
			else {
				actionBreak = Explosion.BlockInteraction.NONE;
			}
			
			this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, flag, actionBreak);
			this.discard();
		}
	}
	
	@Override
	protected void onHitEntity(EntityHitResult p_37404_) {
      Entity entity = p_37404_.getEntity();
      entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)damageFromProjectile);
   }
}
