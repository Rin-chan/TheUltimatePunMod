package github.Rin_Chan.Punmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SandorceryItem extends Item {
	public SandorceryItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(ModItemGroup.PUN_MOD)
			);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);

		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
