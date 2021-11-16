package com.example.android.moonetkom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter1 extends RecyclerView.Adapter<MainAdapter1.ViewHolder> {
    ArrayList<MainModel1> mainModels;
    Context context;
    public MainAdapter1(Context context, ArrayList<MainModel1> mainModels)
    {
        this.context=context;
        this.mainModels=mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listbutton,parent,false);
        return new MainAdapter1.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.buttonview.setText(mainModels.get(position).getButton());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button buttonview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonview=itemView.findViewById(R.id.button_view1);
        }
    }
}
