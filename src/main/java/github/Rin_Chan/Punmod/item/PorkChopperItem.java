package github.Rin_Chan.Punmod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class PorkChopperItem extends SwordItem {
	public PorkChopperItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties().durability(150)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity p_43279_, LivingEntity p_43280_) {
    	itemstack.hurtAndBreak(1, p_43280_, (p_43296_) -> {
    		p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
    	});
    	p_43279_.setSecondsOnFire(2);
		
    	return true;
    }
}
