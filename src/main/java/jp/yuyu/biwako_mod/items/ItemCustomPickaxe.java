package jp.yuyu.biwako_mod.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class ItemCustomPickaxe extends PickaxeItem {
    public ItemCustomPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
