package github.Rin_Chan.Punmod.event;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class TheUltimateBlockEvent {
	public static void onTickPlayerEvent(PlayerTickEvent event){
		if(event.player instanceof Player){
			Player player = (Player) event.player;
			if(player.getMainHandItem().getItem() == new ItemStack(ItemRegistry.THEULTIMATEBLOCK.get(), 1).getItem()){
				player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 99));
			}
		}
	}
}
