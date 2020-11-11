package com.hieropanda.dicodingsubmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity <onCreateOptionMenu> extends AppCompatActivity {

    RecyclerView recyclerView;

    String c1[], c2[];
    int image[] = {
            R.drawable.american_shorthair,
            R.drawable.balinese,
            R.drawable.bengal,
            R.drawable.birman,
            R.drawable.british_shorthair,
            R.drawable.mainecoon,
            R.drawable.persian,
            R.drawable.ragdoll,
            R.drawable.russian_blue,
            R.drawable.scottish_fold
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        c1 = getResources().getStringArray(R.array.cat_name);
        c2 = getResources().getStringArray(R.array.cat_desc);

        MyAdapter myAdapter = new MyAdapter(this, c1, c2, image);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.about_act) {
            Intent intent=new Intent(MainActivity.this, about.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}