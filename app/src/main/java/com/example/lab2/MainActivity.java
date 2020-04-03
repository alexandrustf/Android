package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Query;
import androidx.room.Room;

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
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    private int globalId = 100;
    final String TEXT_VIEW_KEY="CevaString";
    ListView listView;
    TextView textView;
    String appState;
    final String APP_STATE = "CEVAappState";
    int positionItem = 0;
    final String produse_menu_item = "Produse";
    final String cos_menu_item = "Cos";
    final String Settings_menu_item = "Settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            appState = savedInstanceState.getString(TEXT_VIEW_KEY);
        }
        textView = (TextView) findViewById(R.id.textView);
        listView = (ListView)findViewById(R.id.lvExp);

        ArrayList<Product> list = CreateDatabase();
        final ArrayList<String> arrayList = new ArrayList<>();
        for (Product product : list)
        {
            arrayList.add(product.name);
        }

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
    private ArrayList<Product> CreateDatabase(){
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-products")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .build();
        Product p1 = new Product();
        p1.uid =  ++globalId;
        p1.name = "Nike";
        Product p3 = new Product();
        p3.uid =  ++globalId;
        p3.name = "Puma";
        Product p4 = new Product();
        p4.uid =  ++globalId;
        p4.name = "Loto";
        Product p5 = new Product();
        p5.uid =  ++globalId;
        p5.name = "Umbro";
//        database.getProductDao().insertAll(p4,p3,p5);

        return (ArrayList<Product>) database.getProductDao().getAll();
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
            case R.id.cart:
                sendMessage();
                return true;
            case R.id.settings:
                goToSettings();
                return true;
            case R.id.sensors:
                goToSensors();
                return true;
            case R.id.location:
                goToMap();
                return true;
            case R.id.camera:
                goToCamera();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToCamera(){
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);
    }
    private void goToSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    private void goToSensors() {
        Intent intent = new Intent(this, Sensors.class);
        startActivity(intent);
    }
    private void goToMap() {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public void sendMessage() {
        Intent intent = new Intent(this, AddNewItem.class);
        String message = "Doresti sa cumperi produsul cu id-ul: " + positionItem + " ?";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
