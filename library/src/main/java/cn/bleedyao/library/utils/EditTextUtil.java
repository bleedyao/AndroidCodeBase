package cn.bleedyao.library.utils;

import android.widget.EditText;

/**
 * Created by yaoluhao on 31/07/2017.
 */

public class EditTextUtil {
    /**
      * @auther YaoLuHao
      * create by 21/12/2017 13:38
      * 编辑框设置值后移动光标到最后
      */
    public static void setEditTextView(EditText et, String value){
        et.setText(value);
        et.setSelection(value.length());
    }
}
