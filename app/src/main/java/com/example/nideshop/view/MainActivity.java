package com.example.nideshop.view;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.nideshop.R;
import com.example.nideshop.view.fragment.ClassifyFragment;
import com.example.nideshop.view.fragment.HomeFragment;
import com.example.nideshop.view.fragment.MyFragment;
import com.example.nideshop.view.fragment.ShoppingFragment;
import com.example.nideshop.view.fragment.SpecialFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgTab;
    private RadioButton rbHome;
    private RadioButton rbSpecial;
    private RadioButton rbClassify;
    private RadioButton rbShopping;
    private RadioButton rbMy;
    private ViewPager vpHome;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rgTab = (RadioGroup) findViewById(R.id.rg_tab);
        rbHome = (RadioButton) findViewById(R.id.rb_home);
        rbSpecial = (RadioButton) findViewById(R.id.rb_special);
        rbClassify = (RadioButton) findViewById(R.id.rb_classify);
        rbShopping = (RadioButton) findViewById(R.id.rb_shopping);
        rbMy = (RadioButton) findViewById(R.id.rb_my);
        vpHome = (ViewPager) findViewById(R.id.vp_home);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new ShoppingFragment());
        fragments.add(new MyFragment());

        vpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_home) {
                    vpHome.setCurrentItem(0);
                } else if (checkedId == R.id.rb_special) {
                    vpHome.setCurrentItem(1);
                } else if (checkedId == R.id.rb_classify) {
                    vpHome.setCurrentItem(2);
                } else if (checkedId == R.id.rb_shopping) {
                    vpHome.setCurrentItem(3);
                } else {
                    vpHome.setCurrentItem(4);
                }
            }
        });
    }
}