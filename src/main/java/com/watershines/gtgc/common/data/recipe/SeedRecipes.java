package com.watershines.gtgc.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

import static com.blakebr0.mysticalagriculture.lib.ModCrops.IRON;
import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.ingot;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iron;
import static com.watershines.gtgc.common.data.recipe.GTGCRecipeUtils.*;
import static com.watershines.gtgc.gtbridge.GTGCRecipeTypes.MULTIBLOCK_ALTAR;

public class SeedRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        MULTIBLOCK_ALTAR.recipeBuilder("iron_seed_creation")
                .inputItems(new ItemStack(tertiumEssence, 4))
                .inputItems(new ItemStack(prosperitySeedBase, 1))
                .inputItems(ingot, Iron, 4)
                .outputItems(IRON.getSeedsItem())
                .duration(400).EUt(VA[IV]).save(provider);
    }
}
