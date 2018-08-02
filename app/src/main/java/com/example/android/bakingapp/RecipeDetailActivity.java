package com.example.android.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity implements RecipeDetailAdapter.ListItemClickListener {

    static String SELECTED_RECIPES = "Selected_Recipes";
    private ArrayList<Recipe> recipe;
    String recipeName;
    private String RECIPE_DETAIL = "RECIPE_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipedetailactivity_detail);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = getIntent().getExtras();
            recipe = new ArrayList<>();
            assert arguments != null;
            recipe = arguments.getParcelableArrayList(SELECTED_RECIPES);
            recipeName = recipe.get(0).getName();

         final RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.recipedetailactivity_detail_container, fragment).addToBackStack(RECIPE_DETAIL)
                    .commit();
        } else {
            recipeName= savedInstanceState.getString("Title");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, RecipeDetailActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(List<Step> stepsOut, int clickedItemIndex, String recipeName) {

    }
}
