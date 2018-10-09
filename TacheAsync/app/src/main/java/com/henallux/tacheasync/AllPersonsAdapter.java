package com.henallux.tacheasync;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.henallux.tacheasync.Model.Person;

import java.util.ArrayList;

public class AllPersonsAdapter extends RecyclerView.Adapter<AllPersonsAdapter.ViewHolder>{
    private ArrayList<Person> dataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(View v){
            super(v);
            textView=v.findViewById(R.id.textView);
        }
    }

    public AllPersonsAdapter(ArrayList<Person> dataSet){
        this.dataSet=dataSet;
    }

    public void setDataSet(ArrayList<Person> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public AllPersonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(dataSet.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
