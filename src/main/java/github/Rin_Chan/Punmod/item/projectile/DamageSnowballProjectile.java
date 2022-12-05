package github.Rin_Chan.Punmod.item.projectile;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class DamageSnowballProjectile extends ThrowableItemProjectile {
	private int damageFromProjectile = 0;
	
	public DamageSnowballProjectile(Level level, LivingEntity player, int damage) {
		super(EntityType.SNOWBALL, player, level);
		this.damageFromProjectile = damage;
	}
	
	@Override
	protected Item getDefaultItem() {
		return Items.SNOWBALL;
	}
	
	@Override
	protected void onHitEntity(EntityHitResult p_37404_) {
      super.onHitEntity(p_37404_);
      Entity entity = p_37404_.getEntity();
      entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)damageFromProjectile);
   }
}
