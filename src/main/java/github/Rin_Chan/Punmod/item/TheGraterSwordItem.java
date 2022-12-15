package github.Rin_Chan.Punmod.item;

import java.util.List;
import java.util.Map;
import java.util.Random;

import github.Rin_Chan.Punmod.util.MobLootScrap;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class TheGraterSwordItem extends SwordItem {
	Random random = new Random();
	
	public TheGraterSwordItem() {
		super(Tiers.DIAMOND, 3, -2.4F, (new Item.Properties().durability(300)).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemstack, Player player, Entity entity) {
		if (random.nextBoolean() && random.nextBoolean()) {
			MobLootScrap mobLoot = new MobLootScrap();
			Map<String, List<Item>> mobLootList = mobLoot.getListOfMobLoot();
			EntityType<?> entityType = entity.getType();
			List<Item> mobLoots = mobLootList.get(entityType.toString());
	  
			if (mobLoots != null) {
				int randomInt = random.nextInt(mobLoots.size());
				player.getInventory().add(new ItemStack(mobLoots.get(randomInt)));
			}
		}
		return false;
	}
}
