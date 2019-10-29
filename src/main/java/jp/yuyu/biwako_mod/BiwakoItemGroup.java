package jp.yuyu.biwako_mod;

import jp.yuyu.biwako_mod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BiwakoItemGroup extends ItemGroup {
    public BiwakoItemGroup(){
        super("BiwakoItemGroup");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemList.BiwakoIngot);
    }
}
