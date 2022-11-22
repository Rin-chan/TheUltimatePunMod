package github.Rin_Chan.Punmod.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class LuxDyemondSwordItem extends SwordItem {
	public LuxDyemondSwordItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties().durability(1800)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		itemstack.enchant(Enchantments.MOB_LOOTING, 3);
	}
}
