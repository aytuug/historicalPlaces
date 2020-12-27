package com.aytugakin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //static  Bitmap selectedImage;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //Data

        ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Sultanahmet");
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Colleseo");
        landmarkNames.add("London Bridge");

        ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Turkey");
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("England");

        Bitmap sultanahmet = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.first);
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.second);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.thirx);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fourty);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fifty);

        ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(sultanahmet);
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colleseo);
        landmarkImages.add(londonBridge);

        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(landmarkNames.get(position));
                //System.out.println(countryNames.get(position));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("Name",landmarkNames.get(position));
                intent.putExtra("Country",countryNames.get(position));
                //selectedImage = landmarkImages.get(position);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));

                startActivity(intent);

            }
        });

    }
}