package com.example.android.moonetkom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapteritems extends RecyclerView.Adapter<MainAdapteritems.ViewHolder> {
    ArrayList<Modelitems> mainmodels;
    Context context;
    public MainAdapteritems(Context context,ArrayList<Modelitems> mainmodels)
    {
        this.context=context;
        this.mainmodels=mainmodels;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_data_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.imageView.setImageResource(mainmodels.get(position).getImageresource());
     holder.textView1.setText(mainmodels.get(position).getDescriptiomn());
     holder.textView2.setText(mainmodels.get(position).getPricee());
    }

    @Override
    public int getItemCount() {
        return mainmodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_data);
            textView1=itemView.findViewById(R.id.description);
            textView2=itemView.findViewById(R.id.price);
        }
    }
}
