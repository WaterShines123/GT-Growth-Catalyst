package com.watershines.gtgc.common.block;

import com.gregtechceu.gtceu.api.block.AppearanceBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

import com.watershines.gtgc.api.block.IGlassType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class GlassBlock extends AppearanceBlock {

    public IGlassType glassBlock;

    public GlassBlock(Properties properties, IGlassType glassType) {
        super(properties);
        this.glassBlock = glassType;
    }

    public enum GlassType implements StringRepresentable, IGlassType {

        GLASS("glass", 1.0f, 0, new ResourceLocation("minecraft", "blocks/glass")),
        TEMPERED_GLASS("tempered_glass", 0.9f, 1, new ResourceLocation("gtceu", "blocks/casing_tempered_glass")),
        LAMINATED_GLASS("laminated_glass", 0.8f, 2, new ResourceLocation("gtceu", "blocks/casing_laminated_glass"));

        private final String name;
        private final float energyDiscount;
        private final int tier;
        private final ResourceLocation texture;

        GlassType(String name, float energyDiscount, int tier, ResourceLocation texture) {
            this.name = name;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.texture = texture;
        }

        @Override
        public @NotNull String getName() {
            return this.name;
        }

        @Override
        public float getEnergyDiscount() {
            return this.energyDiscount;
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
