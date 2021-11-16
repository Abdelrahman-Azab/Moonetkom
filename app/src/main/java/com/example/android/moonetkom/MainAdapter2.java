package com.example.android.moonetkom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter2 extends RecyclerView.Adapter<MainAdapter2.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;
    public MainAdapter2(Context context,ArrayList<MainModel> mainModels)
    {
        this.context=context;
        this.mainModels=mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_relateditem,parent,false);
        return new MainAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModels.get(position).getCardslogo());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }
}
