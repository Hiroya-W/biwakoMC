package jp.yuyu.biwako_mod;

import jp.yuyu.biwako_mod.items.*;
import jp.yuyu.biwako_mod.lists.ArmorMaterialList;
import jp.yuyu.biwako_mod.lists.BlockList;
import jp.yuyu.biwako_mod.lists.ItemList;
import jp.yuyu.biwako_mod.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(BiwakoMod.MOD_ID)
public class BiwakoMod {
    public static final String MOD_ID = "biwako_mod";

    private static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ItemGroup_Biwako = new BiwakoItemGroup();

    public BiwakoMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("HELLO FROM Client Setup");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            LOGGER.info("HELLO from Register Item");
            itemRegistryEvent.getRegistry().registerAll(
                    // Items
                    ItemList.BiwakoIngot = new Item(new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_ingot")),
                    // Blocks
                    ItemList.BiwakoBlock = new BlockItem(BlockList.BiwakoBlock, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(BlockList.BiwakoBlock.getRegistryName()),
                    // Tools
                    ItemList.BiwakoAxe = new ItemCustomAxe(ToolMaterialList.MATERIAL_BIWAKO, 5.0f, -3.0f, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_axe")),
                    ItemList.BiwakoHoe = new ItemCustomHoe(ToolMaterialList.MATERIAL_BIWAKO, 0.0f, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_hoe")),
                    ItemList.BiwakoPickaxe = new ItemCustomPickaxe(ToolMaterialList.MATERIAL_BIWAKO, 1, -2.8f, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_pickaxe")),
                    ItemList.BiwakoShovel = new ItemCustomShovel(ToolMaterialList.MATERIAL_BIWAKO, 1.5f, -3.0f, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_shovel")),
                    ItemList.BiwakoSword = new ItemCustomSword(ToolMaterialList.MATERIAL_BIWAKO, 3, -2.4f, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_sword")),
                    // Armors
                    ItemList.BiwakoHelmet = new ArmorItem(ArmorMaterialList.MATERIAL_BIWAKO, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_helmet")),
                    ItemList.BiwakoChestplate = new ArmorItem(ArmorMaterialList.MATERIAL_BIWAKO, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_chestplate")),
                    ItemList.Biwakoleggings = new ArmorItem(ArmorMaterialList.MATERIAL_BIWAKO, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_leggings")),
                    ItemList.Biwakoboots = new ArmorItem(ArmorMaterialList.MATERIAL_BIWAKO, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup_Biwako))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_boots"))
            );
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("HELLO from Register Block");
            blockRegistryEvent.getRegistry().registerAll(
                    BlockList.BiwakoBlock = new Block(Block.Properties.create(Material.IRON)
                            .hardnessAndResistance(2.0f, 3.0f)
                            .lightValue(5)
                            .sound(SoundType.METAL))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_block"))
            );
        }
    }
}
