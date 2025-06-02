package com.watershines.gtgc.common.data;

import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import static com.watershines.gtgc.GTGrowthCatalyst.REGISTRATE;

public class GTGCItems {

    static {
        REGISTRATE.creativeModeTab(() -> GTGCCreativeModeTab.MAIN);
    }

    public static ItemEntry<Item> PlatinumMesh = REGISTRATE.item("platinum_mesh", Item::new).register();
    public static ItemEntry<Item> OsmiridiumMesh = REGISTRATE.item("osmiridium_mesh", Item::new).register();
    public static ItemEntry<Item> TZMCatalyst = REGISTRATE.item("tmt_catalyst", Item::new).register();

    public static void init() {}
}
