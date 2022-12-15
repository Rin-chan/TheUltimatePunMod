package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.item.projectile.StealSnowballProjectile;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StealKnifeItem extends Item {
	private int damageFromProjectile = 4;
	
	public StealKnifeItem() {
		super(new Item.Properties().stacksTo(16).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide) {
			StealSnowballProjectile snowball = new StealSnowballProjectile(level, player, damageFromProjectile);
			snowball.setItem(itemstack);
			snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(snowball);
		}
		
		if (!player.getAbilities().instabuild) {
		   itemstack.shrink(1);
		}
		
		return InteractionResultHolder.consume(itemstack);
	}
}
