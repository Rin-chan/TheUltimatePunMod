package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.item.projectile.ExplosiveSnowballProjectile;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class HammerItem extends SwordItem {
	int durabilityUsedFromProjectile = 10;
	private int damageFromProjectile = 20;
	
	public HammerItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties().durability(10)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		  if (!level.isClientSide) {
			ExplosiveSnowballProjectile snowball = new ExplosiveSnowballProjectile(level, player, damageFromProjectile, true);
			snowball.setItem(itemstack);
			snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
		    level.addFreshEntity(snowball);
		  }
		
		if (!player.getAbilities().instabuild) {
			itemstack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
