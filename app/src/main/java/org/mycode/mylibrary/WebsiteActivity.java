package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteActivity extends AppCompatActivity {

    private WebView webView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        Intent intent = getIntent();
        if (null != intent){
            webView = findViewById(R.id.webView);
            webView.loadUrl("https://vvduth.github.io/portfolio.official/");
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);

        }


    }

    @Override
    public void onBackPressed() { // if we dont over ride, when the press back button it will go back to the main session of app. that is not good
        if (webView.canGoBack()){
            webView.goBack();
        } else {
        super.onBackPressed();
        }
    }
}

