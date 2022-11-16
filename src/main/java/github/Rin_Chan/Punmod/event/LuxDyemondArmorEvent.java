package github.Rin_Chan.Punmod.event;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class LuxDyemondArmorEvent {
	public static void onTickPlayerEvent(PlayerTickEvent event){
		if(event.player instanceof Player){
			Player player = (Player) event.player;
			
			boolean fullArmor = true;
			
			for (ItemStack armor : player.getArmorSlots()) 
			{ 
			    if (armor.getItem() == new ItemStack(ItemRegistry.LUXDYEMONDHELMET.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.LUXDYEMONDCHESTPLATE.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.LUXDYEMONDLEGGINGS.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.LUXDYEMONDBOOTS.get(), 1).getItem()) {
			    	continue;
			    }
			    else {
			    	fullArmor = false;
			    	break;
			    }
			}
			
			if(fullArmor){
				player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 0));
				player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 0));
			}
		}
	}
}
