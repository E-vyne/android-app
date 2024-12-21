package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddRecipeActivity extends AppCompatActivity {

    EditText titleInput, ingredientsInput, stepsInput;
    Button saveButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        titleInput = findViewById(R.id.titleInput);
        ingredientsInput = findViewById(R.id.ingredientsInput);
        stepsInput = findViewById(R.id.stepsInput);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String ingredients = ingredientsInput.getText().toString();
                String steps = stepsInput.getText().toString();

                Intent intent = new Intent(AddRecipeActivity.this, ViewRecipesActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("ingredients", ingredients);
                intent.putExtra("steps", steps);
                startActivity(intent);
            }
        });
    }
}