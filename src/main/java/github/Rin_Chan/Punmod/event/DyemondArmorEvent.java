package github.Rin_Chan.Punmod.event;

import github.Rin_Chan.Punmod.init.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class DyemondArmorEvent {
	public static void onTickPlayerEvent(PlayerTickEvent event){
		if(event.player instanceof Player){
			Player player = (Player) event.player;
			
			boolean fullArmor = true;
			
			for (ItemStack armor : player.getArmorSlots()) 
			{ 
			    if (armor.getItem() == new ItemStack(ItemRegistry.DYEMONDHELMET.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.DYEMONDCHESTPLATE.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.DYEMONDLEGGINGS.get(), 1).getItem()) {
			    	continue;
			    }
			    else if (armor.getItem() == new ItemStack(ItemRegistry.DYEMONDBOOTS.get(), 1).getItem()) {
			    	continue;
			    }
			    else {
			    	fullArmor = false;
			    	break;
			    }
			}
			
			if(fullArmor){
				player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 20, 1));
				player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 1));
			}
		}
	}
}
