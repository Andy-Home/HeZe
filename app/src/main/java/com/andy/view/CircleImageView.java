package com.andy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 圆形自定义View
 * <p>
 * Created by andy on 17-2-21.
 */
public class CircleImageView extends ImageView {
    /**
     * 该图形的默认半径,当使用{@link MeasureSpec.AT_MOST}时,使用这个设置图形长宽
     */
    private final int mRadius = 120;

    /**
     * 相交模式中的背景颜色
     */
    private final int mColor = Color.RED;

    private Paint paint;
    private PorterDuffXfermode mPorterDuffXfermode;
    private PorterDuff.Mode mPorterDuffMode;

    public CircleImageView(Context context) {
        super(context);
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPorterDuffMode = PorterDuff.Mode.SRC_IN;
        mPorterDuffXfermode = new PorterDuffXfermode(mPorterDuffMode);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        //配置wrap_content情况下的View长宽
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(2 * mRadius, 2 * mRadius);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(2 * mRadius, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 2 * mRadius);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingBottom - paddingTop;

        Bitmap bitmap = getBitmap(Math.min(width, height) / 2);
        if (bitmap == null) {
            return;
        }

        canvas.drawBitmap(bitmap, 0, 0, new Paint());
    }

    private Bitmap getBitmap(int i) {
        Bitmap src = getScaleBitmap(i);
        if (src == null) {
            return null;
        }
        Bitmap output = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Bitmap dst = makeDst(i);

        canvas.drawBitmap(dst, 0, 0, paint);
        paint.setXfermode(mPorterDuffXfermode);
        canvas.drawBitmap(src, 0, 0, paint);
        return output;
    }

    /**
     * 获取资源图片的缩放图
     */
    private Bitmap getScaleBitmap(int radius) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        //将资源图片缩放
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Matrix matrix = new Matrix();
        if (min != radius * 2) {
            float scale = (radius * 2) / min;
            matrix.postScale(scale, scale);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) (bitmap.getWidth() * scale), (int) (bitmap.getHeight() * scale), matrix, true);
        }
        return bitmap;
    }

    /**
     * 获取背景图片
     */
    private Bitmap makeDst(int radius) {
        Bitmap b = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        paint.setColor(mColor);
        c.drawCircle(radius, radius, radius, paint);
        return b;
    }
}
