package cn.bleedyao.androidcodebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bleedyao.library.utils.StringUtils;
import cn.bleedyao.library.widget.recyclerview.OnItemClickListener;
import cn.bleedyao.library.widget.recyclerview.OnItemLongClickListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private List<String> datas = new ArrayList<>();
    private List<Content> contents = new ArrayList<>();
    private int[] layouts = new int[]{android.R.layout.simple_expandable_list_item_1, android.R
            .layout.simple_expandable_list_item_2, android.R.layout.activity_list_item};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            datas.add(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            contents.add(new Content(String.valueOf(i), String.valueOf(i + 10)));
        }
        mRecycleView = findViewById(R.id.recycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(linearLayoutManager);

        TestAdapter adapter = new TestAdapter(this, datas, android.R.layout
                .simple_list_item_1);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, StringUtils.addValue("第%d个布局被点击", position),
                        Toast.LENGTH_SHORT).show();
            }
        });

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(mRecycleView
                .getContext(), linearLayoutManager.getOrientation());

        mRecycleView.addItemDecoration(mDividerItemDecoration);

        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public void onLongItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, StringUtils.addValue("第%d被长点击", position),
                        Toast.LENGTH_SHORT).show();
            }
        });
        mRecycleView.setAdapter(adapter);


//        mRecycleView.setAdapter(new TestMultiAdapter(this, contents, layouts));
    }
}
