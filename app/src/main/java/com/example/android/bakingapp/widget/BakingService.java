package com.example.android.bakingapp.widget;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;

public class BakingService extends IntentService {
    public static final String INGREDIENTS_LIST = "INGREDIENTS";

    public BakingService() {
        super("BakingService");
    }


    public static void startRecipeService(Context context, ArrayList<String> fromActivityIngredientsList) {
        Intent intent = new Intent(context, BakingService.class);
        intent.putExtra(INGREDIENTS_LIST,fromActivityIngredientsList);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            ArrayList<String> fromActivityIngredientsList = intent.getExtras().getStringArrayList(INGREDIENTS_LIST);
            handleActionUpdateRecipeWidgets(fromActivityIngredientsList);

        }
    }



    private void handleActionUpdateRecipeWidgets(ArrayList<String> fromActivityIngredientsList) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE2");
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE2");
        intent.putExtra(INGREDIENTS_LIST,fromActivityIngredientsList);
        sendBroadcast(intent);
    }

}
