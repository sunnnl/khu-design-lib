package com.sunnni.khudesignlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.sunnni.khudesignlibrary.databinding.ActivityMainBinding;
import com.sunnni.library.KhuButton;
import com.sunnni.library.KhuEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    KhuEditText khuEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        khuEdt = findViewById(R.id.edt_sample);

        initListener();
    }

    private void initListener() {
        binding.btnSample.setOnClickListener(view -> {
            String message = binding.edtSample.getText();
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.error_no_message), Toast.LENGTH_SHORT).show();
            }
        });
    }
}