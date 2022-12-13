package github.Rin_Chan.Punmod.client.render;

import github.Rin_Chan.Punmod.PunMod;
import github.Rin_Chan.Punmod.entity.DropletArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DropletArrowRenderer extends ArrowRenderer<DropletArrowEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(PunMod.MODID, "textures/entity/projectiles/droplet_arrow.png");

    public DropletArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(DropletArrowEntity arrow) {
        return TEXTURE;
    }
}