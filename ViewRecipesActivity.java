package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewRecipesActivity extends AppCompatActivity {

    ListView recipesListView;
    ArrayList<String> recipes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipes);

        recipesListView = findViewById(R.id.recipesListView);
        recipes = new ArrayList<>();

        // Example recipes
        recipes.add("Spaghetti Bolognese");
        recipes.add("Chicken Curry");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipes);
        recipesListView.setAdapter(adapter);

        recipesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String recipe = recipes.get(position);
                Intent intent = new Intent(ViewRecipesActivity.this, RecipeDetailActivity.class);
                intent.putExtra("recipe", recipe);
                startActivity(intent);
            }
        });
    }
}