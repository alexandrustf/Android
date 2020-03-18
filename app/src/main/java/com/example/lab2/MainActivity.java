package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String TEXT_VIEW_KEY="CevaString";
    ListView listView;
    TextView textView;
    String appState;
    final String APP_STATE = "CEVAappState";
    int positionItem = 0;
    final String produse_menu_item = "Produse";
    final String cos_menu_item = "Cos";
    final String FAQ_menu_item = "FAQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            appState = savedInstanceState.getString(TEXT_VIEW_KEY);
        }
        textView = (TextView) findViewById(R.id.textView);
        listView = (ListView)findViewById(R.id.lvExp);
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("papuci");
        arrayList.add("blugi");
        arrayList.add("ochelari");
        arrayList.add("adidasi");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "clicked item" + position
                        +" " + arrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
                        positionItem = position;
                    }
                }
        );
    }

    @Override
    public void onPause(){
        super.onPause();
        Toast.makeText(MainActivity.this, "paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(MainActivity.this, "destroyed", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this, "started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this, "resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        textView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
//        outState.putString(, appState);
        String restoreThis = "restored item: " + positionItem;
        outState.putString(TEXT_VIEW_KEY, restoreThis);
//        outState.putInt(TEXT_VIEW_KEY, positionItem);
//        textView.setText("CLOCKED" + positionItem);
//        outState.putInt((String) textView.getText(), positionItem);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.products:
                sendMessage();
                return true;
            case R.id.cart:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public void sendMessage() {
        Intent intent = new Intent(this, AddNewItem.class);
        String message = "Doresti sa cumperi produsul cu id-ul: " + positionItem + " ?";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
