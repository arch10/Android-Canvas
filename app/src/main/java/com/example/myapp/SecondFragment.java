package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondFragment extends Fragment {


    final static int COLOR_PINK = -2614432;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second, container, false);

        RadioGroup rg = root.findViewById(R.id.radioGroup);
        Button setColor = root.findViewById(R.id.btn_set_color);

        if(getArguments() != null){
            int color = getArguments().getInt("color");
            checkSelectedItem(color, rg);
        }


        Bundle bundle = new Bundle();

        rg.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.red:
                    bundle.putInt("color", Color.RED);
                    break;
                case R.id.blue:
                    bundle.putInt("color", Color.BLUE);
                    break;
                case R.id.green:
                    bundle.putInt("color", Color.GREEN);
                    break;
                case R.id.pink:
                    bundle.putInt("color", COLOR_PINK);
                    break;
            }
        });

        setColor.setOnClickListener(click -> {
            Navigation.findNavController(click).navigate(R.id.action_secondFragment_to_firstFragment, bundle);
        });

        return root;
    }

    private void checkSelectedItem(int color, RadioGroup rg) {
        switch (color) {
            case R.id.red:
                rg.check(R.id.red);
                break;
            case R.id.blue:
                rg.check(R.id.blue);
                break;
            case R.id.green:
                rg.check(R.id.green);
                break;
            case R.id.pink:
                rg.check(R.id.pink);
                break;
        }
    }

}