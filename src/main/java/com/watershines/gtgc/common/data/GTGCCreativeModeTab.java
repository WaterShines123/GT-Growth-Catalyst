package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import net.minecraft.world.item.CreativeModeTab;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.watershines.gtgc.GTGrowthCatalyst;

import static com.watershines.gtgc.GTGrowthCatalyst.REGISTRATE;

public class GTGCCreativeModeTab {

    public static RegistryEntry<CreativeModeTab> MAIN = REGISTRATE.defaultCreativeTab("main",
            builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", REGISTRATE))
                    .icon(GTGCMachines.GREENHOUSE_TEST::asStack)
                    .title(REGISTRATE.addLang("itemGroup", GTGrowthCatalyst.id("main"), "GT Growth Catalyst"))
                    .build())
            .register();
}
