package net.sugaryhydra.advancedalchemy.DataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.sugaryhydra.advancedalchemy.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Advanced Alchemy Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.SLINGSHOT)
                .pattern("AAA")
                .pattern("B B")
                .pattern(" B ")
                .define('A', Items.STRING)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .group("ModWeapons")
                .save(output);
    }
}
