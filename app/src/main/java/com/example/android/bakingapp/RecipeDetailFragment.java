package com.example.android.bakingapp;

import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.bakingapp.RecipeDetailActivity.SELECTED_RECIPES;


public class RecipeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private ArrayList<Recipe> recipe;
    private String recipeName;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeDetailFragment() {
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rView;
        final TextView tView;

        recipe = new ArrayList<>();

        if(savedInstanceState != null){
            recipe = savedInstanceState.getParcelableArrayList(SELECTED_RECIPES);
        } else{
            recipe = getArguments().getParcelableArrayList(SELECTED_RECIPES);
        }

        List<Ingredient> ingredientList = recipe.get(0).getIngredients();
        recipeName = recipe.get(0).getName();

        View rootView = inflater.inflate(R.layout.recipedetailactivity_detail, container, false);
        tView = (TextView) rootView.findViewById(R.id.recipe_detail_text_view);

        ingredientList.forEach((a) ->
        {
            tView.append("*  " + a.getIngredient() + "\n");
            tView.append("\t\t\t Quantity: " + a.getQuantity().toString() + "\n");
            tView.append("\t\t\t Measure: " + a.getMeasure() + "\n\n");
        });

        rView = (RecyclerView) rootView.findViewById(R.id.recipe_detail_reycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rView.setLayoutManager(linearLayoutManager);

        RecipeDetailAdapter recipeDetailAdapter = new RecipeDetailAdapter((RecipeDetailActivity)getActivity());
        rView.setAdapter(recipeDetailAdapter);
        recipeDetailAdapter.setMasterRecipeData(recipe, getContext());

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(SELECTED_RECIPES, recipe);
        outState.putString("Title", recipeName);
    }
}
