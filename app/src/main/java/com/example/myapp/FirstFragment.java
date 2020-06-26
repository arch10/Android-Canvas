package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.example.myapp.SecondFragment.COLOR_PINK;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        //setting default color
        int color = Color.RED;

        if(getArguments() != null){
            color = getArguments().getInt("color");
            Toast.makeText(getContext(), "Color: " + getColor(color), Toast.LENGTH_LONG).show();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);

        DrawingView dv = root.findViewById(R.id.drawingView);
        dv.setDrawColor(color);
        Button changeColor = root.findViewById(R.id.button);

        changeColor.setOnClickListener(click -> {
            Navigation.findNavController(click).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
        });
        return root;
    }

    private String getColor(int colorInt) {
        switch (colorInt){
            case Color.RED:
                return "Red";
            case Color.BLUE:
                return "Blue";
            case Color.GREEN:
                return "Green";
            case COLOR_PINK:
                return "Pink";
            default:
                return "RED";
        }
    }
}