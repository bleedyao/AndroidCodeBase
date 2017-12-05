package cn.bleedyao.library.component;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaoluhao on 01/12/2017.
 */

public class LazyFragment extends Fragment {
    private static final String TAG = "LazyFragment";
    private View mRootView;
    private boolean mIsInited;
    private boolean mIsPrepared;

    public static LazyFragment newInstance() {
        return new LazyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(android.R.layout.two_line_list_item, container, false);
        mIsPrepared = true;
        lazyLoad();
        return mRootView;
    }

    public void lazyLoad() {
        if (getUserVisibleHint() && mIsPrepared && !mIsInited) {
            // 异步初始化，在初始化后显示正常 UI
            loadData();
        }
    }

    private void loadData() {
        new Thread() {
            @Override
            public void run() {
                // 1. 加载数据
                // 2. 更新UI
                // 3. mIsInited = true;
            }
        }.start();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }
}
