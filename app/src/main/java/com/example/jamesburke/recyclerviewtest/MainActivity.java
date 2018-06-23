package com.example.jamesburke.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_LIST_ITEMS = 100;
    private MyViewAdapter myViewAdapter;
    private RecyclerView mNumbersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);

        myViewAdapter = new MyViewAdapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(myViewAdapter);

    }
}
