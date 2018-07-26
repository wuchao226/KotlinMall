package com.wuc.kotlin.base.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wuc.kotlin.base.R

/**
 * @author:     wuchao
 * @date:       2018/6/27 15:51
 * @desciption: Glide工具类
 */
object GlideUtils {

    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).apply(RequestOptions().centerCrop()).into(imageView)
    }

    fun loadImage(context: Context, url: String, options: RequestOptions, imageView: ImageView) {
        Glide.with(context).load(url).apply(options).into(imageView)
    }

    /**
     * 当fragment或者activity失去焦点或者destroyed的时候，Glide会自动停止加载相关资源，确保资源不会被浪费
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
                .load(url)
                .apply(RequestOptions()
                        .placeholder(R.drawable.icon_state_error)
                        .error(R.drawable.icon_state_error)
                        .centerCrop())
                .into(imageView)

    }

}