package github.Rin_Chan.Punmod.init;

import github.Rin_Chan.Punmod.PunMod;
import github.Rin_Chan.Punmod.item.BatFurItem;
import github.Rin_Chan.Punmod.item.BatleIronItem;
import github.Rin_Chan.Punmod.item.BatleOreppleItem;
import github.Rin_Chan.Punmod.item.CoalOreppleItem;
import github.Rin_Chan.Punmod.item.DangerIceItem;
import github.Rin_Chan.Punmod.item.DiamondOreppleItem;
import github.Rin_Chan.Punmod.item.DyemondItem;
import github.Rin_Chan.Punmod.item.DyemondOreppleItem;
import github.Rin_Chan.Punmod.item.EmeraldOreppleItem;
import github.Rin_Chan.Punmod.item.FlameThwoolerItem;
import github.Rin_Chan.Punmod.item.FrenchFriceItem;
import github.Rin_Chan.Punmod.item.HardBoiledEggItem;
import github.Rin_Chan.Punmod.item.IronOreppleItem;
import github.Rin_Chan.Punmod.item.LapisOreppleItem;
import github.Rin_Chan.Punmod.item.RedstoneOreppleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PunMod.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PunMod.MODID);

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
    
    public static final RegistryObject<HardBoiledEggItem> HARDBOILEDEGG = ITEMS.register("hardboiledegg", HardBoiledEggItem::new);
    public static final RegistryObject<BatFurItem> BATFUR = ITEMS.register("batfur", BatFurItem::new);
    public static final RegistryObject<DyemondItem> DYEMOND = ITEMS.register("dyemond", DyemondItem::new);
    public static final RegistryObject<BatleIronItem> BATLEIRON = ITEMS.register("batleiron", BatleIronItem::new);
    public static final RegistryObject<DangerIceItem> DANGERICE = ITEMS.register("dangerice", DangerIceItem::new);
    
    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
