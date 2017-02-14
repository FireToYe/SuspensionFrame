package tydic.cn.com.suspensionframe.layout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import tydic.cn.com.suspensionframe.R;
import tydic.cn.com.suspensionframe.service.FloatWindowService;
import tydic.cn.com.suspensionframe.util.MyWindowUtil;

/**
 * Created by yechenglong on 2017/2/14.
 */

public class FloatWindowBigView extends LinearLayout{
    public static int viewWidth;
    public static int viewHeight;
    public FloatWindowBigView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.float_window_big,this);
        View view = findViewById(R.id.big_window_layout);
        viewWidth = view.getLayoutParams().width;
        viewHeight = view.getLayoutParams().height;
        Button btnClose = (Button) findViewById(R.id.btn_close);
        Button btnBack = (Button)findViewById(R.id.btn_back);
        btnClose.setOnClickListener(v -> {
            MyWindowUtil.removeSmallWindow(context);
            MyWindowUtil.removeBigWindow(context);
            Intent intent = new Intent(getContext(), FloatWindowService.class);
            context.stopService(intent);
        });
        btnBack.setOnClickListener(v -> {
            MyWindowUtil.removeBigWindow(context);
            MyWindowUtil.createSmallWindow(context);
        });
    }
}
