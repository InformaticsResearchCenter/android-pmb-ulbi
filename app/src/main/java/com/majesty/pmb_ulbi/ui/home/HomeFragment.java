package com.majesty.pmb_ulbi.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.majesty.pmb_ulbi.R;

public class HomeFragment extends Fragment {
    WebView myWebView;
    WebSettings webSettings;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        myWebView = (WebView) root.findViewById(R.id.webview);
        myWebView.loadUrl("https://pmb.poltekpos.ac.id/index.php");
        myWebView.setWebViewClient(new WebViewClient());
        webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.canGoBack();
        myWebView.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && myWebView.canGoBack()) {
                    myWebView.goBack();
                    return true;
                }
                return false;
            }
        });

        return root;
    }
}