package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class SandorceryItem extends Item {
	int durabilityUsedFromProjectile = 2;
	
	public SandorceryItem() {
		super(new Item.Properties().stacksTo(1).durability(300).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override 
	public InteractionResult useOn(UseOnContext context) {
		ItemStack itemstack = context.getItemInHand();
		BlockPos originalblockpos = context.getClickedPos();
		Level level = context.getLevel();
		Player player = context.getPlayer();
		InteractionHand hand = context.getHand();
		
		BlockPos blockpos1 = BlockPos.ZERO;
		BlockPos blockpos2 = BlockPos.ZERO;
		BlockPos blockpos3 = BlockPos.ZERO;
		BlockPos blockpos4 = BlockPos.ZERO;
		BlockPos blockpos5 = BlockPos.ZERO;
		BlockPos blockpos6 = BlockPos.ZERO;
		BlockPos blockpos7 = BlockPos.ZERO;
		BlockPos blockpos8 = BlockPos.ZERO;
		
		if (level.isEmptyBlock(originalblockpos.above())) {
			blockpos1 = originalblockpos.above();
		}
		
		if (level.isEmptyBlock(originalblockpos.above().above())) {
			blockpos2 = originalblockpos.above().above();
		}
		
		if (level.isEmptyBlock(originalblockpos.north())) {
			blockpos3 = originalblockpos.north();
		}
		
		if (level.isEmptyBlock(originalblockpos.north().above())) {
			blockpos4 = originalblockpos.north().above();
		}
		
		if (level.isEmptyBlock(originalblockpos.east())) {
			blockpos5 = originalblockpos.east();
		}
		
		if (level.isEmptyBlock(originalblockpos.east().above())) {
			blockpos6 = originalblockpos.east().above();
		}
		
		if (level.isEmptyBlock(originalblockpos.north().east())) {
			blockpos7 = originalblockpos.north().east();
		}
		
		if (level.isEmptyBlock(originalblockpos.north().east().above())) {
			blockpos8 = originalblockpos.north().east().above();
		}

		if (!level.isClientSide) {
			level.setBlock(blockpos1, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos2, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos3, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos4, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos5, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos6, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos7, Blocks.SAND.defaultBlockState(), 0);
			level.setBlock(blockpos8, Blocks.SAND.defaultBlockState(), 0);
		}
		
		if (!player.getAbilities().instabuild) {
			itemstack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
		}
		
		return InteractionResult.SUCCESS;
	}
}
