package com.watershines.gtgc.api.pattern;

import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.error.PatternStringError;

import com.lowdragmc.lowdraglib.utils.BlockInfo;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import com.watershines.gtgc.api.GTGCAPI;
import com.watershines.gtgc.api.block.IGlassType;
import com.watershines.gtgc.api.block.ISoilType;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Supplier;

public class GTGCPredicates {

    public static TraceabilityPredicate soilBlocks() {
        return new TraceabilityPredicate(blockWorldState -> {
            var blockState = blockWorldState.getBlockState();
            for (Map.Entry<ISoilType, Supplier<Block>> entry : GTGCAPI.SOIL_BLOCKS.entrySet()) {
                Block candidate = entry.getValue().get();
                if (blockState.is(candidate)) {
                    ISoilType stats = entry.getKey();
                    Object currentSoil = blockWorldState.getMatchContext().getOrPut("SoilType", stats);
                    if (!currentSoil.equals(stats)) {
                        blockWorldState.setError(
                                new PatternStringError("gtceu.multiblock.pattern.error.coils"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> GTGCAPI.SOIL_BLOCKS.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey().getTier()))
                .map(e -> BlockInfo.fromBlockState(
                        e.getValue().get().defaultBlockState()))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("gtceu.multiblock.pattern.error.coils"));
    }

    public static TraceabilityPredicate glassBlocks() {
        return new TraceabilityPredicate(blockWorldState -> {
            var blockState = blockWorldState.getBlockState();
            for (Map.Entry<IGlassType, Supplier<Block>> entry : GTGCAPI.GLASS_BLOCKS.entrySet()) {
                Block candidate = entry.getValue().get();
                if (blockState.is(candidate)) {
                    IGlassType stats = entry.getKey();
                    Object currentSoil = blockWorldState.getMatchContext().getOrPut("GlassType", stats);
                    if (!currentSoil.equals(stats)) {
                        blockWorldState.setError(
                                new PatternStringError("gtceu.multiblock.pattern.error.coils"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> GTGCAPI.GLASS_BLOCKS.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey().getTier()))
                .map(e -> BlockInfo.fromBlockState(
                        e.getValue().get().defaultBlockState()))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("gtceu.multiblock.pattern.error.coils"));
    }
}
