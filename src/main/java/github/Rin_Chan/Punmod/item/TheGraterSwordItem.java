package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class TheGraterSwordItem extends SwordItem {
	public TheGraterSwordItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD));
	}
}
