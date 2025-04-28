package com.watershines.gtgc.api;

import net.minecraft.world.level.block.Block;

import com.watershines.gtgc.api.block.IGlassType;
import com.watershines.gtgc.api.block.ISoilType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GTGCAPI {

    public static final Map<ISoilType, Supplier<Block>> SOIL_BLOCKS = new HashMap<>();
    public static final Map<IGlassType, Supplier<Block>> GLASS_BLOCKS = new HashMap<>();
}
