package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsFragmentSecond extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("News");
        builder.setMessage("Temperature in the morning is 20 degree");
        builder.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment Cycle", "Fragment Created");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Welcome");
        builder.setMessage("Some fresh news in the morning");
        builder.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_fragment_one,container,false);
        WebView webView = (WebView)view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.vijayavani.net/category/%e0%b2%a6%e0%b3%87%e0%b2%b6/");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("lifyCycle","Fragment onStart");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Continue");
        builder.setMessage("You can always visit back");
        builder.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("lifyCycle","Fragment onDestroyView");
        Toast.makeText(getContext(),"Fragment onDestroyView",Toast.LENGTH_LONG).show();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("lifyCycle","Fragment onDestroy");
        Toast.makeText(getContext(),"Fragment onDestroy",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lifyCycle","Fragment onDetach");
        Toast.makeText(getContext(),"Fragment onDetach",Toast.LENGTH_LONG).show();
    }

}
