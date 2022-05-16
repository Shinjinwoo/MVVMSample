package com.example.mvvmsample.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataBidingViewModel extends ViewModel {

    public String LOG_TAG = this.getClass().getSimpleName();
    private MutableLiveData<Integer> data;

    public LiveData<Integer> getMutableData() {
        if (data == null) {
            data = new MutableLiveData<>(0);
        }
        return data;
    }

    public void add(){
        data.setValue(data.getValue()+1);
        Log.d(LOG_TAG,data.toString());
    }

    public void delete() {
        data.setValue(0);
    }

}
