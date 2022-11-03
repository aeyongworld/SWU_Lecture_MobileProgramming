package com.android.project7_3_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        android.util.Log.i("fragment2 test", "onCreateView()");

        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        android.util.Log.i("fragment2 test", "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.util.Log.i("fragment2 test", "onCreate()");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        android.util.Log.i("fragment2 test", "onViewCreated()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        android.util.Log.i("fragment2 test", "onViewStateRestored()");
    }

    @Override
    public void onStart() {
        super.onStart();
        android.util.Log.i("fragment2 test", "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.i("fragment2 test", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.i("fragment2 test", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        android.util.Log.i("fragment2 test", "onStop()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        android.util.Log.i("fragment2 test", "onSaveInstanceState()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        android.util.Log.i("fragment2 test", "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        android.util.Log.i("fragment2 test", "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        android.util.Log.i("fragment2 test", "onDetach()");
    }

}