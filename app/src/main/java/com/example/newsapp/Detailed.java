package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detailed extends AppCompatActivity {

    TextView tvTitle,tvSource,tvTime,tvDesc;
    ImageView imageView;
    WebView webView;
    ProgressBar loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        tvTitle=findViewById(R.id.tvtitle);
        tvSource=findViewById(R.id.tvSource);
        tvTime=findViewById(R.id.tvDate);
        tvDesc=findViewById(R.id.tvDesc);
        imageView=findViewById(R.id.image_photo);
        webView=findViewById(R.id.webView);

        loader=findViewById(R.id.webViewloader);
        loader.setVisibility(View.VISIBLE);
        Intent i=getIntent();
        String title=i.getStringExtra("title");
        String source=i.getStringExtra("source");
        String time=i.getStringExtra("time");
        String desc=i.getStringExtra("desc");
        String imageUri=i.getStringExtra("imageUri");
        String uri=i.getStringExtra("Url");

        tvTitle.setText(title);
        tvSource.setText(source);
        tvTime.setText(time);
        tvDesc.setText(desc);

        Picasso.with(Detailed.this).load(imageUri).into(imageView);

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(uri);

        if(webView.isShown())
        {
            loader.setVisibility(View.INVISIBLE);
        }

    }
}
