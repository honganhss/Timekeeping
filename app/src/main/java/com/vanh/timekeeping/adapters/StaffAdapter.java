package com.vanh.timekeeping.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vanh.timekeeping.databinding.ItemStaffBinding;
import com.vanh.timekeeping.entity.Staff;
import com.vanh.timekeeping.fragments.RVinterface;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewholder> {

    public List<Staff> staffs;
    private final RVinterface rVinterface;

    public StaffAdapter(List<Staff> staffs, RVinterface rVinterface) {
        this.staffs = staffs;
        this.rVinterface = rVinterface;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public StaffViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStaffBinding itemStaffBinding = ItemStaffBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new StaffViewholder(itemStaffBinding, rVinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewholder holder, int position) {
        holder.setStaffdata(staffs.get(position));
    }

    @Override
    public int getItemCount() {
        return staffs.size();
    }

    class StaffViewholder extends RecyclerView.ViewHolder {

        ItemStaffBinding binding;

        StaffViewholder(ItemStaffBinding itemStaffBinding, RVinterface rVinterface) {
            super(itemStaffBinding.getRoot());
            binding = itemStaffBinding;

        }

        void setStaffdata(Staff staff) {
            binding.staffName.setText(staff.getNameStaff());
            binding.staffId.setText(staff.getIdStaff());
            binding.itemStaff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rVinterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            rVinterface.onIteamClick(pos);
                        }
                    }
                }
            });
        }
    }

}
