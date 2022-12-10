package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.item.projectile.DamageSnowballProjectile;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class PieceMakerItem extends SwordItem {
	private int durabilityUsedFromProjectile = 10;
	private int damageFromProjectile = 4;
	
	public PieceMakerItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		
		  if (!level.isClientSide) {
			DamageSnowballProjectile snowball = new DamageSnowballProjectile(level, player, damageFromProjectile);
			ItemStack feather = new ItemStack(() -> Items.FEATHER);
			snowball.setItem(feather);
			snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
		    level.addFreshEntity(snowball);
		  }
        
		if (!player.getAbilities().instabuild) {
			stack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
        return InteractionResultHolder.success(stack);
	}
}
