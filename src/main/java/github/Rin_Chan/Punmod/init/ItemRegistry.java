package github.Rin_Chan.Punmod.init;

import github.Rin_Chan.Punmod.PunMod;
import github.Rin_Chan.Punmod.item.BatleOreppleItem;
import github.Rin_Chan.Punmod.item.CoalOreppleItem;
import github.Rin_Chan.Punmod.item.DIceMondOrbItem;
import github.Rin_Chan.Punmod.item.DangerIceItem;
import github.Rin_Chan.Punmod.item.DiamondOreppleItem;
import github.Rin_Chan.Punmod.item.DyemondAxeItem;
import github.Rin_Chan.Punmod.item.DyemondHoeItem;
import github.Rin_Chan.Punmod.item.DyemondOreppleItem;
import github.Rin_Chan.Punmod.item.DyemondPickaxeItem;
import github.Rin_Chan.Punmod.item.DyemondShovelItem;
import github.Rin_Chan.Punmod.item.EmeraldOreppleItem;
import github.Rin_Chan.Punmod.item.EndDyemondAxeItem;
import github.Rin_Chan.Punmod.item.EndDyemondHoeItem;
import github.Rin_Chan.Punmod.item.EndDyemondPickaxeItem;
import github.Rin_Chan.Punmod.item.EndDyemondShovelItem;
import github.Rin_Chan.Punmod.item.FlameThwoolerItem;
import github.Rin_Chan.Punmod.item.FleeBagItem;
import github.Rin_Chan.Punmod.item.FlyingPanItem;
import github.Rin_Chan.Punmod.item.FrenchFriceItem;
import github.Rin_Chan.Punmod.item.IronOreppleItem;
import github.Rin_Chan.Punmod.item.LapisOreppleItem;
import github.Rin_Chan.Punmod.item.LuxDyemondAxeItem;
import github.Rin_Chan.Punmod.item.LuxDyemondHoeItem;
import github.Rin_Chan.Punmod.item.LuxDyemondPickaxeItem;
import github.Rin_Chan.Punmod.item.LuxDyemondShovelItem;
import github.Rin_Chan.Punmod.item.MintItem;
import github.Rin_Chan.Punmod.item.ModItemGroup;
import github.Rin_Chan.Punmod.item.MorningStarItem;
import github.Rin_Chan.Punmod.item.NetherDyemondAxeItem;
import github.Rin_Chan.Punmod.item.NetherDyemondHoeItem;
import github.Rin_Chan.Punmod.item.NetherDyemondPickaxeItem;
import github.Rin_Chan.Punmod.item.NetherDyemondShovelItem;
import github.Rin_Chan.Punmod.item.RainbowItem;
import github.Rin_Chan.Punmod.item.RedstoneOreppleItem;
import github.Rin_Chan.Punmod.item.SandorceryItem;
import github.Rin_Chan.Punmod.item.TheStoneOfMiteItem;
import github.Rin_Chan.Punmod.item.TheUltimateBlockItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PunMod.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PunMod.MODID);

    public static final RegistryObject<DangerIceItem> DANGERICE = ITEMS.register("dangerice", DangerIceItem::new);
    public static final RegistryObject<MintItem> MINT = ITEMS.register("mint", MintItem::new);
    
    public static final RegistryObject<CoalOreppleItem> COALOREPPLE = ITEMS.register("coalorepple", CoalOreppleItem::new);
    public static final RegistryObject<DiamondOreppleItem> DIAMONDOREPPLE = ITEMS.register("diamondorepple", DiamondOreppleItem::new);
    public static final RegistryObject<EmeraldOreppleItem> EMERALDOREPPLE = ITEMS.register("emeraldorepple", EmeraldOreppleItem::new);
    public static final RegistryObject<IronOreppleItem> IRONOREPPLE = ITEMS.register("ironorepple", IronOreppleItem::new);
    public static final RegistryObject<LapisOreppleItem> LAPISOREPPLE = ITEMS.register("lapisorepple", LapisOreppleItem::new);
    public static final RegistryObject<RedstoneOreppleItem> REDSTONEOREPPLE = ITEMS.register("redstoneorepple", RedstoneOreppleItem::new);
    public static final RegistryObject<BatleOreppleItem> BATLEOREPPLE = ITEMS.register("batleorepple", BatleOreppleItem::new);
    public static final RegistryObject<DyemondOreppleItem> DYEMMONDOREPPLE = ITEMS.register("dyemondorepple", DyemondOreppleItem::new);
    public static final RegistryObject<FrenchFriceItem> FRENCHFRICE = ITEMS.register("frenchfrice", FrenchFriceItem::new);

    public static final RegistryObject<FlameThwoolerItem> FLAMETHWOOLER = ITEMS.register("flamethwooler", FlameThwoolerItem::new);
    public static final RegistryObject<RainbowItem> RAINBOW = ITEMS.register("rainbow", RainbowItem::new);
    public static final RegistryObject<TheStoneOfMiteItem> THESTONEOFMITE = ITEMS.register("thestoneofmite", TheStoneOfMiteItem::new);
    public static final RegistryObject<FlyingPanItem> FLYINGPAN = ITEMS.register("flyingpan", FlyingPanItem::new);
    public static final RegistryObject<FleeBagItem> FLEEBAG = ITEMS.register("fleebag", FleeBagItem::new);
    public static final RegistryObject<SandorceryItem> SANDORCERY = ITEMS.register("sandorcery", SandorceryItem::new);
    
    public static final RegistryObject<Item> HARDBOILEDEGG = ITEMS.register("hardboiledegg", () -> new Item(new Item.Properties().tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<Item> BATFUR = ITEMS.register("batfur", () -> new Item(new Item.Properties().tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<Item> DYEMOND = ITEMS.register("dyemond", () -> new Item(new Item.Properties().tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<Item> BATLEIRON = ITEMS.register("batleiron", () -> new Item(new Item.Properties().tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<DIceMondOrbItem> DICEMONDORB = ITEMS.register("dicemondorb", DIceMondOrbItem::new);
    public static final RegistryObject<Item> DROPLET = ITEMS.register("droplet", () -> new Item(new Item.Properties().tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<MorningStarItem> MORNINGSTAR = ITEMS.register("morningstar", MorningStarItem::new);
    public static final RegistryObject<Item> OBSIDIEANSHARDS = ITEMS.register("obsidieanshards", () -> new Item(new Item.Properties().tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<TheUltimateBlockItem> THEULTIMATEBLOCK = ITEMS.register("theultimateblock", TheUltimateBlockItem::new);
    
    public static final RegistryObject<AxeItem> BATLEAXE = ITEMS.register("batleaxe", () -> new AxeItem(Tiers.IRON, 6.0F, -2.6F,(new Item.Properties().durability(750)).tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<DyemondAxeItem> DYEMONDAXE = ITEMS.register("dyemondaxe", DyemondAxeItem::new);
    public static final RegistryObject<NetherDyemondAxeItem> NETHERDYEMONDAXE = ITEMS.register("netherdyemondaxe", NetherDyemondAxeItem::new);
    public static final RegistryObject<EndDyemondAxeItem> ENDDYEMONDAXE = ITEMS.register("enddyemondaxe", EndDyemondAxeItem::new);
    public static final RegistryObject<LuxDyemondAxeItem> LUXDYEMONDAXE = ITEMS.register("luxdyemondaxe", LuxDyemondAxeItem::new);
    public static final RegistryObject<AxeItem> OBSIDIEANAXE = ITEMS.register("obsidieanaxe", () -> new AxeItem(Tiers.DIAMOND, 5.0F, -3.2F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD)));
    
    public static final RegistryObject<PickaxeItem> BATLEPICKAXE = ITEMS.register("batlepickaxe", () -> new PickaxeItem(Tiers.IRON, 1, -2.8F, (new Item.Properties().durability(750)).tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<PickaxeItem> BREAKFAST = ITEMS.register("breakfast", () -> new PickaxeItem(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties().durability(100)).tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<DyemondPickaxeItem> DYEMONDPICKAXE = ITEMS.register("dyemondpickaxe", DyemondPickaxeItem::new);
    public static final RegistryObject<NetherDyemondPickaxeItem> NETHERDYEMONDPICKAXE = ITEMS.register("netherdyemondpickaxe", NetherDyemondPickaxeItem::new);
    public static final RegistryObject<EndDyemondPickaxeItem> ENDDYEMONDPICKAXE = ITEMS.register("enddyemondpickaxe", EndDyemondPickaxeItem::new);
    public static final RegistryObject<LuxDyemondPickaxeItem> LUXDYEMONDPICKAXE = ITEMS.register("luxdyemondpickaxe", LuxDyemondPickaxeItem::new);
    public static final RegistryObject<PickaxeItem> OBSIDIEANPICKAXE = ITEMS.register("obsidieanpickaxe", () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD)));
    
    public static final RegistryObject<ShovelItem> BATLESHOVEL = ITEMS.register("batleshovel", () -> new ShovelItem(Tiers.IRON, 1.5F, -3.0F, (new Item.Properties().durability(750)).tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<DyemondShovelItem> DYEMONDSHOVEL = ITEMS.register("dyemondshovel", DyemondShovelItem::new);
    public static final RegistryObject<NetherDyemondShovelItem> NETHERDYEMONDSHOVEL = ITEMS.register("netherdyemondshovel", NetherDyemondShovelItem::new);
    public static final RegistryObject<EndDyemondShovelItem> ENDDYEMONDSHOVEL = ITEMS.register("enddyemondshovel", EndDyemondShovelItem::new);
    public static final RegistryObject<LuxDyemondShovelItem> LUXDYEMONDSHOVEL = ITEMS.register("luxdyemondshovel", LuxDyemondShovelItem::new);
    public static final RegistryObject<ShovelItem> OBSIDIEANSHOVEL = ITEMS.register("obsidieanshovel", () -> new ShovelItem(Tiers.DIAMOND, 1.5F, -3.0F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD)));
    
    public static final RegistryObject<HoeItem> BATLEHOE = ITEMS.register("batlehoe", () -> new HoeItem(Tiers.IRON, -2, -1.0F, (new Item.Properties().durability(750)).tab(ModItemGroup.PUN_MOD)));
    public static final RegistryObject<DyemondHoeItem> DYEMONDHOE = ITEMS.register("dyemondhoe", DyemondHoeItem::new);
    public static final RegistryObject<NetherDyemondHoeItem> NETHERDYEMONDHOE = ITEMS.register("netherdyemondhoe", NetherDyemondHoeItem::new);
    public static final RegistryObject<EndDyemondHoeItem> ENDDYEMONDHOE = ITEMS.register("enddyemondhoe", EndDyemondHoeItem::new);
    public static final RegistryObject<LuxDyemondHoeItem> LUXDYEMONDHOE = ITEMS.register("luxdyemondhoe", LuxDyemondHoeItem::new);
    public static final RegistryObject<HoeItem> OBSIDIEANHOE = ITEMS.register("obsidieanhoe", () -> new HoeItem(Tiers.DIAMOND, -3, 0.0F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD)));
    
    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
