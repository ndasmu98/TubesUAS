package com.apps.newsapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.newsapp.R;
import com.apps.newsapp.activities.Preferences.Preference;
import com.google.android.material.card.MaterialCardView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialCardView cvHead, cvSports, cvTechno, cvBusiness, cvHealth, cvEntertaiment, cvName;
    TextView tvToday;
    String hariIni;
    Button btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cvHead = findViewById(R.id.cardHeadLine);
        cvSports = findViewById(R.id.cardSports);
        cvTechno = findViewById(R.id.cardTechno);
        cvBusiness = findViewById(R.id.cardBusiness);
        cvHealth = findViewById(R.id.cardHealth);
        cvEntertaiment = findViewById(R.id.cardEnter);
        cvName = findViewById(R.id.cvName);

        cvHead.setOnClickListener(this);
        cvSports.setOnClickListener(this);
        cvTechno.setOnClickListener(this);
        cvBusiness.setOnClickListener(this);
        cvHealth.setOnClickListener(this);
        cvEntertaiment.setOnClickListener(this);
        btnKeluar = findViewById(R.id.btnKeluar);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        cvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityProfile.class));
            }
        });

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);
        if (hariIni.equalsIgnoreCase("sunday")) {
            hariIni = "Minggu";
        } else if (hariIni.equalsIgnoreCase("monday")) {
            hariIni = "Senin";
        } else if (hariIni.equalsIgnoreCase("tuesday")) {
            hariIni = "Selasa";
        } else if (hariIni.equalsIgnoreCase("wednesday")) {
            hariIni = "Rabu";
        } else if (hariIni.equalsIgnoreCase("thursday")) {
            hariIni = "Kamis";
        } else if (hariIni.equalsIgnoreCase("friday")) {
            hariIni = "Jumat";
        } else if (hariIni.equalsIgnoreCase("saturday")) {
            hariIni = "Sabtu";
        }

        getToday();

    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d", date);
        String monthNumber = (String) DateFormat.format("M", date);
        String year = (String) DateFormat.format("yyyy", date);

        int month = Integer.parseInt(monthNumber);
        String bulan = null;
        if (month == 1) {
            bulan = "Januari";
        } else if (month == 2) {
            bulan = "Februari";
        } else if (month == 3) {
            bulan = "Maret";
        } else if (month == 4) {
            bulan = "April";
        } else if (month == 5) {
            bulan = "Mei";
        } else if (month == 6) {
            bulan = "Juni";
        } else if (month == 7) {
            bulan = "Juli";
        } else if (month == 8) {
            bulan = "Agustus";
        } else if (month == 9) {
            bulan = "September";
        } else if (month == 10) {
            bulan = "Oktober";
        } else if (month == 11) {
            bulan = "November";
        } else if (month == 12) {
            bulan = "Desember";
        }
        String formatFix = hariIni + ", " + tanggal + " " + bulan + " " + year;
        tvToday.setText(formatFix);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.cardHeadLine) {
            Intent intent = new Intent(MainActivity.this, HeadLineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardSports) {
            Intent intent = new Intent(MainActivity.this, SportsNewsActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardTechno) {
            Intent intent = new Intent(MainActivity.this, TechnologyActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardBusiness) {
            Intent intent = new Intent(MainActivity.this, BusinessActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardHealth) {
            Intent intent = new Intent(MainActivity.this, HealthActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardEnter) {
            Intent intent = new Intent(MainActivity.this, EntertaimentActivity.class);
            startActivity(intent);
        }
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Keluar aplikasi");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Anda Yakin Ingin Keluar?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Preference.setLogOut(getBaseContext());
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}