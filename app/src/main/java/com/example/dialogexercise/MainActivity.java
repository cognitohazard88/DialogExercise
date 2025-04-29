package com.example.dialogexercise;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDeleteData = findViewById(R.id.buttonDeleteData);
        TextView textViewData = findViewById(R.id.textViewData);

        buttonDeleteData.setOnClickListener(v->showAlertDialog(textViewData));
    }

    public void showAlertDialog(TextView textViewData){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog");
        builder.setMessage("Czy na pewno chcesz usunąć dane?");

        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Dane zostały usunięte", Toast.LENGTH_SHORT).show();
                licznik++;
                if(licznik == 1){
                    textViewData.setText("Dane usunięto: " + licznik + " raz");
                } else {
                    textViewData.setText("Dane usunięto: " + licznik + " razy");
                };
            }
        });

        builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {};
        });

        builder.create().show();
    }
}