package com.ariavgroup.bpft.lakiLaki;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ariavgroup.bpft.DataFitnessActivity;
import com.ariavgroup.bpft.R;

public class HasilTestPriaActivity extends AppCompatActivity {
    private int skorReactionTest;
    private int skorRightFootBalance;
    private int skorLeftFootBalance;
    private int skorMedicineBall;
    private int skorFlexibility;
    private int skorShortService;
    private int skorLongService;
    private int skorForehandLob;
    private int skorForehandSmash;
    private int skorForehandDropshoot;
    private int skorCoordination;
    private int skorAgility;
    private int skorSpeed;
    private int skorRast;
    private int skorDurability;
    private String namaLengkap;
    private String usia;
    private String jk;
    private int totalSkor;
    private TextView tvScore;
    private TextView tvKesimpulan;
    private Button btnRepeatTest;
    private TextView tvName;
    private TextView tvAge;
    private TextView tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_test_pria);
        getSupportActionBar().hide();
        initView();
        namaLengkap = getIntent().getStringExtra("NAMA_LENGKAP");
        usia = getIntent().getStringExtra("USIA");
        jk = getIntent().getStringExtra("JK");
        skorReactionTest = getIntent().getIntExtra("SKORREACTIONTEST", 0);
        skorRightFootBalance = getIntent().getIntExtra("SKORRIGHTFOOTBALANCE", 0);
        skorLeftFootBalance = getIntent().getIntExtra("SKORLEFTFOOTBALANCE", 0);
        skorMedicineBall = getIntent().getIntExtra("SKORMEDICINEBALL", 0);
        skorFlexibility = getIntent().getIntExtra("SKORFLEXIBILITY", 0);
        skorShortService = getIntent().getIntExtra("SKORSHORTSERVICE", 0);
        skorLongService = getIntent().getIntExtra("SKORLONGSERVICE", 0);
        skorForehandLob = getIntent().getIntExtra("SKORFOREHANDLOB", 0);
        skorForehandSmash = getIntent().getIntExtra("SKORFOREHANDSMASH", 0);
        skorForehandDropshoot = getIntent().getIntExtra("SKORFOREHANDDROPSHOOT", 0);
        skorCoordination = getIntent().getIntExtra("SKORCOORDINATION", 0);
        skorAgility = getIntent().getIntExtra("SKORAGILITY", 0);
        skorSpeed = getIntent().getIntExtra("SKORSPEED", 0);
        skorRast = getIntent().getIntExtra("SKORRAST", 0);
        skorDurability = getIntent().getIntExtra("SKORDURABILITY", 0);

        tvName.setText(namaLengkap);
        tvAge.setText(usia);
        tvGender.setText(jk);

//        totalSkor = String.valueOf(skorReactionTest) + String.valueOf(skorRightFootBalance);


        totalSkor =
                skorReactionTest +
                        skorRightFootBalance +
                        skorLeftFootBalance +
                        skorMedicineBall +
                        skorFlexibility +
                        skorShortService +
                        skorLongService +
                        skorForehandLob +
                        skorForehandSmash +
                        skorForehandDropshoot +
                        skorCoordination +
                        skorAgility +
                        skorSpeed +
                        skorRast +
                        skorDurability;
        tvScore.setText(String.valueOf(totalSkor));

        if (totalSkor >= 1 && totalSkor <= 15) {
            tvKesimpulan.setText("Very Poor");
        } else if (totalSkor >= 16 && totalSkor <= 30) {
            tvKesimpulan.setText("Poor");
        } else if (totalSkor >= 31 && totalSkor <= 45) {
            tvKesimpulan.setText("Medium");
        } else if (totalSkor >= 46 && totalSkor <= 60) {
            tvKesimpulan.setText("Good");
        } else if (totalSkor >= 61 && totalSkor <= 75) {
            tvKesimpulan.setText("Very Good");
        } else {
            tvKesimpulan.setText("Belum ada Nilai");
        }


        Log.d("jumlahSkor", "onCreate: " + "\n " +
                "skorReactionTest " + skorReactionTest + "\n " +
                "skorRightFootBalance " + skorRightFootBalance + "\n " +
                "skorLeftFootBalance " + skorLeftFootBalance + "\n " +
                "skorMedicineBall " + skorMedicineBall + "\n " +
                "skorFlexibility " + skorFlexibility + "\n " +
                "skorShortService " + skorShortService + "\n " +
                "skorLongService " + skorLongService + "\n " +
                "skorForehandLob " + skorForehandLob + "\n " +
                "skorForehandSmash " + skorForehandSmash + "\n " +
                "skorForehandDropshoot " + skorForehandDropshoot + "\n " +
                "skorCoordination " + skorCoordination + "\n " +
                "skorAgility " + skorAgility + "\n " +
                "skorSpeed " + skorSpeed + "\n " +
                "skorRast " + skorRast + "\n " +
                "skorDurability " + skorDurability + "\n \n \n" +
                "total skor " + totalSkor
        );

        btnRepeatTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), DataFitnessActivity.class));
            }
        });

    }

    private void initView() {
        tvScore = findViewById(R.id.tv_score);
        tvKesimpulan = findViewById(R.id.tv_kesimpulan);
        btnRepeatTest = findViewById(R.id.btn_repeat_test);
        tvName = findViewById(R.id.tv_name);
        tvAge = findViewById(R.id.tv_age);
        tvGender = findViewById(R.id.tv_gender);
    }
}
