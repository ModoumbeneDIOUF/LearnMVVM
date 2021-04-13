package com.bichri.yewou.model

import android.os.Parcel
import android.os.Parcelable

data class Pageable(
    var offset: Int,
    var pageNumber: Int,
    var pageSize: Int,
    var paged: Boolean,
    var sort: Sort,
    var unpaged: Boolean
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        TODO("sort"),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(offset)
        parcel.writeInt(pageNumber)
        parcel.writeInt(pageSize)
        parcel.writeByte(if (paged) 1 else 0)
        parcel.writeByte(if (unpaged) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pageable> {
        override fun createFromParcel(parcel: Parcel): Pageable {
            return Pageable(parcel)
        }

        override fun newArray(size: Int): Array<Pageable?> {
            return arrayOfNulls(size)
        }
    }
}