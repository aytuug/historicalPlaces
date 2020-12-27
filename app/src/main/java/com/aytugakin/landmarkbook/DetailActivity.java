package com.aytugakin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.aytugakin.landmarkbook.MainActivity.selectedImage;


public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView landmarkNameText;
    TextView countryNameText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageView);
        landmarkNameText = findViewById(R.id.landmarkNameText);
        countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent();
        String landmarkName = intent.getStringExtra("Name");
        String countryName = intent.getStringExtra("Country");
        landmarkNameText.setText(landmarkName);
        countryNameText.setText(countryName);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());



        //imageView.setImageBitmap(selectedImage);


    }
}