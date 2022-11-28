package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PaneMakerItem extends SwordItem {
	public PaneMakerItem() {
		super(Tiers.WOOD, 3, -2.4F, (new Item.Properties().durability(80)).tab(ModItemGroup.PUN_MOD));
	}
	
	private void enchantItem(ItemStack itemstack) {
		itemstack.removeTagKey("Enchantments");
		itemstack.removeTagKey("StoredEnchantments");
		
		if(itemstack.getDamageValue() <= 10) {
			itemstack.enchant(Enchantments.SHARPNESS, 1);
    	}
		else if(itemstack.getDamageValue() <= 20) {
			itemstack.enchant(Enchantments.SHARPNESS, 2);
    	}
    	else if(itemstack.getDamageValue() <= 30) {
    		itemstack.enchant(Enchantments.SHARPNESS, 4);
    	}
    	else if(itemstack.getDamageValue() <= 50) {
    		itemstack.enchant(Enchantments.SHARPNESS, 6);
    	}
    	else if(itemstack.getDamageValue() <= 65) {
    		itemstack.enchant(Enchantments.SHARPNESS, 8);
    	}
    	else if(itemstack.getDamageValue() >= 75) {
    		itemstack.enchant(Enchantments.SHARPNESS, 12);
    	}
	}
	
    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity p_43279_, LivingEntity p_43280_) {
    	itemstack.hurtAndBreak(1, p_43280_, (p_43296_) -> {
    		p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
    	});
    	enchantItem(itemstack);
		
    	return true;
    }

    @Override
    public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
    	if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
    		p_43282_.hurtAndBreak(2, p_43286_, (p_43276_) -> {
    			p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
    		});
    	}
    	enchantItem(p_43282_);

    	return true;
    }
}
