package com.frqstbite.ashis_snacks.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class GroundBeefBucket extends Item {
    public GroundBeefBucket() {
        super((new Item.Properties())
                .craftRemainder(Items.BUCKET)
                .food(Foods.BEEF)
                .stacksTo(1)
                .tab(CreativeModeTab.TAB_FOOD)
        );
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        super.finishUsingItem(itemStack, level, entity);

        Player player = entity instanceof Player ? (Player)entity : null;
        if (player == null || !player.getAbilities().instabuild) {
            if (itemStack.isEmpty()) {
                return new ItemStack(Items.BUCKET);
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(Items.BUCKET));
            }
        }

        return itemStack;
    }
}
