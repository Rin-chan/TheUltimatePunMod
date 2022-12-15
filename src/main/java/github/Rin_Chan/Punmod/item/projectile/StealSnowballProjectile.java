package github.Rin_Chan.Punmod.item.projectile;

import java.util.List;
import java.util.Map;
import java.util.Random;

import github.Rin_Chan.Punmod.util.MobLootScrap;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class StealSnowballProjectile extends ThrowableItemProjectile {
	private int damageFromProjectile = 0;
	Random random = new Random();
	
	public StealSnowballProjectile(Level level, LivingEntity player, int damage) {
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
      Player player = (Player) this.getOwner();
      entity.hurt(DamageSource.thrown(this, player), (float)damageFromProjectile);
      
      MobLootScrap mobLoot = new MobLootScrap();
      Map<String, List<Item>> mobLootList = mobLoot.getListOfMobLoot();
      EntityType<?> entityType = entity.getType();
      List<Item> mobLoots = mobLootList.get(entityType.toString());
      
      if (mobLoots != null) {
	      int randomInt = random.nextInt(mobLoots.size());
	      player.getInventory().add(new ItemStack(mobLoots.get(randomInt)));
      }
   }
}
