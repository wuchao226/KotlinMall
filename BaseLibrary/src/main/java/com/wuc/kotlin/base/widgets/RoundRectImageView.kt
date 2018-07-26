package com.wuc.kotlin.base.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import com.wuc.kotlin.base.R
import org.jetbrains.anko.dimen

/**
 * @author:     wuchao
 * @date:       2018/7/3 17:05
 * @desciption: 圆角图标    左上，右上为圆角
 */
class RoundRectImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    val radius = dimen(R.dimen.common_radius).toFloat()
    //设置圆角为左上和右上
    private val radiusArray: FloatArray = floatArrayOf(radius, radius, radius, radius, 0.0f, 0.0f, 0.0f, 0.0f)

    /*
    绘制圆角
     */
    private fun drawRoundAngle(canvas: Canvas) {
        val paint = Paint()
        paint.isAntiAlias = true
        //Xfermode 指的是你要绘制的内容和 Canvas 的目标位置的内容应该怎样结合计算出最终的颜色。但通俗地说，
        // 其实就是要你以绘制的内容作为源图像，以 View 中已有的内容作为目标图像，
        //  PorterDuff.Mode 作为绘制内容的颜色处理方案
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        val path = Path()
        //顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise)
        path.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()),
                this.radiusArray, Path.Direction.CW)
        //设置填充方式设置图形自相交时的填充算法
        path.fillType = Path.FillType.INVERSE_WINDING
        canvas.drawPath(path, paint)
    }

    /*
    重新绘制
     */
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        var bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        var localCanvas = Canvas(bitmap)
        val paint = Paint()
        if (bitmap.isRecycled) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            localCanvas = Canvas(bitmap)
        }
        super.onDraw(canvas)
        drawRoundAngle(localCanvas)

        paint.xfermode = null
        canvas!!.drawBitmap(bitmap, 0.0f, 0.0f, paint)
        bitmap.recycle()
    }
}