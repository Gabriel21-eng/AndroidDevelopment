package com.example.esam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.esam.databinding.ActivityHomeBinding;
import com.example.esam.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        progressDialog=new ProgressDialog(this);
        binding.vleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                startActivity(new Intent(HomeActivity.this,WebActivity.class));
                progressDialog.cancel();

            }
        });
        binding.spImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                startActivity(new Intent(HomeActivity.this,SPActivity.class));
                progressDialog.cancel();
            }
        });
        binding.SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                startActivity(new Intent(HomeActivity.this,loginActivity.class));
                progressDialog.cancel();
            }
        });
    }
}