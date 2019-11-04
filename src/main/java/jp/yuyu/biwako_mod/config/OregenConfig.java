package jp.yuyu.biwako_mod.config;

import jp.yuyu.biwako_mod.BiwakoMod;
import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig
{
    public static ForgeConfigSpec.IntValue biwako_ore_chance;
    public static ForgeConfigSpec.BooleanValue generate_overworld;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        BiwakoMod.LOGGER.info("OregenConfig init");
        server.comment("Oregen Config");

        biwako_ore_chance = server
                .comment("Maximum number of ore veins of the biwako ore that can spawn in one chunk.")
                .defineInRange("oregen.biwako_ore_chance", 20, 1, 1000000);

        generate_overworld = server
                .comment("Decide if you want Biwako Mod ores to spawn in the overworld")
                .define("oregen.generate_overworld", true);
    }
}
