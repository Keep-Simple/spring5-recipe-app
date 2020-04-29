package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        try {
            run();
        } catch (Exception e) {
            System.out.println("Error bootstrapping data");
        }
    }


    public void run(String... args) throws Exception {

        Recipe recipe = new Recipe();
        recipe.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        recipe.setCookTime(15);
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setServings(3);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe.setPrepTime(10);

        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("ripe avocados");
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Number").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);
        ingredient = new Ingredient();
        ingredient.setDescription("salt");
        ingredient.setAmount(BigDecimal.valueOf(0.25));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);
        ingredient = new Ingredient();
        ingredient.setDescription("fresh lemon juice");
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);
        ingredient = new Ingredient();
        ingredient.setDescription("freshly grated black pepper");
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Dash").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);


        recipe.setSource("Cook Book");
        recipe.setImage(new Byte[]{});
        recipe.setDescription("The best guacamole keeps it simple: just ripe avocados, salt," +
                " a squeeze of lime, onions, chiles, cilantro, and some chopped tomato." +
                " Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.");
        recipe.setDirections("IDK");

        recipeRepository.save(recipe);

        recipe = new Recipe();
        recipe.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        recipe.setCookTime(15);
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setServings(3);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe.setPrepTime(10);

        ingredient = new Ingredient();
        ingredient.setDescription("chicken");
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Number").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);
        ingredient = new Ingredient();
        ingredient.setDescription("sauce");
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);
        ingredient = new Ingredient();
        ingredient.setDescription("freshly grated black pepper");
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(unitOfMeasureRepository.findByDescription("Dash").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);


        recipe.setSource("Cook Book");
        recipe.setImage(new Byte[]{});
        recipe.setDescription("Eat chicken, Eat chicken, Eat chicken, Eat chicken, Eat chicken," +
                "Eat chicken, Eat chicken, Eat chicken, Eat chicken, Eat chicken");
        recipe.setDirections("IDK");

        recipeRepository.save(recipe);
    }
}
