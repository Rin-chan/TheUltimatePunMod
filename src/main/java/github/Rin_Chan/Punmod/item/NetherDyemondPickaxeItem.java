package github.Rin_Chan.Punmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class NetherDyemondPickaxeItem extends PickaxeItem {
	public NetherDyemondPickaxeItem() {
		super(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties().durability(1800).fireResistant()).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public void onCraftedBy(ItemStack itemstack, Level level, Player player) {
		itemstack.enchant(Enchantments.FIRE_ASPECT, 3);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1));
		player.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
		
		return InteractionResultHolder.success(itemstack);
	}
}
