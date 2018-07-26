package com.wuc.kotlin.base.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * @author:     wuchao
 * @date:       2018/6/28 14:02
 * @desciption: RecyclerViewAdapter基类
 */
abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var mContext: Context) :
        RecyclerView.Adapter<VH>() {

    //ItemClick事件
    var mOnItemClickListener: OnItemClickListener<T>? = null
    //数据集合
    var dataList: MutableList<T> = mutableListOf()

    /**
     * 设置数据
     * Presenter处理过为null的情况，所以为不会为Null
     */
    fun setData(sources: MutableList<T>) {
        dataList = sources
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (mOnItemClickListener != null) {
                mOnItemClickListener!!.onItemClick(dataList[position], position)
            }
        }
    }

    /**
     * ItemClick事件声明
     */
    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mOnItemClickListener = listener
    }
}