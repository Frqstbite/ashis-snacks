package com.frqstbite.ashis_snacks;

import com.frqstbite.ashis_snacks.item.GroundBeefBucket;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AshisSnacks.MOD_ID);

    public static final RegistryObject<Item> BUCKET_GROUND_BEEF = ITEMS.register("bucket_ground_beef", GroundBeefBucket::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
