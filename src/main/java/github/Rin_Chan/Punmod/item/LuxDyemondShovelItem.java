package github.Rin_Chan.Punmod.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class LuxDyemondShovelItem extends ShovelItem {
	public LuxDyemondShovelItem() {
		super(Tiers.NETHERITE, 1.5F, -3.0F, (new Item.Properties().durability(1800)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		itemstack.enchant(Enchantments.MOB_LOOTING, 3);
		itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
	}
}