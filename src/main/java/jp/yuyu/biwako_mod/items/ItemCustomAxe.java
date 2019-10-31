package jp.yuyu.biwako_mod.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class ItemCustomAxe extends AxeItem {
    public ItemCustomAxe(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
