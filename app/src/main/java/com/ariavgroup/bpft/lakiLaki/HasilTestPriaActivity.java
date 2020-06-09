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

    private String statusReactionTest;
    private String statusRightFootBalance;
    private String statusLeftFootBalance;
    private String statusMedicineBall;
    private String statusFlexibility;
    private String statusShortService;
    private String statusLongService;
    private String statusForehandLob;
    private String statusForehandSmash;
    private String statusForehandDropshoot;
    private String statusCoordination;
    private String statusAgility;
    private String statusSpeed;
    private String statusRast;
    private String statusDurability;


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
    private TextView tvHasilScoreReaction;
    private TextView tvHasilConclusionReaction;
    private TextView tvHasilScoreRightFootBalance;
    private TextView tvHasilConclusionRightFootBalance;
    private TextView tvHasilScoreLeftFootBalance;
    private TextView tvHasilConclusionLeftFootBalance;
    private TextView tvHasilScoreMedicineBall;
    private TextView tvHasilConclusionMedicineBall;
    private TextView tvHasilScoreFlexibilityTest;
    private TextView tvHasilConclusionFlexibilityTest;
    private TextView tvHasilScoreShortService;
    private TextView tvHasilConclusionShortService;
    private TextView tvHasilScoreLongService;
    private TextView tvHasilConclusionLongService;
    private TextView tvHasilScoreForehandLob;
    private TextView tvHasilConclusionForehandLob;
    private TextView tvHasilScoreForehandSmash;
    private TextView tvHasilConclusionForehandSmash;
    private TextView tvHasilScoreForehandDropshoot;
    private TextView tvHasilConclusionForehandDropshoot;
    private TextView tvHasilScoreCoordination;
    private TextView tvHasilConclusionCoordination;
    private TextView tvHasilScoreAgility;
    private TextView tvHasilConclusionAgility;
    private TextView tvHasilScoreSpeed;
    private TextView tvHasilConclusionSpeed;
    private TextView tvHasilScoreRast;
    private TextView tvHasilConclusionRast;
    private TextView tvHasilScoreEndurance;
    private TextView tvHasilConclusionEndurance;

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


        statusReactionTest = getIntent().getStringExtra("REACTIONTEST");
        statusRightFootBalance = getIntent().getStringExtra("RIGHTFOOTBALANCE");
        statusLeftFootBalance = getIntent().getStringExtra("LEFTFOOTBALANCE");
        statusMedicineBall = getIntent().getStringExtra("MEDICINEBALL");
        statusFlexibility = getIntent().getStringExtra("FLEXIBILITY");
        statusShortService = getIntent().getStringExtra("SHORTSERVICE");
        statusLongService = getIntent().getStringExtra("LONGSERVICE");
        statusForehandLob = getIntent().getStringExtra("FOREHANDLOB");
        statusForehandSmash = getIntent().getStringExtra("FOREHANDSMASH");
        statusForehandDropshoot = getIntent().getStringExtra("FOREHANDDROPSHOOT");
        statusCoordination = getIntent().getStringExtra("COORDINATION");
        statusAgility = getIntent().getStringExtra("AGILITY");
        statusSpeed = getIntent().getStringExtra("SPEED");
        statusRast = getIntent().getStringExtra("RAST");
        statusDurability = getIntent().getStringExtra("DURABILITY");

        tvName.setText(namaLengkap);
        tvAge.setText(usia);
        tvGender.setText(jk);

        tvHasilScoreReaction.setText(String.valueOf(skorReactionTest));
        tvHasilScoreRightFootBalance.setText(String.valueOf(skorRightFootBalance));
        tvHasilScoreLeftFootBalance.setText(String.valueOf(skorLeftFootBalance));
        tvHasilScoreMedicineBall.setText(String.valueOf(skorMedicineBall));
        tvHasilScoreFlexibilityTest.setText(String.valueOf(skorFlexibility));
        tvHasilScoreShortService.setText(String.valueOf(skorShortService));
        tvHasilScoreLongService.setText(String.valueOf(skorLongService));
        tvHasilScoreForehandLob.setText(String.valueOf(skorForehandLob));
        tvHasilScoreForehandSmash.setText(String.valueOf(skorForehandSmash));
        tvHasilScoreForehandDropshoot.setText(String.valueOf(skorForehandDropshoot));
        tvHasilScoreCoordination.setText(String.valueOf(skorCoordination));
        tvHasilScoreAgility.setText(String.valueOf(skorAgility));
        tvHasilScoreSpeed.setText(String.valueOf(skorSpeed));
        tvHasilScoreRast.setText(String.valueOf(skorRast));
        tvHasilScoreEndurance.setText(String.valueOf(skorDurability));

        tvHasilConclusionReaction.setText(statusReactionTest);
        tvHasilConclusionRightFootBalance.setText(statusRightFootBalance);
        tvHasilConclusionLeftFootBalance.setText(statusLeftFootBalance);
        tvHasilConclusionMedicineBall.setText(statusMedicineBall);
        tvHasilConclusionFlexibilityTest.setText(statusFlexibility);
        tvHasilConclusionShortService.setText(statusShortService);
        tvHasilConclusionLongService.setText(statusLongService);
        tvHasilConclusionForehandLob.setText(statusForehandLob);
        tvHasilConclusionForehandSmash.setText(statusForehandSmash);
        tvHasilConclusionForehandDropshoot.setText(statusForehandDropshoot);
        tvHasilConclusionCoordination.setText(statusCoordination);
        tvHasilConclusionAgility.setText(statusAgility);
        tvHasilConclusionSpeed.setText(statusSpeed);
        tvHasilConclusionRast.setText(statusRast);
        tvHasilConclusionEndurance.setText(statusDurability);

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
        tvHasilScoreReaction = findViewById(R.id.tv_hasil_score_reaction);
        tvHasilConclusionReaction = findViewById(R.id.tv_hasil_conclusion_reaction);
        tvHasilScoreRightFootBalance = findViewById(R.id.tv_hasil_score_right_foot_balance);
        tvHasilConclusionRightFootBalance = findViewById(R.id.tv_hasil_conclusion_right_foot_balance);
        tvHasilScoreLeftFootBalance = findViewById(R.id.tv_hasil_score_left_foot_balance);
        tvHasilConclusionLeftFootBalance = findViewById(R.id.tv_hasil_conclusion_left_foot_balance);
        tvHasilScoreMedicineBall = findViewById(R.id.tv_hasil_score_medicine_ball);
        tvHasilConclusionMedicineBall = findViewById(R.id.tv_hasil_conclusion_medicine_ball);
        tvHasilScoreFlexibilityTest = findViewById(R.id.tv_hasil_score_flexibility_test);
        tvHasilConclusionFlexibilityTest = findViewById(R.id.tv_hasil_conclusion_flexibility_test);
        tvHasilScoreShortService = findViewById(R.id.tv_hasil_score_short_service);
        tvHasilConclusionShortService = findViewById(R.id.tv_hasil_conclusion_short_service);
        tvHasilScoreLongService = findViewById(R.id.tv_hasil_score_long_service);
        tvHasilConclusionLongService = findViewById(R.id.tv_hasil_conclusion_long_service);
        tvHasilScoreForehandLob = findViewById(R.id.tv_hasil_score_forehand_lob);
        tvHasilConclusionForehandLob = findViewById(R.id.tv_hasil_conclusion_forehand_lob);
        tvHasilScoreForehandSmash = findViewById(R.id.tv_hasil_score_forehand_smash);
        tvHasilConclusionForehandSmash = findViewById(R.id.tv_hasil_conclusion_forehand_smash);
        tvHasilScoreForehandDropshoot = findViewById(R.id.tv_hasil_score_forehand_dropshoot);
        tvHasilConclusionForehandDropshoot = findViewById(R.id.tv_hasil_conclusion_forehand_dropshoot);
        tvHasilScoreCoordination = findViewById(R.id.tv_hasil_score_coordination);
        tvHasilConclusionCoordination = findViewById(R.id.tv_hasil_conclusion_coordination);
        tvHasilScoreAgility = findViewById(R.id.tv_hasil_score_agility);
        tvHasilConclusionAgility = findViewById(R.id.tv_hasil_conclusion_agility);
        tvHasilScoreSpeed = findViewById(R.id.tv_hasil_score_speed);
        tvHasilConclusionSpeed = findViewById(R.id.tv_hasil_conclusion_speed);
        tvHasilScoreRast = findViewById(R.id.tv_hasil_score_rast);
        tvHasilConclusionRast = findViewById(R.id.tv_hasil_conclusion_rast);
        tvHasilScoreEndurance = findViewById(R.id.tv_hasil_score_endurance);
        tvHasilConclusionEndurance = findViewById(R.id.tv_hasil_conclusion_endurance);
    }
}
