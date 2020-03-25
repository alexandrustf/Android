package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    private TextView message_name;
    private String format_message =  "Your name in the app is: ";
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);
        message_name = (TextView) findViewById(R.id.textView8);
        editor = this.getPreferences(Context.MODE_PRIVATE).edit();

        SharedPreferences sharedPref2 = this.getPreferences(Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.user_name);
        String user_name = sharedPref2.getString(getString(R.string.user_name), defaultValue);
        message_name.setText(user_name);

        Button mButton = findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText editText = (EditText) findViewById(R.id.editText3);
                String message = format_message + editText.getText();
                editor.putString(getString(R.string.user_name), message);
                editor.apply();
                message_name.setText(message);
            }
        });
    }

}
