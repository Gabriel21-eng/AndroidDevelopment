package com.example.esam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.esam.databinding.ActivityLoginBinding;
import com.example.esam.databinding.ActivitySpactivityBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class SPActivity extends AppCompatActivity {
    ActivitySpactivityBinding binding;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;
    DatabaseReference reference;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpactivityBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.spWebview.setWebViewClient(new WebViewClient());
        binding.spWebview.loadUrl("https://portal.umat.edu.gh/students");
        WebSettings webSettings = binding.spWebview.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }
    private class myclient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
    @Override
    public void onBackPressed() {
        if(binding.spWebview.isFocused() && binding.spWebview.canGoBack())
        {
            binding.spWebview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}