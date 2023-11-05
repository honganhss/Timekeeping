package com.vanh.timekeeping.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.vanh.timekeeping.databinding.ActivityAddStaffBinding;

public class AddStaffActivity extends AppCompatActivity {

    private ActivityAddStaffBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAddStaffBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        setListener();
    }
    private void init(){

    }

    private void setListener(){

    }
}