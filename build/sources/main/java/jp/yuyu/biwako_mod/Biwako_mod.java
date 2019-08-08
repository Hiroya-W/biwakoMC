package jp.yuyu.biwako_mod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = Biwako_mod.MOD_ID,
        name = Biwako_mod.MOD_NAME,
        version = Biwako_mod.VERSION
)
public class Biwako_mod {

    public static final String MOD_ID = "biwako_mod";
    public static final String MOD_NAME = "Biwako Mod";
    public static final String VERSION = "1.0.1";

    @Mod.Instance(MOD_ID)
    public static Biwako_mod INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {

    }

    /**
     * アイテム保持用内部クラス
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
        public static final Item biwakoBurger = null;       /** 琵琶湖バーガー */
        public static final Item biwakoWater = null;        /** 琵琶湖の水 */
        public static final Item biwakoSword = null;        /** 琵琶湖ソード , 滋賀剣*/
    }

    /**
     * アイテム登録用イベント
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                new Item()
                        .setRegistryName(MOD_ID, "biwakoburger")
                        .setCreativeTab(CreativeTabs.FOOD)
                        .setTranslationKey("biwakoburger"),
                new Item()
                        .setRegistryName(MOD_ID,"biwakowater")
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setTranslationKey("biwakowater"),
                new AddSword(EnumHelper.addToolMaterial("BIWAKOWATER_MATERIAL",1,1000,5,7,1))
                        .setRegistryName(MOD_ID,"biwakosword")
                        .setTranslationKey("biwakosword")
            );
        }

        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {

        }

        /**
         * モデル登録用イベント
         */
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(Items.biwakoBurger, 0, new ModelResourceLocation(Items.biwakoBurger.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Items.biwakoWater, 0, new ModelResourceLocation(Items.biwakoWater.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(Items.biwakoSword, 0, new ModelResourceLocation(Items.biwakoSword.getRegistryName(), "inventory"));
        }
    }

}
