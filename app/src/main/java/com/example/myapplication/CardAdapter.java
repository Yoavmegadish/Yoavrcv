package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder>
{
Context context;
ArrayList<CardModel> models;
AdapterInterface adapterInterface;

    public CardAdapter(Context context, ArrayList<CardModel> models,AdapterInterface adapterInterface) {
        this.context = context;
        this.models = models;
        this.adapterInterface = adapterInterface;
    }

    @NonNull
    @Override
    public CardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(view, adapterInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.MyViewHolder myViewHolder, int position) {
        if (models != null && position < models.size()) {
            myViewHolder.text.setText(models.get(position).getText());
            myViewHolder.text2.setText(models.get(position).getText2());
            myViewHolder.iv.setImageResource(models.get(position).getImag());
        }
    }

    @Override
    public int getItemCount() {
        return models.size();

    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text2;
        TextView text;
    ImageView iv;

        public MyViewHolder(@NonNull View itemView, AdapterInterface adapterInterface) {
            super(itemView);
            text=itemView.findViewById(R.id.textView);
            iv = itemView.findViewById(R.id.imageView3);
            text2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterInterface.onItemClicked(getAdapterPosition());
                }
            });
        }
    }
}
