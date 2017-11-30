package cn.bleedyao.library.widget.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by yaoluhao on 29/11/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    private SparseArray<View> views;//存放 item 中的控件
    private OnItemClickListener mOnItemClick;

    public ViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    //供 adapter 调用，返回 holder
    public static <T extends ViewHolder> T getHolder(View view) {
        return (T) new ViewHolder(view);
    }

    // 根据 item 中的 id 获取控件
    public <T extends View> T getViewbyId(int viewId) {
        View childView = views.get(viewId);
        if (childView == null) {
            childView = itemView.findViewById(viewId);
            views.put(viewId, childView);
        }
        return (T) childView;
    }

    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getViewbyId(viewId);
        view.setOnClickListener(listener);
    }


    public void setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getViewbyId(viewId);
        view.setOnLongClickListener(listener);
    }

}

