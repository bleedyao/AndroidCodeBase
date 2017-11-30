package cn.bleedyao.library.widget.recyclerview;

import android.content.Context;

import java.util.List;

/**
 * Created by yaoluhao on 29/11/2017.
 */

public abstract class MultiLayoutsBaseAdapter<T> extends BaseAdapter<T> {
    private int[] layoutIds;

    public MultiLayoutsBaseAdapter(Context context, List<T> data, int[] layoutIds) {
        super(context, data, layoutIds);
    }

    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }

    @Override
    protected void onBind(ViewHolder holder, T t, int position) {
        onBinds(holder, t, position, getItemViewType(position));
    }

    protected abstract int getItemType(int position);

    protected abstract void onBinds(ViewHolder holder, T t, int position, int itemViewType);
}
