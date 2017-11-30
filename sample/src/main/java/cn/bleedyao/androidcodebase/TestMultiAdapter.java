package cn.bleedyao.androidcodebase;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.bleedyao.library.widget.recyclerview.MultiLayoutsBaseAdapter;
import cn.bleedyao.library.widget.recyclerview.ViewHolder;

/**
 * Created by yaoluhao on 29/11/2017.
 */

public class TestMultiAdapter extends MultiLayoutsBaseAdapter<Content> {
    private final int[] layoutIds;

    public TestMultiAdapter(Context context, List<Content> data, int[] layoutIds) {
        super(context, data, layoutIds);
        this.layoutIds = layoutIds;
    }

    @Override
    protected int getItemType(int position) {
        return position % layoutIds.length;
    }

    @Override
    protected void onBinds(ViewHolder holder, Content content, int position, int itemViewType) {
        TextView text1 = holder.getViewbyId(android.R.id.text1);
        text1.setText(content.str1);
        switch (itemViewType) {
            case 0:
                break;
            case 1:
                TextView text2 = holder.getViewbyId(android.R.id.text2);
                text2.setText(content.str2);
                break;
            case 2:
                ImageView imageView = holder.getViewbyId(android.R.id.icon);
                imageView.setImageResource(R.mipmap.ic_launcher);
                break;
            default:
        }
    }
}
