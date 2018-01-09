package cn.bleedyao.androidcodebase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bleedyao.androidcodebase.R;
import cn.bleedyao.androidcodebase.adapter.TestAdapter;
import cn.bleedyao.library.widget.recyclerview.OnItemClickListener;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "fragment";

    private RecyclerView mRecycleView;
    private String[] strs = {"懒加载", "mqtt"};
    private List<String> datas = new ArrayList<>();
    private int[] layouts = new int[]{android.R.layout.simple_expandable_list_item_1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas.addAll(Arrays.asList(strs));

        mRecycleView = findViewById(R.id.recycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(linearLayoutManager);

        TestAdapter adapter = new TestAdapter(this, datas, android.R.layout
                .simple_list_item_1);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, LazyLoadActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, MqttActivity.class));
                        break;
                }
            }
        });

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(mRecycleView
                .getContext(), linearLayoutManager.getOrientation());

        mRecycleView.addItemDecoration(mDividerItemDecoration);

        mRecycleView.setAdapter(adapter);

//        mRecycleView.setAdapter(new TestMultiAdapter(this, contents, layouts));
    }


}
