package github.Rin_Chan.Punmod.event;

import javax.annotation.Nonnull;

import github.Rin_Chan.Punmod.PunMod;
import github.Rin_Chan.Punmod.client.render.DropletArrowRenderer;
import github.Rin_Chan.Punmod.event.loot.BatFurFromBatAdditionModifier;
import github.Rin_Chan.Punmod.event.loot.FleeBagFromDungeonAdditionModifier;
import github.Rin_Chan.Punmod.event.loot.MintFromDungeonAdditionModifier;
import github.Rin_Chan.Punmod.init.EntityRegistry;
import github.Rin_Chan.Punmod.util.ModItemProperties;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PunMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
	@SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }
	
	@SubscribeEvent
	public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityRegistry.DROPLET_ARROW.get(), DropletArrowRenderer::new);
	}
	
	@SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
            new BatFurFromBatAdditionModifier.Serializer().setRegistryName(new ResourceLocation(PunMod.MODID,"batfur_from_bat")),
            new FleeBagFromDungeonAdditionModifier.Serializer().setRegistryName(new ResourceLocation(PunMod.MODID, "fleebag_from_dungeon")),
            new MintFromDungeonAdditionModifier.Serializer().setRegistryName(new ResourceLocation(PunMod.MODID, "mint_from_dungeon"))
        );
    }
}
