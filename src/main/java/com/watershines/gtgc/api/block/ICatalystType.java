package com.watershines.gtgc.api.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.util.Lazy;

import com.watershines.gtgc.api.GTGCAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Comparator;

public interface ICatalystType {

    @NotNull
    String getName();

    double getSpeedBoost();

    int getTier();

    ResourceLocation getTexture();

    Lazy<ICatalystType[]> ALL_CATALYST_TIER_SORTED = Lazy.of(() -> GTGCAPI.CATALYST_BLOCKS.keySet().stream()
            .sorted(Comparator.comparing(ICatalystType::getTier))
            .toArray(ICatalystType[]::new));

    @Nullable
    static ICatalystType getMinRequiredTier(int minTier) {
        return Arrays.stream(ALL_CATALYST_TIER_SORTED.get())
                .filter(glass -> glass.getTier() >= minTier)
                .findFirst().orElse(null);
    }
}
