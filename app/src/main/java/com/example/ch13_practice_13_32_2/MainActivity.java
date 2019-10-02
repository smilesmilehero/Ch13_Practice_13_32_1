package com.example.ch13_practice_13_32_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    EditText et;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.editText);
        WebView wv=findViewById(R.id.wv);
        pb=findViewById(R.id.pb);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());

        wv.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view,int progress){
                pb.setProgress(progress);
                pb.setVisibility(progress<100? View.VISIBLE:View.GONE);
            }
        });

        wv.loadUrl(String.valueOf(et.getText()));
    }
}
