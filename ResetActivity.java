package com.example.esam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.esam.databinding.ActivityResetBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class ResetActivity extends AppCompatActivity {
    ActivityResetBinding binding;
    FirebaseDatabase database;
    FirebaseFirestore firestore;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressBar = new ProgressBar(this);

        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.Email.getEditText().getText().toString().trim();
                if(email.isEmpty()){
                    binding.Email.setError("Email is required");
                    binding.Email.requestFocus();
                    return;

                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    binding.Email.setError("Please Enter a valid email");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(ResetActivity.this, "reset code sent to email account", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(ResetActivity.this, "Unsuccessful, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}