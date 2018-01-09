package cn.bleedyao.androidcodebase.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bleedyao.androidcodebase.R;
import cn.bleedyao.androidcodebase.fragment.FirstFragment;
import cn.bleedyao.androidcodebase.fragment.FourthFragment;
import cn.bleedyao.androidcodebase.fragment.SecondFragment;
import cn.bleedyao.androidcodebase.fragment.ThirdFragment;

/**
 * Created by yaoluhao on 01/12/2017.
 */

public class LazyLoadActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy);
        mViewPager = findViewById(R.id.root);

        List<Fragment> list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        list.add(new ThirdFragment());
        list.add(new FourthFragment());

        MyFragmentPageAdapter pageradapter = new MyFragmentPageAdapter(getSupportFragmentManager(),
                list);

        mViewPager.setAdapter(pageradapter);
        mViewPager.setOffscreenPageLimit(list.size() - 1);

    }

    class MyFragmentPageAdapter extends FragmentPagerAdapter {
        List<Fragment> mList;

        public MyFragmentPageAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
