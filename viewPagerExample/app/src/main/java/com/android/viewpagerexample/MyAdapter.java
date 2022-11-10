package com.android.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentStateAdapter {

    List<Fragment> fragments;

    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        fragments = new ArrayList<>();
        fragments.add(new RedFragment());
        fragments.add(new GreenFragment());
        fragments.add(new BlueFragment());

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
