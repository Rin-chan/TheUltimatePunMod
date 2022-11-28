package github.Rin_Chan.Punmod.item;

import java.util.List;

import javax.annotation.Nullable;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class CoalOreppleItem extends Item {
	public CoalOreppleItem() {
		super(new Item.Properties()
				.tab(ModItemGroup.PUN_MOD)
				.food(new FoodProperties.Builder()
						.nutrition(4)
						.saturationMod(1.2F)
						.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
						.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0F)
						.alwaysEat()
						.build()
					)
		);
	}
	
	@Override
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
			components.add(new TextComponent("Wait, can I eat this?").withStyle(ChatFormatting.BLUE));
			super.appendHoverText(itemStack, level, components, flag);
   }
}
