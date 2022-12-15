package github.Rin_Chan.Punmod.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;


public class MobLootScrap {
	Map<String, List<Item>> map = new HashMap<String, List<Item>>();
	List<Item> Creeper = Arrays.asList(Items.GUNPOWDER);
	List<Item> Skeleton = Arrays.asList(Items.BOW, Items.BONE, Items.ARROW);
	List<Item> Zombie = Arrays.asList(Items.ROTTEN_FLESH, Items.IRON_INGOT);
	List<Item> Slime = Arrays.asList(Items.SLIME_BALL);
	List<Item> Ghast = Arrays.asList(Items.GUNPOWDER, Items.GHAST_TEAR);
	List<Item> ZombiePigman = Arrays.asList(Items.ROTTEN_FLESH, Items.GOLD_NUGGET);
	List<Item> MagmaCube = Arrays.asList(Items.MAGMA_CREAM);
	List<Item> Witch = Arrays.asList(Items.GLASS_BOTTLE, Items.SUGAR, Items.GLOWSTONE_DUST, Items.REDSTONE);
	List<Item> Pig = Arrays.asList(Items.PORKCHOP);
	List<Item> Sheep = Arrays.asList(Items.WHITE_WOOL);
	List<Item> Cow = Arrays.asList(Items.LEATHER, Items.BEEF);
	List<Item> Squid = Arrays.asList(Items.INK_SAC);
	List<Item> Mooshroom = Arrays.asList(Items.LEATHER, Items.BEEF, Items.MUSHROOM_STEW);
	List<Item> Villager = Arrays.asList(Items.EMERALD);
	
	public MobLootScrap() {
		map.put("entity.minecraft.creeper", Creeper);
		map.put("entity.minecraft.skeleton", Skeleton);
		map.put("entity.minecraft.zombie", Zombie);
		map.put("entity.minecraft.slime", Slime);
		map.put("entity.minecraft.ghast", Ghast);
		map.put("entity.minecraft.zombified_piglin", ZombiePigman);
		map.put("entity.minecraft.magma_cube", MagmaCube);
		map.put("entity.minecraft.witch", Witch);
		map.put("entity.minecraft.pig", Pig);
		map.put("entity.minecraft.sheep", Sheep);
		map.put("entity.minecraft.cow", Cow);
		map.put("entity.minecraft.squid", Squid);
		map.put("entity.minecraft.mooshroom", Mooshroom);
		map.put("entity.minecraft.villager", Villager);
	}
	
	public Map<String, List<Item>> getListOfMobLoot() {
		return map;
	}
}
