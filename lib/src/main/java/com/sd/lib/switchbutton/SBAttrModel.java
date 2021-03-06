package com.sd.lib.switchbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class SBAttrModel
{
    /**
     * 正常view图片id
     */
    public int imageNormalResId;
    /**
     * 选中view图片id
     */
    public int imageCheckedResId;
    /**
     * 手柄view图片id
     */
    public int imageThumbResId;
    /**
     * 手柄view左边间距
     */
    public int marginLeft;
    /**
     * 手柄view顶部间距
     */
    public int marginTop;
    /**
     * 手柄view右边间距
     */
    public int marginRight;
    /**
     * 手柄view底部间距
     */
    public int marginBottom;
    /**
     * 是否选中
     */
    public boolean isChecked;
    /**
     * 是否需要点击切换动画
     */
    public boolean isNeedToggleAnim;
    /**
     * 是否调试模式
     */
    public boolean isDebug;

    /**
     * 解析xml属性
     *
     * @param context
     * @param attrs
     */
    public void parse(Context context, AttributeSet attrs)
    {
        imageNormalResId = R.drawable.lib_sb_layer_normal_view;
        imageCheckedResId = R.drawable.lib_sb_layer_checked_view;
        imageThumbResId = R.drawable.lib_sb_layer_thumb_view;

        final int defaultMargin = context.getResources().getDimensionPixelSize(R.dimen.lib_sb_margins);
        marginLeft = defaultMargin;
        marginTop = defaultMargin;
        marginRight = defaultMargin;
        marginBottom = defaultMargin;

        if (attrs != null)
        {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LibSwitchButton);

            imageNormalResId = a.getResourceId(R.styleable.LibSwitchButton_sbImageNormal, imageNormalResId);
            imageCheckedResId = a.getResourceId(R.styleable.LibSwitchButton_sbImageChecked, imageCheckedResId);
            imageThumbResId = a.getResourceId(R.styleable.LibSwitchButton_sbImageThumb, imageThumbResId);

            if (a.hasValue(R.styleable.LibSwitchButton_sbMargins))
            {
                int margins = a.getDimensionPixelSize(R.styleable.LibSwitchButton_sbMargins, defaultMargin);
                marginLeft = margins;
                marginTop = margins;
                marginRight = margins;
                marginBottom = margins;
            }

            if (a.hasValue(R.styleable.LibSwitchButton_sbMarginLeft))
                marginLeft = a.getDimensionPixelSize(R.styleable.LibSwitchButton_sbMarginLeft, marginLeft);

            if (a.hasValue(R.styleable.LibSwitchButton_sbMarginTop))
                marginTop = a.getDimensionPixelSize(R.styleable.LibSwitchButton_sbMarginTop, marginTop);

            if (a.hasValue(R.styleable.LibSwitchButton_sbMarginRight))
                marginRight = a.getDimensionPixelSize(R.styleable.LibSwitchButton_sbMarginRight, marginRight);

            if (a.hasValue(R.styleable.LibSwitchButton_sbMarginBottom))
                marginBottom = a.getDimensionPixelSize(R.styleable.LibSwitchButton_sbMarginBottom, marginBottom);

            isChecked = a.getBoolean(R.styleable.LibSwitchButton_sbIsChecked, false);
            isNeedToggleAnim = a.getBoolean(R.styleable.LibSwitchButton_sbIsNeedToggleAnim, true);
            isDebug = a.getBoolean(R.styleable.LibSwitchButton_sbIsDebug, false);

            a.recycle();
        }
    }
}
