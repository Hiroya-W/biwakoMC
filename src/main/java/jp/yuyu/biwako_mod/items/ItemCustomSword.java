package jp.yuyu.biwako_mod.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class ItemCustomSword extends SwordItem {
    public ItemCustomSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
