package github.Rin_Chan.Punmod.util;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup extends CreativeModeTab{
	public static final ModItemGroup PUN_MOD = new ModItemGroup(CreativeModeTab.TABS.length, "punmodTab");
	
	public ModItemGroup(int length, String label) {
		super(length, label);
	}
	
	@Override
	public ItemStack makeIcon() {
		return ItemRegistry.RAINBOW.get().getDefaultInstance();
	}
}
