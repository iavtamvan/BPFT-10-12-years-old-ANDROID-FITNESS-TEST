package com.ariavgroup.bpft.wanita;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ariavgroup.bpft.DataFitnessActivity;
import com.ariavgroup.bpft.R;
import com.ariavgroup.bpft.lakiLaki.HasilTestPriaActivity;

public class FitnessWanitaActivity extends AppCompatActivity {
    private String namaLengkap;
    private String usia;
    private String jk;
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

    long millisecondTime, startTime, timeBuff, updateTime = 0L;
    int seconds, minutes, milliseconds;
    Handler handler;

    private TextView tvTime;
    private TextView tvWatchReactionTest;
    private EditText edtReactionTest;
    private TextView tvResultReactionTest;
    private Button btnMulaiTestReaction;
    private Button btnStopTestReaction;
    private TextView tvWatchBalanceFootRight;
    private EditText edtRightFootBalnce;
    private TextView tvResultRightFootBalance;
    private Button btnMulaiRightFootBalance;
    private Button btnStopRightFootBalance;
    private TextView tvWatchBalanceFootLeft;
    private EditText edtLeftFootBalnce;
    private TextView tvResultLeftFootBalance;
    private Button btnMulaiLeftFootBalance;
    private Button btnStopLeftFootBalance;
    private EditText edtMedicineBall;
    private TextView tvResultMedicineBall;
    private EditText edtFlexibility;
    private TextView tvResultFlexibility;
    private EditText edtShortService;
    private TextView tvResultShortService;
    private EditText edtLongService;
    private TextView tvResultLongService;
    private EditText edtForehandLob;
    private TextView tvResultForehandLob;
    private EditText edtForehandSmash;
    private TextView tvResultForehandSmash;
    private EditText edtForehandDropshoot;
    private TextView tvResultForehandDropshoot;
    private EditText edtCoordination;
    private TextView tvResultCoordination;
    private EditText edtAgility;
    private TextView tvResultAgility;
    private TextView tvWatchSpeed;
    private EditText edtSpeed;
    private TextView tvResultSpeed;
    private Button btnMulaiSpeed;
    private Button btnStopSpeed;
    private EditText edtRast;
    private TextView tvResultRast;
    private EditText edtDurability;
    private TextView tvResultDurability;
    private Button btnLihatSkor;
    private TextView tvName;
    private TextView tvAge;
    private TextView tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_wanita);
        initView();
        handler = new Handler();

        namaLengkap = getIntent().getStringExtra("NAMA_LENGKAP");
        usia = getIntent().getStringExtra("USIA");
        jk = getIntent().getStringExtra("JK");

        tvName.setText(namaLengkap);
        tvAge.setText(usia);
        tvGender.setText(jk);
        Log.d("data", "onCreate: " + namaLengkap + " > " + usia + " > " + jk);

        btnLihatSkor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtDurability.getText().toString().isEmpty()) {
                    Toast.makeText(FitnessWanitaActivity.this, "Complete the test first", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), HasilTestPriaActivity.class);
                    intent.putExtra("SKORREACTIONTEST", skorReactionTest);
                    intent.putExtra("SKORRIGHTFOOTBALANCE", skorRightFootBalance);
                    intent.putExtra("SKORLEFTFOOTBALANCE", skorLeftFootBalance);
                    intent.putExtra("SKORMEDICINEBALL", skorMedicineBall);
                    intent.putExtra("SKORFLEXIBILITY", skorFlexibility);
                    intent.putExtra("SKORSHORTSERVICE", skorShortService);
                    intent.putExtra("SKORLONGSERVICE", skorLongService);
                    intent.putExtra("SKORFOREHANDLOB", skorForehandLob);
                    intent.putExtra("SKORFOREHANDSMASH", skorForehandSmash);
                    intent.putExtra("SKORFOREHANDDROPSHOOT", skorForehandDropshoot);
                    intent.putExtra("SKORCOORDINATION", skorCoordination);
                    intent.putExtra("SKORAGILITY", skorAgility);
                    intent.putExtra("SKORSPEED", skorSpeed);
                    intent.putExtra("SKORRAST", skorRast);
                    intent.putExtra("SKORDURABILITY", skorDurability);
                    intent.putExtra("NAMA_LENGKAP", namaLengkap);
                    intent.putExtra("USIA", usia);
                    intent.putExtra("JK", jk);
                    startActivity(intent);
                }
            }
        });


        // TODO 1 start Reaction Test
        btnMulaiTestReaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStopwatch();
            }
        });

        btnStopTestReaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopStopwatch();
            }
        });

        edtReactionTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtReactionTest.setError("Fill First");
                    tvResultReactionTest.setText("Result Reaction Test");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 11) {
                        statusReactionTest = "Very Good";
                        skorReactionTest = 5;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 12 && Double.parseDouble(String.valueOf(charSequence)) <= 17) {
                        statusReactionTest = "Good";
                        skorReactionTest = 4;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 18 && Double.parseDouble(String.valueOf(charSequence)) <= 23) {
                        statusReactionTest = "Medium";
                        skorReactionTest = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 24 && Double.parseDouble(String.valueOf(charSequence)) <= 29) {
                        statusReactionTest = "Poor";
                        skorReactionTest = 2;
                    } else {
                        statusReactionTest = "Very Poor";
                        skorReactionTest = 1;
                    }
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultReactionTest.setText(statusReactionTest);
            }
        });
        // TODO 1 end Reaction Test

        // TODO 2 start Balance
        btnMulaiRightFootBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStopwatch();
            }
        });

        btnStopRightFootBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopStopwatch();
                if (seconds <= 6) {
                    statusRightFootBalance = "Very Poor";
                    skorRightFootBalance = 1;
                    tvWatchBalanceFootRight.setText(tvTime.getText().toString().trim());
                    tvResultRightFootBalance.setText(statusRightFootBalance);
                } else if (seconds >= 7 && seconds <= 9) {
                    statusRightFootBalance = "Poor";
                    skorRightFootBalance = 2;
                    tvWatchBalanceFootRight.setText(tvTime.getText().toString().trim());
                    tvResultRightFootBalance.setText(statusRightFootBalance);
                } else if (seconds >= 10 && seconds <= 12) {
                    statusRightFootBalance = "Medium";
                    skorRightFootBalance = 3;
                    tvWatchBalanceFootRight.setText(tvTime.getText().toString().trim());
                    tvResultRightFootBalance.setText(statusRightFootBalance);
                } else if (seconds >= 13 && seconds <= 15) {
                    statusRightFootBalance = "Good";
                    skorRightFootBalance = 4;
                    tvWatchBalanceFootRight.setText(tvTime.getText().toString().trim());
                    tvResultRightFootBalance.setText(statusRightFootBalance);
                } else {
                    statusRightFootBalance = "Very Good";
                    skorRightFootBalance = 5;
                    tvWatchBalanceFootRight.setText(tvTime.getText().toString().trim());
                    tvResultRightFootBalance.setText(statusRightFootBalance);
                }
            }
        });

        btnMulaiLeftFootBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStopwatch();
            }
        });

        btnStopLeftFootBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopStopwatch();
                if (seconds <= 6) {
                    statusLeftFootBalance = "Very Poor";
                    skorLeftFootBalance = 1;
                    tvWatchBalanceFootLeft.setText(tvTime.getText().toString().trim());
                    tvResultLeftFootBalance.setText(statusLeftFootBalance);
                } else if (seconds >= 7 && seconds <= 9) {
                    statusLeftFootBalance = "Poor";
                    skorLeftFootBalance = 2;
                    tvWatchBalanceFootLeft.setText(tvTime.getText().toString().trim());
                    tvResultLeftFootBalance.setText(statusLeftFootBalance);
                } else if (seconds >= 10 && seconds <= 12) {
                    statusLeftFootBalance = "Medium";
                    skorLeftFootBalance = 3;
                    tvWatchBalanceFootLeft.setText(tvTime.getText().toString().trim());
                    tvResultLeftFootBalance.setText(statusLeftFootBalance);
                } else if (seconds >= 13 && seconds <= 15) {
                    statusLeftFootBalance = "Good";
                    skorLeftFootBalance = 4;
                    tvWatchBalanceFootLeft.setText(tvTime.getText().toString().trim());
                    tvResultLeftFootBalance.setText(statusLeftFootBalance);
                } else {
                    statusLeftFootBalance = "Very Good";
                    skorLeftFootBalance = 5;
                    tvWatchBalanceFootLeft.setText(tvTime.getText().toString().trim());
                    tvResultLeftFootBalance.setText(statusLeftFootBalance);
                }
            }
        });
        // TODO 2 end Balance

        // TODO 3 start Kekuatan

        edtMedicineBall.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtMedicineBall.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 5) {
                        statusMedicineBall = "Very Poor";
                        skorMedicineBall = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 6 && Double.parseDouble(String.valueOf(charSequence)) <= 7) {
                        statusMedicineBall = "Poor";
                        skorMedicineBall = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 8 && Double.parseDouble(String.valueOf(charSequence)) <= 9) {
                        statusMedicineBall = "Medium";
                        skorMedicineBall = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 10 && Double.parseDouble(String.valueOf(charSequence)) <= 11) {
                        statusMedicineBall = "Good";
                        skorMedicineBall = 4;
                    } else {
                        statusMedicineBall = "Very Good";
                        skorMedicineBall = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultMedicineBall.setText(statusMedicineBall);
            }
        });
        // TODO 3 end Kekuatan

        // TODO 4 start Daya Lentur

        edtFlexibility.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtFlexibility.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 19) {
                        statusFlexibility = "Very Poor";
                        skorFlexibility = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 20 && Double.parseDouble(String.valueOf(charSequence)) <= 23) {
                        statusFlexibility = "Poor";
                        skorFlexibility = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 24 && Double.parseDouble(String.valueOf(charSequence)) <= 27) {
                        statusFlexibility = "Medium";
                        skorFlexibility = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 28 && Double.parseDouble(String.valueOf(charSequence)) <= 31) {
                        statusFlexibility = "Good";
                        skorFlexibility = 4;
                    } else {
                        statusFlexibility = "Very Good";
                        skorFlexibility = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultFlexibility.setText(statusFlexibility);
            }
        });

        // TODO 4 end Daya Lentur

        // TODO 5 start Akurasi

        edtShortService.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtShortService.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 16) {
                        statusShortService = "Very Poor";
                        skorShortService = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 17 && Double.parseDouble(String.valueOf(charSequence)) <= 24) {
                        statusShortService = "Poor";
                        skorShortService = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 25 && Double.parseDouble(String.valueOf(charSequence)) <= 32) {
                        statusShortService = "Medium";
                        skorShortService = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 33 && Double.parseDouble(String.valueOf(charSequence)) <= 40) {
                        statusShortService = "Good";
                        skorShortService = 4;
                    } else {
                        statusShortService = "Very Good";
                        skorShortService = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultShortService.setText(statusShortService);
            }
        });

        edtLongService.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtShortService.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 19) {
                        statusLongService = "Very Poor";
                        skorLongService = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 20 && Double.parseDouble(String.valueOf(charSequence)) <= 26) {
                        statusLongService = "Poor";
                        skorLongService = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 27 && Double.parseDouble(String.valueOf(charSequence)) <= 33) {
                        statusLongService = "Medium";
                        skorLongService = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 34 && Double.parseDouble(String.valueOf(charSequence)) <= 40) {
                        statusLongService = "Good";
                        skorLongService = 4;
                    } else {
                        statusLongService = "Very Good";
                        skorLongService = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultLongService.setText(statusLongService);
            }
        });

        edtForehandLob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtForehandLob.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 21) {
                        statusForehandLob = "Very Poor";
                        skorForehandLob = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 22 && Double.parseDouble(String.valueOf(charSequence)) <= 28) {
                        statusForehandLob = "Poor";
                        skorForehandLob = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 29 && Double.parseDouble(String.valueOf(charSequence)) <= 35) {
                        statusForehandLob = "Medium";
                        skorForehandLob = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 36 && Double.parseDouble(String.valueOf(charSequence)) <= 42) {
                        statusForehandLob = "Good";
                        skorForehandLob = 4;
                    } else {
                        statusForehandLob = "Very Good";
                        skorForehandLob = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultForehandLob.setText(statusForehandLob);
            }
        });

        edtForehandSmash.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtForehandSmash.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 18) {
                        statusForehandSmash = "Very Poor";
                        skorForehandSmash = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 19 && Double.parseDouble(String.valueOf(charSequence)) <= 26) {
                        statusForehandSmash = "Poor";
                        skorForehandSmash = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 27 && Double.parseDouble(String.valueOf(charSequence)) <= 34) {
                        statusForehandSmash = "Medium";
                        skorForehandSmash = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 35 && Double.parseDouble(String.valueOf(charSequence)) <= 42) {
                        statusForehandSmash = "Good";
                        skorForehandSmash = 4;
                    } else {
                        statusForehandSmash = "Very Good";
                        skorForehandSmash = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultForehandSmash.setText(statusForehandSmash);
            }
        });

        edtForehandDropshoot.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtForehandDropshoot.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 14) {
                        statusForehandDropshoot = "Very Poor";
                        skorForehandDropshoot = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 15 && Double.parseDouble(String.valueOf(charSequence)) <= 22) {
                        statusForehandDropshoot = "Poor";
                        skorForehandDropshoot = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 23 && Double.parseDouble(String.valueOf(charSequence)) <= 30) {
                        statusForehandDropshoot = "Medium";
                        skorForehandDropshoot = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 31 && Double.parseDouble(String.valueOf(charSequence)) <= 38) {
                        statusForehandDropshoot = "Good";
                        skorForehandDropshoot = 4;
                    } else {
                        statusForehandDropshoot = "Very Good";
                        skorForehandDropshoot = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultForehandDropshoot.setText(statusForehandDropshoot);
            }
        });
        // TODO 5 end Akurasi

        // TODO 6 start Koordinasi
        edtCoordination.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtCoordination.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 36) {
                        statusCoordination = "Very Poor";
                        skorCoordination = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 37 && Double.parseDouble(String.valueOf(charSequence)) <= 47) {
                        statusCoordination = "Poor";
                        skorCoordination = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 48 && Double.parseDouble(String.valueOf(charSequence)) <= 58) {
                        statusCoordination = "Medium";
                        skorCoordination = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 59 && Double.parseDouble(String.valueOf(charSequence)) <= 69) {
                        statusCoordination = "Good";
                        skorCoordination = 4;
                    } else {
                        statusCoordination = "Very Good";
                        skorCoordination = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultCoordination.setText(statusCoordination);
            }
        });
        // TODO 6 end Koordinasi

        // TODO 7 start Agility
        edtAgility.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtAgility.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 9) {
                        statusAgility = "Very Poor";
                        skorAgility = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 10 && Double.parseDouble(String.valueOf(charSequence)) <= 12) {
                        statusAgility = "Poor";
                        skorAgility = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 13 && Double.parseDouble(String.valueOf(charSequence)) <= 15) {
                        statusAgility = "Medium";
                        skorAgility = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 16 && Double.parseDouble(String.valueOf(charSequence)) <= 18) {
                        statusAgility = "Good";
                        skorAgility = 4;
                    } else {
                        statusAgility = "Very Good";
                        skorAgility = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultAgility.setText(statusAgility);
            }
        });
        // TODO 7 end Agility

        // TODO 8 start Speed
        btnMulaiSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStopwatch();
            }
        });

        btnStopSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopStopwatch();
                if (seconds <= 10) {
                    statusSpeed = "Very Good";
                    skorSpeed = 5;
                    tvWatchSpeed.setText(tvTime.getText().toString().trim());
                    tvResultSpeed.setText(statusSpeed);
                } else if (seconds >= 11 && seconds <= 12) {
                    statusSpeed = "Good";
                    skorSpeed = 4;
                    tvWatchSpeed.setText(tvTime.getText().toString().trim());
                    tvResultSpeed.setText(statusSpeed);
                } else if (seconds >= 13 && seconds <= 14) {
                    statusSpeed = "Medium";
                    skorSpeed = 3;
                    tvWatchSpeed.setText(tvTime.getText().toString().trim());
                    tvResultSpeed.setText(statusSpeed);
                } else if (seconds >= 15 && seconds <= 16) {
                    statusSpeed = "Poor";
                    skorSpeed = 2;
                    tvWatchSpeed.setText(tvTime.getText().toString().trim());
                    tvResultSpeed.setText(statusSpeed);
                } else {
                    statusSpeed = "Very Poor";
                    skorSpeed = 1;
                    tvWatchSpeed.setText(tvTime.getText().toString().trim());
                    tvResultSpeed.setText(statusSpeed);
                }
            }
        });
        // TODO 8 end Speed

        // TODO 9 start RAST
        edtRast.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtRast.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 34) {
                        statusRast = "Very Good";
                        skorRast = 5;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 35 && Double.parseDouble(String.valueOf(charSequence)) <= 37) {
                        statusRast = "Good";
                        skorRast = 4;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 38 && Double.parseDouble(String.valueOf(charSequence)) <= 40) {
                        statusRast = "Medium";
                        skorRast = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 41 && Double.parseDouble(String.valueOf(charSequence)) <= 43) {
                        statusRast = "Poor";
                        skorRast = 2;
                    } else {
                        statusRast = "Very Poor";
                        skorRast = 1;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultRast.setText(statusRast);
            }
        });
        // TODO 9 end RAST

        // TODO 10 start Durability
        edtDurability.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    edtDurability.setError("Fill First");
                } else {
                    if (Double.parseDouble(String.valueOf(charSequence)) <= 991) {
                        statusDurability = "Very Poor";
                        skorDurability = 1;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 992 && Double.parseDouble(String.valueOf(charSequence)) <= 1086) {
                        statusDurability = "Poor";
                        skorDurability = 2;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 1087 && Double.parseDouble(String.valueOf(charSequence)) <= 1181) {
                        statusDurability = "Medium";
                        skorDurability = 3;
                    } else if (Double.parseDouble(String.valueOf(charSequence)) >= 1182 && Double.parseDouble(String.valueOf(charSequence)) <= 1276) {
                        statusDurability = "Good";
                        skorDurability = 4;
                    } else {
                        statusDurability = "Very Good";
                        skorDurability = 5;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvResultDurability.setText(statusDurability);
            }
        });
        // TODO 10 end Durability


    }

    private void startStopwatch() {
        millisecondTime = 0L;
        startTime = 0L;
        timeBuff = 0L;
        updateTime = 0L;
        seconds = 0;
        minutes = 0;
        milliseconds = 0;
        startTime = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
//                reset.setEnabled(false);
    }

    private void stopStopwatch() {
        timeBuff += millisecondTime;
        handler.removeCallbacks(runnable);
//                reset.setEnabled(true);
    }

    public Runnable runnable = new Runnable() {

        @SuppressLint({"SetTextI18n", "DefaultLocale"})
        public void run() {

            millisecondTime = SystemClock.uptimeMillis() - startTime;

            updateTime = timeBuff + millisecondTime;

            seconds = (int) (updateTime / 1000);

            minutes = seconds / 60;

            seconds = seconds % 60;

            milliseconds = (int) (updateTime % 1000);
            tvTime.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliseconds));

            handler.postDelayed(this, 0);
        }

    };
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.app_name)
                .setMessage("Are you sure you want to exit this test?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        startActivity(new Intent(getApplicationContext(), DataFitnessActivity.class));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }


    private void initView() {
        tvTime = findViewById(R.id.tv_time);
        tvWatchReactionTest = findViewById(R.id.tv_watch_reaction_test);
        edtReactionTest = findViewById(R.id.edt_reaction_test);
        tvResultReactionTest = findViewById(R.id.tv_result_reaction_test);
        btnMulaiTestReaction = findViewById(R.id.btn_mulai_test_reaction);
        btnStopTestReaction = findViewById(R.id.btn_stop_test_reaction);
        tvWatchBalanceFootRight = findViewById(R.id.tv_watch_balance_foot_right);
        edtRightFootBalnce = findViewById(R.id.edt_right_foot_balnce);
        tvResultRightFootBalance = findViewById(R.id.tv_result_right_foot_balance);
        btnMulaiRightFootBalance = findViewById(R.id.btn_mulai_right_foot_balance);
        btnStopRightFootBalance = findViewById(R.id.btn_stop_right_foot_balance);
        tvWatchBalanceFootLeft = findViewById(R.id.tv_watch_balance_foot_left);
        edtLeftFootBalnce = findViewById(R.id.edt_left_foot_balnce);
        tvResultLeftFootBalance = findViewById(R.id.tv_result_left_foot_balance);
        btnMulaiLeftFootBalance = findViewById(R.id.btn_mulai_left_foot_balance);
        btnStopLeftFootBalance = findViewById(R.id.btn_stop_left_foot_balance);
        edtMedicineBall = findViewById(R.id.edt_medicine_ball);
        tvResultMedicineBall = findViewById(R.id.tv_result_medicine_ball);
        edtFlexibility = findViewById(R.id.edt_flexibility);
        tvResultFlexibility = findViewById(R.id.tv_result_flexibility);
        edtShortService = findViewById(R.id.edt_short_service);
        tvResultShortService = findViewById(R.id.tv_result_short_service);
        edtLongService = findViewById(R.id.edt_long_service);
        tvResultLongService = findViewById(R.id.tv_result_long_service);
        edtForehandLob = findViewById(R.id.edt_forehand_lob);
        tvResultForehandLob = findViewById(R.id.tv_result_forehand_lob);
        edtForehandSmash = findViewById(R.id.edt_forehand_smash);
        tvResultForehandSmash = findViewById(R.id.tv_result_forehand_smash);
        edtForehandDropshoot = findViewById(R.id.edt_forehand_dropshoot);
        tvResultForehandDropshoot = findViewById(R.id.tv_result_forehand_dropshoot);
        edtCoordination = findViewById(R.id.edt_coordination);
        tvResultCoordination = findViewById(R.id.tv_result_coordination);
        edtAgility = findViewById(R.id.edt_agility);
        tvResultAgility = findViewById(R.id.tv_result_agility);
        tvWatchSpeed = findViewById(R.id.tv_watch_speed);
        edtSpeed = findViewById(R.id.edt_speed);
        tvResultSpeed = findViewById(R.id.tv_result_speed);
        btnMulaiSpeed = findViewById(R.id.btn_mulai_speed);
        btnStopSpeed = findViewById(R.id.btn_stop_speed);
        edtRast = findViewById(R.id.edt_rast);
        tvResultRast = findViewById(R.id.tv_result_rast);
        edtDurability = findViewById(R.id.edt_Durability);
        tvResultDurability = findViewById(R.id.tv_result_durability);
        btnLihatSkor = findViewById(R.id.btn_lihat_skor);
        tvName = findViewById(R.id.tv_name);
        tvAge = findViewById(R.id.tv_age);
        tvGender = findViewById(R.id.tv_gender);
    }
}
