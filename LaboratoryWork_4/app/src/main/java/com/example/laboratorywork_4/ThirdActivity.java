package com.example.laboratorywork_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private EditText editTextStartPoint, editTextEndPoint, editTextTime,
            editTextDistance, editTextCost, editTextAdditionalInfo;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editTextStartPoint = findViewById(R.id.editTextStartPoint);
        editTextEndPoint = findViewById(R.id.editTextEndPoint);
        editTextTime = findViewById(R.id.editTextTime);
        editTextDistance = findViewById(R.id.editTextDistance);
        editTextCost = findViewById(R.id.editTextCost);
        editTextAdditionalInfo = findViewById(R.id.editTextAdditionalInfo);
        btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Prepare data to send back to the second activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("путь", getPathData());
                setResult(RESULT_OK, resultIntent);
                // Finish the third activity
                finish();
            }
        });
    }

    // Utility method to concatenate path data
    private String getPathData() {
        String startPoint = editTextStartPoint.getText().toString();
        String endPoint = editTextEndPoint.getText().toString();
        String time = editTextTime.getText().toString();
        String distance = editTextDistance.getText().toString();
        String cost = editTextCost.getText().toString();
        String additionalInfo = editTextAdditionalInfo.getText().toString();

        // Concatenate the path data
        return startPoint + " в " + endPoint + "\nВремя: " + time +
                "\nРасстояние: " + distance + "\nСтоимость: " + cost + "\nПодробности: " + additionalInfo;
    }
}
