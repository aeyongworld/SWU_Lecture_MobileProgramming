package com.android.project7_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class MenuFragment extends Fragment {

    public static MenuFragment newInstance() {
        MenuFragment mf = new MenuFragment();
        return mf;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        Button button = rootView.findViewById(R.id.button2);
        TextView tvOutput = rootView.findViewById(R.id.tvOutput);

        if(getArguments() != null) {
            String s = getArguments().getString("key");
            tvOutput.setText(s);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                MainFragment mainFragment = new MainFragment();
                ft.replace(R.id.container, mainFragment);
                ft.commit();


//                MainActivity activity = (MainActivity) getActivity();
//                activity.onFragmentChanged(1);
            }
        });


        return rootView;
    }
}