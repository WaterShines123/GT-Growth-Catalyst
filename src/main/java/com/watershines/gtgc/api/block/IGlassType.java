package com.watershines.gtgc.api.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.util.Lazy;

import com.watershines.gtgc.api.GTGCAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Comparator;

public interface IGlassType {

    @NotNull
    String getName();

    float getEnergyDiscount();

    int getTier();

    ResourceLocation getTexture();

    Lazy<IGlassType[]> ALL_GLASS_TIER_SORTED = Lazy.of(() -> GTGCAPI.GLASS_BLOCKS.keySet().stream()
            .sorted(Comparator.comparing(IGlassType::getTier))
            .toArray(IGlassType[]::new));

    @Nullable
    static IGlassType getMinRequiredTier(int minTier) {
        return Arrays.stream(ALL_GLASS_TIER_SORTED.get())
                .filter(glass -> glass.getTier() >= minTier)
                .findFirst().orElse(null);
    }
}
