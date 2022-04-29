package com.example.mvvmsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvmsample.viewmodel.DataBidingViewModel;

public class MainActivity extends AppCompatActivity {

    private ViewModelStore viewModelStore = new ViewModelStore();
    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;
    private DataBidingViewModel viewModel;

    private BlankFragment[] fragments = {
                BlankFragment.newInstance(1),BlankFragment.newInstance(2),BlankFragment.newInstance(3)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (viewModelFactory == null) {
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }

        viewModel = new ViewModelProvider(MainActivity.this,viewModelFactory).get(DataBidingViewModel.class);
        setViewPager();

        Button btn = (Button)findViewById(R.id.main_button);
        btn.setOnClickListener(view -> {
            viewModel.add();
        });
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return viewModelStore;
    }

    private void setViewPager(){
        ViewPager2 viewPager2 = (ViewPager2)findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());

        viewPagerAdapter.setList(fragments);
        viewPager2.setAdapter(viewPagerAdapter);
    }
}