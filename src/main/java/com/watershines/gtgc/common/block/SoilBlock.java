package com.watershines.gtgc.common.block;

import com.gregtechceu.gtceu.api.block.AppearanceBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

import com.watershines.gtgc.api.block.ISoilType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SoilBlock extends AppearanceBlock {

    public ISoilType soilBlock;

    public SoilBlock(Properties properties, ISoilType soilType) {
        super(properties);
        this.soilBlock = soilType;
    }

    public enum SoilType implements StringRepresentable, ISoilType {

        FARMLAND("farmland", 1.2f, 0, new ResourceLocation("minecraft", "blocks/farmland")),
        INFERIUM_FARMLAND("inferium_farmland", 1.0f, 1, new ResourceLocation("minecraft", "blocks/grass_block")),
        PRUDENTIUM_FARMLAND("prudentium_farmland", 0.833f, 2,
                new ResourceLocation("mysticalagriculture", "blocks/prudentium_farmland")),
        TERTIUM_FARMLAND("tertium_farmland", 0.714f, 3,
                new ResourceLocation("mysticalagriculture", "blocks/tertium_farmland")),
        IMPERIUM_FARMLAND("imperium_farmland", 0.625f, 4,
                new ResourceLocation("mysticalagriculture", "blocks/imperium_farmland")),
        SUPREMIUM_FARMLAND("supremium_farmland", 0.5f, 5,
                new ResourceLocation("mysticalagriculture", "blocks/supremium_farmland"));

        private final String name;
        private final float speedBonus;
        private final int tier;
        private final ResourceLocation texture;

        SoilType(String name, float speedBonus, int tier, ResourceLocation texture) {
            this.name = name;
            this.speedBonus = speedBonus;
            this.tier = tier;
            this.texture = texture;
        }

        @Override
        public @NotNull String getName() {
            return this.name;
        }

        @Override
        public float getSpeedBonus() {
            return this.speedBonus;
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
