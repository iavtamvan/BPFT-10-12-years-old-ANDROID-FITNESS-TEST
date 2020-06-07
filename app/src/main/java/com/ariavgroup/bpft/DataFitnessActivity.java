package com.ariavgroup.bpft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ariavgroup.bpft.lakiLaki.FitenessTestActivity;
import com.ariavgroup.bpft.wanita.FitnessWanitaActivity;

public class DataFitnessActivity extends AppCompatActivity {

    private EditText edtNama;
    private EditText edtJk;
    private EditText edtUsia;
    private Button btnMulaiTest;
    private RadioButton rbLaki;
    private RadioButton rbWanita;
    private RadioGroup rggroup;

    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_fitness);
        getSupportActionBar().hide();
        initView();

        rggroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = rggroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.rb_laki:
                        gender = rbLaki.getText().toString().trim();
                        Toast.makeText(DataFitnessActivity.this, "" + gender, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_wanita:
                        gender = rbWanita.getText().toString().trim();
                        Toast.makeText(DataFitnessActivity.this, "" + gender, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnMulaiTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() || edtUsia.getText().toString().isEmpty() || gender.isEmpty()) {
                    Toast.makeText(DataFitnessActivity.this, "Completed yor data", Toast.LENGTH_SHORT).show();
                } else {
                    if (gender.equalsIgnoreCase("Man")) {
                        Intent intent = new Intent(getApplicationContext(), FitenessTestActivity.class);
                        intent.putExtra("NAMA_LENGKAP", edtNama.getText().toString().trim());
                        intent.putExtra("USIA", edtUsia.getText().toString().trim());
                        intent.putExtra("JK", gender.trim());
                        startActivity(intent);
                    } else if (gender.equalsIgnoreCase("Women")){
                        Intent intent = new Intent(getApplicationContext(), FitnessWanitaActivity.class);
                        intent.putExtra("NAMA_LENGKAP", edtNama.getText().toString().trim());
                        intent.putExtra("USIA", edtUsia.getText().toString().trim());
                        intent.putExtra("JK", gender.trim());
                        startActivity(intent);
                    } else {
                        Toast.makeText(DataFitnessActivity.this, "Data null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initView() {
        edtNama = findViewById(R.id.edt_nama);
        edtJk = findViewById(R.id.edt_jk);
        edtUsia = findViewById(R.id.edt_usia);
        btnMulaiTest = findViewById(R.id.btn_mulai_test);
        rbLaki = findViewById(R.id.rb_laki);
        rbWanita = findViewById(R.id.rb_wanita);
        rggroup = findViewById(R.id.rggroup);
    }
}
