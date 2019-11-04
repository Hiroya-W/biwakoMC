package jp.yuyu.biwako_mod.world;

import jp.yuyu.biwako_mod.BiwakoMod;
import jp.yuyu.biwako_mod.config.OregenConfig;
import jp.yuyu.biwako_mod.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
    public static void setupOreGeneration() {
        if (OregenConfig.generate_overworld.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
//                BiwakoMod.LOGGER.info("biome:" + biome.getRegistryName());
                BiwakoMod.LOGGER.info("ore_chance:" + OregenConfig.biwako_ore_chance.get().toString());
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(
                                Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        BlockList.BiwakoOre.getDefaultState(),
                                        OregenConfig.biwako_ore_chance.get()),
                                Placement.COUNT_RANGE,
                                new CountRangeConfig(10, 20, 0, 100)));
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(
                                Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NETHERRACK,
                                        BlockList.BiwakoQuartzOre.getDefaultState(),
                                        OregenConfig.biwako_ore_chance.get()),
                                Placement.COUNT_RANGE,
                                new CountRangeConfig(10, 20, 0, 100)));
            }
        }
    }
}
