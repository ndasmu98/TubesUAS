package com.apps.newsapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.apps.newsapp.R;
import com.apps.newsapp.activities.Preferences.Preference;
import com.apps.newsapp.activities.adapter.WalkthroughAdapter;
import com.apps.newsapp.activities.model.WalkthroughModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class walkthroughActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button btnMulai,btnLanjut;
    private WalkthroughAdapter walkthroughAdapter;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Preference.getLoginStatus(getBaseContext())){
            Preference.setLoginStatus(true, getBaseContext());
            startActivity(new Intent(walkthroughActivity.this, MainActivity.class));
            finish();
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_walkthrough);

        viewPager = findViewById(R.id.viewpager);
        btnLanjut = findViewById(R.id.btnLanjut);
        btnMulai = findViewById(R.id.btnMulai);
        tabLayout = findViewById(R.id.tablayout);

        final List<WalkthroughModel> modelList = new ArrayList<>();
        modelList.add(new WalkthroughModel("Hiji", "Berawal dari hobi, dilanjutkan menjadi rutinitas.", R.drawable.ic_kuliner));
        modelList.add(new WalkthroughModel("Dua", "Disambung silaturahmi dengan sesama codingers.", R.drawable.ic_hotel));
        modelList.add(new WalkthroughModel("Tilu", "Code yang baik adalah yang bermanfaat.", R.drawable.ic_guide));

        walkthroughAdapter = new WalkthroughAdapter(getBaseContext(), modelList);
        viewPager.setAdapter(walkthroughAdapter);

        tabLayout.setupWithViewPager(viewPager);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewPager.getCurrentItem();

                if (position < modelList.size()){
                    position++;
                    viewPager.setCurrentItem(position);
                }

                if (position == modelList.size() - 1){
                    btnLanjut.setVisibility(View.INVISIBLE);
                    tabLayout.setVisibility(View.INVISIBLE);
                    btnMulai.setVisibility(View.VISIBLE);
                }
            }
        });

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preference.setLoginStatus(true, getBaseContext());
                startActivity(new Intent(walkthroughActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}