package com.example.proyectofinal_clubstyle;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal_clubstyle.Adapter.SliderAdapter;
import com.example.proyectofinal_clubstyle.databinding.ActivityMainBinding;
import com.example.proyectofinal_clubstyle.dominio.ItemDominio;
import com.example.proyectofinal_clubstyle.dominio.SliderItems;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {
    private ActivityMainBinding binding ;
    private ItemDominio object;
    private int numero_de_orden = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_detalle);

        managmentCart = new ManagmentCart(this);

        getBundles();
        initBanners();
    }

    private void initBanners() {
        ArrayList<SliderItems> sliderItems= new ArrayList<>();
        for (int i = 0; i < object.getPicUrl().size(); i++){
            sliderItems.add(new SliderItems(object.getPicUrl().get(i)));
        }
        binding.viewPagerSlider.setAdapter(new SliderAdapter(sliderItems, binding.viewPagerSlider));
        binding.viewPagerSlider.setClipToPadding(false);
        binding.viewPagerSlider.setClipChildren(false);
        binding.viewPagerSlider.setOffscreenPageLimit(3);
        binding.viewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
    }

    private void getBundles(){
        object = (ItemDominio) getIntent().getSerializableExtra("objeto");
        binding.titleTxt.setTex(object.getTitulo());
        binding.precioTxt.setText("$"+object.getPrecio());
        binding.rantinBar.setRating((float)object.getRating());
        binding.ratingTxt.setText(object.getRating()+"Clasificacion");
        binding.descripcionTxt.setText(object.getDescripcion());

        binding.AddCarritoBtn.setOnClickListener( v -> {
            object.getNumeroEnCarrito(numero_de_orden);
            managmentCart.insertarItem(object);
        });

        binding.atrasBtn.setOnClickListaner (v -> finish());

    }

}