package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddNewItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        System.out.println( message);
//        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);
        final String messageOk = message + "\nProdusul a fost achizitionat cu succes!";
        final String messageCancel = message + "\nDin pacate, ai ales sa nu cumperi acest produs.";


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Cumperi acest produs?")
                .setTitle("Confirmare achizitie");


        builder.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TextView textView = findViewById(R.id.textView2);
                textView.setText(messageOk);
            }
        });
        builder.setNegativeButton("Renunta", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TextView textView = findViewById(R.id.textView2);
                textView.setText(messageCancel);
            }
        });

        AlertDialog dialog = builder.create();
        builder.show();

    }
}
