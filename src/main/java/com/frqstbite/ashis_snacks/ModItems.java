package com.frqstbite.ashis_snacks;

import com.frqstbite.ashis_snacks.block.MeatGrinderBlock;
import com.frqstbite.ashis_snacks.item.GroundBeefBucket;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AshisSnacks.MOD_ID);

    // Items
    public static final RegistryObject<Item> BUCKET_GROUND_BEEF = ITEMS.register("bucket_ground_beef", GroundBeefBucket::new);

    //BlockItems
    public static final RegistryObject<BlockItem> MEAT_GRINDER = ITEMS.register("meat_grinder", () -> new BlockItem(ModBlocks.MEAT_GRINDER.get(), new Item.Properties().rarity(Rarity.UNCOMMON).tab(CreativeModeTab.TAB_DECORATIONS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
