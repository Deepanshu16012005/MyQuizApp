package com.myquizapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.myquizapp.databinding.ActivityMainBinding;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    private RadioButton checkButtons[]=new RadioButton[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initComponents();

    }

    private void initComponents() {
        checkButtons[0]=binding.option1;
        checkButtons[1]=binding.option2;
        checkButtons[2]=binding.option3;
        checkButtons[3]=binding.option4;
        for(RadioButton button : checkButtons){
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
//        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        RadioButton ClickedButton = (RadioButton) view;
        for(RadioButton button:checkButtons){
            button.setChecked(button.getId() == ClickedButton.getId());
        }
    }
}