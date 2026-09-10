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
                .pattern("AAA") //3x3 character matrix represents the crafting grid
                .pattern("B B")
                .pattern(" B ")
                .define('A', Items.STRING) //Each item involved is assigned to a character
                .define('B', Items.STICK) //Like a rhyme scheme
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING)) //Player unlocks the recipe upon receiving string
                .group("ModWeapons") //Belongs to ModWeapons
                .save(output); //saves the recipe

        shaped(RecipeCategory.COMBAT, Items.TRIDENT)
                .pattern("AAA") //3x3 character matrix represents the crafting grid
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.ELDERSPIKE.get()) //Each item involved is assigned to a character
                .define('B', Items.PRISMARINE_SHARD) //Like a rhyme scheme
                .unlockedBy(getHasName(ModItems.ELDERSPIKE.get()), has(ModItems.ELDERSPIKE.get())) //Player unlocks the recipe upon receiving string
                .group("Weapons") //Belongs to ModWeapons
                .save(output); //saves the recipe
    }
}
