package com.wuc.kotlin.goods.widget

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.eightbitlab.rxbus.Bus
import com.wuc.kotlin.base.ext.loadUrl
import com.wuc.kotlin.base.ext.onClick
import com.wuc.kotlin.base.utils.YuanFenConverter
import com.wuc.kotlin.base.widgets.DefaultTextWatcher
import com.wuc.kotlin.goods.R
import com.wuc.kotlin.goods.common.GoodsConstant
import com.wuc.kotlin.goods.data.protocol.GoodsSku
import com.wuc.kotlin.goods.event.AddCartEvent
import com.wuc.kotlin.goods.event.SkuChangedEvent
import com.wuc.kotlin.goods.getEditText
import kotlinx.android.synthetic.main.layout_sku_pop.view.*

/**
 * @author:     wuchao
 * @date:       2018/7/11 15:34
 * @desciption: 商品SKU弹层
 */
class GoodsSkuPopView(context: Activity) : PopupWindow(context) {

    //根视图
    private val mRootView: View
    private val mContext: Context
    private val mSkuViewList = arrayListOf<SkuView>()

    init {
        mContext = context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mRootView = inflater.inflate(R.layout.layout_sku_pop, null)

        initView()

        //设置窗体的View
        this.contentView = mRootView
        this.width = ViewGroup.LayoutParams.MATCH_PARENT
        this.height = ViewGroup.LayoutParams.MATCH_PARENT
        //设置窗体可点击
        this.isFocusable = true
        //设置弹出窗体动画效果
        this.animationStyle = R.style.AnimBottom
        background.alpha = 150
        //判断获取触屏位置如果在选择框外面则销毁弹出框
        mRootView.setOnTouchListener { v, event ->
            val height = mRootView.findViewById<View>(R.id.mPopView).top
            val y = event.y.toInt()
            if (event.action == MotionEvent.ACTION_UP) {
                if (y < height) {
                    dismiss()
                }
            }
            true
        }
    }

    /*
    初始化视图
     */
    private fun initView() {

        mRootView.mSkuCountBtn.setCurrentNumber(1)
        mRootView.mSkuCountBtn.getEditText().addTextChangedListener(object : DefaultTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                Bus.send(SkuChangedEvent())
            }
        })
        mRootView.mCloseIv.onClick {
            dismiss()
        }
        mRootView.mAddCartBtn.onClick {
            Bus.send(AddCartEvent())
            dismiss()
        }
    }

    /*
       设置商品图标
    */
    fun setGoodsIcon(text: String) {
        mRootView.mGoodsIconIv.loadUrl(text)
    }

    /*
        设置商品价格
     */
    fun setGoodsPrice(text: Long) {
        mRootView.mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(text)
    }


    /*
        设置商品编号
     */
    @SuppressLint("SetTextI18n")
    fun setGoodsCode(text: String) {
        mRootView.mGoodsCodeTv.text = "商品编号:" + text
    }

    /*
        设置商品SKU
     */
    fun setSkuData(list: List<GoodsSku>) {
        for (goodSku in list) {
            val skuView = SkuView(mContext)
            skuView.setSkuData(goodSku)

            mSkuViewList.add(skuView)
            mRootView.mSkuView.addView(skuView)
        }
    }

    /*
        获取选中的SKU
     */
    fun getSelectSku(): String {
        var skuInfo = ""
        for (skuView in mSkuViewList) {
            skuInfo += skuView.getSkuInfo().split(GoodsConstant.SKU_SEPARATOR)[1] + GoodsConstant.SKU_SEPARATOR
        }
        return skuInfo.take(skuInfo.length - 1)//刪除最后一个分隔
    }

    /*
        获取商品数量
     */
    fun getSelectCount() = mRootView.mSkuCountBtn.number

}