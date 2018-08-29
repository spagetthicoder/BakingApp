package com.example.android.bakingapp;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

public class RecipeDetaileActivityBasicTest {
    public static final String STEP_NAME = "0. Recipe Introduction";

    /**
     * The ActivityTestRule is a rule provided by Android used for functional testing of a single
     * activity. The activity that will be tested will be launched before each test that's annotated
     * with @Test and before methods annotated with @Before. The activity will be terminated after
     * the test and methods annotated with @After are complete. This rule allows you to directly
     * access the activity during the test.
     */
    @Rule
    public ActivityTestRule<RecipeDetailActivity> mActivityTestRule = new ActivityTestRule<>(RecipeDetailActivity.class);

    /**
     * Clicks on a GridView item and checks it opens up the Main with the correct details.
     */
    @Test
    public void clickGridViewItem_OpensRecipeDetailActivity() {

        // Uses {@link Espresso#onData(org.hamcrest.Matcher)} to get a reference to a specific
        // gridview item and clicks it.
        onData(anything()).inAdapterView(withId(R.id.recipe_detail_recycler)).atPosition(0).perform(click());

        // Checks that the RecipeDetailActivity opens with the correct recipe name displayed
        onView(withId(R.id.recipe_detail_recycler)).check(matches(withText(STEP_NAME)));

    }
}
