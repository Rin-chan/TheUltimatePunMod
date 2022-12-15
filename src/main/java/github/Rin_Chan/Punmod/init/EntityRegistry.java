package github.Rin_Chan.Punmod.init;

import github.Rin_Chan.Punmod.PunMod;
import github.Rin_Chan.Punmod.entity.DropletArrowEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, PunMod.MODID);
	
	public static final RegistryObject<EntityType<DropletArrowEntity>> DROPLET_ARROW = ENTITY_TYPES.register("droplet_arrow", () -> EntityType.Builder.of((EntityType.EntityFactory<DropletArrowEntity>) DropletArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("droplet_arrow"));

	public static void init() {
    	ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
