package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AdapterInterface{
    int[] images = {R.drawable.icon25,R.drawable.icon26,
            R.drawable.icon27,R.drawable.icon28,R.drawable.icon29,R.drawable.icon30,
            R.drawable.icon31,R.drawable.icon32,R.drawable.icon33,R.drawable.icon34,
            R.drawable.icon35,R.drawable.icon36,R.drawable.icon37,R.drawable.icon38,
            R.drawable.icon39,R.drawable.icon40,R.drawable.icon41,R.drawable.icon42,
            R.drawable.icon43,R.drawable.icon44};
    ArrayList<CardModel> models=new ArrayList<>();
    ArrayList<CardModel> models2=new ArrayList<>();
    CardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpModel();
       adapter = new CardAdapter(this,models,this);
        RecyclerView recyclerView = findViewById(R.id.Rcv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                models.add(new CardModel(getString(R.string.im_new),R.drawable.icon27,"im new2"));
                adapter.notifyItemInserted(models.size());
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.smoothScrollToPosition(models.size());

                    }
                });
            }
        });

    }

    private void setUpModel() {
String []text = getResources().getStringArray(R.array.whatever);
        String []text2 = getResources().getStringArray(R.array.whatever2);
for(int i=0;i<text.length;i++)
{
    models.add(new CardModel(text[i],images[i],text2[i]));
}
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "Clicked item at position: " + position, Toast.LENGTH_SHORT).show();
    }
}