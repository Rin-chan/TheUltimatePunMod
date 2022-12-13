package github.Rin_Chan.Punmod.item;

import java.util.Random;

import github.Rin_Chan.Punmod.entity.DropletArrowEntity;
import github.Rin_Chan.Punmod.init.EntityRegistry;
import github.Rin_Chan.Punmod.init.ItemRegistry;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RainbowItem extends BowItem {
	public RainbowItem() {
		super(new Item.Properties().tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void releaseUsing(ItemStack p_40667_, Level p_40668_, LivingEntity p_40669_, int p_40670_) {
	      if (p_40669_ instanceof Player) {
	         Player player = (Player)p_40669_;
	         boolean flag = player.getAbilities().instabuild;
	         
	         ItemStack itemstack = ItemStack.EMPTY;
	 		 for (ItemStack item : player.getInventory().items) {
	 		 	if (item.getItem() == ItemRegistry.DROPLET.get()) {
	 		 		itemstack = item;
	 		 		break;
	 			}
	 		 }
	         
	         int i = this.getUseDuration(p_40667_) - p_40670_;
	         i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_40667_, p_40668_, player, i, !itemstack.isEmpty() || flag);
	         if (i < 0) return;

	         if (!itemstack.isEmpty() || flag) {
	            if (itemstack.isEmpty()) {
	               itemstack = new ItemStack(ItemRegistry.DROPLET.get());
	            }

	            float f = getPowerForTime(i);
	            if (!((double)f < 0.1D)) {
	               if (!p_40668_.isClientSide) {
	            	   Random rand = new Random();
	            	   
	            	   for (int p=0;p<16;p++) {
	            		  float ran1 = rand.nextFloat(0.0F, 2.0F);
	            		  float ran2 = rand.nextFloat(2.0F, 3.0F);
	            		  float ran3 = rand.nextFloat(-50.0F, 50.0F);
	            		  
	            		  DropletArrowEntity arrow = new DropletArrowEntity(EntityRegistry.DROPLET_ARROW.get(), player, p_40668_);
	 	                  arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), ran1, f * ran2, ran3);
	 		        	  p_40668_.addFreshEntity(arrow);
	            	   }
	               }

	               p_40668_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (p_40668_.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	               if (!player.getAbilities().instabuild) {
	                  itemstack.shrink(1);
	                  if (itemstack.isEmpty()) {
	                     player.getInventory().removeItem(itemstack);
	                  }
	               }

	               player.awardStat(Stats.ITEM_USED.get(this));
	            }
	         }
	      }
	   }
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level p_40672_, Player player, InteractionHand p_40674_) {
	      ItemStack itemstack = player.getItemInHand(p_40674_);
	      boolean flag = (player.getInventory().countItem(ItemRegistry.DROPLET.get()) > 0);

	      InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, p_40672_, player, p_40674_, flag);
	      if (ret != null) return ret;

	      if (!player.getAbilities().instabuild && !flag) {
	         return InteractionResultHolder.fail(itemstack);
	      } else {
	    	  player.startUsingItem(p_40674_);
	         return InteractionResultHolder.consume(itemstack);
	      }
	   }
}
;