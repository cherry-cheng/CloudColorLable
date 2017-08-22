package com.example.chengyonghui.floatlabel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengyonghui on 2017/8/18.
 */
public class LabelView extends ViewGroup {
    private static final String TAG = LabelView.class.getSimpleName();
    private Paint mBackgroudPaint;
    private int mBackgroundPaintcolor = Color.LTGRAY;
    private Paint mLinePaint;
    private int mLinePaintColor = Color.BLUE;

    private float mTextSize;
    private int mTextColor = Color.WHITE;

    private float mTextViewPaddingLeft;
    private float mTextViewPaddingRight;
    private float mTextViewPaddingTop;
    private float mTextViewPaddingBottom;

    private float mTextViewMarginLeft;
    private float mTextViewMarginRight;
    private float mTextViewMarginTop;
    private float mTextViewMarginBottom;

    private List<String> tags = new ArrayList<String>();
    private List<TagView> tagViews = new ArrayList<TagView>();

    private float rx = 20,ry = 20;
    private float mStrokeWidth = 5;

/*    public int getmBackgroundPaintcolor(){
        return mBackgroundPaintcolor;
    }

    public Paint getmLinePaint() {
        return mLinePaint;
    }

    public int getmLinePaintColor() {
        return mLinePaintColor;
    }

    public float getmTextSize() {
        return mTextSize;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public float getmTextViewPaddingLeft() {
        return mTextViewPaddingLeft;
    }

    public float getmTextViewPaddingRight() {
        return mTextViewPaddingRight;
    }

    public float getmTextViewPaddingTop() {
        return mTextViewPaddingTop;
    }

    public float getmTextViewPaddingBottom() {
        return mTextViewPaddingBottom;
    }

    public float getmTextViewMarginRight() {
        return mTextViewMarginRight;
    }

    public float getmTextViewMarginLeft() {
        return mTextViewMarginLeft;
    }

    public float getmTextViewMarginTop() {
        return mTextViewMarginTop;
    }

    public float getmTextViewMarginBottom() {
        return mTextViewMarginBottom;
    }

    public List<String> getTags() {
        return tags;
    }

    public float getRx() {
        return rx;
    }

    public float getRy() {
        return ry;
    }

    public void setmBackgroudPaint(Paint mBackgroudPaint) {
        this.mBackgroudPaint = mBackgroudPaint;
    }

    public void setmBackgroundPaintcolor(int mBackgroundPaintcolor) {
        this.mBackgroundPaintcolor = mBackgroundPaintcolor;
    }

    public void setmLinePaint(Paint mLinePaint) {
        this.mLinePaint = mLinePaint;
    }

    public void setmLinePaintColor(int mLinePaintColor) {
        this.mLinePaintColor = mLinePaintColor;
    }

    public void setmTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public void setmTextViewPaddingLeft(float mTextViewPaddingLeft) {
        this.mTextViewPaddingLeft = mTextViewPaddingLeft;
    }

    public void setmTextViewPaddingRight(float mTextViewPaddingRight) {
        this.mTextViewPaddingRight = mTextViewPaddingRight;
    }

    public void setmTextViewPaddingTop(float mTextViewPaddingTop) {
        this.mTextViewPaddingTop = mTextViewPaddingTop;
    }

    public void setmTextViewPaddingBottom(float mTextViewPaddingBottom) {
        this.mTextViewPaddingBottom = mTextViewPaddingBottom;
    }

    public void setmTextViewMarginLeft(float mTextViewMarginLeft) {
        this.mTextViewMarginLeft = mTextViewMarginLeft;
    }

    public void setmTextViewMarginRight(float mTextViewMarginRight) {
        this.mTextViewMarginRight = mTextViewMarginRight;
    }

    public void setmTextViewMarginTop(float mTextViewMarginTop) {
        this.mTextViewMarginTop = mTextViewMarginTop;
    }

    public void setmTextViewMarginBottom(float mTextViewMarginBottom) {
        this.mTextViewMarginBottom = mTextViewMarginBottom;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setRx(float rx) {
        this.rx = rx;
    }

    public void setRy(float ry) {
        this.ry = ry;
    }*/

