package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FrenchFriceItem extends Item {
	public FrenchFriceItem() {
		super(new Item.Properties()
				.tab(ModItemGroup.PUN_MOD)
				.food(new FoodProperties.Builder()
					.nutrition(2)
					.saturationMod(0.2F)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0), 1.0F)
					.alwaysEat()
					.build()
				)
			);
	}
}
