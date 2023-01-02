package com.example.a08_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a08_fragment.R;

public class TextFragment extends Fragment {

    private TextView DemoTextView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.text_fragment,container,false);

        DemoTextView = (TextView)view.findViewById(R.id.DemoTextView);

        return view;
    }

    public void ChangeTextViewProperties(int fontsize,String text){
        DemoTextView.setTextSize(fontsize);
        DemoTextView.setText(text);
    }
}
