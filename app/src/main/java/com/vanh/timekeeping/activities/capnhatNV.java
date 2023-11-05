package com.vanh.timekeeping.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.vanh.timekeeping.R;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

public class capnhatNV extends AppCompatActivity {
    TextView labelGender, labelID, labelFullName, labelDate, labelSalary,
            tv, tv1, tv2, tv3, tv4;
    Button btnChonAnh, btnCapNhat, btnHuy;
    RadioGroup radioGroup;
    RadioButton rbtnNam, rbtnNu;
    EditText id, fullname, dateOfBirth, salary;
    String ten, MaNV, ngaySinh;
    int gt;
    double luongCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhat_nv);
        anhXa();
        changeActionBar();
        getIntentNV();
        setIntentNV();
        radioGender();
        btnCapNhat();
        btnHuy();
        editNgaySinh();
    }
    public void changeActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Cập nhật thông tin nhân viên");
        }
    }
    public void anhXa(){
        labelGender = findViewById(R.id.lable_Gender);
        labelID = findViewById(R.id.lable_ID);
        labelFullName = findViewById(R.id.lable_Name);
        labelDate = findViewById(R.id.lable_date);
        labelSalary = findViewById(R.id.lable_luongcb);

        tv = findViewById(R.id.textView);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);

        id = findViewById(R.id.edtviewID);
        fullname = findViewById(R.id.edtviewFullName);
        dateOfBirth = findViewById(R.id.edtviewDate);
        salary = findViewById(R.id.edtviewLuong);

        btnChonAnh = findViewById(R.id.button);
        btnCapNhat = findViewById(R.id.btncapnhat);
        btnHuy = findViewById(R.id.btnHuy);

        radioGroup = findViewById(R.id.radioGroup);
        rbtnNam = findViewById(R.id.rbtnNam);
        rbtnNu = findViewById(R.id.rtbnNu);
    }
    public void getIntentNV(){
        ten = getIntent().getStringExtra("Name");
        MaNV = getIntent().getStringExtra("MaNV");
        ngaySinh = getIntent().getStringExtra("NgaySinh");
        gt = getIntent().getIntExtra("GT", 0);
        luongCB = getIntent().getDoubleExtra("LuongCB", 0.0);
    }
    public void editNgaySinh(){
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });
    }
    public void setIntentNV(){
        fullname.setText(ten);
        id.setText(MaNV);
        dateOfBirth.setText(ngaySinh);
        salary.setText(String.valueOf(luongCB));
        if(gt==0){
            radioGroup.check(rbtnNu.getId());
        }
        else{
            radioGroup.check(rbtnNam.getId());
        }
    }
    public void radioGender(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbtnNam:
                        gt=1;
                        break;
                    case R.id.rtbnNu:
                        gt=0;
                        break;
                }
            }
        });
//        Toast.makeText(capnhatNV.this, "gt=" + gt, Toast.LENGTH_SHORT).show();
    }
    public  void btnCapNhat(){
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ten = fullname.getText().toString();
                MaNV = id.getText().toString();
                ngaySinh = dateOfBirth.getText().toString();
                try {
                    luongCB = Double.parseDouble(salary.getText().toString());
                }catch (Exception e){
                    Toast.makeText(capnhatNV.this, "Luong khong hop le", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(capnhatNV.this, DetailStaffActivity.class);
                intent.putExtra("Name", ten);
                intent.putExtra("MaNV", MaNV);
                intent.putExtra("NgaySinh", ngaySinh);
                intent.putExtra("GT", gt);
                Log.d("gtIntent", "onClick: " + gt);
                intent.putExtra("LuongCB", luongCB);
                startActivity(intent);
            }
        });
    }
    public void btnHuy(){
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(capnhatNV.this, DetailStaffActivity.class);
                intent.putExtra("Name", ten);
                intent.putExtra("MaNV", MaNV);
                intent.putExtra("NgaySinh", ngaySinh);
                intent.putExtra("GT", gt);
                Log.d("gtIntent", "onClick: " + gt);
                intent.putExtra("LuongCB", luongCB);
                startActivity(intent);
            }
        });
    }
    public void ChonNgay(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateOfBirth.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },calendar.get(Calendar.YEAR) ,
                calendar.get(Calendar.MONTH) +1,
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}