package com.majesty.pmb_ulbi.ui.daftar;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.majesty.pmb_ulbi.R;

public class DaftarFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    WebView myWebView;
    Spinner spProdi;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_daftar, container, false);

        spProdi = (Spinner) root.findViewById(R.id.spProdi);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.prodi_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProdi.setAdapter(adapter);

        spProdi.setOnItemSelectedListener(this);

        myWebView = (WebView) root.findViewById(R.id.webview);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
        if (parent.getSelectedItem().toString().equals("S1 - Manajemen Transportasi") || (parent.getSelectedItem().toString().equals("S1 - Manajemen Logistik"))){
            myWebView.loadUrl("https://rere.stimlog.ac.id/");
        }else if (parent.getSelectedItem().toString().equals("--SELECT PROGRAM STUDI--")){
            Toast.makeText(getContext(), "Tolong Pilih Program Studi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else {
            myWebView.loadUrl("https://rara.poltekpos.ac.id/");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}