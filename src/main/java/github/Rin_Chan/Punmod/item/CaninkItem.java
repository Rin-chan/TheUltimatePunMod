package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.item.projectile.InkSnowballProjectile;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CaninkItem extends Item {
	private int durabilityUsedFromProjectile = 10;
	private int damageFromProjectile = 2;
	
	public CaninkItem() {
		super(new Item.Properties().stacksTo(1).durability(500).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		
		if (!level.isClientSide) {
			InkSnowballProjectile snowball = new InkSnowballProjectile(level, player, damageFromProjectile);
			ItemStack ink = new ItemStack(() -> Items.INK_SAC);
			snowball.setItem(ink);
			snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
		    level.addFreshEntity(snowball);
		  }
        
		if (!player.getAbilities().instabuild) {
			stack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
        return InteractionResultHolder.success(stack);
	}
}
