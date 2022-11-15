package github.Rin_Chan.Punmod.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class EndDyemondAxeItem extends AxeItem {
	public EndDyemondAxeItem() {
		super(Tiers.NETHERITE, 4.5F, -3.0F, (new Item.Properties().durability(1800)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		itemstack.enchant(Enchantments.KNOCKBACK, 5);
	}
}
