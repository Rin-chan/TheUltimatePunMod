package github.Rin_Chan.Punmod.event;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class EndDyemondArmorEvent {
	public static void onTickPlayerEvent(PlayerTickEvent event){
		if(event.player instanceof Player){
			Player player = (Player) event.player;
			
			boolean fullArmor = true;
			
			for (ItemStack armor : player.getArmorSlots()) 
			{ 
			    if (armor.getItem() == new ItemStack(ItemRegistry.ENDDYEMONDHELMET.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.ENDDYEMONDCHESTPLATE.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.ENDDYEMONDLEGGINGS.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.ENDDYEMONDBOOTS.get(), 1).getItem()) {
			    	continue;
			    }
			    else {
			    	fullArmor = false;
			    	break;
			    }
			}
			
			if(fullArmor){
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0));
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1));
				player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 2));
			}
		}
	}
}
