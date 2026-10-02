package uk.co.improvemedia.certlogic;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.parseColor("#03060F"));
        getWindow().setNavigationBarColor(Color.parseColor("#03060F"));

        webView = new WebView(this);
        webView.setBackgroundColor(Color.parseColor("#03060F"));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        setContentView(webView);

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        } else {
            webView.loadUrl("file:///android_asset/index.html");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    public void onBackPressed() {
        // The page handles its own screen stack; it returns "true" if it went back.
        webView.evaluateJavascript("window.appBack && window.appBack()", result -> {
            if (!"true".equals(result)) {
                finish();
            }
        });
    }
}
