package com.example.yanxiaoyong.myapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yanxiaoyong on 2016/8/9.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight = 1;
    private Paint mLinePaint;

    private int mLeft = 0;
    public DividerItemDecoration(Context context) {
        mLinePaint = new Paint();
        mLinePaint.setStrokeWidth(dividerHeight);
        mLinePaint.setColor(Color.parseColor("#1e000000"));
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = mLeft;
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            c.drawLine(left, top, right, top, mLinePaint);
        }
    }

//    @Override
//    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDraw(c, parent, state);
//    }

//    @Override
//    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
//    }
}
