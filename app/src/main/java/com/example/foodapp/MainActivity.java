package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import recipe.RecipeFragment;
import storage.StorageFragment;

import static recipe.RecipeFragment.initializeFoodRecipeData;
import static storage.StorageFragment.prepareFoodDate;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        toolbar = getSupportActionBar();
        toolbar.setTitle("Food Storage");

        navView = findViewById(R.id.nav_view);
//
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new StorageFragment());

        prepareFoodDate();
        initializeFoodRecipeData();



    }

//todo set action bar title in the center

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_food_storage:
                    toolbar.setTitle("Food Storage");
                    Log.i("Info", "OK");
                    fragment = new StorageFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("DashboardFragment");
                    fragment = new DashboardFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_recipe:
                    toolbar.setTitle("Food Recipe");
                    Log.i("Info", "OK");
                    fragment = new RecipeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_notifications:
                    toolbar.setTitle("ProfileFragment");
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment){
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Log.i("Info", "OK");



    }

}
