package cn.bleedyao.library.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yaoluhao on 01/12/2017.
 * 模板 fragment 不建议用于继承，因为 newInstance 方法中的参数需要根据业务需求修改。
 * 不建议直接传递 bundle，因为其他开发人员不知道应该使用什么字段作为键，因此在敏捷开发中，建议直接传递参数
 * 实际开发中应该至少出现以下方法（newInstance 参数可不同）
 */
public class TemplateFragment extends Fragment {
    private static final String ARG_PARAM = "param_key";
    private Activity mActivity;
    private String mParam;

    public static TemplateFragment newInstance(String str) {
        TemplateFragment fragment = new TemplateFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View root = inflater.inflate(android.R.layout.simple_list_item_activated_2,container,false);
        TextView view = (TextView) root.findViewById(android.R.id.text1);
        view.setText(mParam);
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mParam = getArguments().getString(ARG_PARAM);
    }

}
