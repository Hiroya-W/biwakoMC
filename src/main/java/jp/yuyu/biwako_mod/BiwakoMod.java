package jp.yuyu.biwako_mod;

import jp.yuyu.biwako_mod.lists.BlockList;
import jp.yuyu.biwako_mod.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
                    ItemList.BiwakoIngot = new Item(new Item.Properties().group(ItemGroup.MISC))
                            .setRegistryName(new ResourceLocation(MOD_ID, "biwako_ingot")),
                    ItemList.BiwakoBlock = new BlockItem(BlockList.BiwakoBlock, new Item.Properties().group(ItemGroup.MISC))
                            .setRegistryName(BlockList.BiwakoBlock.getRegistryName())
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
