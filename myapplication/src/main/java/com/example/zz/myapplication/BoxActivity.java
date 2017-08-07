package com.example.zz.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BoxActivity extends AppCompatActivity {


    @BindView(R.id.flexbox)
    FlexBoxView mFlexbox;
    @BindView(R.id.edt_input)
    EditText mEdtInput;
    @BindView(R.id.btn_click)
    Button mBtnClick;
    private Context mContext;
    private ArrayList<String> mArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_box);
        ButterKnife.bind(this);
        mContext = this;
        mArray = new ArrayList<String>();

    }

    private void getFlexbox(String name) {
        ViewGroup vTv = null;
        int sum = 0;
        int screenWidth = getWidth() - 60;
        int line=0;
//        if (line>=4){
//            mArray.add(0,name);
//        }else {
            mArray.add(name);
//        }
        for (int i = 0; i < mArray.size(); i++) {
            if (vTv != null) {
                mFlexbox.removeView(vTv);
            }
            vTv = (ViewGroup) getLayoutInflater().inflate(R.layout.item_flexbox, mFlexbox, false);
            TextView tv = (TextView) vTv.findViewById(R.id.tv_test);
            tv.setText(mArray.get(i));
            int tvWidth = getViewWidth(tv);
            sum = sum + tvWidth;
            Log.i("控件高度", tvWidth + "控件高度" + (i + 1));
            Log.i("控件累计高度", sum + "控件累计高度" + (i + 1));
            Log.i("布局宽度", screenWidth + "布局宽度" + (i + 1));
            if (sum >= screenWidth) {
                if (i == 0) {
                    line = 0;
                } else {
                    screenWidth = getWidth() - 60;
                    line++;
                }
                sum = tvWidth;

            } else {
                screenWidth -= 20;
            }
            if (line < 4) {
                mFlexbox.addView(vTv);
                Log.i("行数", line + "行数" + (i + 1));
            }
        }
    }


    /**
     * 获取屏幕的宽
     *
     * @return
     */
    private int getWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        //取得窗口属性
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //窗口的宽度
        int screenWidth = dm.widthPixels;
        return screenWidth;
    }

    /**
     * 获取控件的宽
     *
     * @param view
     * @return
     */
    private int getViewWidth(final View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int width = view.getMeasuredWidth();
        return width;
    }

    /**
     * 获取控件的高
     *
     * @param view
     * @return
     */
    private int getViewHeight(final View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();
        return height;
    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        getFlexbox(mEdtInput.getText().toString());
    }
}
