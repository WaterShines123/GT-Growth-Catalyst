package com.watershines.gtgc.api.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.util.Lazy;

import com.watershines.gtgc.api.GTGCAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Comparator;

public interface ISoilType {

    @NotNull
    String getName();

    float getSpeedBonus();

    int getTier();

    ResourceLocation getTexture();

    Lazy<ISoilType[]> ALL_SOILS_TIER_SORTED = Lazy.of(() -> GTGCAPI.SOIL_BLOCKS.keySet().stream()
            .sorted(Comparator.comparing(ISoilType::getTier))
            .toArray(ISoilType[]::new));

    @Nullable
    static ISoilType getMinRequiredTier(int minTier) {
        return Arrays.stream(ALL_SOILS_TIER_SORTED.get())
                .filter(soil -> soil.getTier() >= minTier)
                .findFirst().orElse(null);
    }
}
