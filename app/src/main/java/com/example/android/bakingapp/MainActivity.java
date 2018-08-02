package com.example.android.bakingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.ListItemClickListener{

    private static final String SELECTED_RECIPE = "Selected_Recipes";
    static String ALL_RECIPES="All_Recipes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListItemClick(Recipe clickedItemIndex) {
        Bundle selectedRecipe = new Bundle();
        ArrayList<Recipe> selectedRecipeArray = new ArrayList<>();
        selectedRecipeArray.add(clickedItemIndex);
        selectedRecipe.putParcelableArrayList(SELECTED_RECIPE, selectedRecipeArray);

        final Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtras(selectedRecipe);
        startActivity(intent);

    }
}
