package com.example.a08_fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a08_fragment.R;

public class ToolbarFragment extends Fragment {

    private EditText InputEditText;
    private SeekBar FontSizeSeekBar;
    private Button ChangeButton;
    private int fontsize = 12;
    ToolbarListener toolbarListenerRef;

    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            toolbarListenerRef = (ToolbarListener)context;
        }catch (ClassCastException e){}
    }

    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.toolbar_fragment,container,false);

        InputEditText = (EditText)view.findViewById(R.id.InputEditText);
        FontSizeSeekBar = (SeekBar)view.findViewById(R.id.FontSizeSeekBar);
        ChangeButton = (Button)view.findViewById(R.id.ChangeButton);

        SeekBarHandler seekBarHandler = new SeekBarHandler();
        FontSizeSeekBar.setOnSeekBarChangeListener(seekBarHandler);

        ButtonHandler ButtonHandler = new ButtonHandler();
        ChangeButton.setOnClickListener(ButtonHandler);

        return view;
    }

    public interface ToolbarListener{
        public void onButtonClick(int fontSize,String text);
    }

    private class SeekBarHandler implements SeekBar.OnSeekBarChangeListener{
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            fontsize = progress;
        }
        public void onStartTrackingTouch(SeekBar seekBar) { }
        public void onStopTrackingTouch(SeekBar seekBar) { }
    }

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View view) {
            toolbarListenerRef.onButtonClick(fontsize,InputEditText.getText().toString());
        }
    }
}
