package cn.bleedyao.library.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yaoluhao on 29/11/2017.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements View
        .OnClickListener, View.OnLongClickListener {
    private Context mContext;
    private List<T> mData;
    private int[] mLayoutIds;
    private OnItemClickListener mOnClickListener;
    private OnItemLongClickListener mOnLongClickListener;


    public BaseAdapter(Context context, List<T> data, int layoutId) {
        this.mContext = context;
        this.mData = data;
        this.mLayoutIds = new int[]{layoutId};
    }

    public BaseAdapter(Context context, List<T> data, int[] layoutIds) {
        this.mContext = context;
        this.mData = data;
        this.mLayoutIds = layoutIds;
    }

    public List<T> getData() {
        return mData;
    }

    public void addElement(T t){
        mData.add(t);
        notifyItemInserted(mData.indexOf(t));
    }
    public void removeElement(T t){
        mData.remove(t);
        notifyItemRemoved(mData.indexOf(t));
    }

    public void setData(List<T> mData) {
        mData.clear();
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnClickListener = listener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnLongClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    // viewType 默认是 0；
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutIds[viewType], parent, false);
        ViewHolder holder = ViewHolder.getHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        onBind(holder, mData.get(position), position);
    }

    protected abstract void onBind(ViewHolder holder, T t, int position);

    @Override
    public void onClick(View v) {
        if (mOnClickListener != null) {
            mOnClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnLongClickListener != null){
            mOnLongClickListener.onLongItemClick(v, (int) v.getTag());
            return true;
        }
        return false;
    }
}
