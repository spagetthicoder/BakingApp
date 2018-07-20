package com.example.android.bakingapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceRecipe {
    @GET("baking.json")
    Call<ArrayList<Recipe>> getRecipe();
}
