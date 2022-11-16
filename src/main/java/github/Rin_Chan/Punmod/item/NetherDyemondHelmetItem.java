package github.Rin_Chan.Punmod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class NetherDyemondHelmetItem extends ArmorItem {
	public NetherDyemondHelmetItem() {
		super(ModArmorMaterial.NETHERDYEMOND, EquipmentSlot.HEAD, (new Item.Properties().durability(383).fireResistant()).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		itemstack.enchant(Enchantments.FIRE_PROTECTION, 5);
	}
}
