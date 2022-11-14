package github.Rin_Chan.Punmod;

import github.Rin_Chan.Punmod.init.ItemRegistry;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PunMod.MODID)
public class PunMod
{
    public static final String MODID = "punmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public PunMod()
    {
        ItemRegistry.init();
        
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
}