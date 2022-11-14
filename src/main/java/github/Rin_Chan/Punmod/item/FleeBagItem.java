package github.Rin_Chan.Punmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FleeBagItem extends Item {
	public FleeBagItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(ModItemGroup.PUN_MOD)
			);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		player.moveTo(player.getX(), 255, player.getZ());
		player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0));
		
		if (!player.getAbilities().instabuild) {
		   itemstack.shrink(1);
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
