package jp.yuyu.biwako_mod.lists;

import jp.yuyu.biwako_mod.BiwakoMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial {
    MATERIAL_BIWAKO(BiwakoMod.MOD_ID + ":MATERIAL_BIWAKO",35,new int[] {3,6,8,3},25,"block.waterlily.place",3.0f, ItemList.BiwakoIngot);

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final String equipSound;
    private final float toughness;
    private final Item repairMaterial;

    private ArmorMaterialList(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, String equipSoundIn, float toughnessIn, Item repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.equipSound = equipSoundIn;
        this.toughness = toughnessIn;
        this.repairMaterial = repairMaterialIn;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }

    @Override
    public String getName() {
        return BiwakoMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
