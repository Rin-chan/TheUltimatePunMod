package github.Rin_Chan.Punmod.event.loot;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class FleeBagFromDungeonAdditionModifier extends LootModifier {
	private final Item addition;

    protected FleeBagFromDungeonAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }
    
    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
    	if (context.getRandom().nextFloat() > 0.5) {
    		generatedLoot.add(new ItemStack(addition, 1));
    	}
    	
    	if (context.getRandom().nextFloat() > 0.5) {
        	generatedLoot.add(new ItemStack(addition, 1));
        }
    	
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<FleeBagFromDungeonAdditionModifier> {

        @Override
        public FleeBagFromDungeonAdditionModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new FleeBagFromDungeonAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(FleeBagFromDungeonAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
