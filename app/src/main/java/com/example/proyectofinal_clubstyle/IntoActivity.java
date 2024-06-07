package com.example.proyectofinal_clubstyle;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectofinal_clubstyle.databinding.ActivityIntoBinding;

public class IntoActivity extends BaseActivity {

    private ActivityIntoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityIntoBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_into);

        binding.iniciarBtn.setOnClickListener( v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}