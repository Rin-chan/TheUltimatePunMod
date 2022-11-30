package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HammerItem extends SwordItem {
	int durabilityUsedFromProjectile = 10;
	
	public HammerItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties().durability(10)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide) {
			Vec3 vec3 = player.getViewVector(1.0F);
			
			LargeFireball fireball = new LargeFireball(level, player, player.getX(), player.getEyeY(), player.getZ(), 1);
			fireball.setPos(player.getX() + vec3.x * 4.0D, player.getY(0.5D) + 0.5D, fireball.getZ() + vec3.z * 4.0D);
			fireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 0.0F);
			fireball.setItem(itemstack);
			level.addFreshEntity(fireball);
		}
		
		if (!player.getAbilities().instabuild) {
			itemstack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
