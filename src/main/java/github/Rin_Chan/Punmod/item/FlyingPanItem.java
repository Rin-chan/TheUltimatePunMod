package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FlyingPanItem extends Item {
	public FlyingPanItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(ModItemGroup.PUN_MOD)
			);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		player.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, 9));
		player.jumpFromGround();

		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
