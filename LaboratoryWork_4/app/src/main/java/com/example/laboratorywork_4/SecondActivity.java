package com.example.laboratorywork_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewUserInfo, textViewRoute;
    private Button btnSetPath, btnCallTaxi;
    private static final int REQUEST_CODE_SET_PATH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewUserInfo = findViewById(R.id.textViewUserInfo);
        textViewRoute = findViewById(R.id.textViewRoute);
        btnSetPath = findViewById(R.id.btnSetPath);
        btnCallTaxi = findViewById(R.id.btnCallTaxi);

        // Get user info from intent
        Intent intent = getIntent();
        String phone = intent.getStringExtra("Номер");
        String fullName = intent.getStringExtra("Имя") + " " + intent.getStringExtra("Фамилия");
        textViewUserInfo.setText("Информация о пользователе:\n" + fullName + "\nНомер: " + phone);

        btnSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the third activity for setting the path
                Intent setPathIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(setPathIntent, REQUEST_CODE_SET_PATH);
            }
        });

        btnCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a success message
                // You can replace this with actual taxi calling logic
                showToast("Такси успешно вызвано!");
            }
        });
    }

    // Utility method to display a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Override onActivityResult to handle the result from the third activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SET_PATH && resultCode == RESULT_OK) {
            // Get the path data from the third activity result
            String path = data.getStringExtra("путь");
            // Update the route text view
            textViewRoute.setText("Маршрут: " + path);
            // Enable the Call Taxi button
            btnCallTaxi.setEnabled(true);
        }
    }
}
