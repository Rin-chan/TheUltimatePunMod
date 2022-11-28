package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class BedderSwordItem extends SwordItem {
	int durabilityUsedFromProjectile = 10;
	
	public BedderSwordItem() {
		super(Tiers.WOOD, 3, -2.4F, (new Item.Properties().durability(100)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide) {
			MinecraftServer server = level.getServer();
			ServerLevel serverlevel = server.overworld();
			serverlevel.setDayTime(0);
		}
		
		if (!player.getAbilities().instabuild) {
			itemstack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
