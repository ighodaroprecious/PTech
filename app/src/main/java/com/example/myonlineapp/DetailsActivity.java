package com.example.myonlineapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView name, instruction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        name = findViewById(R.id.name);
        instruction = findViewById(R.id.instruction);

        String Name = getIntent().getStringExtra("Name");
        String Instruction = getIntent().getStringExtra("Instruction");

        name.setText(Name);
        instruction.setText(Instruction);
    }

}
