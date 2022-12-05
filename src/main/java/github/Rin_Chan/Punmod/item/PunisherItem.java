package github.Rin_Chan.Punmod.item;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class PunisherItem extends SwordItem {
	public PunisherItem() {
		super(Tiers.NETHERITE, 3, -1F, (new Item.Properties()).tab(ModItemGroup.PUN_MOD));
	}
}
