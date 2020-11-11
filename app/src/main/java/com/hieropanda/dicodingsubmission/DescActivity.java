package com.hieropanda.dicodingsubmission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescActivity extends AppCompatActivity {

    ImageView mainImg;
    TextView title, desc;

    String d1, d2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

        mainImg = findViewById(R.id.mainImg);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("d1") && getIntent().hasExtra("d2") ) {
            d1 = getIntent().getStringExtra("d1");
            d2 = getIntent().getStringExtra("d2");
            myImage = getIntent().getIntExtra("myImage", 1);
        } else {
            Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(d1);
        desc.setText(d2);
        mainImg.setImageResource(myImage);
    }
}