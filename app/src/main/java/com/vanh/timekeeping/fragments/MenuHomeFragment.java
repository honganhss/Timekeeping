package com.vanh.timekeeping.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.vanh.timekeeping.activities.AddStaffActivity;
import com.vanh.timekeeping.activities.DetailStaffActivity;
import com.vanh.timekeeping.adapters.StaffAdapter;
import com.vanh.timekeeping.databinding.FragmentHomepageBinding;
import com.vanh.timekeeping.entity.Staff;

import java.util.ArrayList;
import java.util.List;

public class MenuHomeFragment extends Fragment implements RVinterface{
    private FragmentHomepageBinding binding;
    private List<Staff> staffList = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomepageBinding.inflate(inflater, container, false);
        init();
        return binding.getRoot();
    }
    private void init() {
          //
        staffList.add( new Staff("MV1", "NV1", "1231", 0,"10 10 2003", 110, 1));
        staffList.add( new Staff("MV5", "NV2", "1231", 0, "20 10 2003", 11000000, 1));
        staffList.add( new Staff("MV4", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV3", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1,"10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        staffList.add( new Staff("MV2", "Vanh chos", "1231", 1, "10 10 2003", 11000000, 1));
        StaffAdapter staffAdapter = new StaffAdapter(staffList, this);
        binding.rcvStaffList.setAdapter(staffAdapter);
        staffAdapter.notifyDataSetChanged();
    }

    @Override
    public void onIteamClick(int position) {
        Intent intent = new Intent(getContext(), DetailStaffActivity.class);
        intent.putExtra("Name", staffList.get(position).getNameStaff());
        intent.putExtra("MaNV", staffList.get(position).getIdStaff());
        intent.putExtra("NgaySinh", staffList.get(position).getDateOfBird());
        intent.putExtra("GT", staffList.get(position).getGender());
        intent.putExtra("LuongCB", staffList.get(position).getBasicSalary());
        Log.d("fdff", "onIteamClick: "+ staffList.get(position).getBasicSalary() );

        startActivity(intent);
    }
}
