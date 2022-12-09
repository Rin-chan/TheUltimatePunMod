package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import github.Rin_Chan.Punmod.item.projectile.ExplosiveSnowballProjectile;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EggsterminatorItem extends Item {
	private int durabilityUsedFromProjectile = 10;
	private int damageFromProjectile = 4;
	
	public EggsterminatorItem() {
		super(new Item.Properties().stacksTo(1).durability(600).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		ItemStack EggItemStack = ItemStack.EMPTY;
		
		for (ItemStack item : player.getInventory().items) {
			if (item.getItem() == ItemRegistry.HARDBOILEDEGG.get()) {
				EggItemStack = item;
				break;
			}
		}
		
		if (!EggItemStack.isEmpty() || player.getAbilities().instabuild) {
			if (!level.isClientSide) {
				ExplosiveSnowballProjectile snowball = new ExplosiveSnowballProjectile(level, player, damageFromProjectile, true);
				ItemStack egg = new ItemStack(ItemRegistry.HARDBOILEDEGG.get());
				snowball.setItem(egg);
				snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
				level.addFreshEntity(snowball);
			}
	        
			if (!player.getAbilities().instabuild) {
				EggItemStack.shrink(1);
                if (EggItemStack.isEmpty()) {
                   player.getInventory().removeItem(EggItemStack);
                }
	            
				stack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
			}
			
			return InteractionResultHolder.success(stack);
		}
		
        return InteractionResultHolder.fail(stack);
	}
}
