package github.Rin_Chan.Punmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class BedderSwordItem extends SwordItem {
	public BedderSwordItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD));
	}
}
