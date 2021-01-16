package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyProductAdapter myProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.listId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<MyProduct> myProductData = new ArrayList<>();
        myProductData.add(new MyProduct("Panadol","Pill  for headAche","Price : $2.99",R.drawable.panadol));
        myProductData.add(new MyProduct("Nyquill","Pill  for headAche","Price : $2.99",R.drawable.panadol));
        myProductData.add(new MyProduct("ZAck","Pill  for headAche","Price : $2.99",R.drawable.panadol));
        myProductData.add(new MyProduct("Codeine","Pill  for headAche","Price : $2.99",R.drawable.panadol));



         myProductAdapter = new MyProductAdapter(myProductData,MainActivity.this);
        recyclerView.setAdapter(myProductAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_bar,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                myProductAdapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}