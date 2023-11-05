package com.vanh.timekeeping.activities;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vanh.timekeeping.R;
import com.vanh.timekeeping.databinding.ActivityDetailStaffBinding;
import com.vanh.timekeeping.databinding.ActivityLoginBinding;
import com.vanh.timekeeping.fragments.MenuHomeFragment;

public class DetailStaffActivity extends AppCompatActivity {

    private ActivityDetailStaffBinding binding;
    private String ten, MaNV, ngaySinh;
    private int gt;
    private double luongCB;
    private TextView title, label_gender, result_gender,
            label_id, result_id, label_fulname, result_fulname, label_date, result_date,
            label_salary, result_salary;
    RelativeLayout relativeLayout;
    private ImageView imgAvt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailStaffBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_detail_staff);
        getIntentNV();
        AnhXa();
        setUpNV();
        changeActionBar();
    }
    public void changeActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Thông tin nhân viên");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nv, menu);
        return true;
    }



    private void AnhXa() {
        relativeLayout = findViewById(R.id.inf_Gender);
        title = findViewById(R.id.titleAddStaff);
        label_gender = findViewById(R.id.lable_Gender);
        result_gender = findViewById(R.id.result_Gender);
        label_id = findViewById(R.id.staffId);
        result_id = findViewById(R.id.result_ID);
        label_fulname = findViewById(R.id.lable_Name);
        result_fulname = findViewById(R.id.result_Name);
        label_date = findViewById(R.id.result_DateOfBirth);
        result_date = findViewById(R.id.result_DateOfBirth);
        label_salary = findViewById(R.id.lable_Salary);
        result_salary = findViewById(R.id.result_BasicSalary);
    }

    private void getIntentNV() {
        ten = getIntent().getStringExtra("Name");
        Log.d("nameget", "getIntentNV: " + ten);
        MaNV = getIntent().getStringExtra("MaNV");
        ngaySinh = getIntent().getStringExtra("NgaySinh");
        gt = getIntent().getIntExtra("GT", 0);
        luongCB = getIntent().getDoubleExtra("LuongCB", 0.0);
    }

    private void setUpNV() {
        if(gt==0){
            result_gender.setText("Nu");
        }
        else{
            result_gender.setText("Nam");
        }
        result_fulname.setText(ten);
        Log.d("nameset", "getIntentNV: " + ten);
        result_id.setText(MaNV);
        result_date.setText(ngaySinh);
        result_salary.setText(String.valueOf(luongCB));
        Log.d("dfd", "setUpNV: "+ luongCB);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Xoa:
                Toast.makeText(this, "Xoa", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Sua:
                Intent intent = new Intent(this, capnhatNV.class);
                intent.putExtra("Name", ten);
                intent.putExtra("MaNV", MaNV);
                intent.putExtra("NgaySinh", ngaySinh);
                intent.putExtra("GT", gt);
                intent.putExtra("LuongCB", luongCB);
                startActivity(intent);
                return true;
            case R.id.CTCC:
                Toast.makeText(this, "CTCC", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.back:
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.putExtra("Name", ten);
                intent1.putExtra("MaNV", MaNV);
                intent1.putExtra("NgaySinh", ngaySinh);
                intent1.putExtra("GT", gt);
                intent1.putExtra("LuongCB", luongCB);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}