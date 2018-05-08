package com.example.anhtuan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anhtuan.myapplication.model.CongViec;

public class ThemCongViec extends AppCompatActivity {

    EditText edtTenCV;
    EditText edtNgayBD;
    EditText edtThangBD;
    EditText edtNamBD;
    EditText edtNgayKT;
    EditText edtThangKT;
    EditText edtNamKT;
    TextView tvTitle;
    ImageView ivBack;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_cong_viec);

        edtTenCV = (EditText) findViewById(R.id.edtTenCV);
        edtNgayBD = (EditText) findViewById(R.id.edtNgayBD);
        edtThangBD = (EditText) findViewById(R.id.edtThangBD);
        edtNamBD = (EditText) findViewById(R.id.edtNamBD);
        edtNgayKT = (EditText) findViewById(R.id.edtNgayKT);
        edtThangKT = (EditText) findViewById(R.id.edtThangKT);
        edtNamKT = (EditText) findViewById(R.id.edtNamKT);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        btnSave = (Button) findViewById(R.id.btnSave);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvTitle.setText("THÊM CÔNG VIỆC");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTenCV.getText().toString().isEmpty() || edtNgayBD.getText().toString().isEmpty() || edtThangBD.getText().toString().isEmpty() ||
                        edtNamBD.getText().toString().isEmpty() || edtNgayKT.getText().toString().isEmpty() ||
                        edtThangKT.getText().toString().isEmpty() || edtNamKT.getText().toString().isEmpty()) {
                    Toast.makeText(ThemCongViec.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    String tencv = edtTenCV.getText().toString();
                    int ngaybd = Integer.parseInt(edtNgayBD.getText().toString());
                    int thangbd = Integer.parseInt(edtThangBD.getText().toString());
                    int nambd = Integer.parseInt(edtNamBD.getText().toString());
                    int ngaykt = Integer.parseInt(edtNgayKT.getText().toString());
                    int thangkt = Integer.parseInt(edtThangKT.getText().toString());
                    int namkt = Integer.parseInt(edtNamKT.getText().toString());

                    CongViec cv = new CongViec(tencv, ngaybd, thangbd, nambd, ngaykt, thangkt, namkt);
                    Intent intent = new Intent(ThemCongViec.this, MainActivity.class);
                    intent.putExtra("CV", cv);
                    startActivity(intent);
                }
            }
        });
    }
}
