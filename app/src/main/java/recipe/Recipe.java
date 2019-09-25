package recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipe {

    String name;
    String cookingTime;
    List<String> mainIngredients;
    int photoId;

    public Recipe(String name, String cookingTime, int photoId, String[] mainIngredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.photoId = photoId;

        this.mainIngredients = new ArrayList<>(mainIngredients.length);
        Collections.addAll(this.mainIngredients, mainIngredients);
    }
}
