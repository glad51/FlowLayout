package com.example.zz.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zz.myapplication.adapter.FlexBoxAdapter;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.llyt_view)
    LinearLayout mLlytView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager();
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        mRecyclerView.setLayoutManager(layoutManager);
        FlexBoxAdapter mAdater = new FlexBoxAdapter(new ArrayList<String>());
        mRecyclerView.setAdapter(mAdater);
        List<String> list = new ArrayList<String>();
        String flag = "";
        for (int i = 0; i < 10; i++) {
            flag = flag + "测";
            list.add(flag);
        }
        mAdater.addData(list);
        mAdater.notifyDataSetChanged();
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        mLlytView.measure(w, h);
        int height = mLlytView.getMeasuredHeight();
        Toast.makeText(this, height+"高度布局", Toast.LENGTH_SHORT).show();
        Log.d("高度布局",height+"");
    }
}
