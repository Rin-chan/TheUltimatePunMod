package github.Rin_Chan.Punmod.item;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class PunisherItem extends SwordItem {
	Random random = new Random();
	
	public PunisherItem() {
		super(Tiers.NETHERITE, 3, -1F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		Level level = entity.getLevel();
		
		if (!level.isClientSide) {
			ItemStack itemstack = new ItemStack(() -> Items.FIREWORK_ROCKET);
			
			CompoundTag tagcompound = new CompoundTag();
			ListTag taglist = new ListTag();
			CompoundTag fireworkStar = itemstack.getOrCreateTagElement("Explosion");
			List<Integer> colourList = Lists.newArrayList();
			
			int colourChoice = random.nextInt(16);
			
			switch(colourChoice) {
				case 0:
					colourList.add(((DyeItem) Items.BLACK_DYE).getDyeColor().getFireworkColor());
					break;
				case 1:
					colourList.add(((DyeItem) Items.BLUE_DYE).getDyeColor().getFireworkColor());
					break;
				case 2:
					colourList.add(((DyeItem) Items.BROWN_DYE).getDyeColor().getFireworkColor());
					break;
				case 3:
					colourList.add(((DyeItem) Items.CYAN_DYE).getDyeColor().getFireworkColor());
					break;
				case 4:
					colourList.add(((DyeItem) Items.GRAY_DYE).getDyeColor().getFireworkColor());
					break;
				case 5:
					colourList.add(((DyeItem) Items.GREEN_DYE).getDyeColor().getFireworkColor());
					break;
				case 6:
					colourList.add(((DyeItem) Items.LIGHT_BLUE_DYE).getDyeColor().getFireworkColor());
					break;
				case 7:
					colourList.add(((DyeItem) Items.LIGHT_GRAY_DYE).getDyeColor().getFireworkColor());
					break;
				case 8:
					colourList.add(((DyeItem) Items.LIME_DYE).getDyeColor().getFireworkColor());
					break;
				case 9:
					colourList.add(((DyeItem) Items.MAGENTA_DYE).getDyeColor().getFireworkColor());
					break;
				case 10:
					colourList.add(((DyeItem) Items.ORANGE_DYE).getDyeColor().getFireworkColor());
					break;
				case 11:
					colourList.add(((DyeItem) Items.PINK_DYE).getDyeColor().getFireworkColor());
					break;
				case 12:
					colourList.add(((DyeItem) Items.PURPLE_DYE).getDyeColor().getFireworkColor());
					break;
				case 13:
					colourList.add(((DyeItem) Items.RED_DYE).getDyeColor().getFireworkColor());
					break;
				case 14:
					colourList.add(((DyeItem) Items.YELLOW_DYE).getDyeColor().getFireworkColor());
					break;
				default:
					colourList.add(((DyeItem) Items.WHITE_DYE).getDyeColor().getFireworkColor());
			}
			
			fireworkStar.putIntArray("Colors", colourList);
			taglist.add(fireworkStar);
			tagcompound.put("Explosions", taglist);
			itemstack.addTagElement("Fireworks", tagcompound);
			
			
			FireworkRocketEntity firework = new FireworkRocketEntity(level, itemstack, entity, entity.getX(), entity.getEyeY() - (double)0.15F, entity.getZ(), true);
			firework.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(firework);
		}
		
		return false;
	}
}
