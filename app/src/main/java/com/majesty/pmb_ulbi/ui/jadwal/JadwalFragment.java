package com.majesty.pmb_ulbi.ui.jadwal;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.majesty.pmb_ulbi.R;

public class JadwalFragment extends Fragment {
    WebView myWebView;
    WebSettings webSettings;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jadwal, container, false);

        myWebView = (WebView) root.findViewById(R.id.webview);
        myWebView.loadUrl("https://pmb.poltekpos.ac.id/jadwal.php");
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