package com.example.mvvmsample;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmsample.databinding.FragmentBlankBinding;
import com.example.mvvmsample.viewmodel.DataBidingViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    private View view;
    private String fragment_number = "Fragment";
    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;


    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(int fragment_number) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString("fragment_number", fragment_number + "");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            fragment_number = fragment_number+ getArguments().getString("fragment_number");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentBlankBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false);

        view = binding.getRoot();
        DataBidingViewModel viewModel;

        if ( viewModelFactory == null)
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication());

        viewModel = new ViewModelProvider(getActivity(),viewModelFactory).get(DataBidingViewModel.class);

        binding.setFragmentNumber(fragment_number);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        return view;
    }

}