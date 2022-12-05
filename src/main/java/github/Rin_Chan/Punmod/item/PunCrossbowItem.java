package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.item.projectile.ExplosiveSnowballProjectile;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PunCrossbowItem extends Item {
	private int durabilityUsedFromProjectile = 10;
	private int damageFromProjectile = 4;
	
	public PunCrossbowItem() {
		super(new Item.Properties().stacksTo(1).durability(400).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		
		level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHEEP_AMBIENT, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		  if (!level.isClientSide) {
			ExplosiveSnowballProjectile snowball = new ExplosiveSnowballProjectile(level, player, damageFromProjectile, false);
			ItemStack gold_ingot = new ItemStack(() -> Items.GOLD_INGOT);
			snowball.setItem(gold_ingot);
			snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
		    level.addFreshEntity(snowball);
		  }
        
		if (!player.getAbilities().instabuild) {
			stack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
        return InteractionResultHolder.success(stack);
	}
}