    //constructor
    public LabelView(Context context) {
        super(context);
    }

    public LabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LabelView);
        mBackgroundPaintcolor = ta.getColor(R.styleable.LabelView_background_color, Color.LTGRAY);
        mLinePaintColor = ta.getColor(R.styleable.LabelView_line_color, Color.LTGRAY);
        mStrokeWidth = ta.getDimension(R.styleable.LabelView_stroke_width, 3);

        mTextViewMarginLeft = ta.getDimension(R.styleable.LabelView_textview_margin_left, 2);
        mTextViewMarginRight = ta.getDimension(R.styleable.LabelView_textview_margin_right, 2);
        mTextViewMarginTop = ta.getDimension(R.styleable.LabelView_textview_margin_top, 2);
        mTextViewMarginBottom = ta.getDimension(R.styleable.LabelView_textview_margin_bottom, 2);

        mTextViewPaddingLeft = ta.getDimension(R.styleable.LabelView_textview_padding_left, 2);
        mTextViewPaddingRight = ta.getDimension(R.styleable.LabelView_textview_padding_right, 2);
        mTextViewPaddingTop = ta.getDimension(R.styleable.LabelView_textview_padding_top, 2);
        mTextViewPaddingBottom = ta.getDimension(R.styleable.LabelView_textview_padding_bottom, 2);

        mTextColor = ta.getColor(R.styleable.LabelView_text_color, Color.WHITE);
        mTextSize = ta.getDimension(R.styleable.LabelView_text_size, 6);

        float mTextViewPadding = ta.getDimension(R.styleable.LabelView_textview_padding, 0);
        if (mTextViewPadding != 0) {
            mTextViewPaddingLeft = mTextViewPadding;
            mTextViewPaddingRight = mTextViewPadding;
            mTextViewPaddingBottom = mTextViewPadding;
            mTextViewPaddingTop = mTextViewPadding;
        }

        float mTextViewMargin = ta.getDimension(R.styleable.LabelView_textview_margin, 0);
        if (mTextViewMargin != 0) {
            mTextViewMarginLeft = mTextViewMargin;
            mTextViewMarginRight = mTextViewMargin;
            mTextViewMarginBottom = mTextViewMargin;
            mTextViewMarginTop = mTextViewMargin;
        }

        ta.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;
        int height = 0;

        int lineWidth = 0;
        int lineHeight = 0;

        int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.bottomMargin + lp.topMargin;

            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()) {
                width = Math.max(width, lineWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == cCount -1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }

        setMeasuredDimension(
                modeWidth == MeasureSpec.EXACTLY ? sizeWidth:width + getPaddingLeft() + getPaddingRight(),
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight:height + getPaddingTop() + getPaddingBottom()
        );
    }

    //存储所有的view，一行一行的存
    private List<List<View>> mAllViews = new ArrayList<List<View>>();
    //存储每一行的高度
    private List<Integer> mLineHeight = new ArrayList<>();

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViews.clear();
        mLineHeight.clear();

        int width = getWidth();//当前viewgroup的宽度

        int lineWidth = 0;
        int lineHeight = 0;

        List<View> lineViews = new ArrayList<>();

        int cCount = getChildCount();
        Log.v("TAG", cCount + "");
        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (childWidth + lineWidth + lp.leftMargin + lp.rightMargin > width - getPaddingRight() - getPaddingLeft()) {
                mLineHeight.add(lineHeight);

                mAllViews.add(lineViews);

                lineWidth = 0;
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;

                lineViews = new ArrayList<View>();
            }

            lineWidth += childWidth + lp.rightMargin + lp.leftMargin;
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin);
            lineViews.add(child);
        }

        //处理最后一行
        mLineHeight.add(lineHeight);
        mAllViews.add(lineViews);

        //设置子view的位置
        int left = getPaddingLeft();
        int top = getPaddingTop();

        //行数
        int lineNum = mAllViews.size();

        for (int i = 0; i < lineNum; i++) {
            lineViews = mAllViews.get(i);
            lineHeight = mLineHeight.get(i);

            //遍历行
            for (int j = 0; j < lineViews.size(); j++) {
                View child = lineViews.get(j);
                if (child.getVisibility() == View.GONE) {
                    continue;
                }

                MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();
                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();
                child.layout(lc, tc, rc, bc);

                left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }

            //另一行需要重置行
            left = getPaddingLeft();
            top += lineHeight;
        }
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }


    public void setTags(ArrayList<String> tags) {
        for (String tag : tags) {
            TagView tv = new TagView(getContext(), tag);
            tv.setTextColor(mTextColor);
            tv.setTextSize(mTextSize);
            MarginLayoutParams lp = new MarginLayoutParams(
                    MarginLayoutParams.WRAP_CONTENT,
                    MarginLayoutParams.WRAP_CONTENT
            );
            lp.setMargins((int) mTextViewMarginLeft,
                    (int) mTextViewMarginTop,
                    (int) mTextViewMarginRight,
                    (int) mTextViewMarginBottom);
            this.addView(tv, lp);
            tagViews.add(tv);

            final CharSequence cs = tag;
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), cs, Toast.LENGTH_SHORT).show();
                }
            });
        }
        invalidate();
    }

    public List<TagView> getTagViews() {
        return tagViews;
    }

    class TagView extends TextView {

        float top;
        float left;
        float right;
        float bottom;

        int mBackgroundPaintColor;
        Paint mBackgroundPaint;

        int mLinePaintColor;
        Paint mLinePaint;

        float mTextSize;
        int mTextColor;

        float mStrokeWidth;

        public TagView(Context context) {
            super(context);
        }

        public TagView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public TagView(Context context, CharSequence tag) {
            super(context);

            //初始化
            mBackgroundPaintColor = LabelView.this.mBackgroundPaintcolor;
            mBackgroundPaint = LabelView.this.mBackgroudPaint;
            mLinePaint = LabelView.this.mLinePaint;
            mLinePaintColor = LabelView.this.mLinePaintColor;
            mStrokeWidth = LabelView.this.mStrokeWidth;
            mTextSize = LabelView.this.mTextSize;
            mTextColor = LabelView.this.mTextColor;

            LabelView.this.setPadding((int)mTextViewPaddingLeft, (int)mTextViewPaddingTop,
                    (int)mTextViewPaddingRight, (int)mTextViewPaddingBottom);
            setGravity(TEXT_ALIGNMENT_CENTER);
            setText(tag);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            top = 0;
            left = 0;
            right = getWidth();
            bottom = getHeight();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            RectF rectF = new RectF(left + mStrokeWidth/2,
                    top + mStrokeWidth/2,
                    right - mStrokeWidth/2,
                    bottom - mStrokeWidth/2);

            mBackgroundPaint = new Paint();
            mBackgroundPaint.setColor(mBackgroundPaintColor);
            canvas.drawRoundRect(rectF, rx, ry, mBackgroundPaint);

            mLinePaint = new Paint();
            mLinePaint.setColor(mLinePaintColor);
            mLinePaint.setStyle(Paint.Style.STROKE);
            mLinePaint.setStrokeWidth(mStrokeWidth);
            mLinePaint.setAntiAlias(true);
            canvas.drawRoundRect(rectF, rx, ry, mLinePaint);
            super.onDraw(canvas);
        }

        public void setmBackgroundPaintColor(int mBackgroundPaintColor) {
            this.mBackgroundPaintColor = mBackgroundPaintColor;
            invalidate();
        }

        public void setmLinePaintColor(int mLinePaintColor) {
            this.mLinePaintColor = mLinePaintColor;
            invalidate();
        }

        public void setmStrokeWidth(float mStrokeWidth) {
            this.mStrokeWidth = mStrokeWidth;
            invalidate();
        }

        public void setmTextColor(int mTextColor) {
            this.mTextColor = mTextColor;
            invalidate();
        }
    }
}
