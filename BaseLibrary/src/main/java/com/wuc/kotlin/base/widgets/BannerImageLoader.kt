package com.wuc.kotlin.base.widgets

import android.content.Context
import android.widget.ImageView
import com.wuc.kotlin.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 * @author:     wuchao
 * @date:       2018/7/3 13:56
 * @desciption: Banner图片加载器
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        GlideUtils.loadUrlImage(context!!, path.toString(), imageView!!)
    }
}