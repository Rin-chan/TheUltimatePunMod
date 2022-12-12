package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class BownItem extends BowItem {
	public BownItem() {
		super(new Item.Properties().durability(385).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void releaseUsing(ItemStack p_40667_, Level p_40668_, LivingEntity p_40669_, int p_40670_) {
	      if (p_40669_ instanceof Player) {
	         Player player = (Player)p_40669_;
	         boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_40667_) > 0;
	         ItemStack itemstack = player.getProjectile(p_40667_);

	         int i = this.getUseDuration(p_40667_) - p_40670_;
	         i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_40667_, p_40668_, player, i, !itemstack.isEmpty() || flag);
	         if (i < 0) return;

	         if (!(itemstack.getCount() < 2) || flag) {
	            if (itemstack.isEmpty() || (itemstack.getCount() < 2)) {
	               itemstack = new ItemStack(Items.ARROW);
	            }

	            float f = getPowerForTime(i);
	            if (!((double)f < 0.1D)) {
	               boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, p_40667_, player));
	               if (!p_40668_.isClientSide) {
	                  ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
	                  AbstractArrow abstractarrow1 = arrowitem.createArrow(p_40668_, itemstack, player);
	                  AbstractArrow abstractarrow2 = arrowitem.createArrow(p_40668_, itemstack, player);
	                  abstractarrow1 = customArrow(abstractarrow1);
	                  abstractarrow2 = customArrow(abstractarrow2);
	                  abstractarrow1.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 2.0F, 1.0F);
	                  abstractarrow2.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 4.0F, 1.0F);
	                  
	                  if (f == 1.0F) {
	                	  abstractarrow1.setCritArrow(true);
	                	  abstractarrow2.setCritArrow(true);
	                  }

	                  int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, p_40667_);
	                  if (j > 0) {
	                	  abstractarrow1.setBaseDamage(abstractarrow1.getBaseDamage() + (double)j * 0.5D + 0.5D);
	                	  abstractarrow2.setBaseDamage(abstractarrow2.getBaseDamage() + (double)j * 0.5D + 0.5D);
	                  }

	                  int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, p_40667_);
	                  if (k > 0) {
	                     abstractarrow1.setKnockback(k);
	                     abstractarrow2.setKnockback(k);
	                  }

	                  if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_40667_) > 0) {
	                     abstractarrow1.setSecondsOnFire(100);
	                     abstractarrow2.setSecondsOnFire(100);
	                  }

	                  p_40667_.hurtAndBreak(1, player, (p_40665_) -> {
	                     p_40665_.broadcastBreakEvent(player.getUsedItemHand());
	                  });
	                  if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
	                     abstractarrow1.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
	                     abstractarrow2.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
	                  }

	                  p_40668_.addFreshEntity(abstractarrow1);
	                  p_40668_.addFreshEntity(abstractarrow2);
	               }

	               p_40668_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (p_40668_.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	               if (!flag1 && !player.getAbilities().instabuild) {
	                  itemstack.shrink(2);
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
	   public InteractionResultHolder<ItemStack> use(Level p_40672_, Player p_40673_, InteractionHand p_40674_) {
	      ItemStack itemstack = p_40673_.getItemInHand(p_40674_);
	      boolean flag = !p_40673_.getProjectile(itemstack).isEmpty();
	      
	      InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, p_40672_, p_40673_, p_40674_, flag);
	      if (ret != null) return ret;

	      if (!p_40673_.getAbilities().instabuild && !flag) {
	         return InteractionResultHolder.fail(itemstack);
	      } 
	      else if ((p_40673_.getInventory().countItem(Items.ARROW) < 2) && !(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemstack) > 0) && !p_40673_.getAbilities().instabuild) {
	    	  return InteractionResultHolder.fail(itemstack);
	      }
	      else {
	         p_40673_.startUsingItem(p_40674_);
	         return InteractionResultHolder.consume(itemstack);
	      }
	   }
}
