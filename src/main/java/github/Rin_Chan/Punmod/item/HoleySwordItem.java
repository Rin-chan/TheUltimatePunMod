package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class HoleySwordItem extends SwordItem {
	public HoleySwordItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties().durability(1000)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		if (itemstack.getDamageValue() == 0) {
			itemstack.setDamageValue(750);
		}
	}
}
