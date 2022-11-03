package com.android.project7_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {



    public static MainFragment newInstance() {
        MainFragment mf = new MainFragment();
        return mf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = rootView.findViewById(R.id.button1);
        EditText edtInput = rootView.findViewById(R.id.edtInput);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = edtInput.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("key", s);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                MenuFragment menuFragment = MenuFragment.newInstance();
                menuFragment.setArguments(bundle);
                ft.replace(R.id.container, menuFragment);
                ft.commit();

//                MainActivity activity = (MainActivity) getActivity();
//                activity.onFragmentChanged(0);
            }
        });


        return rootView;
    }

}