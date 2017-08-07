package com.example.zz.myapplication.adapter;

import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zz.myapplication.R;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.List;

/**
 * Created by zz on 2017/8/5.
 */

public class FlexBoxAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public FlexBoxAdapter(List<String> data) {
        super(R.layout.item_flexbox,data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView tv = helper.getView(R.id.tv_test);
        tv.setText(item);
        ViewGroup.LayoutParams lp = tv.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
            flexboxLp.setFlexGrow(1.0f);
        }
    }

}
