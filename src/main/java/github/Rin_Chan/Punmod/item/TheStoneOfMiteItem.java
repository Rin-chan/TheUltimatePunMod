package github.Rin_Chan.Punmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TheStoneOfMiteItem extends Item {
	public TheStoneOfMiteItem() {
		super(new Item.Properties()
				.durability(2)
				.tab(ModItemGroup.PUN_MOD)
			);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide) {
			int DistanceFromPlayer = 4;
			
			Silverfish silverfish1 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish1.moveTo(player.getX()+DistanceFromPlayer, player.getY(), player.getZ()+DistanceFromPlayer);
			level.addFreshEntity(silverfish1);
			
			Silverfish silverfish2 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish2.moveTo(player.getX()+DistanceFromPlayer, player.getY(), player.getZ());
			level.addFreshEntity(silverfish2);
			
			Silverfish silverfish3 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish3.moveTo(player.getX(), player.getY(), player.getZ()+DistanceFromPlayer);
			level.addFreshEntity(silverfish3);
			
			Silverfish silverfish4 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish4.moveTo(player.getX()-DistanceFromPlayer, player.getY(), player.getZ()-DistanceFromPlayer);
			level.addFreshEntity(silverfish4);
			
			Silverfish silverfish5 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish5.moveTo(player.getX()-DistanceFromPlayer, player.getY(), player.getZ());
			level.addFreshEntity(silverfish5);
			
			Silverfish silverfish6 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish6.moveTo(player.getX(), player.getY(), player.getZ()-DistanceFromPlayer);
			level.addFreshEntity(silverfish6);
			
			Silverfish silverfish7 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish7.moveTo(player.getX()-DistanceFromPlayer, player.getY(), player.getZ()+DistanceFromPlayer);
			level.addFreshEntity(silverfish7);
			
			Silverfish silverfish8 = new Silverfish(EntityType.SILVERFISH, level);
			silverfish8.moveTo(player.getX()+DistanceFromPlayer, player.getY(), player.getZ()-DistanceFromPlayer);
			level.addFreshEntity(silverfish8);
		}

		if (!player.getAbilities().instabuild) {
			itemstack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(hand));
		}

		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
