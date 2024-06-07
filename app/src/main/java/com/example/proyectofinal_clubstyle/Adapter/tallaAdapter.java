package com.example.proyectofinal_clubstyle.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal_clubstyle.databinding.ViewholderTallaBinding;

import java.util.ArrayList;

public class tallaAdapter extends RecyclerView.Adapter<tallaAdapter.Viewholder> {
    ArrayList<String> items;
    Context context;
    int seleccionPosicion = -1;
    int despuesSeleccionPosicion = -1;
    public tallaAdapter(ArrayList<String> items){
        this.items = items;
    }
    @NonNull
    @Override
    public tallaAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderTallaBinding binding= ViewholderTallaBinding.inflate(LayoutInflater.from(context),parent,false);
        return new Viewholder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull tallaAdapter.Viewholder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
