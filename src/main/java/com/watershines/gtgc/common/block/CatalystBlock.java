package com.watershines.gtgc.common.block;

import com.gregtechceu.gtceu.api.block.AppearanceBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

import com.watershines.gtgc.api.block.ICatalystType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class CatalystBlock extends AppearanceBlock {

    public ICatalystType catalystBlock;

    public CatalystBlock(Properties properties, ICatalystType catalystType) {
        super(properties);
        this.catalystBlock = catalystType;
    }

    public enum CatalystType implements StringRepresentable, ICatalystType {

        TIER_0("tier_0", 1, 0, new ResourceLocation("minecraft", "blocks/glass")),
        TIER_1("tier_1", 1.2, 1, new ResourceLocation("minecraft", "blocks/glass")),
        TIER_2("tier_2", 1.3, 2, new ResourceLocation("minecraft", "blocks/glass")),
        TIER_3("tier_2", 1.3, 2, new ResourceLocation("minecraft", "blocks/glass")),
        TIER_4("tier_2", 1.3, 2, new ResourceLocation("minecraft", "blocks/glass")),
        TIER_5("tier_2", 1.3, 2, new ResourceLocation("minecraft", "blocks/glass"));

        private final String name;
        private final double speedBoost;
        private final int tier;
        private final ResourceLocation texture;

        CatalystType(String name, double speedBoost, int tier, ResourceLocation texture) {
            this.name = name;
            this.speedBoost = speedBoost;
            this.tier = tier;
            this.texture = texture;
        }

        @Override
        public @NotNull String getName() {
            return this.name;
        }

        @Override
        public double getSpeedBoost() {
            return this.speedBoost;
        }

        @Override
        public int getTier() {
            return this.tier;
        }

        @Override
        public ResourceLocation getTexture() {
            return this.texture;
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }
    }
}
