package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.entity.DropletArrowEntity;
import github.Rin_Chan.Punmod.init.EntityRegistry;
import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DropletItem extends ArrowItem {
	private final float damage;
	
	public DropletItem() {
        super(new Item.Properties().tab(ModItemGroup.PUN_MOD));
        this.damage = 0;
    }

    @Override
    public AbstractArrow createArrow(Level world, ItemStack ammoStack, LivingEntity shooter) {
    	AbstractArrow arrow = new DropletArrowEntity(EntityRegistry.DROPLET_ARROW.get(), shooter, world);
    	arrow.setBaseDamage(this.damage);
        return arrow;
    }
}
