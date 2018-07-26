package com.wuc.kotlin.order.data.protocol

import android.os.Parcel
import android.os.Parcelable

/*
   收货地址
 */
data class ShipAddress(
        val id: Int,
        var shipUserName: String,
        var shipUserMobile: String,
        var shipAddress: String,
        var shipIsDefault: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(shipUserName)
        parcel.writeString(shipUserMobile)
        parcel.writeString(shipAddress)
        parcel.writeInt(shipIsDefault)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShipAddress> {
        override fun createFromParcel(parcel: Parcel): ShipAddress {
            return ShipAddress(parcel)
        }

        override fun newArray(size: Int): Array<ShipAddress?> {
            return arrayOfNulls(size)
        }
    }
}
