package github.Rin_Chan.Punmod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class NetherDyemondLeggingsItem extends ArmorItem {
	public NetherDyemondLeggingsItem() {
		super(ArmorMaterials.DIAMOND, EquipmentSlot.LEGS, (new Item.Properties().durability(515).fireResistant()).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		itemstack.enchant(Enchantments.FIRE_PROTECTION, 5);
	}
}
