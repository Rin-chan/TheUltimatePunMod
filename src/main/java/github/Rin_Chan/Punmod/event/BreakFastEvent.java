package github.Rin_Chan.Punmod.event;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class BreakFastEvent {
	public static void onTickPlayerEvent(PlayerTickEvent event){
		if(event.player instanceof Player){
			Player player = (Player) event.player;
			if(player.getMainHandItem().getItem() == new ItemStack(ItemRegistry.BREAKFAST.get(), 1).getItem()){
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 2));
				player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10, 2));
			}
		}
	}
}
