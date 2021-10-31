package com.frqstbite.ashis_snacks;

import com.frqstbite.ashis_snacks.block.MeatGrinderBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AshisSnacks.MOD_ID);

    public static final RegistryObject<Block> MEAT_GRINDER = BLOCKS.register("meat_grinder", MeatGrinderBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
