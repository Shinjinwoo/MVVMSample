package com.example.mvvmsample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewPagerAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> list = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    public void addFragment(Fragment fragment)
    {
        list.add(fragment);
    }

    public void setList(Fragment[] fragments){
        list.clear();
        list.addAll(Arrays.asList(fragments));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}