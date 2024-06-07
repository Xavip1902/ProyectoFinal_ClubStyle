package com.example.proyectofinal_clubstyle;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.proyectofinal_clubstyle.Adapter.CategoryAdapter;
import com.example.proyectofinal_clubstyle.Adapter.PopularAdapter;
import com.example.proyectofinal_clubstyle.Adapter.SliderAdapter;
import com.example.proyectofinal_clubstyle.databinding.ActivityMainBinding;
import com.example.proyectofinal_clubstyle.dominio.CategoryDominio;
import com.example.proyectofinal_clubstyle.dominio.ItemDominio;
import com.example.proyectofinal_clubstyle.dominio.SliderItems;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initBanner();
        initCategoria();
        initPopular();
    }

    private void initPopular (){
        DatabaseReference myref= database.getReference("Items");
        binding.progressBarPopulares.setVisibility(View.VISIBLE);
        ArrayList<ItemDominio> items = new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot isseu : snapshot.getChildren()){
                        items.add(isseu.getValue(ItemDominio.class));
                    }
                    if (!items.isEmpty()){
                        binding.recyclerViewPopulares.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                        binding.recyclerViewPopulares.setAdapter(new PopularAdapter(items));
                        binding.recyclerViewPopulares.setNestedScrollingEnabled(true);
                    }
                    binding.progressBarPopulares.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initCategoria(){
        DatabaseReference myref= database.getReference("Categoria");
        binding.progressBarMarcas.setVisibility(View.VISIBLE);
        ArrayList<CategoryDominio> items = new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue:snapshot.getChildren()){
                        items.add(issue.getValue(CategoryDominio.class));
                    }
                    if (!items.isEmpty()){
                        binding.recyclerViewMarcas.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        binding.recyclerViewMarcas.setAdapter(new CategoryAdapter(items));
                        binding.recyclerViewMarcas.setNestedScrollingEnabled(true);
                    }
                    binding.progressBarMarcas.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initBanner(){
        DatabaseReference myRef= database.getReference("Banner");
        binding.progressBarBanner.setVisibility(View.VISIBLE);
        ArrayList<SliderItems> items= new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue:snapshot.getChildren()){
                        items.addAll(issue.getValue(SliderItems.class));
                    }
                    banners(items);
                    binding.progressBarBanner.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void banners(ArrayList<SliderItems> items){
        binding.viewPagerSlider.setAdapter(new SliderAdapter(items, binding.viewPagerSlider));
        binding.viewPagerSlider.setClipToPadding(false);
        binding.viewPagerSlider.setClipChildren(false);
        binding.viewPagerSlider.setOffscreenPageLimit(3);
        binding.viewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        binding.viewPagerSlider.setPageTransformer(compositePageTransformer);
    }

}