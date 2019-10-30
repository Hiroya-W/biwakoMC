package jp.yuyu.biwako_mod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {
    MATERIAL_BIWAKO(3, 1000, 15.0f, 3.0f,25, ItemList.BiwakoIngot);

    private float attackDamage, efficiency;
    private int maxUses, harvestLevel, enchantability;
    private Item repairMaterial;

    private ToolMaterialList(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = repairMaterialIn;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
