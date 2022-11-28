package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class MintserItem extends SwordItem {
	public MintserItem() {
		super(Tiers.IRON, 3, -2.4F, (new Item.Properties().durability(600)).tab(ModItemGroup.PUN_MOD));
	}

	@Override
	public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
		p_43278_.hurtAndBreak(1, p_43280_, (p_43296_) -> {
			p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		
		p_43280_.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 4));
		
		return true;
	}
}
