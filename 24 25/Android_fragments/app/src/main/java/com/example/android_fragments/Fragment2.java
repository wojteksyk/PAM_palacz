package com.example.android_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_layout, container, false);


        String email = getArguments() != null ? getArguments().getString("email") : "";
        String firstName = getArguments() != null ? getArguments().getString("firstName") : "";
        String lastName = getArguments() != null ? getArguments().getString("lastName") : "";


        TextView emailTextView = view.findViewById(R.id.emailTextView);
        TextView firstNameTextView = view.findViewById(R.id.firstNameTextView);
        TextView lastNameTextView = view.findViewById(R.id.lastNameTextView);

        emailTextView.setText(email);
        firstNameTextView.setText(firstName);
        lastNameTextView.setText(lastName);

        return view;
    }
}
