package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.item.Item;

public class CaninkItem extends Item {
	public CaninkItem() {
		super(new Item.Properties().stacksTo(1).tab(ModItemGroup.PUN_MOD).durability(465));
	}
}
