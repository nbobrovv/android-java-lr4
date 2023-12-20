package com.example.laboratorywork_4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone, editTextFirstName, editTextLastName;
    private Button btnRegistration;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextPhone);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        btnRegistration = findViewById(R.id.btnRegistration);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        // Check if user is already registered
        if (sharedPreferences.contains("Номер")) {
            // User is already registered, change button text
            btnRegistration.setText("Зарегистрироваться");
        }

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save registration data in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Номер", editTextPhone.getText().toString());
                editor.putString("Имя", editTextFirstName.getText().toString());
                editor.putString("Фамилия", editTextLastName.getText().toString());
                editor.apply();

                // Start the second activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Номер", editTextPhone.getText().toString());
                intent.putExtra("Имя", editTextFirstName.getText().toString());
                intent.putExtra("Фамилия", editTextLastName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
