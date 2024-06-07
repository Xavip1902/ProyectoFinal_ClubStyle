package com.example.proyectofinal_clubstyle.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal_clubstyle.databinding.ViewholderCategoryBinding;
import com.example.proyectofinal_clubstyle.databinding.ViewholderPopularesBinding;
import com.example.proyectofinal_clubstyle.dominio.ItemDominio;

import java.util.ArrayList;

public class PopularAdapter  extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<ItemDominio> items;
    Context context;

    public PopularAdapter(ArrayList<ItemDominio> items){
        this.items = items;
    }
    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderPopularesBinding binding = ViewholderPopularesBinding.inflate(LayoutInflater.from(context));
        return new Viewholder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        holder.binding.titleTxt.setText(items.get(position).getTitulo());
        holder.binding.reviewTxt.setText(""+items.get(position).getReview());
        holder.binding.priceTxt.setText("$"+items.get(position).getPrecio());
        holder.binding.ratingTxt.setText("("+items.get(position).getRating()+")");
        holder.binding.oldPricetxt.setText("$"+items.get(position).getOldPrice());
        holder.binding.oldPricetxt.setPaintFlags(holder.binding.oldPricetxt.getPaintFlags());
        holder.binding.ratingBar.setRating((float) items.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderPopularesBinding binding;
        public Viewholder(ViewholderPopularesBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}
