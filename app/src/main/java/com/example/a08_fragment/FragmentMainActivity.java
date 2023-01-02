package com.example.a08_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a08_fragment.R;

public class FragmentMainActivity extends AppCompatActivity implements com.example.a08_fragment.ToolbarFragment.ToolbarListener {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(int fontSize, String text) {
        com.example.a08_fragment.TextFragment TextFragment = (com.example.a08_fragment.TextFragment)getSupportFragmentManager().findFragmentById(R.id.TextFragment);
        TextFragment.ChangeTextViewProperties(fontSize,text);
    }
}