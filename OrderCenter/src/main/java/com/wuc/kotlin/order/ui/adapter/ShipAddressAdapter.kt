package com.wuc.kotlin.order.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuc.kotlin.base.ext.onClick
import com.wuc.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.wuc.kotlin.order.R
import com.wuc.kotlin.order.data.protocol.ShipAddress
import kotlinx.android.synthetic.main.layout_address_item.view.*

/**
 * @author:     wuchao
 * @date:       2018/7/18 21:25
 * @desciption:
 */
class ShipAddressAdapter(context: Context) : BaseRecyclerViewAdapter<ShipAddress,
        ShipAddressAdapter.ViewHolder>(context) {

    var mOptClickListenter: onOptClickListenter? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_address_item,
                parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = dataList[position]
        holder.itemView.mSetDefaultTv.isSelected = (model.shipIsDefault == 0)
        holder.itemView.mShipNameTv.text = model.shipUserName + "    " + model.shipUserMobile
        holder.itemView.mShipAddressTv.text = model.shipAddress

        holder.itemView.mSetDefaultTv.onClick {
            mOptClickListenter?.let {
                if (holder.itemView.mSetDefaultTv.isSelected) {
                    return@onClick
                }
                model.shipIsDefault = 0
                it.onSetDefault(model)
            }
        }
        holder.itemView.mEditTv.onClick {
            mOptClickListenter?.let {
                it.onEdit(model)
            }
        }
        holder.itemView.mDeleteTv.onClick {
            mOptClickListenter?.let {
                it.onDelete(model)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    /*
        对应操作接口
     */
    interface onOptClickListenter {
        fun onSetDefault(address: ShipAddress)
        fun onEdit(address: ShipAddress)
        fun onDelete(address: ShipAddress)
    }
}