package cn.bleedyao.androidcodebase.adapter;

import android.content.Context;
import android.widget.TextView;

import java.util.List;

import cn.bleedyao.library.widget.recyclerview.BaseAdapter;
import cn.bleedyao.library.widget.recyclerview.ViewHolder;

/**
 * Created by yaoluhao on 29/11/2017.
 */

public class TestAdapter extends BaseAdapter<String> {
    private Context context;

    public TestAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
        this.context = context;
    }

    @Override
    protected void onBind(final ViewHolder holder, String s, final int position) {
        TextView textView = holder.getViewbyId(android.R.id.text1);
        textView.setText(s);
//        holder.setOnClickListener(android.R.id.text1, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, String.format(Locale.CHINA, "点击%d", position), Toast
//                        .LENGTH_SHORT).show();
//            }
//        });
//        holder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, String.format(Locale.CHINA, "根布局%d", position), Toast
//                        .LENGTH_SHORT).show();
//            }
//        });
//        holder.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(context, String.format(Locale.CHINA, "长按根布局%d", position), Toast
//                        .LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }
}
